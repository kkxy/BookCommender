<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户个人中心</title>
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
				<table class="table">
					<thead>
					    <tr>
					      	<th>序号</th>
					      	<th>图片</th>
					       	<th>书名</th>
					       	<th>作者</th>
					       	<th>出版社</th>
					    </tr>
				  	</thead>
				  	<tbody>
				  		<c:forEach items="${buylist}" var="bl" varStatus="st">
					  		<tr>
					  			<td>${st.count}</td>
					  			<td>
					  				<c:choose>
					  					<c:when test="${! empty bl.head}">
							  				<img src="public/img/${bl.head}.jpg" style="width:100px;height:150px"/>
					  					</c:when>
					  					<c:otherwise>
					  						<img src="public/img/notfound.png" style="width:100px;height:150px"/>
					  					</c:otherwise>
					  				</c:choose>
					  			</td>	
					  			<td>${bl.bookname}</td>
					  			<td>${bl.author}</td>
					  			<td>${bl.press}</td>
					  		</tr>
				  		</c:forEach>
				  	</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
</body>
</html>