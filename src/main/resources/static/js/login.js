/**
 * Created by ydlx on 2017/5/13.
 */
$(function(){
    $("#btn_login").bind('click', function () {
        var postData = {};
        postData.loginAccount = $("#loginAccount").val();
        postData.password = passwordEncrypt($("#password").val());
        console.log(postData);
        $.ajax({
            type: 'POST',
            url:  $path_base + 'login',
            data: postData,
            success: function(data){
                console.log(data);
                if (data.resultCode != '00000000') {
                    $("#tip").html("用户名不存或者密码错误,请重新输入！");
                    return;
                } else {
                    window.location.href = $path_base + "index";
                }
            },
            error:function () {
                $("#tip").html("系统错误！");
            }
        });
    });
});


//表单密码加密(RSA)
function passwordEncrypt(password) {
    RSAUtils.setMaxDigits(200);
    var key = new RSAUtils.getKeyPair($("#pubexponent").val(), '', $("#pubmodules").val());
    var encrypedPwd = RSAUtils.encryptedString(key, password);
    return encrypedPwd;
}