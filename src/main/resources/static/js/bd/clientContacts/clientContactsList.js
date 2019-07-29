/**
 * Created by Administrator on 2019/3/27.
 */
(function () {


    // var currentPageNo;
    // var totalPageCount;
    function lo(z) {
        $(".content").html(value="");
        var clientname=$(".clientname").val();
        var name=$(".name1").val();

        $.ajax({
            type: "get",
            url: "/bd/client_contacts/list",
            data: {"clientname":clientname,"name":name,pageIndex:z},
            dataType: "json",
            success: function (data) {
                var list=data.list;
                var page=data.page;
                var html = "";
                currentPageNo=data.page.currentPageNo;
                totalPageCount=data.page.totalPageCount;
                $.each(list,function (index1,obj1) {
                    html += " <tr style='height:40px' class='content'>";
                    html +=   "<td class='checklist' style='width: 100px;text-align: center' >";
                    html +=  "<a>"+(index1+1)+"</a>";
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
                    html +=    "<a style='color:blue ' href='/bd/client_contacts/clientContactsParticular?id="+obj1.id+"'>详情</a>"
                    html +=    "<a style='color:#dea97d; margin-left: 4px  ' href='/bd/client_contacts/update?id="+obj1.id+"'>编辑</a>";
                    html +=    ' <a class='+"del"+index1+' style="color:#a6d1c0; margin-left: 4px ">删除</a>';
                    html +=    '<div class='+"confirm"+index1+' style="display: none" >';
                    html +=    "<p style='margin-bottom: 80px;font-size: 20px; '>"+"是否删除客户联系人信息"+"</p>";
                    html +=    "<a class='confirm-ok' type='submit' href='/bd/client_contacts/delete?id="+obj1.id+"'>"+"是"+"</a>";
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
                    onPageChanged:function (event, originalEvent, typePage, currentPage){//点击事件
                        lo(typePage);
                    }
                }
                $("#paginator-test").bootstrapPaginator(options);
            }
        });
    }
    $(document).ready(function () {
        lo();
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

        $("body").on("click",".query",function () {
            lo();
        })
    })
})()