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
<style type="text/css">
iframe{
	width:100%;
}
</style>
<script>
	$(document).ready(function(){
		var contW= $("#js_content").width()*0.98;
		var needH=contW*0.75;
		 $("#mod_player").width(contW*0.98);
		 $("#mod_player").height(needH);
		 
		var w = $("iframe").width();
		var h = w * 0.75;
		$("iframe").height(h);
	});
</script>
<link rel="stylesheet" href="<%=path%>/static/css/detail.css"/>
   <title>美食台菜单：每日更新</title>
</head>
<style>

</style>
<body id="activity-detail" class="zh_CN mm_appmsg">
<div id="js_article" class="rich_media">
    <div id="js_top_ad_area" class="top_banner"></div>
    
    <div class="rich_media_inner">       
       <div id="page-content" class="rich_media_area_primary">
		<div id="img-content">
	             <h2 class="rich_media_title" id="activity-name">
	               ${model.title} </h2>
	             <div class="rich_media_meta_list">
	               <em id="post-date" class="rich_media_meta rich_media_meta_text">${date}</em>
		<em class="rich_media_meta rich_media_meta_text"> </em>
	               <a class="rich_media_meta rich_media_meta_link rich_media_meta_nickname" href="##" id="post-user">美食台</a>
	                <span class="rich_media_meta rich_media_meta_text rich_media_meta_nickname">美食台</span>
	             </div>
	             <div class="rich_media_content " id="js_content"> 
	             <c:if test="${model!=null&&model.id!=null&&model.id>0 }">
	             ${model.originalcontent}
                 </c:if> 
                  <c:if test="${model==null||model.id==null||model.id<=0 }">
                   <p style="line-height: normal; margin-bottom: 5px;">
                   		 文章已删除
                     </p>
                  </c:if> 
                  
                  
                  <p>
                     <br>
	              </p>
 
                   <c:if test="${channels!=null&&channels.wgsChannelDto!=null }">
                     <p>
                     <img data-s="300,640" data-type="png" 
	              data-ratio="0.2782608695652174" data-w="690" class="" 
	              src="${channels.wgsChannelDto.coverimg}" 
	              style="width: auto !important; height: auto !important; visibility: visible !important;" data-fail="0"><br>
	              </p>
	              	 <p> 
	            <c:forEach items="${channels.wgsArticleDtos}" var="articles">
                    <a href="<%=path%>/article/detail?id=${articles.id}" target="_blank" style="font-size: 15px; text-decoration: none;">
						<span style="font-size: 15px;">${articles.title}</span>
					</a>
					<span style="font-size: 15px;!important; text-decoration: none;">｜</span>
				</c:forEach>
					  </p>
					</c:if>
	             </div>
	   	</div>
	</div>
</div>
</div>

<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>

    </body>

</html>


    