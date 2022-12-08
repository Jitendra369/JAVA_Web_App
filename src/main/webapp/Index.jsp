<%@page import="com.tec.blog.dao.PostDAO"%>
<%@page import="com.tec.blog.helpers.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page errorPage="Error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
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
<script type="text/javascript" src="./script/script.js"></script>

<title>Home Page </title>
</head>
<body>

	<!-- nav-bar -->
	<%@ include file="nav_bar.jsp"%>

	<!-- container -->
	<div class="container-fluid p-0 m-o banner-background">
		<div class="jumbotron back bg-primary text-white">
			<div class="container">
				<h3 class="display-3">Welcome, To Programming World.</h3>
				<h3>What is Programming</h3>
				<p>A programming language is any set of rules that converts
					strings, or graphical program elements in the case of visual
					programming languages, to various kinds of machine code
					output.[citation needed] Programming languages are one kind of
					computer language, and are used in computer programming to
					implement algorithms. Most programming languages consist of
					instructions for computers.</p>
				<button type="button" class="btn btn-outline-light btn-lg">
					<span class="fa fa-paper-plane-o"></span> Start it is Free
				</button>
				
				<!-- login button -->
				<a href="Login_page.jsp" type="button" class="btn btn-outline-light btn-lg">
					<span class="fa fa-user-circle-o fa-spin"></span> Login In
				</a>

			</div>
		</div>
	</div>

<%
PostDAO dao = new PostDAO(ConnectionProvider.getConnection());

%>

	<!-- cards -->
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Java <span class="fa fa-paperclip"> <%= dao.getAllPostByCateg(1).size() %> Article</span></h5>
							
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="CheckUserAuthe" class="btn btn-primary">Read More</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Python <span class="fa fa-paperclip"> <%= dao.getAllPostByCateg(3).size() %> Article</span></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="btn btn-primary">Read More</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Android <span class="fa fa-paperclip"> <%= dao.getAllPostByCateg(2).size() %> Article</span></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="btn btn-primary">Read More</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Node Js <span class="fa fa-paperclip"> <%= dao.getAllPostByCateg(4).size() %> Article</span></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="btn btn-primary">Read More</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">C++ <span class="fa fa-paperclip"> <%= dao.getAllPostByCateg(5).size() %> Article</span></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="btn btn-primary">Read More</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Machine Learning</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="btn btn-primary">Read More</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>



</body>
</html>