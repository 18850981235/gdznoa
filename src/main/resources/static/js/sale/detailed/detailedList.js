/**
 * Created by Administrator on 2019/6/10.
 */

function lo(z) {
    $(".sea2").html(value="");
    var branchName=$(".branchName").val();

    var projectId=$("#ap").val();


    var systemId=$(".systemId").val();
    var subitemId=$(".subitemId").val();

    //
    $.ajax({
        type:"get",
        url:"/sd/Inventory/quyry",
        data:{ "projectId":projectId,"branchName":branchName,"systemId":systemId,"subitemId":subitemId,"pageIndex":z},
        dataType:"json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";
            $.each(list, function (index1, obj1) {
                html += '<tr class="seal" style="height: 40px">';
                html += '<td style="width: 250px ">'+obj1.project.name+'</td>';
                html += ' <td style="width: 250px ">'+obj1.system.name+'</td>';
                html += '<td style="width: 250px ">'+obj1.branchName+'</td>';
                html += ' <td style="width: 250px ">'+obj1.subitem.name+'</td>';
                html += '<td style="width:140px">';
                html += '<a href="/mc/qualification/detail?id='+obj1.id+'" style="color:blue">详情</a>';
                html += '<a  href="/mc/qualification/update?id='+obj1.id+'" style="color:#dea97d; margin-left: 4px  ">编辑</a>';
                html += '<a class="del" style="color:#a6d1c0; margin-left: 4px ">删除</a>';
                html += '<div id="confirm" style="display: none" >';
                html += '<p style="margin-bottom: 80px ">' + "是否删除客户联系人信息" + '</p>';
                html += '<a href="/mc/qualification/delete" class="confirm-ok" type="submit" >' + "是" + '</a>';
                html += '<a class="confirm-no" type="submit" >'+"否"+'</a>';
                html += '</div>';
                html += '</td>';
                html += '</tr>';
            });
            $(".sea2").append(html);
            var options = {
                bootstrapMajorVersion: 1,    //版本
                currentPage: data.page.currentPageNo,    //当前页数
                numberOfPages: 5,    //最多显示Page页
                totalPages: data.page.totalPageCount,    //所有数据可以显示的页数
                // onPageClicked:function(e,originalEvent,type,page){
                onPageChanged: function (event, originalEvent, typePage, currentPage) {  //点击事件
                    lo(typePage);
                }
            };
            $("#paginator-test").bootstrapPaginator(options);
        }
        // });

    })
}

$(document).ready(function () {
    lo();
})
$(document).on("click",".del",function () {
    $("#confirm").show();
})
$(document).on("click",".confirm-no",function () {
    $("#confirm").hide();
})
$(document).on("click",".query",function () {
    console.log(1);
    lo();
})
$.ajax({
    type:"post",
    dataType:"json",
    url:"/sd/SdSalesContract/getProject",
    success:function (data) {
        $.each(data,function (index,obj) {
            var html="";
            html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

            $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        })
    }
});