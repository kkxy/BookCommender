<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="public/css/bootstrap-3.3.7/dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="public/css/mycss/all.css" />
</head>
<body>
	<div class="continer">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
				    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				    </button>
		     			<a class="navbar-brand" href="#">
		     				图书推荐
		     			</a>
		  		</div>
		
			    <div class="collapse navbar-collapse" id="bs-example">
			      	<ul class="nav navbar-nav">
			        	<li><a href="index.html">首页</a></li>
			      	</ul>
		     		<ul class="nav navbar-nav navbar-right">
		        		<li><a href="#">登录</a></li>
		        		<li><a href="#">注册</a></li>
		        		<li><a href="cart.html">购物车</a></li>
					</ul>
			    </div>
			</div>
		</nav>	
		<div class="row">
			<img src="public/img/图书馆.jpg" />
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
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
			<div class="col-md-8 col-md-offset-5">
				<a href="wishcart.html"><button class="btn btn-primary">提交心愿单</button></a>
				<!--<input value="提交心愿单" type="submit"/>-->
			</div>
		</div>
	</div>
	<script type="text/javascript" src="public/css/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/css/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
</body>
</html>