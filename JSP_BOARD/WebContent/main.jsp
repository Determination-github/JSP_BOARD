<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%-- <%
    String contentPage=request.getParameter("contentPage");
    if(contentPage==null)
        contentPage="FirstView.jsp";
%> --%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <title>메인 화면</title>
    
	<style>
        /* 
        레이아웃 전체 가운데 정렬 태그  
        - margin:0 auto 0 auto;(시계방향으로 위, 오른쪽, 아래, 왼쪽)
        왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬이 된다. 
        
        전체를 감싸주는 태그 #wrap 
        */
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
        <jsp:include page="${contentPage}" />       
    <script src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>


