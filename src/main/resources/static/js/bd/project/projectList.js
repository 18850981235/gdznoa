/**
 * Created by Administrator on 2019/3/26.
 */
(function () {
    //分页


    function lo(z) {
        $(".content").html(value = "");
        var projectName=$(".projectName").val();
        var deptid=$(".deptid").val();
        var stage=$(".stage").val();
        var areaManager=$(".areaManager").val();
        var principalName=$(".principalName").val();
        var start=$(".start").val();
        var end=$(".end").val();
        $.ajax({
            type: "get",
            url: "/bd/project/query.html",
            data: {"projectName":projectName,"deptid":deptid,"stage":stage,"areaManager":areaManager,"principalName":principalName,"start":start,"end":end,"pageIndex":z},
            dataType: "json",
            success: function (data) {
                var list = data.list;
                var page = data.page;
                var html = "";
                $.each(list, function (index1, obj1) {
                    html += " <tr style='height:45px' class='content'>";
                    html += "<td class='content-in' style='text-align: center' >" + obj1.name + "</td>";
                    html += "<td class='content-in' style='text-align: center' >" + obj1.abbreviation + "</td>";
                    html += "<td class='content-in' style='text-align: center'>" + obj1.dept.name + "</td>";
                    html += "<td class='content-in' style='text-align: center'>" + obj1.biddingType + "</td>";
                    html += "<td class='content-in' style='text-align: center'>" + obj1.stage + "</td>";
                    html += "<td class='content-in' style='text-align: center'>" + obj1.principalUser.name + "</td>";
                    html += "<td class='content-in' style='text-align: center'>" + obj1.areaManagerUser.name + "</td>";
                    html += "<td class='content-in' style='text-align: center'>" + obj1.createtime + "</td>";
                    html += "<td class='content-in' style='text-align: center'>" + obj1.budget + "</td>";

                    html += '<td style="width: 110px ;text-align: center">';
                    html += "<a  href='/bd/project/particular?id="+obj1.id+"'  style='color:blue'>详情</a>";
                    html += '<a href="/bd/project/update?id='+obj1.id+'" style="color:#dea97d; margin-left: 4px  ">编辑</a>';
                    html += '<a class="del" style="color:#a6d1c0; margin-left: 4px ">删除</a>';
                    html += '<div id="confirm" style="display: none" >';
                    html += '<p style="margin-bottom: 80px ">' + "是否删除客户联系人信息" + '</p>';
                    html += '<a class="confirm-ok" type="submit" >' + "是" + '</a>';
                    html += '<a class="confirm-no" type="submit" >' + "否" + '</a>';
                    html += '</div>';
                    html += '</td>';
                    // if (obj1.processState == "已结束") {
                    //     html += "<td class='content-in-on'  style='text-align:center;'>";
                    //     html += "<a style='color: blue'  href=/bd/project/particular?id="+obj1.id+">详情</a>";
                    //     html += "<a style='display: none'>(不可编辑)</a>";
                    //     html += " <a class='del'  style='display: none'>(不可删除)</a>";
                    //     html += "<div id='confirm' style='none'  >";
                    //     html += "<p style='margin-bottom: 110px '>" + "是否删除客户联系人信息" + "</p>";
                    //     html += "<a class='confirm-ok' type='submit' >" + "是" + "</a>";
                    //     html += "<a class='confirm-no' type='submit' >" + "否" + "</a>";
                    //     html += "</div>";
                    // } else if (obj1.processState == "进行中") {
                    //     html += "<td class='content-in-on'style='text-align:center;' >";
                    //     html += "<a style='color:#dea97d; ' href=/bd/project/update?id="+obj1.id+">编辑</a>";
                    //     html += " <a class='del' style='display: none'>(不可删除)</a>";
                    //     html += "<div id='confirm' style='none'  >";
                    //     html += "<p style='margin-bottom: 110px '>" + "是否删除客户联系人信息" + "</p>";
                    //     html += "<a class='confirm-ok' type='submit' >" + "是" + "</a>";
                    //     html += "<a class='confirm-no' type='submit' >" + "否" + "</a>";
                    //     html += "</div>";
                    // } else if (obj1.processState == "不通过") {
                    //     html += "<td class='content-in-on'style='text-align:center;' >";
                    //     html += "<a style='color: blue' href=/bd/project/particular?id="+obj1.id+">详情</a>";
                    //     html += "<a style='display: none'>(不可编辑)</a>";
                    //     html += " <a class='del' style='color: #a6d1c0'>删除</a>";
                    //     html += "<div id='confirm' style='none'  >";
                    //     html += "<p style='margin-bottom: 110px '>" + "是否删除客户联系人信息" + "</p>";
                    //     html += "<a class='confirm-ok' type='submit' >" + "是" + "</a>";
                    //     html += "<a class='confirm-no' type='submit' >" + "否" + "</a>";
                    //     html += "</div>";
                    // }
                    // html += " </td>";
                    html += " </tr>";
                });
                $(".paging .start").after(html);
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
        });
    }


    $(document).ready(function () {
        $("body").on("click", ".del", function () {
            $("#confirm").show();
        })
        // $(".query").click();
        $("body").on("click", ".query", function () {
            lo();
            var status = $(".time-d").val();
            var start = $(".time-x").val();
        })
        $("body").on("click", ".confirm-no", function () {
            $("#confirm").hide();
        })
        lo(0);
    })
})()