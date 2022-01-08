<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
<head>
    <title>메인 화면</title>
    
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
        <jsp:include page="header.jsp" />
        <c:set var="contentPage" value="${param.contentPage}"/>
	        <c:if test="${contentPage==null}">
	       		<jsp:include page="firstView.jsp" />
	       	</c:if>
	       		<jsp:include page="${contentPage}"/>       
</body>
</html>


