function login(){
    userData = {
        userName : $("#user-name").val(),
        password : $("#password").val()
    }

    $.ajax({
        url: "/login",
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(userData),
        success: function(data){
            $(".msg").html(data)
            if(data == "welcome.html")
                window.location = '/welcome';
        }
    });

    $("#user-name").val("")
    $("#password").val("")
}