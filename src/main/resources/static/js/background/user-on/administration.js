/**
 * Created by Administrator on 2019/7/10.
 */
function lo(z) {
    // $(".paging-in").html("");
    $(".table").html(value="");
    var test=$("#test1").val();
    var test1=$("#test2").val();
    var name=$(".name").val();
    $.ajax({
        type: "get",
        url: "/user/useraction/queryRequestspbyuser",
        data: {"name":name,"StartTime":test,"EndTime":test1,"pageIndex":z},
        dataType: "json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";
            $.each(list, function (index, obj1) {
              html += '<tr class="table" style="height:30px">';
                  html += '<td style="width:60px">'+(index+1)+'</td>';
                  html += '<td style="width:80px">'+obj1.userName+'</td>';
                  html += '<td style="width:90px">'+obj1.time+'</td>';
                  html += '<td style="width: 350px ;" >'+obj1.ermissions+'</td>';
                  html += '<td style="width:130px">'+obj1.phone+'</td>';
                  html += '<td style="width:80px">'+obj1.evidencePeople+'</td>';
                  html += '<td style="width:130px">'+obj1.evidencePhone+'</td>';
                  html += '<td style="width:100px">'+obj1.evidence+'</td>';
                  html += '<td style="width:80px">'+obj1.state+'</td>';
                html += '<td style="width:110px">';
                if(obj1.state=="未审批"){
                    html += '<a style="color:blue" href=" '+obj1.id+'">同意</ a>';
                    html += '<a style="color:#dea97d;margin-left:4px" href="/mc/borrow/update?id='+obj1.id+'">不同意</ a>';
                }
                // html += '<a style="color:blue" href="/user/useraction/updateRequestspbyid?id='+obj1.id+'">同意</a>';
                // html += '<a style="color:#dea97d;margin-left:4px" href="/user/useraction/unRequestspbyid?id='+obj1.id+'">不同意</a>';
                html += '</td>';
              html += '</tr>';

            });
            // currentPageNo=data.page.currentPageNo;
            // totalPageCount=data.page.totalPageCount;

            $(".table").prepend(html);//prepend   append
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