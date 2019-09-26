/**
 * Created by Administrator on 2019/8/12.
 */
function lo(z) {
    $(".sea2").html(value="");
    var  project= $.cookie("id");
    var  ferf= $.cookie("herf");
    console.log(project)
    console.log(ferf)
    var projectName=$(".projectName").val();
    $.ajax({
        type: "get",
        url: "/ga/payment/query.html?projectId="+project+"&matter="+ferf,
        // /ga/payment/update.html?projectId=26&matter=&type=
        ///ga/payment/query.html?projectId=26&matter=采购付款
        data: {"pageIndex":z},
        dataType: "json",
        success: function (data) {

            var html = "";

            $.each(data.list, function (index1, obj1) {
                console.log(obj1.pdProcurementContract)
                html += '<tr class="seal" style="height: 40px; " >';
                html += '<td style="width: 100px ">' + (index1+1) + '</td>';
                if(obj1.pdProcurementContract==undefined){
                    html += '<td style="width: 200px ">'+obj1.project.name+'</td>';
                    html += '<td style="width: 100px ">'+obj1.createtime+'</td>';
                    html += '<td style="width: 100px "></td>';
                    html += '<td style="width: 100px ">'+obj1.paymentMoney+'</td>';
                    html += '<td style="width: 100px ">'+obj1.paid+'</td>';
                    html += '<td style="width: 100px "></td>';
                    html += '<td style="width: 100px ">'+obj1.ticket+'</td>';
                    html += '<td style="width: 100px "></td>';
                    html += '<td style="width: 100px ">'+obj1.processState+'</td>';
                }else {
                    html += '<td style="width: 200px ">'+obj1.project.name+'</td>';
                    html += '<td style="width: 100px ">'+obj1.createtime+'</td>';
                    html += '<td style="width: 100px ">'+obj1.pdProcurementContract.total+'</td>';
                    html += '<td style="width: 100px ">'+obj1.paymentMoney+'</td>';
                    html += '<td style="width: 100px ">'+obj1.paid+'</td>';
                    html += '<td style="width: 100px ">'+(obj1.pdProcurementContract.total-obj1.paid)+'</td>';
                    html += '<td style="width: 100px ">'+obj1.ticket+'</td>';
                    html += '<td style="width: 100px ">'+(obj1.pdProcurementContract.total-obj1.ticket)+'</td>';
                    html += '<td style="width: 100px ">'+obj1.processState+'</td>';
                }


                html += '<td style="width:110px">';
                html += '<a style="color:blue" href="/ga/payment/purchase/particular?id='+obj1.id+'">详情</a>';
                html += '<a style="color:#dea97d; margin-left: 4px " href="/ga/payment/purchase/update?id='+obj1.id+'">编辑</a>';
                html += '<a class='+"del"+index1+' style="color:#a6d1c0; margin-left: 4px">删除</a>';
                html += '<div class='+"confirm"+index1+' style="display: none" >';
                html += '<p style="margin-bottom:80px ">' + "是否删除客户联系人信息" + '</p>';
                html += '<a class="confirm-ok" type="submit" href="" >' + "是" + '</a>';
                html += '<a class="confirm-no" type="submit" >' + "否" + '</a>';
                html += '</div>';
                html += '</td>';
                html += '</tr>';
            });


            // currentPageNo=data.page.currentPageNo;
            // totalPageCount=data.page.totalPageCount;

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