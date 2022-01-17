<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
	<title>메인 화면</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"> <!-- 부트스트랩  css -->
	<style>
		#wrap {
		    width: 800px;
		    margin: 0 auto 0 auto;
		    background-color: #f5f5f5;
		}
		
		#header {
		    text-align: center;
		    width: 800px;
		    height: 150px;
		    padding: 60px 0px;
		}
		
		#main {
		    float: left;
		    width: 800px;
		    height: 500px;
		    text-align:center;
		    vertical-align: middle;
		}
	</style>
	</head>
	<body>
    	<jsp:include page="header.jsp" /> <!-- header page 공통적으로 포함 -->
		
		<c:set var="contentPage" value="${param.contentPage}"/> <!-- 파라미터로 전달된 contentPage 받아오기 -->
			<c:if test="${contentPage==null}">
				<jsp:include page="firstView.jsp" /> <!-- 전달된 contentPage가 없다면  -->
			</c:if>
		
		<jsp:include page="${contentPage}"/> <!-- 전달된 contentPage가 있다면 -->      
	</body>
	
	<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script> <!-- jQuery -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script> <!-- 부트스트랩 js -->
</html>


