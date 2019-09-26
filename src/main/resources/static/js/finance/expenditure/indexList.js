/**
 * Created by Administrator on 2019/8/19.
 */
function lo(z) {
    $(".sea2").html(value="");
    var projectName=$(".projectName").val();
    // var  project= $.cookie("name");
    var  projectid= $.cookie("id");
    var  ferf= $.cookie("herf");

    $.ajax({
        type: "get",
        url: "/ga/payment/query.html?projectId="+projectid+"&matter="+ferf,
        // url: "/ga/payment/query.html?projectId="+"25"+"&matter="+"保函费用付款",
        data: {"projectName":projectName,"pageIndex":z},
        dataType: "json",
        success: function (data) {

            var html = "";

            $.each(data.list, function (index1, obj1) {

                html += '<tr class="seal" style="height: 40px; " >';
                // html += '<td style="width: 100px ">' + (index1+1) + '</td>';
                // html += '<td style="width: 350px ">'+obj1.project.abbreviation +'</td>';
                // html += '<td style="width: 250px "> '+obj1.user.name +'</td>';
                // html += '<td style="width: 250px ">'+obj1.createtime +'</td>';
                // html += '<td style="width: 150px ">'+obj1.validTime +'</td>';
                html += '<td style="width: 100px ">' + (index1+1) + '</td>';
                html += '<td style="width: 400px ">'+obj1.project.abbreviation +'</td>';
                html += '<td style="width: 300px ">'+obj1.unit+'</td>';
                html += '<td style="width: 300px ">'+obj1.type+'</td>';
                html += '<td style="width:110px">';
                html += '<a style="color:blue" href="/ga/payment/common/particular?id='+obj1.id+'">详情</a>';
                html += '<a style="color:#dea97d; margin-left: 4px " href="/ga/payment/common/update?id='+obj1.id+'">编辑</a>';
                html += '<a class='+"del"+index1+' style="color:#a6d1c0; margin-left: 4px">删除</a>';
                html += '<div class='+"confirm"+index1+' style="display: none" >';
                html += '<p style="margin-bottom:80px ">' + "是否删除客户联系人信息" + '</p>';

                html += '<a class="confirm-ok" type="submit" href="" >' + "是" + '</a>';
                html += '<a class="confirm-no" type="submit" >' + "否" + '</a>';
                html += '</div>';
                html += '</td>';
                html += '</tr>';
            });


            currentPageNo=data.page.currentPageNo;
            totalPageCount=data.page.totalPageCount;

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
            }
            $("#paginator-test").bootstrapPaginator(options);
        }
        // });

    })
}
$(document).ready(function () {
    lo();
})
$(document).on("click",".del1",function () {
    $(".confirm1").show();
})
$(document).on("click",".del2",function () {
    $(".confirm2").show();
})
$(document).on("click",".del3",function () {
    $(".confirm3").show();
})
$(document).on("click",".del4",function () {
    $(".confirm4").show();
})
$(document).on("click",".del5",function () {
    $(".confirm5").show();
})
$(document).on("click",".del6",function () {
    $(".confirm6").show();
})
$(document).on("click",".del7",function () {
    $(".confirm7").show();
})
$(document).on("click",".del8",function () {
    $(".confirm8").show();
})
$(document).on("click",".del9",function () {
    $(".confirm9").show();
})
$(document).on("click",".del0",function () {
    $(".confirm0").show();
})

$(document).on("click",".confirm-no",function () {
    $(".confirm0").hide();
    $(".confirm1").hide();
    $(".confirm2").hide();
    $(".confirm3").hide();
    $(".confirm4").hide();
    $(".confirm5").hide();
    $(".confirm6").hide();
    $(".confirm7").hide();
    $(".confirm8").hide();
    $(".confirm9").hide();
})

$(document).on("click",".query",function () {
    lo();
})