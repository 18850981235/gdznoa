/**
 * Created by 10216 on 2019/4/14.
 */
/**
 * Created by Administrator on 2019/4/9.
 */

function lo(z) {
    // $(".paging-in").html("");
    $(".sea2").html(value="");

    var projectName=$(".projectName").val();
    var name=$(".name").val();
    var deptid=$(".department").val();
    var start=$(".start").val();
    var end=$(".end").val();
    $.ajax({
        type: "get",
        url: "/sd/SdSalesContract/queryContract",
        data: {"projectName":projectName,"name":name,"deptid":deptid,"start":start,"end":end,"pageIndex":z},
        dataType: "json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";
            $.each(list, function (index1, obj1) {
                html += '<tr style="height:40px;text-align: center" class="paging-in" >';
                html += '<td style="width:40px">' + (index1+1) + '</td>';
                html += '<td style="width: 200px ">'+obj1.project.name+'</td>';
                html += '<td style="width: 120px ">'+obj1.project.code+'</td>';
                html += '<td style="width: 80px ">'+obj1.project.client.name+'</td>';
                html += '<td style="width: 100px ">'+obj1.project.client.biddate+'</td>';
                html += '<td style="width: 100px ">'+obj1.managementRate+'</td>';
                html += '<td style="width: 100px ">'+obj1.contractAmount+'</td>';
                html += '<td style="width: 80px ">'+obj1.addAmount+'</td>';
                html += '<td style="width: 80px ">'+obj1.reductionAmount+'</td>';
                html += '<td style="width: 100px ">'+obj1.invoiceType+'</td>';

                html += '<td style="width: 140px ">';
                html += '<a style="color:#ff061c;margin-right: 3px "  href="/sd/Inventory/getContractbyprojectPage?id='+obj1.id+'">清单</a>';
                html += '<a style="color:blue"  href="/sd/SdSalesContract/detailProjectPage?id='+obj1.id+'">详情</a>';
                html += '<a style="color:#dea97d; margin-left: 4px  " href="/sd/SdSalesContract/UpdateProjectPage?id='+obj1.id+'">编辑</a>';
                html += '<a class="del" style="color:#a6d1c0; margin-left: 4px ">删除</a>';
                html += '<div id="confirm" style="display: none" >';
                html += '<p style="margin-bottom: 80px ">' + "是否删除客户联系人信息" + '</p>';
                html += '<a class="confirm-ok" type="submit" >' + "是" + '</a>';
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

$(document).on("click",".del",function () {
    $("#confirm").show();
})
$(document).on("click",".confirm-no",function () {
    $("#confirm").hide();
})
$(document).on("click",".query",function () {

    lo();
})
// $(".query").click(lo());

