<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理界面</title>
<link rel="stylesheet" type="text/css" href="public/bootstrap-3.3.7/dist/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-md-offset-1">
				<a href="getuploadclass">
					<button class="btn btn-primary">上传字典</button>
				</a>
			</div>
			<div class="col-md-3">
				<a href="getuploadbook">
					<button class="btn btn-primary">上传书本</button>
				</a>
			</div>
			<div class="col-md-3">
				<button class="btn btn-primary" id="recomm" onclick="computerecom()">推荐书籍</button>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
	<script type="text/javascript" src="public/js/func.js"></script>
</body>
</html>