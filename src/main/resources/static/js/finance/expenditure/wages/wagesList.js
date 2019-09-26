/**
 * Created by Administrator on 2019/8/15.
 */
function lo(z) {
    // $(".paging-in").html("");
    $(".sea2").html(value="");

    var projectid=$(".project").val();
    var supplierid=$(".contacts").val();
    var serialnumber=$(".serialnumber").val();
    var code=$(".code").val();



    var id=$.cookie("id");
    $.ajax({
        type: "get",
        url: "/ga/payment/query.html?projectId="+id+"&matter=项目部工资&type=",
        data: {"projectid":projectid,"supplierid":supplierid,"serialnumber":serialnumber,"code":code,"pageIndex":z},
        dataType: "json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";

            $.each(list, function (index1, obj1) {

                html += '<tr style="height:40px;text-align: center" class="paging-in" >';
                html += '<td style="width:80px">' + (index1+1) + '</td>';
                html += '<td style="width: 200px ">'+obj1.project.name+'</td>';
                html += '<td style="width: 150px ">'+obj1.createtime+'</td>';
                // html += '<td style="width: 150px ">'+obj1.supplier.name+'</td>';
                 html += '<td style="width: 150px ">'+obj1.nuit+'</td>';


                html += '<td style="width: 200px ">'+obj1.serialnumber+'</td>';
                html += '<td style="width: 200px ">'+obj1.code+'</td>';
                html += '<td style="width: 100px ">'+obj1.processState+'</td>';
                html += '<td style="width:130px ">';
                html += '<a style="color:#ff061c;margin-right: 3px "  href="/ga/payment/salary/update?id='+obj1.id+'">清单</a>';
                html += '<a style="color:blue" href="/ga/payment/salary/particular?id='+obj1.id+'">详情</a>';
                html += '<a style="color:#dea97d; margin-left: 4px  " href="/mc/borrow/update?id='+obj1.id+'">编辑</a>';
                html += '<a class='+"del"+index1+' style="color:#a6d1c0; margin-left: 4px ">删除</a>';

                html += '<div class='+"confirm"+index1+' style="display: none" >';
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
            };
            $("#paginator-test").bootstrapPaginator(options);
        }
        // });

    })
}


$(document).ready(function () {
    lo();


    $(document).on("click",".del1",function () {
        $(".confirm1").show();
    });
    $(document).on("click",".del2",function () {
        $(".confirm2").show();
    });
    $(document).on("click",".del3",function () {
        $(".confirm3").show();
    });
    $(document).on("click",".del4",function () {
        $(".confirm4").show();
    });
    $(document).on("click",".del5",function () {
        $(".confirm5").show();
    });
    $(document).on("click",".del6",function () {
        $(".confirm6").show();
    });
    $(document).on("click",".del7",function () {
        $(".confirm7").show();
    });
    $(document).on("click",".del8",function () {
        $(".confirm8").show();
    });
    $(document).on("click",".del9",function () {
        $(".confirm9").show();
    });
    $(document).on("click",".del0",function () {
        $(".confirm0").show();
    });

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
    });
    $(document).on("click",".query",function () {
        lo();
    });

});