<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标题栏</title>
</head>
<body>
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
		      	<c:choose>
		      		<c:when test="${! empty user}">
			     		<ul class="nav navbar-nav navbar-right">
			        		<li><a href="usercenter"><button type="button" class="btn btn-primary btn-md">${user.loginname}</button></a></li>
			        		<li><a href="logout"><button type="button" class="btn btn-primary btn-md">登出</button></a></li>
			        		<!-- <li><a href="wishcart"><button type="button" class="btn btn-primary btn-md">心愿单</button></a></li> -->
						</ul>
		      		</c:when>
		      		<c:otherwise>
						<ul class="nav navbar-nav navbar-right">
			        		<li><button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#loginmodal">登录</button></li>
			        		<li><button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#registermodal">注册帐号</button></li>
						</ul>
		      		</c:otherwise>
		      	</c:choose>
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
          		<form action="login" method="post">
            		<div class="modal-body row">
              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                			<span class="input-group-addon"  id="basic-addon1" >
                  				<span class=" glyphicon glyphicon-user"></span>
                  			</span>
                			<input type="text" name="user.loginname" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
              			</div>
              			<br>
              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                			<span class="input-group-addon" id="basic-addon2">
                  				<span class="glyphicon glyphicon-lock"></span>
                			</span>
               			 	<input type="password" name="user.password" class="form-control" placeholder="密码" aria-describedby="basic-addon2">
              			</div>
              			<br>
              			<div class="modal-footer">
                  			<div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                   			 	<button type="submit" class="btn btn-primary">登录</button>
                  			</div>
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
          		<form action="register" method="post">
            		<div class="modal-body row">
              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                			<span class="input-group-addon"  id="basic-addon1" >
                  				<span class=" glyphicon glyphicon-user"></span>
                  			</span>
                			<input type="text" name="user.loginname" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
              			</div>
              			<br>
              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                			<span class="input-group-addon" id="basic-addon2">
                  				<span class="glyphicon glyphicon-lock"></span>
                			</span>
               			 	<input type="password" name="user.password" class="form-control" placeholder="密码" aria-describedby="basic-addon2">
              			</div>
              			<br>
              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                			<span class="input-group-addon" id="basic-addon3">
                  				<span class="glyphicon glyphicon-lock"></span>
                			</span>
                			<input type="password" class="form-control" placeholder="确认密码" aria-describedby="basic-addon3">
              			</div>
             			<br>
             			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                			<span class="input-group-addon" id="basic-addon4">
                  				<span class="glyphicon glyphicon-envelope"></span>
                			</span>
               			 	<input type="email" name="user.email" class="form-control" placeholder="邮箱" aria-describedby="basic-addon4">
              			</div>
              			<br>
              			<div class="input-group col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                			<span class="input-group-addon" id="basic-addon5">
                  				<span class="glyphicon glyphicon-home"></span>
                			</span>
               			 	<input type="text" name="user.college" class="form-control" placeholder="学院" aria-describedby="basic-addon5">
              			</div>
              			<br>
              			<div class="modal-footer">
                  			<div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                    			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                   			 	<button type="submit" class="btn btn-primary">保存</button>
                  			</div>
              			</div>
            		</div>
          		</form>
       	 	</div>
      	</div>
    </div>
</body>
</html>