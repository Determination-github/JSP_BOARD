<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    
    <script type="text/javascript">
       function changeResultView(value){
               if(value == "0") // "네" 클릭시 로그인 화면으로 이동
               {
                   location.href="LoginForm.do";
               }
               else if(value == "1") // "아니요" 클릭시 메인으로 이동
               {
                   location.href="main.do";
               }
       }
       
    </script>
    <title>요청이 완료되었습니다.</title>
  </head>
  <body class="text-center">
  <c:set var="msg" value="${sessionScope.msg}" scope="session"/>
  	<c:choose>
  	<c:when test="${msg!=null && msg=='0'}">
		<div class="modal modal-alert position-static d-block bg-secondary py-5" tabindex="-1" role="dialog" id="modalChoice">
	  		<div class="modal-dialog" role="document">
	    		<div class="modal-content rounded-4 shadow">
	      			<div class="modal-body p-4 text-center">
	       				<h5 class="mb-0">로그인 하시겠습니까?</h5>
	        			<p class="mb-0">회원가입한 정보로 로그인 해주세요.</p>
	     		    </div>
	      			<div class="modal-footer flex-nowrap p-0">
	        			<button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 m-0 rounded-0 border-right" onclick="changeResultView(0)"><strong>네. 로그인 하겠습니다.</strong></button>
	        			<button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 m-0 rounded-0" data-bs-dismiss="modal" onclick="changeResultView(1)">아니요. 괜찮습니다.</button>
	      			</div>
	    		</div>
	  		</div>
		</div>
	</c:when>
  	<c:when test="${msg!=null && msg=='1'}">
		<div class="modal modal-alert position-static d-block bg-secondary py-5" tabindex="-1" role="dialog" id="modalChoice">
	  		<div class="modal-dialog" role="document">
	    		<div class="modal-content rounded-4 shadow">
	      			<div class="modal-body p-4 text-center">
	       				<h5 class="mb-0">회원정보가 수정되었습니다.</h5>
	        			<p class="mb-0">수정된 정보로 로그인 해주세요.</p>
	     		    </div>
	      			<div class="modal-footer flex-nowrap p-0">
	        			<button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 m-0 rounded-0 border-right" onclick="changeResultView(0)"><strong>네. 로그인 하겠습니다.</strong></button>
	        			<button type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 m-0 rounded-0" data-bs-dismiss="modal" onclick="changeResultView(1)">아니요. 괜찮습니다.</button>
	      			</div>
	    		</div>
	  		</div>
		</div>
	</c:when>
	</c:choose>
  </body>
</html>