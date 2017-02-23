<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
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
		        		<li><button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#loginmodal">登录</button></li>
		        		<li><button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#registermodal">注册帐号</button></li>
		        		<li><button type="button" class="btn btn-primary btn-md"><a href="cart">购物车</a></button></li>
					</ul>
			    </div>
			    
			</div>
		</nav>
		<!--登录模块-->
		<div class="modal fade" id="loginmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	      	<div class="modal-dialog" role="document">
	        	<div class="modal-content">
	          		<div class="modal-header">
	            		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	              		<span aria-hidden="true">&times;</span>
	            		</button>
	            		<h4 class="modal-title" id="myModalLabel">登录</h4>
	          		</div>
	          		<form action="login" onsubmit="" method="post">
	            		<div class="modal-body row">
	              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
	                			<span class="input-group-addon"  id="basic-addon1" >
	                  				<span class=" glyphicon glyphicon-user"></span>
	                  			</span>
	                			<input type="text" id="username" name="username" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
	              			</div>
	              			<br>
	              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
	                			<span class="input-group-addon" id="basic-addon2">
	                  				<span class="glyphicon glyphicon-lock"></span>
	                			</span>
	               			 	<input type="password" id="psw" name="psw" class="form-control" placeholder="密码" aria-describedby="basic-addon2">
	              			</div>
	              			<br>
	              			<div class="modal-footer">
		                		<center>
		                  			<div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
		                   			 	<button type="submit" class="btn btn-primary">登录</button>
		                  			</div>
		                		</center>
	              			</div>
	            		</div>
	          		</form>
	       	 	</div>
	      	</div>
	    </div>
		<!-- 注册模块 -->
	    <div class="modal fade" id="registermodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	      	<div class="modal-dialog" role="document">
	        	<div class="modal-content">
	          		<div class="modal-header">
	            		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	              		<span aria-hidden="true">&times;</span>
	            		</button>
	            		<h4 class="modal-title" id="myModalLabel">请填写您的个人信息</h4>
	          		</div>
	          		<form action="register" onsubmit="" method="post">
	            		<div class="modal-body row">
	              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
	                			<span class="input-group-addon"  id="basic-addon1" >
	                  				<span class=" glyphicon glyphicon-user"></span>
	                  			</span>
	                			<input type="text" id="user_name" name="user_name" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
	              			</div>
	              			<br>
	              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
	                			<span class="input-group-addon" id="basic-addon2">
	                  				<span class="glyphicon glyphicon-lock"></span>
	                			</span>
	               			 	<input type="password" id="password" name="password" class="form-control" placeholder="密码" aria-describedby="basic-addon2">
	              			</div>
	              			<br>
	              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
	                			<span class="input-group-addon" id="basic-addon3">
	                  				<span class="glyphicon glyphicon-lock"></span>
	                			</span>
	                			<input type="password" id="password_confirm" name="password_confirm" class="form-control" placeholder="确认密码" aria-describedby="basic-addon3">
	              			</div>
	             			<br>
	              			<div class="modal-footer">
		                		<center>
		                  			<div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
		                    			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                   			 	<button type="submit" class="btn btn-primary">保存</button>
		                  			</div>
		                		</center>
	              			</div>
	            		</div>
	          		</form>
	       	 	</div>
	      	</div>
	    </div>

		<div class="row">
			<img src="public/img/图书馆.jpg" />
		</div>
		<div class="row">
			<div class="col-md-3">
				<p class="lead"><strong>计算机类</strong></p>
				<ol class="breadcrumb">
					<li><a href="booklist">c++</a></li>
					<li><a href="#">计算机网络</a></li>
					<li><a href="#">通信</a></li>
					<li><a href="#">硬件</a></li>
					<li><a href="bookclass">更多...</a></li>
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
							      <li><a href="booklist">搜书名</a></li>
							      <li><a href="booklist">搜作者</a></li>
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
								    <a href="lend" class="btn btn-primary" role="button">加入阅读车</a>
								    <a href="bookdetail" class="btn btn-primary" role="button">详情</a>
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