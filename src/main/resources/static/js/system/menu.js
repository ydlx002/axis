/**
 * Created by ydlx on 2017/6/4.
 */
$(document).ready(function(){
    $.ajax({
        type: 'POST',
        url: $path_base + 'system/menu/getMenu',
        success: function (data) {
            var obj = new Array();
            $('#nestable2').append(createMenu(obj,data).join(''));
            $("#nestable2").nestable();
        },
        error: function () {
            console.log("错误");
        }
    });



    //
    // $("#nestable-menu").on("click",function(e){
    //     var target=$(e.target),action=target.data("action");
    //     if(action==="expand-all"){
    //         $(".dd").nestable("expandAll")
    //     }
    //     if(action==="collapse-all"){
    //         $(".dd").nestable("collapseAll")
    //     }
    // })



    var createMenu = function(obj, menuList){
        for(var i=0,size=menuList.length;i<size;i++) {
            obj.push("<ol class=\"dd-list\">");
            obj.push("<li class=\"dd-item\" data-id=\"" + menuList[i].id + "\">");
            obj.push("<div class=\"dd-handle\"><span class=\"label label-info\"><i class=\"fa fa-users\"></i></span>" + menuList[i].name + "</div>");
            if (menuList[i].leaf == 0) {
                createMenu(obj, menuList[i].childMenuList);
            }
            obj.push("</li></ol>");
        }
        return obj;
    };

    var updateOutput = function(e)
    {
        var list=e.length?e:$(e.target),output=list.data("output");
        if(window.JSON){
            output.val(window.JSON.stringify(list.nestable("serialize")))
        }else{
            output.val("浏览器不支持")
        }
    };

   // $("#nestable2").on("change",updateOutput($("#nestable2").data("output",$("#nestable2"))));
});