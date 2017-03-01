<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="public/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="public/css/all.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
			<img src="public/img/library.jpg" class="img-responsive" alt="library"/>
		</div>
		<div class="row">
			<!-- 左侧导航栏 -->
			<div class="col-md-3">
				<c:forEach items="${bigclass}" var="bc" varStatus="st">
					<p class="lead"><strong>${bc.name}</strong></p>
					<c:if test="${! empty smallclass}">
						<ol class="breadcrumb">
							<c:forEach begin="${count[st.index]}" end="${count[st.index + 1] - 1}" step="1" var="x">
								<li><a href="index?typeid=${smallclass[x].itemid}&classtype=bc">${smallclass[x].name}</a></li>
							</c:forEach>
						</ol> 
					</c:if>
				</c:forEach>
			</div>
			
			<!-- 主内容 -->
			<div class="col-md-8">
				<div class="row">
					<form action="search" method="post" role="form" class="form" id="searchform">
						<div class="form-group">
							<div class="col-md-10">
								<input class="form-control" type="text" name="itemname" placeholder="搜索您想借的书把"/>
							</div>
							<div class="col-md-2">
								<div class="btn-group" role="group">
								    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								      	搜索
								      <span class="caret"></span>
								    </button>
								    <ul class="dropdown-menu">
								      <li><button type="submit" class="btn btn-primary" onclick="changeAction('searchform', 'search?seachtype=book')">搜书名</button></li>
								      <li><button type="submit" class="btn btn-primary" onclick="changeAction('searchform', 'search?seachtype=author')">搜作者</button></li>
								    </ul>
								  </div>
							</div>
						</div>	
					</form>
				</div>
				<hr>
				
				<p class="lead">这是大家都在读的书</p>
				<div class="row">
					<c:forEach items="${booklist}" var="bl" varStatus="st">
						<div class="col-md-3">
							<div class="thumbnail">
							    <img src="public/img/${bl.head}" alt="${bl.head}">
							    <div class="caption">
								    <h5>${bl.bookname}</h5>
									    <p>作者：${bl.author}</p>
								    <a href="wishcart?bookid=${bl.id}" class="btn btn-primary" role="button">加入心愿单</a>
								    <a href="bookdetail?bookid=${bl.id}" class="btn btn-primary" role="button">详情</a>
							    </div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	

	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
	<script type="text/javascript" src="public/js/func.js" ></script>
</body>
</html>