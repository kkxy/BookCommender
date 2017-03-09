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
		<hr>
		<div class="row">
			<!-- 左侧导航栏 -->
			<div class="col-md-3">
				<s:action name="sidebar_leftframe" executeResult="true"></s:action>
			</div>
			
			<!-- 主内容 -->
			<div class="col-md-6">
				<!-- 搜索框 -->
				<div class="row">
					<div class="form-group">
						<div class="col-md-10">
							<input class="form-control" type="text" id="inputitemname" name="itemname" placeholder="搜索您想借的书把"/>
						</div>
						<div class="col-md-2">
							<div class="btn-group" role="group">
							    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							      	搜索
							      <span class="caret"></span>
							    </button>
							    <ul class="dropdown-menu">
							      <li><a href="search" id="searchbook" onclick="changeHref('searchbook', 'search?searchtype=book')">搜书名</a></li>
							      <li><a href="search" id="searchauthor" onclick="changeHref('searchauthor', 'search?searchtype=author')">搜作者</a></li>
							    </ul>
							  </div>
						</div>
					</div>	
				</div>
				<hr>
				
				<!-- 书籍列表 -->
				<!-- <p class="lead">这是大家都在读的书</p> -->
				<div class="row">
					<c:choose>
						<c:when test="${! empty booklist}">
							<c:forEach items="${booklist}" var="bl" varStatus="st">
								<div class="col-md-4">
									<div class="thumbnail">
										<c:choose>
						  					<c:when test="${! empty bl.head}">
								  				<img src="public/img/${bl.head}.jpg" style="width:100px;height:150px"/>
						  					</c:when>
						  					<c:otherwise>
						  						<img src="public/img/notfound.png" style="width:100px;height:150px"/>
						  					</c:otherwise>
						  				</c:choose>
									    <div class="caption">
										    <h5 class="text-overflow">${bl.bookname}</h5>
											    <p class="text-overflow">作者：${bl.author}</p>
											<c:if test="${! empty user}">
												<c:choose>
													<c:when test="${order[st.index] == 0}">
													    <button id="mainbuybtn_${bl.id}" type="button" class="btn btn-primary" onclick="putwishcart('main',${bl.id})">借书</button>
													</c:when>
													<c:otherwise>
														<button type="button" class="btn btn-primary" disabled="disabled">已借</button>
													</c:otherwise>
												</c:choose>
											</c:if>
										    <a href="bookdetail?bookid=${bl.id}" class="btn btn-primary" role="button">详情</a>
									    </div>
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p class="lead">没有书籍</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<div class="col-md-2 col-md-offset-1">
				<s:action name="sidebar_rightframe" executeResult="true"></s:action>
			</div>
		</div>
	</div>
	

	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
	<script type="text/javascript" src="public/js/func.js" ></script>
</body>
</html>