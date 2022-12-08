/**
 * 
 */
// let display_details = document.getElementById("prifile-details");
// display_details.style.display ='none'

$(document).ready(function(){
    // alert('ready');

    // id="edit_save-btn" - btn for -save the data 
    // prifile-details -display the data
    // profile-edit  - edit the  Data

   $('#profile-edit').hide();
   let editStatus =false;
     
    $('#edit_details-btn').click(function(){
        // alert('cilcked')
        if(editStatus== false){
            $('#prifile-details').hide();
            $('#profile-edit').show();
            editStatus = true;
            $(this).text('Back');
        }else{
            $('#prifile-details').show();
            $('#profile-edit').hide();
            editStatus = false;
            $(this).text('Edit Details');
        }


        
    });
    
    

})