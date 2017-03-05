<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左侧导航栏</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<c:forEach items="${bigclass}" var="bc" varStatus="st">
					<c:choose>
						<c:when test="${nowtype != 'a'}">
							<p class="lead">
								<strong>${bc.name}</strong>
								<a href="index?typeid=${bc.typeid}&classtype=${lasttype}"><small>返回</small></a>
							</p>
						</c:when>
						<c:otherwise>
							<p class="lead"><strong>${bc.name}</strong></p>
						</c:otherwise>
					</c:choose>
					<c:if test="${! empty smallclass}">
						<ol class="breadcrumb">
							<c:forEach begin="${count[st.index]}" end="${count[st.index + 1] - 1}" step="1" var="x">
								<li><a href="index?typeid=${smallclass[x].itemid}&classtype=${nexttype}">${smallclass[x].name}</a></li>
							</c:forEach>
						</ol> 
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>