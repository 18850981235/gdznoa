/**
 * Created by Administrator on 2019/7/1.
 */
/**
 * Created by Administrator on 2019/5/30.
 */

function lo(z) {
    $(".paging-in").html(value="");

    var account=$(".account").val();
    var name=$(".name").val();

    $.ajax({
        type: "get",
        url: "/user/useraction/queryUser",
        data: {"account":account,"name":name,"pageIndex":z},
        dataType: "json",
        success: function (data) {
            var qq = data.list;
            var page = data.page;
            var html = "";
            $.each(qq, function (index1, obj1) {
                html += '<tr style="height:40px;text-align:center" >';
                html += '<td style="width:50px">'+index1+'</td>';
                html += '<td style="width:240px">'+obj1.account+'</td>';
                html += '<td style="width:156px">'+obj1.name+'</td>';
                html += '<td style="width:83px">'+obj1.dept.name+'</td>';
                html += '<td style="width:136px">'+obj1.role.name+'</td>';
                if(obj1.sex=="1"){
                    html += '<td style="width:83px ">男</td>';
                }else {
                    html += '<td style="width:83px ">女</td>';
                }
                html += '<td style="width: 136px ">'+obj1.phone+'</td>';
                html += '<td style="width: 209px ">'+obj1.email+'</td>';
                html += '<td style="width:116px">';
                // html += '<a href="/user/user/updateUserPage?id='+obj1.id+' " style="color:blue">详情</a>';
                html += '<a  href="/user/user/updateUserPage?id='+obj1.id+'" style="color:#dea97d; margin-left: 4px  ">修改</a>';
                html += '<a class="del" style="color:#a6d1c0; margin-left: 4px ">删除</a>';
                html += '<div id="confirm" style="display: none" >';
                html += '<p style="margin-bottom: 80px ">' + "是否删除客户联系人信息" + '</p>';
                html += '<a href="/mc/qualification/delete" class="confirm-ok" type="submit" >' + "是" + '</a>';
                html += '<a class="confirm-no" type="submit" >'+"否"+'</a>';
                html += '</div>';
                html += '</td>';
                html += '</tr>';
            });
            $(".paging-in").append(html);
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