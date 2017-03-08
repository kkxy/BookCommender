<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传书本</title>
<link rel="stylesheet" type="text/css" href="public/bootstrap-3.3.7/dist/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<form class="form" action="uploadbook" method="post">
			<div class="row">
				<div class="col-md-4 col-md-offset-2">
					<div class="form-group">
						<label for="bookname">书籍名称</label>
						<input id="bookname" name="book.bookname">
					</div>
					<div class="form-group">
						<label for="author">作者名称</label>
						<input id="author" name="book.author">
					</div>
					<div class="form-group">
						<label for="press">出版社名称</label>
						<input id="press" name="book.press">
					</div>
					<div class="form-group">
						<label for="place">地点名称</label>
						<input id="place" name="book.place">
					</div>
					<div class="form-group">
						<label for="atypeid">A级类别选择</label>
						<select id="atypeid" onchange="changeClass('a', 'b')" name="book.atype">
							<c:forEach var="acl" items="${aclasslist}" varStatus="st">
								<option value="${acl.itemid}">${acl.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="btypeid">B级类别选择</label>
						<select id="btypeid" onchange="changeClass('b', 'c')" name="book.btype">
							<c:forEach var="bcl" items="${bclasslist}" varStatus="st">
								<option value="${bcl.itemid}">${bcl.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="ctypeid">C级类别选择</label>
						<select id="ctypeid" name="book.ctype">
							<c:forEach var="ccl" items="${cclasslist}" varStatus="st">
								<option value="${ccl.itemid}">${ccl.name}</option>
							</c:forEach>
						</select>
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
				<form class="form" action="getbkfile" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="postbookfile">提交附件</label>
						<s:file name="upload" id="postbookfile"></s:file>
					</div>
					<button class="btn btn-primary" type="submit">提交</button>
				</form>
			</div>
		</div>
		
	</div>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js" ></script>
	<script type="text/javascript" src="public/bootstrap-3.3.7/docs/dist/js/bootstrap.js" ></script>
	<script type="text/javascript" src="public/js/func.js" ></script>
</body>
</html>