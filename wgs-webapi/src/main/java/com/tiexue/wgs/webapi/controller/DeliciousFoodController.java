package com.tiexue.wgs.webapi.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tiexue.wgs.core.entity.WgsArticle;
import com.tiexue.wgs.core.service.IWgsArticleService;
import com.tiexue.wgs.webapi.dto.ApiArticle;
import com.tiexue.wgs.webapi.dto.ApiConstants;
import com.tiexue.wgs.webapi.dto.ApiList;
import com.tiexue.wgs.webapi.dto.ApiRecommend;
import com.tiexue.wgs.webapi.dto.ApiResult;
import com.tiexue.wgs.webapi.util.ConvertApiArticle;
import com.tiexue.wgs.webapi.util.ConvertArticle;

@Controller
@RequestMapping("delicious")
public class DeliciousFoodController {
	private static Logger logger=Logger.getLogger(DeliciousFoodController.class);
	private static final int pageSize=16;
	@Resource
	IWgsArticleService iWgsArticleService;
	/**
	 * 获取美食列表内容
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping("list")
	@ResponseBody
	public String getList(HttpServletRequest request,HttpServletResponse response){
		ApiResult apiResult=new ApiResult();
		try {
			//页码
			String pString=request.getParameter("p");
			//分类
			String categoryStr=request.getParameter("catagory");
			int pStart=0;
			int p=0;
			if(pString!=null&&!"".equals(pString)){
				p=Integer.parseInt(pString);
				if(p>=1){
					pStart=(--p)*pageSize;
				}
			}
			List<WgsArticle> articles= iWgsArticleService.getList(categoryStr, pStart, pageSize);
			int count=iWgsArticleService.getCount(categoryStr);
			boolean hasMore=false;
			if(articles!=null&&articles.size()>0){
				if(count>(pStart+articles.size()))
					hasMore=true;
				apiResult.setCode(ApiConstants.ResultCode_Success);
				apiResult.setMsg("获取列表数据成功");
			}
			else{
				apiResult.setCode(ApiConstants.ResultCode_Error);
				apiResult.setMsg("获取列表数据失败");
			}
			ApiList apiList= ConvertApiArticle.fillApiList(p++,hasMore,articles);
			apiResult.setResult(apiList);
			
		} catch (Exception e) {
			logger.error("getList exception."+e);
			apiResult.setCode(ApiConstants.ResultCode_Error);
			apiResult.setMsg("获取列表数据异常");
		}
		return JSON.toJSONString(apiResult,SerializerFeature.WriteMapNullValue);
	}
	@RequestMapping("recommend")
	@ResponseBody
	public String getRecommend(HttpServletRequest request,HttpServletResponse response){
		ApiRecommend apiResult=new ApiRecommend();
		try {
			//获取首页幻灯片数据内容
			List<WgsArticle> slider= iWgsArticleService.getList(null, 0, 6);
			//获取首页图片展示框的数据内容
			List<WgsArticle> venues= iWgsArticleService.getList("1", 6, 12);
			apiResult= ConvertApiArticle.fillApiRecommend(slider,venues);
		} catch (Exception e) {
			logger.error("getList exception."+e);
			apiResult.setCode(ApiConstants.ResultCode_Error);
			apiResult.setMsg("获取列表数据异常");
		}
		return JSON.toJSONString(apiResult,SerializerFeature.WriteMapNullValue);
	}
	
	
	/**
	 * 获取美食列表内容
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("detail")
	@ResponseBody
	public String getDetail(HttpServletRequest request,HttpServletResponse response){
		ApiResult apiResult=new ApiResult();
		JSONObject jObject=new JSONObject();
		try {
			String idString=request.getParameter("id");
			int id=0;
			if(idString!=null&&!"".equals(idString)){
				id=Integer.parseInt(idString);
			}
			WgsArticle wgsArticle= iWgsArticleService.getDetail(id);
			if(wgsArticle!=null){
				apiResult.setCode(ApiConstants.ResultCode_Success);
				apiResult.setMsg("获取详情页数据成功");
			}
			else{
				apiResult.setCode(ApiConstants.ResultCode_Error);
				apiResult.setMsg("获取详情页数据失败");
			}
			ApiArticle apiArticle= ConvertApiArticle.fillApiArticle(wgsArticle);
			apiResult.setResult(apiArticle);
		} catch (Exception e) {
			logger.error("getDetail exception."+e);
			apiResult.setCode(ApiConstants.ResultCode_Error);
			apiResult.setMsg("获取详情页数据异常");
		}

		return JSON.toJSONString(apiResult,SerializerFeature.WriteMapNullValue);
	}
}
