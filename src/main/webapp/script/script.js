

 
function doLike(user_ID, post_ID) {
    console.log(user_ID+" , ", post_ID);
   
    const likeData ={
	//send data in key-value form 
        userID : user_ID,
        postID : post_ID,
        operation : 'like'
    }
    // Cannot add or update a child row: a foreign key constraint 
    // fails (`techblog`.`likes`, CONSTRAINT `post_id` FOREIGN KEY (`post_id`) REFERENCES 
    // `post_table` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE)
    
    $.ajax({
        url :'LikeServlet',
        data : likeData,
        success : function(data, textStatus, jqx){
            console.log("data fro server :"+data);
            if(data.trim()=='true'){
                let c = $(".like-counter").html();
                c++;
                console.log("data in counter class :" + c);
                $('.like-counter').html(c);
            }

        },
        error: function(data, textStatus, jqx){
            console.log(data);
        }
    })
}