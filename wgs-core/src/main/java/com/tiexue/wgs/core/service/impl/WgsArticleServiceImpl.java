package com.tiexue.wgs.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiexue.wgs.base.util.DateUtil;
import com.tiexue.wgs.core.dto.WgsArticleDto;
import com.tiexue.wgs.core.entity.WgsArticle;
import com.tiexue.wgs.core.entity.WgsArticleSub;
import com.tiexue.wgs.core.entity.WgsChannel;
import com.tiexue.wgs.core.mapper.WgsArticleMapper;
import com.tiexue.wgs.core.mapper.WgsArticleSubMapper;
import com.tiexue.wgs.core.mapper.WgsChannelMapper;
import com.tiexue.wgs.core.service.IWgsArticleService;

@Service("iWgsArticleService")
public class WgsArticleServiceImpl implements IWgsArticleService {

	@Resource
	WgsArticleMapper wgsArticleMapper;
	@Resource 
	WgsArticleSubMapper wgsArticleSubMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return wgsArticleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WgsArticle record) {
		return wgsArticleMapper.insert(record);
	}

	@Override
	public int insertSelective(WgsArticle record) {
		return wgsArticleMapper.insertSelective(record);
	}

	@Override
	public WgsArticle selectByPrimaryKey(Integer id) {
		return wgsArticleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WgsArticle record) {
		return wgsArticleMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public int updateByPrimaryKey(WgsArticle record) {
		return wgsArticleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<WgsArticleDto> getList(Integer pStart, Integer pEnd) {
		List<WgsArticleDto> wgsArticleDtos=new ArrayList<WgsArticleDto>();
		List<WgsArticle> wgsArticles=wgsArticleMapper.getList(pStart, pEnd);
		if(wgsArticles!=null){
			for (WgsArticle wgsArticle : wgsArticles) {
				 WgsArticleDto wgsAtricleDto=new WgsArticleDto();
				 wgsAtricleDto=toWgsAtricleDto(wgsArticle);
//		         int id=wgsArticle.getId();
//		         WgsArticleSub wgsArticleSub=wgsArticleSubMapper.select(id);
//		         if(wgsArticleSub!=null)
//		        	 wgsAtricleDto.setOriginalcontent(wgsArticleSub.getOriginalcontent());
		         wgsArticleDtos.add(wgsAtricleDto);
			}
		}
		return wgsArticleDtos;
	}
	
	

	@Override
	public WgsArticleDto getModel(Integer id) {
		WgsArticleDto wgsAtricleDto=new WgsArticleDto();
		WgsArticle wgsArticle= wgsArticleMapper.getModel(id);
		if(wgsArticle==null){
			return null;
		}
		wgsAtricleDto=toWgsAtricleDto(wgsArticle);
        WgsArticleSub wgsArticleSub=wgsArticleSubMapper.select(id);
        if(wgsArticleSub!=null)
        	wgsAtricleDto.setOriginalcontent(wgsArticleSub.getOriginalcontent());
		return wgsAtricleDto;
	}
	
	@Override
	public List<WgsArticleDto> getListBySourceType(Integer sourceType,String order,Integer pStart,Integer pSize) {
		List<WgsArticleDto> WgsArticleDtos=new ArrayList<WgsArticleDto>();
		List<WgsArticle> wgsArticles=wgsArticleMapper.getListBySourceType(sourceType,order,pStart,pSize);
		if(wgsArticles==null)
			return null;
		for (WgsArticle wgsArticle : wgsArticles) {
			WgsArticleDto wgsArticleDto=new WgsArticleDto();
			wgsArticleDto=toWgsAtricleDto(wgsArticle);
			WgsArticleDtos.add(wgsArticleDto);
		}
		return WgsArticleDtos;
	}
	
	@Override
	public List<WgsArticleDto> getAllListBySourceType(Integer sourceType,String order) {
		List<WgsArticleDto> WgsArticleDtos=new ArrayList<WgsArticleDto>();
		List<WgsArticle> wgsArticles=wgsArticleMapper.getAllListBySourceType(sourceType,order);
		if(wgsArticles==null)
			return null;
		for (WgsArticle wgsArticle : wgsArticles) {
			WgsArticleDto wgsArticleDto=new WgsArticleDto();
			wgsArticleDto=toWgsAtricleDto(wgsArticle);
			WgsArticleDtos.add(wgsArticleDto);
		}
		return WgsArticleDtos;
	}

	@Override
	public List<WgsArticleDto> getListBySourceTypes(String sourceTypes,String order,Integer pStart,Integer pSize) {
		List<WgsArticleDto> WgsArticleDtos=new ArrayList<WgsArticleDto>();
		List<WgsArticle> wgsArticles=wgsArticleMapper.getListBySourceTypes(sourceTypes,order,pStart,pSize);
		if(wgsArticles==null)
			return null;
		for (WgsArticle wgsArticle : wgsArticles) {
			WgsArticleDto wgsArticleDto=new WgsArticleDto();
			wgsArticleDto=toWgsAtricleDto(wgsArticle);
			WgsArticleDtos.add(wgsArticleDto);
		}
		return WgsArticleDtos;
	}
	
	
	@Override
	public List<WgsArticleDto> getAllListBySourceTypes(String sourceTypes,String order) {
		List<WgsArticleDto> WgsArticleDtos=new ArrayList<WgsArticleDto>();
		List<WgsArticle> wgsArticles=wgsArticleMapper.getAllListBySourceTypes(sourceTypes,order);
		if(wgsArticles==null)
			return null;
		for (WgsArticle wgsArticle : wgsArticles) {
			WgsArticleDto wgsArticleDto=new WgsArticleDto();
			wgsArticleDto=toWgsAtricleDto(wgsArticle);
			WgsArticleDtos.add(wgsArticleDto);
		}
		return WgsArticleDtos;
	}

	/**
	 * 转化成WgsArticleDto
	 * @param wgsArticle
	 * @return
	 */
	private WgsArticleDto toWgsAtricleDto(WgsArticle wgsArticle){
		 WgsArticleDto wgsAtricleDto=new WgsArticleDto();
		 if(wgsArticle==null)
			 return null;
		 wgsAtricleDto.setCaicount(wgsArticle.getCaicount()==null?0:wgsArticle.getCaicount());
		 wgsAtricleDto.setCollectioncount(wgsArticle.getCollectioncount()==null?0:wgsArticle.getCollectioncount());
		 wgsAtricleDto.setCommentcount(wgsArticle.getCommentcount()==null?0:wgsArticle.getCommentcount());
		 wgsAtricleDto.setContentlen(wgsArticle.getContentlen()==null?0:wgsArticle.getContentlen());
		 wgsAtricleDto.setContenttype(wgsArticle.getContenttype()==null?0:wgsArticle.getContenttype());
		 wgsAtricleDto.setCoverimgs(wgsArticle.getCoverimgs()==null?"":wgsArticle.getCoverimgs());
		 wgsAtricleDto.setCreatetime(wgsArticle.getCreatetime()==null?"": 
			 DateUtil.date2Str(wgsArticle.getCreatetime(),DateUtil.DATE_FORMAT));
		 wgsAtricleDto.setDingcount(wgsArticle.getDingcount()==null?0:wgsArticle.getDingcount());
		 wgsAtricleDto.setFromid(wgsArticle.getFromid()==null?0:wgsArticle.getFromid());
		 wgsAtricleDto.setFromname(wgsArticle.getFromname()==null?"":wgsArticle.getFromname());
		 wgsAtricleDto.setId(wgsArticle.getId()==null?0:wgsArticle.getId());
		 wgsAtricleDto.setImgshowtype(wgsArticle.getImgshowtype()==null?0:wgsArticle.getImgshowtype());
		 wgsAtricleDto.setIntro(wgsArticle.getIntro()==null?"":wgsArticle.getIntro());
		 wgsAtricleDto.setMark(wgsArticle.getMark()==null?0:wgsArticle.getMark());
		 wgsAtricleDto.setOriginalid(wgsArticle.getOriginalid()==null?"":wgsArticle.getOriginalid());
		 wgsAtricleDto.setOriginaltitle(wgsArticle.getOriginaltitle()==null?"":wgsArticle.getOriginaltitle());
		 wgsAtricleDto.setOriginalurl(wgsArticle.getOriginalurl()==null?"":wgsArticle.getOriginalurl());
		 wgsAtricleDto.setPlatformid(wgsArticle.getPlatformid()==null?0:wgsArticle.getPlatformid());
		 wgsAtricleDto.setPlatformname(wgsArticle.getPlatformname()==null?"":wgsArticle.getPlatformname());
		 wgsAtricleDto.setPublishericon(wgsArticle.getPublishericon()==null?"":wgsArticle.getPublishericon());
		 wgsAtricleDto.setPublisherid(wgsArticle.getPublisherid()==null?0:wgsArticle.getPublisherid());
		 wgsAtricleDto.setPublishername(wgsArticle.getPublishername()==null?"":wgsArticle.getPublishername());
		 wgsAtricleDto.setSharecount(wgsArticle.getSharecount()==null?0:wgsArticle.getSharecount());
		 wgsAtricleDto.setShowtime(wgsArticle.getShowtime()==null?"":
			 DateUtil.date2Str(wgsArticle.getShowtime(),DateUtil.DATE_FORMAT));
		 wgsAtricleDto.setSourcetype(wgsArticle.getSourcetype()==null?0:wgsArticle.getSourcetype());
		 wgsAtricleDto.setStatus(wgsArticle.getStatus()==null?0:wgsArticle.getStatus());
		 wgsAtricleDto.setTags(wgsArticle.getTags()==null?"":wgsArticle.getTags());
		 wgsAtricleDto.setTitle(wgsArticle.getTitle()==null?"":wgsArticle.getTitle());
		 wgsAtricleDto.setUscore(wgsArticle.getUscore()==null?0:wgsArticle.getUscore());
		 wgsAtricleDto.setViewcount(wgsArticle.getViewcount()==null?0:wgsArticle.getViewcount());
		 wgsAtricleDto.setWeight(wgsArticle.getWeight()==null?0:wgsArticle.getWeight());
		
		 
		 if(wgsArticle.getCoverimgs()!=null){
			 JSONObject jObject=new JSONObject();
			 try {
				List<String> imgs= jObject.parseArray(wgsArticle.getCoverimgs(),String.class);
				if(imgs!=null&&!imgs.isEmpty()&&imgs.size()>0){
					wgsAtricleDto.setCoverimgList(imgs);
				}
			} catch (Exception e) {
				
			}
		 }
		 return wgsAtricleDto;
	}

}
