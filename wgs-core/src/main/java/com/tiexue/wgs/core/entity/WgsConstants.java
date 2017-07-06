package com.tiexue.wgs.core.entity;

import java.util.HashMap;
import java.util.Map;

public class WgsConstants {

	// 文章状态 正常
	public static final int ArticleStatus_Normal = 1;
	// 文章状态 删除
	public static final int ArticleStatus_Deleted = 2;
	// 审核
	public static final int ArticleStatus_Audited = 3;
	// 相似文章
	public static final int ArticleStatus_Similarity = 4;
	/**
	 * 文章状态
	 */
	public static Map<Integer, String> ArticleType = new HashMap<Integer, String>() {
		{
			put(ArticleStatus_Normal, "正常");
			put(ArticleStatus_Deleted, "删除");
			put(ArticleStatus_Audited, "被审核");
			put(ArticleStatus_Similarity, "相似文章");
		}
	};
	//帖子
	public static final int SourceType_Forum=1;
	//资讯
	public static final int SourceType_News=2;
	//视频
	public static final int SourceType_Video=3;
	//图片
	public static final int SourceType_Pic=4;
	/**
	 * 来源文章类型
	 */
	public static Map<Integer,String> SourceType=new HashMap<Integer,String>(){
		{
			put(SourceType_Forum,"帖子");
			put(SourceType_News, "资讯");
			put(SourceType_Video, "视频");
			put(SourceType_Pic, "图片");
		}
	};
	
	
	
	public static final int Api_Success = 0;
	public static final int Api_TextNumberShortByServer = -1;
	public static final int Api_RepeatContent = -2;
	public static final int Api_NetError = -3;
	public static final int Api_TextNumberShortByClient = -4;
	public static final int Api_ServerError = -12;

}
