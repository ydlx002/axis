/**
 * Created by ydlx on 2017/6/4.
 */
$(document).ready(function(){
    var menuAddFlag=0;//新增菜单
    var menuEditFlag=0;//编辑菜单
    $.ajax({
        type: 'POST',
        url: $path_base + 'system/menu/getMenu',
        success: function (data) {
            $('#nestable2').append(createMenu(new Array(),data).join('')).nestable();
        },
        error: function () {
            console.log("错误");
        }
    });

    $("#nestable-menu").on("click",function(e){
        var target=$(e.target),action=target.data("action");
        if(action==="expand-all"){
            $(".dd").nestable("expandAll")
        }
        if(action==="collapse-all"){
            $(".dd").nestable("collapseAll")
        }
    })

    var createMenu = function(obj, menuList){
        for(var i=0,size=menuList.length;i<size;i++) {
            obj.push("<ol class=\"dd-list\">");
            obj.push("<li class=\"dd-item\" data-id=\"" + menuList[i].id + "\">");
            obj.push("<div class=\"dd-handle\">");
            obj.push("<span class=\"pull-right\"><i class=\"fa fa-edit\" style='margin-right:10px'></i><i class=\"fa fa-trash\"></i></span>");
            obj.push("<span class=\"label label-info\"><i class=\""+menuList[i].icon+"\"></i></span>" + menuList[i].name + "</div>");
            if (menuList[i].leaf == 0) {
                createMenu(obj, menuList[i].childMenuList);
            }
            obj.push("</div></li></ol>");
        }
        return obj;
    };

    $(".select_box").click(function(event){
        event.stopPropagation();
        $(this).find(".option").toggle();
        $(this).parent().siblings().find(".option").hide();
    });
    /*赋值给文本框*/
    $(".option a").click(function(){
        $(".select_txt").empty();
        $(this).parent().siblings(".select_txt").append($(this).clone(true));
    });

    $(document).click(function(event){
        var eo=$(event.target);
        if($(".select_box").is(":visible")&&eo.attr("class")!="option"&&!eo.parent(".option").length){
            $('.option').hide();
        }
        //新增菜单标识
        if(menuAddFlag==1&&eo.parent(".dd-item").length){
            $('#parentMenu').val(eo.text());
            $('#parentMenuId').val(eo.parent().attr('data-id'));
        }

    });

});