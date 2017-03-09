<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推荐列表</title>
</head>
<body>
	<c:if test="${! empty user}">
		<p class="lead">你可能想借的书</p>
		<c:forEach items="${recobooklist}" var="rbl" varStatus="st">
			<div class="row">
				<div class="thumbnail">
					<c:choose>
	  					<c:when test="${! empty rbl.head}">
			  				<img src="public/img/${rbl.head}.jpg" style="width:100px;height:150px"/>
	  					</c:when>
	  					<c:otherwise>
	  						<img src="public/img/notfound.png" style="width:100px;height:150px"/>
	  					</c:otherwise>
	  				</c:choose>
				    <div class="caption">
					    <h5 class="text-overflow">${rbl.bookname}</h5>
						    <p class="text-overflow">作者：${rbl.author}</p>
						<c:if test="${! empty user}">
							<c:choose>
								<c:when test="${recoorder[st.index] == 0}">
								    <button id="recobuybtn_${rbl.id}" type="button" class="btn btn-primary" onclick="putwishcart('reco', ${rbl.id})">借书</button>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-primary" disabled="disabled">已借</button>
								</c:otherwise>
							</c:choose>
						</c:if>
					    <a href="bookdetail?bookid=${rbl.id}" class="btn btn-primary" role="button">详情</a>
				    </div>
				</div>
			</div>
		</c:forEach>
	</c:if>
</body>
</html>