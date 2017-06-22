package com.tiexue.wgs.core.entity;

import java.util.HashMap;
import java.util.Map;

public class WgsConstants {

	/**
	 * 文章频道的类型：美食
	 */
	public static final int ArticleType_MeiShi=1;
	/**
	 * 文章频道的类型：婴幼儿
	 */
	public static final int ArticleType_YingYouEr=2;
	/**
	 * 文章频道的类型
	 */
	public static Map<Integer,String> ArticleType=new HashMap<Integer,String>(){
		{
			put(ArticleType_MeiShi,"美食");
			put(ArticleType_YingYouEr,"婴幼儿");
		}
	};

}
