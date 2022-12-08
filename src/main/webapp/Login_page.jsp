<%@page import="com.tec.blog.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>


<!-- css files -->
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

</head>
<body>
	<!-- nav-bar -->
	<%@include file="nav_bar.jsp"%>

	<main class="d-flex align-items-center bg-primary banner-background"
		style="height: 80vh">
		<div class="container">
			<div class=row>
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-header bg-primary text-white text-center">
							<span class="fa fa-user-plus fa-3x"></span>
							<p>Login Here</p>
						</div>
						<%
						Message msg = (Message) session.getAttribute("message");
						if (msg != null) {
						%>
						<!-- message contain the css class, which apply once the result comes  -->
						<div class="alert text-center <%= msg.getCssClass() %>" role="alert">
							<%= msg.getContent() %>
						</div>

						<%
						session.removeAttribute("message");
						}
						%>

						<div class="card-body">
							<form method="post" action="LoginServlet">
								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> <input
										type="email" name="user_email" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp"
										placeholder="Enter email"> <small id="emailHelp"
										class="form-text text-muted">We'll never share your
										email with anyone else.</small>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" name="password" class="form-control"
										id="exampleInputPassword1" placeholder="Password">
								</div>
								<div class="form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1"> <label class="form-check-label"
										for="exampleCheck1">Agree to Terms & Condition</label>
								</div>
								<div class="container text-center">
								
								<%-- <%
								String arr[] = {"jittu","neetu","pooja","ratna","sahebrao"};
								for(String str: arr){
									%>
									
									<h4> <%= str %></h4>
								<%		
								}
								
								%> --%>
								
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>

							</form>
						</div>

					</div>

				</div>
			</div>
		</div>
	</main>




	<!-- javaScript files -->
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