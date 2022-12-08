<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>

<!-- css file of bootstrap -->
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

	<%@ include file="nav_bar.jsp"%>

	<main class=" bg-primary  banner-background" style=" padding-bottom: 90px;">

		<div class="container" >
			<div class="col-md-6 offset-md-3">

				<div class="card">

					<div class="card-header bg-primary text-white text-center"><span class="fa fa-3x fa-user-circle"></span>
					<br>
					Register Here</div>
					<div class="card-body">
					<form id="reg-from" method="post" action="RegisterServlet">
						  <div class="form-group">
						    <label for="exampleInputEmail1">Enter Name</label>
						    <input type="text" class="form-control" name="user_name" id="user_name_id" aria-describedby="emailHelp" placeholder="Enter UserName">
						    <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
						  </div>
						  
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email address</label>
						    <input type="email" class="form-control" name="user_email" aria-describedby="emailHelp" placeholder="Enter email">
						    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						  </div>
						  
						  <div class="form-group">
						    <label for="exampleInputPassword1">Password</label>
						    <input type="password" class="form-control" name="user_password" placeholder="Password">
						  </div>
						  
						  <div class="form-group">
						   <label for="gender">Select Gender</label><br>
						    <input  type="radio" id="user_gender_id" value="male" name="user_gender"> Male 
						    <input type="radio" id="user_gender_id" value="female" name="user_gender"> Female
						  </div>
						  
						  
						  <div class="form-group">
						  <textarea class="form-control"  name="user_details" rows="5" >Tell me something about your self..</textarea>
						  
						  </div>
						  <div class="form-check">
						    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="user_checkbox">
						    <label class="form-check-label" for="exampleCheck1">Agree, Terms & Condition</label>
						  </div>

						  <div class="container text-center" id="loader" style="display: none;">
							<span class="fa fa-refresh fa-spin fa-4x"></span>
							<h4>Please wait...</h4>

						  </div>
						  <button type="submit" id="submit-btn" class="btn btn-primary">Submit</button>
						</form>
					</div>
					<div class="card-footer"></div>
				</div>

			</div>

		</div>
	</main>




	<!-- script file bootstrap style -->
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
		
		<!-- swwt alert js file , for pop message -->
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

		<script>
		
			$(document).ready(function(){
				console.log('loading........');
				$('#reg-from').on('submit', function(event){
					event.preventDefault();
					$('#submit-btn').hide();
					$('#loader').show();

					let form = new FormData(this);
					$.ajax({
						url:"RegisterServlet",
						type: 'POST',
						data : form,
						success : function(data,textStatus, jqXHR){
							console.log(data);
							console.log(textStatus);
							console.log(jqXHR);

							$('#submit-btn').show();
							$('#loader').hide();

							if (data.trim() ==='data have been saved into DB') {
								swal("Register successfully.. we are redirecting to Login Page")
								.then((value) => {
								window.location="Login_page.jsp"
								});
							}else{
								swal(data);
							}
							
						},
						error : function(data, textStatus, jqXHR){
							$('#submit-btn').show();
							$('#loader').hide();

							$('#loader').hide();
							swal("Something Went Wrong, Try Again..")
								
						},
						processData: false,
						contentType: false
					});
				});

			});

		</script>
</body>
</html>