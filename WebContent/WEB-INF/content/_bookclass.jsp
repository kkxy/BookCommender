<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书大类</title>
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
			        	<li><a href="#">首页</a></li>
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
			<img src="public/img/library.jpg" />
		</div>
		<div class="row">
			<div class="col-md-3">
				<p class="lead"><strong>程序设计类</strong></p>
				<ol class="breadcrumb">
					<li><a href="booklist.html">c++</a></li>
					<li><a href="#">java</a></li>
					<li><a href="#">c</a></li>
				</ol> 
			</div>
			<div class="col-md-9">
				<form action="booklist" method="post" role="form">
					<div class="form-group">
						<div class="col-md-10">
							<input class="form-control" type="text" name="bookname" placeholder="搜索您想借的书把"/>
						</div>
						<div class="col-md-2">
							<div class="btn-group" role="group">
							    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							      	搜索
							      <span class="caret"></span>
							    </button>
							    <ul class="dropdown-menu">
							      <li><a href="booklist.html">搜书名</a></li>
							      <li><a href="#">搜作者</a></li>
							    </ul>
							  </div>
						</div>
					</div>	
				</form>
				
				<div class="index-down">
					<p class="lead">这是大家都在读的书</p>
					<div class="row">
						<div class="col-md-3">
							<div class="thumbnail">
							    <img src="public/img/cpp.jpg" alt="...">
							    <div class="caption">
								    <h5>c++程序设计</h5>
									    <p>作者：xxx</p>
								    <a href="lend.html" class="btn btn-primary" role="button">加入阅读车</a>
								    <a href="bookdetail.html" class="btn btn-primary" role="button">详情</a>
							    </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="public/css/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/css/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
</body>
</html>