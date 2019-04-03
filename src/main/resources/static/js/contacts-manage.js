/**
 * Created by Administrator on 2019/3/27.
 */
(function () {


    var currentPageNo;
    var totalPageCount;
    function lo(z) {
        $(".content").html(value="");
        var clientname=$(".name1").val();
        var name=$(".name2").val();
        $.ajax({
            type: "get",
            url: "/bd/client_contacts/list",
             data: {"clientname":clientname,"name":name,"pageIndex":z},
            dataType: "json",
            success: function (data) {
                var list=data.list;
                var page=data.page;
                var html = "";
                currentPageNo=data.page.currentPageNo;
                totalPageCount=data.page.totalPageCount;
                $.each(list,function (index1,obj1) {
                    html += " <tr style='height:45px' class='content'>";
                    html +=   "<td class='checklist' style='width: 100px' >";
                    html +=  "<input  type='checkbox'>";
                    html +=     " </td>";
                    html +=    "<td class='content-in' >"+obj1.clientname+"</td>";
                    html +=    "<td class='content-in' >"+obj1.name+"</td>";
                    html +=    "<td class='content-in' >"+obj1.role+"</td>";
                    html +=    "<td class='content-in' >"+obj1.mobile+"</td>";
                    html +=    "<td class='content-in' >"+obj1.phone+"</td>";
                    html +=    "<td class='content-in' >"+obj1.wechat+"</td>";
                    html +=    "<td class='content-in' >"+obj1.content  +"</td>";
                    html +=    "<td class='content-in' >"+obj1.email+"</td>";
                    html +=    "<td class='content-in' >";
                    html +=    "<a href='/bd/client_contacts/update?id="+obj1.id+"'>编辑</a>";
                    html +=    " <a id='del'>删除</a>";
                    html +=    "<div id='confirm' style='none' >";
                    html +=    "<p style='margin-bottom: 110px '>"+"是否删除客户联系人信息"+"</p>";
                    html +=    "<a class='confirm-ok' type='submit'  href='/bd/client_contacts/delete?id="+obj1.id+"'>"+"是"+"</a>";
                    html +=    "<a class='confirm-no' type='submit' >"+"否"+"</a>";
                    html +=    "</div>";

                    html +=    " </td>";
                    html +=    " </tr>";
                });
                $(".paging .start").after(html);
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
        lo();
        $("body").on("click","#del",function(){
            $("#confirm").show();
        })
        $("body").on("click",".confirm-no",function () {
            $("#confirm").hide();
        })
        $("body").on("click",".query",function () {
            lo();
        })
    })

})()