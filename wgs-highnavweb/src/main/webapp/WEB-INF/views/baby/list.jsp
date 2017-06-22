<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">

<%@ include file="/WEB-INF/views/include/include_base.jsp"%>
<style>
td, th {
    word-wrap: break-word;
    word-break: break-all;
    padding: 5px 10px;
    border: 1px solid #DDD;
    width: 50%;
}
</style>
<link rel="stylesheet" href="<%=path%>/static/css/list.css"/>
   <title>675道辅食菜谱，不再为宝宝吃啥而发愁！</title>
</head>
<body id="activity-detail" class="zh_CN mm_appmsg">
<div id="js_article" class="rich_media">
    <div id="js_top_ad_area" class="top_banner"></div>
    
    <div class="rich_media_inner">
                
       <div id="page-content" class="rich_media_area_primary">
		<div id="img-content">
            <h2 class="rich_media_title" id="activity-name">
             675道辅食菜谱，不再为宝宝吃啥而发愁！</h2>
            <div class="rich_media_meta_list">
              <em id="post-date" class="rich_media_meta rich_media_meta_text">${date}</em>
<em class="rich_media_meta rich_media_meta_text"> </em>
              <a class="rich_media_meta rich_media_meta_link rich_media_meta_nickname" href="##" id="post-user">宝宝营养辅食</a>
               <span class="rich_media_meta rich_media_meta_text rich_media_meta_nickname">宝宝营养辅食</span>
            </div>
         
            <div class="rich_media_content " id="js_content"> 
            <p><br></p>
            <p><br></p>
               <p style="margin-top: 5px; padding-top: 10px; padding-bottom: 10px; white-space: normal; border-width: medium; border-style: none; line-height: 1.75em; background-image: none;">
            这里面的菜谱都是按着时间顺序来排列的。最近更新的辅食都会显示在前面哟~</p>
            <p style="margin-top: 5px; padding-top: 10px; padding-bottom: 10px; line-height: 25.6px; white-space: normal; border-width: medium; border-style: none; text-align: center; background-image: none;">
            <span style="font-size: 24px; color: rgb(255, 41, 65);">点击图片即可查询做法</span></p>
            <table>
            <tbody>
           <c:forEach items="${list}" var="item" varStatus="i">
           <c:if test="${i.index%2==0 }"><tr></c:if>
				 <td valign="top" colspan="1" rowspan="1" style="word-break: break-all;">
			      <p>
			      <a href="<%=path%>/baby/detail?id=${item.id}" target="_blank" style="font-size: 15px; text-decoration: none;">
				  <img alt="" data-src="${item.coverimgList[0]}">			
 				  </a>
				          <a href="<%=path%>/baby/detail?id=${item.id}" target="_blank" style="font-size: 15px; text-decoration: none;">
							<span style="font-size: 15px;">${item.title}</span></a>
				 </p>
				 </td>
			  <c:if test="${i.index%2==1 }"><tr></c:if>
            </c:forEach>
           </tbody>
             </table>     
            </div>
	   	</div>
	</div>
</div>
</div>

<script type="text/javascript" src="<%=path%>/static/js/lazj.js"></script>
<%@ include file="/WEB-INF/views/include/include_footer_baby.jsp"%>
    </body>

</html>


    