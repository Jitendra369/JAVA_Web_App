


<%@page import="com.tec.blog.entities.Users"%>
<%@page import="com.tec.blog.dao.LikeDAO"%>
<%@page import="com.tec.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.tec.blog.helpers.ConnectionProvider"%>
<%@page import="com.tec.blog.dao.PostDAO"%>

<div class="row">
<%

	Users user =(Users) session.getAttribute("current_user");
	Thread.sleep(1000);
	List<Post> listPost = null;
	PostDAO  postDao = new PostDAO(ConnectionProvider.getConnection());
	int cid = Integer.parseInt(request.getParameter("cid"));
	if(cid==0){
		listPost = postDao.getAllPost();	
	}else{
		listPost = postDao.getAllPostByCateg(cid);
	}
	
	if(listPost.size()==0){
		out.println("<h2 class='display-3 text-center'> No Post Avaliable in this catgoery </h2>");
	}


	
	for(Post ps : listPost){
		%>
        <div class="col-md-6 mt-2">
            <div class="card">
             <img class="card-img-top" src="images/<%= ps.getPostPicture() %>" alt="Card image cap">
                <div class="card-body">
                    <b><%= ps.getPostTitle() %></b></br>
                    <p><%= ps.getPostContent() %></p>
                    
                </div>
                
                <%
                LikeDAO dao = new LikeDAO(ConnectionProvider.getConnection());
                
                
                %>
                 
                
                <div class="card-footer">
                    <a href="Show_blog_page.jsp?post_id=<%= ps.getPostID() %>" class="btn btn-outline-primary btn-sm"> Read more..</a>
                    <p> Post ID: <%= ps.getPostID() %></p>
                    <a href="#!" onclick="doLike(<%= user.getId()  %>, <%= ps.getPostID() %>)" class="btn btn-outline-primary btn-sm"> <i class="fa fa-thumbs-o-up"><span class="like-counter"> <%= dao.getLikeOnPost(ps.getPostID()) %></span></i></a>
                    <a href="#!" class="btn btn-outline-primary btn-sm"> <i class="fa fa-commenting-o"><span> 20</span></i></a>
                </div>
            </div>

        </div>
		
<%		
	}
	

%>
</div>
<script src="./script/script.js"></script>