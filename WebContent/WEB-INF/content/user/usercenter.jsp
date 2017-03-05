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
<link rel="stylesheet" type="text/css" href="public/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="public/css/mycss/all.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<s:action name="sidebar_topframe" executeResult="true"></s:action>
			<img src="public/img/library.jpg" class="img-responsive" alt="library"/>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="booklist-bottom">
                2017.2.16号心愿单
				</div>
				<table class="table">
					<thead>
					    <tr>
					      	<th>序号</th>
					      	<th></th>
					       	<th>书名</th>
					       	<th>作者</th>
					       	<th>出版社</th>
					    </tr>
				  	</thead>
				  	<tbody>
				  		<tr>
				  			<td>1</td>
				  			<td><img src="public/img/cpp.jpg" style="width:100px;height:150px"/></td>	
				  			<td>c++程序设计</td>
				  			<td>xxx</td>
				  			<td>清华大学出版社</td>
				  		</tr>
				  	</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="public/css/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/css/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
</body>
</html>