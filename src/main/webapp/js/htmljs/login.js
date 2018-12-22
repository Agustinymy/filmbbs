$("#btnRegister").click(function () {
    window.location='register.html';
});
$("#btnLogin").click(function () {
    var uname = $('#uname').val();
    var upass = $('#upass').val();
    var tName=0;
    var tPass=0;
    if (uname==' ' || uname.trim()==null || uname.trim()==''){
        alert('用户名不能为空!');
    } else{
        tName=1;
    }
    if (upass==' ' || upass.trim()==null || upass.trim()==''){
        alert('密码不能为空!');
    } else{
        tPass=1;
    }
    if (tName==1 && tPass==1){
        $.ajax({
            type:'post',
            url:'/userForm/loginExit?uname='+uname+'&upass='+upass,
            dataType:'json',
            success:function (data) {
                alert(data);
                if (data.res==1){
                    alert('登录成功');
                    window.location.href='/userForm/index?uname='+uname;
                } else{
                    alert('登录失败，请重试!');
                }
            }
        });
    }
})