package com.tiexue.wgs.webapi.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.varia.StringMatchFilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tiexue.wgs.core.entity.WgsArticle;
import com.tiexue.wgs.webapi.dto.ApiArticle;
import com.tiexue.wgs.webapi.dto.ApiConstants;
import com.tiexue.wgs.webapi.dto.ApiList;
import com.tiexue.wgs.webapi.dto.ApiRecommend;
import com.tiexue.wgs.webapi.dto.ContentPicModel;
import com.tiexue.wgs.webapi.dto.MaterialCont;
import com.tiexue.wgs.webapi.dto.MaterialModel;

public class ConvertApiArticle {

	
	/**
	 * 填充列表页数据
	 * @param page
	 * @param hasMore
	 * @param wgsArticles
	 * @return
	 */
	public static ApiList fillApiList(int page,boolean hasMore,List<WgsArticle> wgsArticles){
		ApiList apiList=new ApiList();
		apiList.setHasMore(hasMore);
		apiList.setPage(page);
		List<ApiArticle> list=new ArrayList<ApiArticle>();
		if(wgsArticles!=null&&wgsArticles.size()>0){
			for (WgsArticle article : wgsArticles) {
				list.add(fillApiArticle(article));
			}
		}
		apiList.setList(list);;
		return apiList;
	}
	
	/**
	 * 填充列表页数据
	 * @param page
	 * @param hasMore
	 * @param wgsArticles
	 * @return
	 */
	public static ApiRecommend fillApiRecommend(List<WgsArticle> slider,List<WgsArticle> venues){
		ApiRecommend apiRecommend=new ApiRecommend();
		if(slider==null||slider.size()<=0){
			apiRecommend.setCode(ApiConstants.ResultCode_Error);
			apiRecommend.setMsg("获取列表数据失败");
			return apiRecommend;
			}
		List<ApiArticle> sliderList=new ArrayList<ApiArticle>();
		if(slider!=null){
			for (WgsArticle article : slider) {
				sliderList.add(fillApiArticle(article));
			}
		}
		apiRecommend.setSlider(sliderList);
		List<ApiArticle> venuesList=new ArrayList<ApiArticle>();
		if(venues==null||venues.size()<=0){
			for (WgsArticle article : slider) {
				venuesList.add(fillApiArticle(article));
			}
			apiRecommend.setVenues(venuesList);
		}
		else{
			for (WgsArticle article : venues) {
				venuesList.add(fillApiArticle(article));
			}
			apiRecommend.setVenues(venuesList);
			
		}
		apiRecommend.setCode(ApiConstants.ResultCode_Success);
		apiRecommend.setMsg("获取列表数据成功");
		return apiRecommend;
	}
	
	
	/**
	 * 接口文章填充数据
	 * @param article
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ApiArticle fillApiArticle(WgsArticle article){
		ApiArticle apiArticle=new ApiArticle();
		if(article==null)
			return apiArticle;
	
		String coverImg="";
		try {
			//String imgUrl=article.getCoverimgs()==null?"[]":article.getCoverimgs().replace("http:", "https:");
			String imgUrl=article.getCoverimgs()==null?"[]":article.getCoverimgs();
			List<String> imgs= JSON.parseObject(imgUrl,new ArrayList<String>().getClass());
			if(imgs!=null&&imgs.size()>0){
				coverImg=imgs.get(0);
			}
		} catch (Exception e) {
		}
		apiArticle.setCoverImgs(coverImg);
		apiArticle.setId(article.getId());
		apiArticle.setIntro(article.getIntro());
	
		try {
			//String contPic=(article.getContentPic()==null?"":article.getContentPic().replace("http:", "https:"));
			String contPic=(article.getContentPic()==null?"":article.getContentPic());
			List<ContentPicModel> imgs= JSON.parseObject(contPic,new ArrayList<ContentPicModel>().getClass());
			apiArticle.setContentPic(imgs);
		} catch (Exception e) {
		}
		try {
			//String materials=(article.getMaterials()==null?"":article.getMaterials().replace("http:", "https:"));
			String materials=(article.getMaterials()==null?"":article.getMaterials());
			MaterialModel imgs= JSON.parseObject(materials,MaterialModel.class);
			apiArticle.setMaterials(imgs);
		} catch (Exception e) {
		}
		apiArticle.setTitle(article.getTitle());
		return apiArticle;
		
	}
}
