/**
 * Created by Administrator on 2019/4/9.
 */

function lo(z) {
    $(".content1").html(value="");
    var projectName=$(".projectName").val();
    var stampType=$(".stampType").val();
    var deptid=$(".deptid").val();
    var content=$(".contents").val();
    var purpose=$(".purpose").val();
    var start=$(".start").val();
    var end=$(".end").val();
    $.ajax({
        type: "get",
        url: "/mc/stamp/query.html",
        data: {"projectName":projectName,"stampType":stampType,"deptid":deptid,"content":content,"purpose":purpose,"start":start,"end":end,"pageIndex":z},
        dataType: "json",
        success: function (data) {
            var list1 = data.list;
            var page = data.page;
            var html = "";
                $.each(list1, function (index1, obj1) {
                    // console.log(data.list[index1].project.abbreviation)
                    // console.log(obj1.project123.abbreviation);
                    html += '<tr style="height: 40px" class="content1" >';
                    html += '<td style="width: 60px ">' + (index1+1) + '</td>';
                    if(obj1.project==undefined){
                        html += '<td style="width: 70px ">'+"无"+'</td>';
                    }else {
                        html += '<td style="width: 70px ">' + obj1.project.abbreviation + '</td>';
                    }
                    html += '<td style="width: 70px ">' + obj1.dept.name + '</td>';
                    html += '<td style="width: 80px ">' + obj1.user.name + '</td>';
                    html += '<td style="width: 100px ">' + obj1.createtime + '</td>';
                    html += '<td style="width: 100px ">' + obj1.stampType + '</td>';
                    html += '<td style="width: 200px ">' + obj1.purpose + '</td>';
                    html += '<td style="width: 250px ">' + obj1.accessory + '</td>';
                    html += '<td style="width: 110px ">';
                    html += '<a style="color:blue" href="/mc/stamp/particular?id='+obj1.id+'">详情</a>';
                    html += '<a style="color:#dea97d; margin-left: 4px  " href="/mc/stamp/update?id='+obj1.id+'">编辑</a>';
                    html += '<a class="del" style="color:#a6d1c0; margin-left: 4px " >删除</a>';
                    html += '<div class="confirm" style="display: none" >';
                    html += '<p style="margin-bottom: 80px ">' + "是否删除客户联系人信息" + '</p>';
                    html += '<a class="confirm-ok" type="submit" href="/mc/stamp/delete?id='+obj1.id+'">' + "是" + '</a>';
                    html += '<a class="confirm-no" type="submit" >' + "否" + '</a>';
                    html += '</div>';
                    html += '</td>';
                    html += '</tr>';
                });


            // currentPageNo=data.page.currentPageNo;
            // totalPageCount=data.page.totalPageCount;

            $(".seal").after(html);
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
        $(".confirm").show();
    })
    $(document).on("click",".confirm-no",function () {
        $(".confirm").hide();
    })
    $(document).on("click",".query",function () {
        lo();
    })
    // $(".query").click(lo());
