/**
 * Created by Administrator on 2019/3/20.
 */

$(document).ready(function () {
    address();
    $(".query").click(lo());

})
var currentPageNo;
var totalPageCount;

function lo(z) {
    $(".content").html(value="");
    var s = $(".name").val();
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
            var list = data.list;
            var page = data.page;
            currentPageNo=data.page.currentPageNo;
            totalPageCount=data.page.totalPageCount;
            var html = "";
            $.each(list, function (index1, obj1) {
                html += " <tr style='height:45px' class='content'>";
                html +=   "<td class='checklist' style='width: 100px' >";
                html +=  "<input  type='checkbox'>";
                html +=     " </td>";
                html +=    "<td class='content-in' style='width: 300px'><a style='color: #333333' href='/bd/client/particular?id="+obj1.id+"'>"+obj1.name+"</a></td>";
                html +=    "<td class='content-in' style='width: 130px'>"+obj1.unitType+"</td>";
                html +=    "<td class='content-in' style='width: 130px'>"+obj1.address+"</td>";
                html +=    "<td class='content-in' style='width: 200px'>"+obj1.name+"</td>";
                html +=    "<td class='content-in' style='width: 200px'>"+obj1.user.name+"</td>";
                html +=    "<td class='content-in-on' style='width: 150px'>";
                html +=    "<a href='/bd/client/update?id="+obj1.id+"' style='color: #333333'>编辑</a>";
                html +=    "&nbsp;&nbsp;<a id='del'  style='color: #333333'>删除</a>";
                html +=    "<div id='confirm' style='display: none' >";
                html +=    "<p style='margin-bottom: 110px '>"+"是否删除客户以及旗下联系人信息"+"</p>";
                html +=    "<a class='confirm-ok' type='submit' href='/bd/client/delete?id="+obj1.id+"' >"+"是"+"</a>";
                html +=    "<a class='confirm-no' type='submit' >"+"否"+"</a>";
                html +=    "</div>";
                html +=    " </td>";
                html +=    " </tr>";

            });
            $(".paging-in").after(html);
            var options={
                bootstrapMajorVersion:1,    //版本
                currentPage:page.currentPageNo,    //当前页数
                numberOfPages:5,    //最多显示Page页
                totalPages:page.totalPageCount,    //所有数据可以显示的页数
                // onPageClicked:function(e,originalEvent,type,page){
                onPageChanged:function (event, originalEvent, typePage, currentPage){
                //分页点击事件
               lo(typePage);
                }
            }
            $("#paginator-test").bootstrapPaginator(options);
        }
    });
}
$(document).ready(function () {
    $("body").on("click","#del",function () {
        $("#confirm").show();
    })
    $("body").on("click",".confirm-no",function () {
        $("#confirm").hide();
    })
    $(".query").click(lo())
})
function address() {
    $.ajax({
        type: "get",
        url: "/bd/client/getAddres",
        // data: {"bankaddress":s,"address":s1,"unitType":s2,"name":s3},
        dataType: "json",
        success: function (data) {
            var html="<option value=''>请选择</option>";
            for (var i=0;i<data.length;i++){
                html+="<option value="+data[i]+">"+data[i]+"</option>";
            }
            $(".name1").append(html);
        }
    })

}







