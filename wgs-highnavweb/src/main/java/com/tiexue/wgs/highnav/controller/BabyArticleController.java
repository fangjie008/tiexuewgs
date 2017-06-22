package com.tiexue.wgs.highnav.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiexue.wgs.base.util.DateUtil;
import com.tiexue.wgs.core.dto.WgsArticleDto;
import com.tiexue.wgs.core.dto.WgsChannelDto;
import com.tiexue.wgs.core.dto.WxChannelRelaArticlesDto;
import com.tiexue.wgs.core.entity.WgsConstants;
import com.tiexue.wgs.core.service.IWgsArticleService;
import com.tiexue.wgs.core.service.IWgsChannelService;

@Controller
@RequestMapping("baby")
public class BabyArticleController {

	@Resource
	IWgsArticleService iWgsArticleService;
	@Resource 
	IWgsChannelService iWgsChannelService;
	/**
	 * 获取channel表中Type为美食台的所有文章
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="list")
	public String index(HttpServletRequest request, HttpServletResponse response){
		List<WgsChannelDto> wgsChannelDtos=iWgsChannelService.getListByType(1, WgsConstants.ArticleType_YingYouEr);
		String ids="";
		if(!wgsChannelDtos.isEmpty()&&wgsChannelDtos.size()>0){
			for (WgsChannelDto wgsChannelDto : wgsChannelDtos) {
				ids+=wgsChannelDto.getId()+",";
			}
			if(ids.isEmpty())
				ids.substring(0, ids.length()-1);
			List<WgsArticleDto> wgsArticleDtos= iWgsArticleService.getAllListBySourceTypes(ids,"CreateTime dec");
			if(!wgsArticleDtos.isEmpty()&&wgsArticleDtos.size()>0){
				request.setAttribute("list", wgsArticleDtos);
			}
		}
		
		request.setAttribute("date", DateUtil.date2Str(new Date(),DateUtil.DATE_FORMAT_YYYY_MM_DD));
		return "baby/list";
	}
	
	/**
	 * 获取内容信息
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value="detail")
	public String detail(HttpServletRequest request, HttpServletResponse response,int id){
		WgsArticleDto wgsArticleDto= iWgsArticleService.getModel(id);
		List<WgsArticleDto> wgsArticleDtos= iWgsArticleService.getListBySourceType(wgsArticleDto.getSourcetype()," CreateTime dec",0,10);
		if(!wgsArticleDtos.isEmpty()&&wgsArticleDtos.size()>0){
			//使用迭代器移除当前的对象
			Iterator<WgsArticleDto> iterators= wgsArticleDtos.iterator();
			while(iterators.hasNext()){
				WgsArticleDto temp= iterators.next();
				if(temp.getId()==id)
					iterators.remove();
			}
			if(wgsArticleDtos.size()%2!=0)
				wgsArticleDtos.remove(0);
			request.setAttribute("list", wgsArticleDtos);
		}
		request.setAttribute("model", wgsArticleDto);
		request.setAttribute("date", DateUtil.date2Str(new Date(),DateUtil.DATE_FORMAT_YYYY_MM_DD));
		return "baby/detail";
	}
}
