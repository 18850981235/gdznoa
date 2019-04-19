/**
 * Created by Administrator on 2019/4/9.
 */

function lo(z) {
    $(".content").html(value="");
    var processid=$(".department").val();
    var id=$(".stampType").val();
    var start=$(".start").val();
    var end=$(".end").val();

    $.ajax({
        type: "get",
        url: "/myWork",
         data: {"id":id,"start":start,"end":end,"processid":processid,"pageIndex":z},
        dataType: "json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";
            $.each(list, function (index1, obj1) {

                html += '<tr style="height: 40px;text-align: center;line-height: 40px " class="content" >';
                html += '<td style="width: 160px ">'+obj1.id+'</td>';
                html += '<td style="width: 450px ">'+obj1.process.name+'</td>';
                html += '<td style="width: 200px ">'+obj1.processUser.name+'</td>';
                html += '<td style="width: 200px ">'+obj1.createtime+'</td>';

                // html += '<td style="width: 60px ">' + (index1+1) + '</td>';
                // html += '<td style="width: 100px ">' + obj1.dept.name + '</td>';
                // html += '<td style="width: 100px ">' + obj1.createtime + '</td>';
                // html += '<td style="width: 250px ">' + obj1.stampType + '</td>';
                // html += '<td style="width: 250px ">' + obj1.content + '</td>';
                // html += '<td style="width: 150px ">' + obj1.phone + '</td>';
                // html += '<td style="width: 100px ">' + obj1.fileNum + '</td>';
                html += '<td style="width: 110px ">';
                html += '<a href='+obj1.process.url+'?id='+obj1.id+' style="color:#dea97d; margin-left: 4px  ">审批</a>';
                html += '</td>';
                html += '</tr>';
            });


            // currentPageNo=data.page.currentPageNo;
            // totalPageCount=data.page.totalPageCount;

            $(".sea2").after(html);
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
