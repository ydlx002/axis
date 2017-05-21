/**
 * Created by ydlx on 2017/5/13.
 */
$(function(){
    $("#btn_login").bind('click', function () {
        var userName =
        $.ajax({
            type: 'POST',
            url:  $path_base + 'login',
            beforeSend: function(){
                //$this.button('loading');
                //$('#loginBtn').button('loading');
            },
            data: {"loginAccount": userName, "password": passwordEncrypt(password)},
            success: function(data){
                if(data != null && data != ''){
                    var d = eval('(' + data + ')');
                    $('#loginBtn').button('complete');
                    if(d.flag == 1){
                        $code.attr('data-original-title', d.errorInfo).tooltip('show');
                    }else if(d.flag == 0){//用户名不存 或者密码错误
                        $error.text("用户名不存或者密码错误,请重新输入！");
                    }
                    reloadVerificationCode($codeImage);
                }else{
                    window.location.href = "${ctx}/home.htmls";
                }
            }
        });
    })
});


//表单密码加密(RSA)
function passwordEncrypt(password) {
    RSAUtils.setMaxDigits(200);
    var key = new RSAUtils.getKeyPair('${pubexponent}', '', '${pubmodules}');
    var encrypedPwd = RSAUtils.encryptedString(key, password);
    return encrypedPwd;
}