<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情</title>
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
			<div class="col-md-8 col-md-offset-2">
				<div class="thumbnail">
				    <!-- <img src="public/img/cpp.jpg" alt="..."> -->
				    <div class="caption">
					    <h4>书名：${book.bookname}</h4>
					    <h4>作者：${book.author}</h4>
					    <h4>出版社：${book.press}</h4>
					    <h4>存放地点：${book.place}</h4>
					   	<c:if test="${! empty user}">
						    <c:choose>
								<c:when test="${!buy}">
								    <button type="button" class="btn btn-primary" onclick="putwishcart(${book.id})">加入心愿单</button>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-primary" disabled="disabled">已加入心愿单</button>
								</c:otherwise>
							</c:choose>
					   	</c:if>
				    </div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
	<script type="text/javascript" src="public/js/func.js" ></script>
</body>
</html>