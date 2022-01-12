<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<style type="text/css">
		.container{
			margin-top: 100px;
		}
		.input-group{
			margin-bottom: 5px;
		}
		#btn{
			margin-top: 20px;
		}
	</style>
	<script type="text/javascript">
		function checkValue() {
			const form = document.boardForm;
			const subject = form.boardSubject.value;
			const content = form.boardContent.value;
			
			if(!subject) {
				alert("제목을 입력해주세요.");
				return false;
			} else if(!content) {
				alert("내용을 입력해주세요.");
				return false;
			}
		}
		function goToList() {
			location.href = "BoardListAction.bo";
		}
	</script>
</head>
<body>
	<div class="container">
		<form method="post" action="BoardWriteAction.bo" name="boardForm" enctype="multipart/form-data" onsubmit="return checkValue()">
			<input type="hidden" name="boardID" value="${sessionScope.memberID}">
			<div class="input-group">
	  			<span class="input-group-text" id="inputGroup-sizing-default">제목</span>
	  			<input name="boardSubject" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
				<input name="boardFile" type="file" class="form-control" id="inputGroupFile02">
				<label class="input-group-text" for="inputGroupFile02">Upload</label>
			</div>
			<div class="input-group">
	  			<span class="input-group-text">내용</span>
	  			<textarea name="boardContent" class="form-control" aria-label="With textarea" rows="20"></textarea>
			</div>
	
			<div id="btn" class="d-grid gap-2 d-sm-flex justify-content-sm-center">
				<input type="submit" class="btn btn-primary btn-sm px-3 gap-3" value="등록"></button>
				<input type="button" class="btn btn-outline-secondary btn-sm px-3" value="취소" onclick="goToList()"></input>
			</div>
		</form>
	</div>
	<script src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>