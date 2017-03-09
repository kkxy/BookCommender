<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传字典</title>
<link rel="stylesheet" type="text/css" href="public/bootstrap-3.3.7/dist/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<form class="form" action="uploadclass" method="post">
			<div class="row">
				<div class="col-md-4 col-md-offset-2">
					<div class="form-group">
						<label for="typeid">父级字典</label>
						<select id="typeid" name="dict.typeid">
							<option value="-1"></option>
							<c:forEach var="cl" items="${classlist}" varStatus="st">
								<option value="${cl.itemid}">${cl.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="name">字典名称</label>
						<input id="name" name="dict.name">
					</div>					
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-2">
					<button class="btn btn-primary" type="submit">提交</button>
				</div>
			</div>
		</form>
		<hr>
		<div class="row">
			<div class="col-md-4 col-md-offset-2">
				<a href="manage">
					<button type="button" class="btn btn-primary">返回管理页</button>
				</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
</body>
</html>