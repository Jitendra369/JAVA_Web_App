

//function doComment(postID, userID, comment){
	//alert('inside doComment');
    //console.log('comment handling');
    //alert(postID, userID, comment)
    
//}

comment_obj = null;

    function doComment(postID, userID){
       let user_comment  = $('#user_comment').val();
        alert(postID, userID, user_comment)
        // validation 

        if(user_comment.trim() == ""){
            console.log("Enter some comment ");
            return;
        }
        
        console.log(postID, userID, user_comment)
    
        comment_obj = {
            post_id : postID,
            userID : userID,
            comment : user_comment
        }
        //$('#user_comment').val("");
    
        $.ajax({
            url:'AddCommentServlet',
            data : comment_obj, 
            success : function(data, textStatus, ajax){
					console.log(data);
                    const json  = JSON.parse(data);
                if(json.status=="success"){
                //   todo: set the data comming from servler to UI
                  

                    

                    console.log("comment save in database");
                    $('#user_comment').val("");
                }
            }, error :  function(data, textStatus, ajax){
                    console.log("data has not been added in the database...");
                    $('#user_comment').val("");
            }
        })
        
    
    }



