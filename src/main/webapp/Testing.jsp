<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="ServletPratcis" method="post" enctype="multipart/form-data">
			
			<input type="text" placeholder="Enter your name " name="name"><br>

			<input type="text" name="id" id="" placeholder="enter user id"><br>
			<input type="file" name="file" id="file" multiple ><br>
			<button type="submit">Submit </button>

		</form>

	
	
	</div>
</body>
</html>