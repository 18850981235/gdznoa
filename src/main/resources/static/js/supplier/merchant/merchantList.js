/**
 * Created by Administrator on 2019/6/10.
 */

function lo(z) {
    $(".sea2").html(value="");
    var name=$(".name").val();
    var code=$(".code").val();
    var traname=$(".traname").val();

    // var subitemId=$(".subitemId").val();


    $.ajax({
    type:"get",
        url:"/supplier/supplier2/querySupplier",
        data:{ "name":name,"code":code,"traname":traname,"pageIndex":z},
        dataType:"json",
        success: function (data) {
            var list = data.list;
            var page = data.page;
            var html = "";
            $.each(list, function (index1, obj1) {
                html += '<tr style="height:40px;text-align: center" class="paging-in" >';
                html += '<td style="width: 60px  ">'+(index1+1)+'</td>';
                html += '<td style="width: 250px ">'+obj1.name+'</td>';

                html += '<td style="width: 100px ">'+obj1.code+'</td>';
                html += '<td style="width: 100px ">'+obj1.phone+'</td>';
                html += '<td style="width: 200px ">'+obj1.fax+'</td>';
                if(obj1.supplierTrademarks==""||obj1.supplierTrademarks==null){
                    html += '<td style="width: 100px "></td>';
                }else {
                    html += '<td style="width: 100px ">';
                    $.each(obj1.supplierTrademarks, function (index2, obj2) {
                        html +='<span>'+obj2.supplierTrademark.name+"," + '</span>';
                    })
                    html += '</td>';
                }
                html += '<td style="width: 130px ">'+obj1.email+'</td>';
                html += '<td style="width: 110px ">'+obj1.sysUser.name+'</td>';


                html += '<td style="width:130px">';
                html += '<a href="/supplier/supplier2/QuerySupplierByIdPage?id='+obj1.id+'" style="color:blue">详情</a>';
                html += '<a  href="/supplier/supplier2/updateSupplierPage?id='+obj1.id+'" style="color:#dea97d; margin-left: 4px  ">编辑</a>';
                html += '<a class='+"del"+index1+' style="color:#a6d1c0; margin-left: 4px ">删除</a>';
                html += '<div class='+"confirm"+index1+' style="display: none" >';
                html += '<p style="margin-bottom: 80px ">' + "是否删除客户联系人信息" + '</p>';
                html += '<a href="/supplier//supplier2/delete?id='+obj1.id+'" class="confirm-ok" type="submit" >' + "是" + '</a>';
                html += '<a class="confirm-no" type="submit" >'+"否"+'</a>';
                html += '</div>';
                html += '</td>';
                html += '</tr>';
            });
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
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/sd/SdSalesContract/getProject",
        success:function (data) {
            $.each(data,function (index,obj) {
                var html="";
                html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

                $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })
        }
    });
})
