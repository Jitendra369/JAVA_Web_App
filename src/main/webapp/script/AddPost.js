/**
 * 
 */
 
 $(document).ready( function(element){
    $("#id-post-form").on("submit", function(event){
        event.preventDefault();
        let form = new FormData(this);
        // console.log('user form');
        // console.log(form);

        $.ajax({
            url:"AddPostTitleServlet",
            type: 'POST',
            data:form,
            success : function(data, status, info){
                if(data.trim()=='done'){
                    swal("Good job!", "You Post Has been uploaded", "success");
                    
                   
                }else{
					swal("Error!", "Something Went Wrong!", "error");
                    
                }
            }, 	
            error: function(data, status, info){
				console.log(data)
            },
            processData: false,
            contentType: false
        })
    })
 })