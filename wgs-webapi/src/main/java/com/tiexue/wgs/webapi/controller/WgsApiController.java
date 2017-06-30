package com.tiexue.wgs.webapi.controller;




import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiexue.wgs.core.dto.CollectionArticle;
import com.tiexue.wgs.core.dto.CollectionModel;
import com.tiexue.wgs.core.dto.ResultMsg;
import com.tiexue.wgs.core.entity.WgsArticle;
import com.tiexue.wgs.core.entity.WgsConstants;
import com.tiexue.wgs.core.service.IWgsArticleService;
import com.tiexue.wgs.webapi.util.ConvertArticle;

@Controller 
@RequestMapping("wgsApi")
public class WgsApiController {
	private Logger logger=Logger.getLogger(WgsApiController.class);
	@Resource 
	IWgsArticleService iwgsArticleService;
	
	/**
	 * 保存采集的文章接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("publicContent")
	@ResponseBody
	public String publicContentInternal(HttpServletRequest request,HttpServletResponse response){
		JSONObject jObject=new JSONObject();
		try {
			String content= request.getParameter("content");
			String token= request.getParameter("token");
			if(content==null||content.isEmpty()){
				jObject.put("Ok",false);
				jObject.put("Msg","token验证失败");
				jObject.put("Status",-2);
				return jObject.toString();
			}
			if(token.isEmpty()||token.isEmpty()){
				jObject.put("Ok",false);
				jObject.put("Msg","内容为空");
				jObject.put("Status",-2);
				return jObject.toString();
			}
			CollectionModel collectionModel=JSONObject.parseObject(content, CollectionModel.class);
			
			if(collectionModel==null||collectionModel.getArticle()==null)
			{
				jObject.put("Ok",false);
				jObject.put("Msg","content内容json转化失败");
				jObject.put("Status",WgsConstants.Api_NetError);
				return jObject.toString();
			}
			WgsArticle wgsArticle=ConvertArticle.fillArticle(collectionModel.getArticle());
			if(wgsArticle.getOriginalContent()!=null&&wgsArticle.getOriginalContent().length()>20){
				
			    WgsArticle article=	iwgsArticleService.getModelByUniqueFlag(wgsArticle.getUniqueflag()); 
			    if(article!=null){
				    jObject.put("Ok",true);
					jObject.put("Msg","文章已存在");
					jObject.put("Status",WgsConstants.Api_RepeatContent);
			    }else {
		    	    int res= iwgsArticleService.SaveArticle(wgsArticle);
		    	    jObject.put("Ok",true);
					jObject.put("Msg","保存成功");
					jObject.put("Status",WgsConstants.Api_Success);  
				}
			   
				return jObject.toString();
			}
			else{
				jObject.put("Ok",true);
				jObject.put("Msg","正文内容为空");
				jObject.put("Status",WgsConstants.Api_TextNumberShortByServer);
				return jObject.toString();
			}
			
		} catch (Exception e) {
			logger.error("采集的文章保存失败！"+e.getMessage());
			jObject.put("Ok",false);
			jObject.put("Msg","保存失败"+e.getMessage());
			jObject.put("Status",WgsConstants.Api_NetError);
		}
		return jObject.toString();
	}

}
