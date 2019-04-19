/**
 * Created by Administrator on 2019/3/20.
 */

(function () {


    var currentPageNo;
    var totalPageCount;
    function lo(z) {
        $(".paging-in").html("");
        var s = $(".clientName").val();
        var s1 = $(".name1").val();
        var s2 = $(".name2").val();
        var s3 = $(".Eliminate-no").val();
        var s4 = z;
        $.ajax({
            type: "get",
            url: "/bd/client/query.html",
            data: {"name":s,"address":s1,"unitType":s2,"userid":s3,pageIndex:s4},
            dataType: "json",
            success: function (data) {
                var list=data.list;
                var page=data.page;
                var html = "";
                 currentPageNo=data.page.currentPageNo;
                totalPageCount=data.page.totalPageCount;

                    $.each(list, function (index1, obj1) {
                        html += " <tr style='height:30px ;line-height: 30px ' class='content'>";
                        html += "<td class='checklist' style='width: 100px ;text-align: center' >";
                        html += "<a>" + (index1+1) + "</a>";
                        html += " </td>";
                        html += "<td class='content-in' style='width: 300px'>" + obj1.name + "</td>";
                        html += "<td class='content-in' style='width: 130px'>" + obj1.unitType + "</td>";
                        html += "<td class='content-in' style='width: 130px'>" + obj1.address + "</td>";
                        html += "<td class='content-in' style='width: 200px'>" + obj1.name + "</td>";
                        html += "<td class='content-in' style='width: 200px'>" + obj1.user.name + "</td>";
                        html += "<td class='content-in-on' style='width: 150px'>";
                        html += "<a style='color: blue' href='/bd/client/particular?id="+obj1.id+"'>详情</a>";
                        html += "<a style='margin-left:6px;color:#dea97d;  ' href='/bd/client/update?id="+obj1.id+"'>编辑</a>";
                        html += " <a class='del' style='color: #a6d1c0'>删除</a>";
                        html += "<div id='confirm'   >";
                        html += "<p style='margin-bottom: 80px;font-size:20px '>" + "是否删除客户联系人信息" + "</p>";
                        html += "<a class='confirm-ok' type='submit'  href='/bd/client/delete?id="+obj1.id+"' >" + "是" + "</a>";
                        html += "<a class='confirm-no' type='submit' >" + "否" + "</a>";
                        html += "</div>";
                        html += " </td>";
                        html += " </tr>";
                    });

                $(".paging-in").append(html);

                var options={
                    bootstrapMajorVersion:1,    //版本
                    currentPage:data.page.currentPageNo,    //当前页数
                    numberOfPages:5,    //最多显示Page页
                    totalPages:data.page.totalPageCount,    //所有数据可以显示的页数
                    // onPageClicked:function(e,originalEvent,type,page){
                        onPageChanged:function (event, originalEvent, typePage, currentPage){  //点击事件
                            lo(typePage);
                    }
                }
                $("#paginator-test").bootstrapPaginator(options);
            }
        });

    }

    $(document).ready(function () {
        $("body").on("click",".del",function () {
            $("#confirm").show();
        })
        $("body").on("click",".confirm-no",function () {
            $("#confirm").hide();
        })
        lo(0);
        $("body").on("click",".query",function () {
            lo(0);
        })
    })

})()
$.ajax({
    type: "get",
    url: "/bd/client/getAddres",
    dataType: "json",
    success: function (data) {
        var html="<option value=''>请选择</option>";
        for (var i=0;i<data.length;i++){
            html+="<option value="+data[i]+">"+data[i]+"</option>";
        }
        $(".name1").append(html);
    }
});