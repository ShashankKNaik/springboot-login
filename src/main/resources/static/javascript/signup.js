function signup(){

    if ($("#password").val() != $("#confirm-password").val()){
        $(".msg").html("<p class='warning'>Password not matching</p>")
        return;
    }

    userData = {
        userName : $("#user-name").val(),
        password : $("#password").val()
    }

    $.ajax({
        url: "/signup",
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(userData),
        success: function(data){
            $(".msg").html(data)
        }
    });

    $("#user-name").val("")
    $("#password").val("")
    $("#confirm-password").val("")
}