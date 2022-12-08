<%@page import="com.tec.blog.entities.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tec.blog.helpers.ConnectionProvider"%>
<%@page import="com.tec.blog.dao.PostDAO"%>
<%@page import="com.tec.blog.entities.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page errorPage="Error_page.jsp"%>


<%
/* getting the current user , which has been set during login user  */
Users user = (Users) session.getAttribute("current_user");
if (user == null) {
	response.sendRedirect("Login_page.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>

	<!-- start of NAV Bar  -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="Index.jsp"><span
			class="fa fa-area-chart"></span> ProBloc</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#"><span
						class="fa fa-archive"></span> Home <span class="sr-only">(current)</span></a>
				</li>

				<!-- <li class="nav-item"><a class="nav-link" href="#"><span
						class="fa fa-bank"></span> Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <span class="fa fa-cart-plus"></span>
						Dropdown
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div> -->

				<li class="nav-item active" data-toggle="modal"
					data-target="#post_model"><a class="nav-link" href="#"><span
						class="fa fa-cart-plus"></span> Create Post <span class="sr-only">(current)</span></a>
				</li>
			</ul>

			<!-- User Button, toggleBlock applied here -->
			<ul class="navbar-nav mr-right">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal" href="#!"><span
						class="fa fa-user-circle"></span> <%=user.getName()%></a></li>


				<li class="nav-item "><a class="nav-link" href="LogOutServlet"><span
						class="fa fa-archive"></span> Log Out</a></li>
			</ul>

		</div>
	</nav>
	<!-- end of NAV Bar -->

<!-- main body of the page -->

		<main>
			<div class="container">
				<!-- first col -->
				<div class="row mt-3">
					<div class="col-md-4">
						<!-- categories -->
						<div class="list-group">
							<a href="#" onclick="getPost(0, this)" class=" c-link list-group-item list-group-item-action active">
							  All Post
							</a>
							
							<%
							PostDAO postDAOList = new PostDAO(ConnectionProvider.getConnection());
							ArrayList<Categories> list  = postDAOList.getAllCategories();
							for(Categories categories : list){
								%>
									<a href="#" onclick="getPost(<%= categories.getCate_id() %>, this)" class=" c-link list-group-item list-group-item-action"><%= categories.getCate_name() %></a>
								<%
							}
							%>
						  </div>
					</div>
					<!-- second col -->
					<div class="col-md-8">
						<!-- post -->
						<div class="container text-center" id="loader" >
							<li class=" fa fa-refresh fa-3x fa-spin"></li>
							<h3 class="mt-3">Loading...</h3>
						</div>
						<div class="container-fluid" id="post-container">


						</div>
					</div>
				</div>
			</div>

		</main>
<!-- end of main body -->


	<!-- Modal which poped on the screen -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content text-center">
				<div class="modal-header text-white bg-primary text-center">
					<h5 class="modal-title" id="exampleModalLabel">
						Hello,
						<%=user.getName().toUpperCase()%></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<!-- get the image form the user object -->
						<img src="images/<%=user.getProfile()%>"
							style="border-radius: 50%; max-width: 150px;"> <label><%=user.getProfile()%></label>


						<h5 class="modal-title mt-3">

							<%=user.getName().toUpperCase()%>
						</h5>

						<!--User Details  -->

						<div id="prifile-details">

							<!-- table-details -->

							<table class="table text-left">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<td scope="col"><%=user.getId()%></td>

									</tr>
									<tr>
										<th scope="col">Name</th>
										<td scope="col"><%=user.getName()%></td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">Email</th>
										<td><%=user.getEmail()%></td>

									</tr>
									<tr>
										<th scope="row">Password</th>
										<td><%=user.getPassword()%></td>

									</tr>

									<tr>
										<th scope="row">Gender</th>
										<td><%=user.getGender()%></td>

									</tr>

									<tr>
										<th scope="row">About</th>
										<td><%=user.getAbout()%></td>

									</tr>

									<tr>
										<th scope="row">Date of Joining</th>
										<td><%=user.getDateTime().toString()%></td>

									</tr>
								</tbody>
							</table>

						</div>

						<div id="profile-edit">

							<!--Display the Editable user details  -->
							<form action="EditDetailsSaveServlet" method="post"
								enctype="multipart/form-data">

								<table class="table text-left">
									<thead>
										<tr>
											<!-- not change  -->
											<th scope="col">ID</th>
											<td scope="col"><%=user.getId()%></td>

										</tr>

										<tr>
											<td scope="col">Name</td>
											<td scope="col"><input type="text" name="name"
												class="form-control" value="<%=user.getName()%>"></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">Email</th>
											<td><input type="text" name="email" class="form-control"
												value="<%=user.getEmail()%>"></td>
										</tr>

										<tr>
											<th scope="row">Password</th>
											<td><input class="form-control" type="password"
												name="password" value="<%=user.getPassword()%>"></td>

										</tr>

										<tr>
											<!-- not change  -->
											<th scope="row">Gender</th>
											<td><%=user.getGender().toUpperCase()%></td>

										</tr>

										<tr>
											<th scope="row">About</th>
											<td><textarea rows="5" cols="35" name="about"
													value="<%=user.getAbout()%>"></textarea></td>
										</tr>
										<tr>
											<td>New Profile Pic</td>
											<td><input type="file" name="profile"
												class="form-control"></td>

										</tr>

										<tr>
											<!-- not change  -->
											<th scope="row">Date of Joining</th>
											<td><%=user.getDateTime().toString()%></td>

										</tr>
									</tbody>
								</table>
								<div>
									<button type="submit" class="btn btn-primary">Save
										Details</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="edit_details-btn" class="btn btn-primary">Edit
						Details</button>
					<button type="button" id="edit_save-btn" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- end : live model -->

	<!-- Start Post Model  -->

	<!-- Modal -->
	<div class="modal fade" id="post_model" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Blog Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>


				<div class="modal-body">
					<form method="post" id="id-post-form" action="AddPostTitleServlet">

						<div class="form-group">
							<select class="form-control" name="post_cat" id="">
								<option value="" selected disabled>-------Select Your
									Category---------</option>
								<%
								/* getting cateory from the database categoery table */
								PostDAO postDAO = new PostDAO(ConnectionProvider.getConnection());
								ArrayList<Categories> catList = postDAO.getAllCategories();

								for (Categories cat : catList) {
								%>

								<option value="<%=cat.getCate_id()%>"><%=cat.getCate_name()%></option>

								<%
								}
								%>

							</select>
						</div>


						<div class="form-group">
							<input type="text" name="post_title" class="form-control"
								placeholder="Enter Post Title" required="required">
						</div>
						<div class="form-group">
							<textarea class="form-control" name="post_content" id=""
								cols="30" rows="10" placeholder="Enter Post Content"></textarea>
						</div>

						<div class="form-group">
							<textarea class="form-control" name="post_code" id="" cols="30"
								rows="10" placeholder="Enter Code " required="required"></textarea>
						</div>
						<div class="form-group">
							<label for="">Select Your File</label> <br> <input
								type="file" name="file" multiple>

						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-outline-primary" >Post</button>

						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- End Post Model  -->



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

	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script src="./script/profile_page.js"></script>
	<script type="text/javascript" src="./script/AddPost.js"></script>

	<script>
	
	// categ. navigation 
		function getPost(catID, temp){
			$('#loader').show();
			$('#post-container').hide();
			$('.c-link').removeClass('active');

			$.ajax({
				url:'LoadPostPage.jsp',
				data :{ cid: catID},
				success : function(data, textStatus,jqXHR){
					console.log(data);
					console.log(catID);

					$(temp).addClass('active');
					$('#loader').hide();
					$('#post-container').show();
					$('#post-container').html(data);
				}

			})
		}

		$(document).ready(function(e){
			// alert('loading')
			// select all post initially, getting first Element & pass to function
			let allRef = $('.c-link')[0];
			getPost(0,allRef);

		})
	</script>

</body>
</html>