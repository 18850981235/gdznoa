/**
 * Created by 10216 on 2019/4/14.
 */
/**
 * Created by Administrator on 2019/4/9.
 */

function lo() {
    // $(".paging-in").html("");
    $(".paging-in").html(value="");
    var deptid=$(".department").val();
    var start=$(".start").val();
    var end=$(".end").val();
    var stampType=$(".stampType").val();

    $.ajax({
        type: "get",
        url: "/mc/borrow/query.html",
        data: {"stampType":stampType,"deptid":deptid,"start":start,"end":end},
        dataType: "json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";
                $.each(list, function (index1, obj1) {
                    html += '<tr style="height: 40px ;text-align: center" class="paging-in" >';
                    html += '<td style="width: 110px ">' + (index1+1) + '</td>';
                    html += '<td style="width: 250px ">' + obj1.process.name + '</td>';
                    html += '<td style="width: 100px ">' + obj1.createtime + '</td>';
                    html += '<td style="width: 200px ">' + obj1.dept.name + '</td>';
                    html += '<td style="width: 100px ">' + obj1.fileNum + '</td>';
                    html += '<td style="width: 300px ">' + obj1.phone + '</td>';
                    html += '<td style="width: 100px ">' + obj1.returntime + '</td>';
                    html += '<td style="width: 110px ">';
                    html += '<a style="color:blue" href="/mc/borrow/particular?id='+obj1.id+'">详情</a>';
                    html += '<a style="color:#dea97d; margin-left: 4px  " href="/mc/borrow/update?id='+obj1.id+'">编辑</a>';
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
