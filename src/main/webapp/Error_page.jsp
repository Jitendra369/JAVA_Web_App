<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!--Define the Error Page  -->
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="./css/style.css">
<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 95%, 61% 89%, 31% 100%, 0 90%, 0 0);
}
</style>

<title>This is Error Page</title>
</head>
<body>
	<h4></h4>

	<div class="container text-center">
	
	<img alt="" src="./images/warning.png" class="img-fluid">
	<h3 class="display-3">Something went wrong....</h3>
	
	<button type="button" class="btn btn-primary btn-lg mt-3" onclick="goHome();">Home</button>
	</div>
	<script>
	/* Redirecting the Page to Home Page  */
		function goHome(){
			window.location="Index.jsp"
		}
	</script>
</body>
</html>