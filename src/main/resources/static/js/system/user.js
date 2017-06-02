/**
 * Created by ydlx on 2017/6/1.
 */
$(document).ready(function(){
    $.jgrid.defaults.styleUI="Bootstrap";
    $("#table_list_2").jqGrid({
        url: $path_base+'system/user/getList',
        mtype: 'POST',
        datatype : 'json',
        postData: {},
        height:450,
        autowidth:true,
        shrinkToFit:true,
        rowNum:20,
        rowList:[10,20,30],
        colNames:["序号","登录名","姓名","电子邮箱","电话","昵称","创建时间","修改时间","操作员","操作"],
        colModel:[
            {name:"id",index:"id",editable:true,sorttype:"int",search:true},
            {name:"loginAccount",index:"loginAccount",editable:false,align:"left"},
            {name:"userName",index:"userName",editable:false,align:"left"},
            {name:"email",index:"email",editable:false,align:"left"},
            {name:"mobile",index:"mobile",editable:false,align:"left"},
            {name:"nickName",index:"nickName",editable:false,align:"left"},
            {name:"createTime",index:"createTime",editable:false,align:"left",sorttype:"date",formatter:"date"},
            {name:"modifyTime",index:"modifyTime",editable:false,align:"left",sorttype:"date",formatter:"date"},
            {name:"operator",index:"operator",editable:false,align:"left"},
            {name:"act",index:"act",editable:false,sortable:false}
        ],
        pager:"#pager_list_2",
        viewrecords:true,
        caption:"用户管理",
        add:true,
        edit:true,
        addtext:"Add",
        edittext:"Edit",
        hidegrid:false,
        jsonReader : {
            id: "id",
            root: 'content',
            page: 'number',
            total: 'totalPages',
            records: 'totalElements',
            repeatitems: false
        },
    });
    $("#table_list_2").setSelection(4,true);
    $("#table_list_2").jqGrid("navGrid","#pager_list_2",{edit:true,add:true,del:true,search:true},{height:200,reloadAfterSubmit:true});
    $(window).bind("resize",function(){
        var width=$(".jqGrid_wrapper").width();
        $("#table_list_2").setGridWidth(width)
    })
});