<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	function methodA(){
		alert("methodA 호출")
		let pic=5;
		$.ajax({
	          method: "get",
	          url:
	            "b.jsp?id=" +
	            pic +
	            "&timestamp=" +
	            new Date().getTime(),
	          dataType: "html",
	          success: function (result) {
	        	  console.log(result);
	            $("#d_pic").css("left", $(td).offset().left + 50 + "px");
	            $("#d_pic").css("top", $(td).offset().top + "px");
	            $("#d_pic").html(result);
	          },
	        });
	}
</script>
<title>Insert title here</title>
</head>
<body onLoad="methodA()">
<div id="d_pic">5</div>
</body>
</html>