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
         data: {"processid":processid,"id":id,"start":start,"end":end,"pageIndex":z},
        dataType: "json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";
            $.each(list, function (index1, obj1) {

                html += '<tr style="height: 40px;text-align: center;line-height: 40px " class="content" >';
                html += '<td style="width: 160px ">'+obj1.id+'</td>';
                html += '<td style="width: 450px ">'+obj1.process.name+'</td>';
                html += '<td style="width: 200px ">'+obj1.user.name+'</td>';
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
// $(".query").click(lo());
