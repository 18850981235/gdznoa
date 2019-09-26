/**
 * Created by Administrator on 2019/8/6.
 */
function w() {
    var  id=q("id");
    var url="/ed/EdMassageStaff/QueryOneMassageStaff?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            // var data=obj.pdProcurementContract
            var html="";

            $("#center input").eq(0).val(data.id);

            $("#ap option").eq(0).val(data.project.id)
            $("#ap option").eq(0).text(data.project.name)

            $("#center input").eq(1).val(data.name);
            $("#center input").eq(2).val(data.phone);
            $("#center input").eq(3).val(data.attendanceTime);
            $("#center input").eq(4).val(data.staffRole);
            $("#center input").eq(5).val(data.idfile);
            $("#center input").eq(6).val(data.identityCard);
            $("#center input").eq(7).val(data.contractsfile);

            $("#center input").eq(8).val(data.securityfile);
            $("#center input").eq(9).val(data.buyfile);
            $("#center input").eq(10).val(data.buyState);
            $("#center input").eq(11).val(data.chargeer);

            $("#center input").eq(12).val(data.remarks);
            // $("#center input").eq(13).val(data.supervisor);
            // $("#center input").eq(14).val(data.supervisorPhone);




        }
    });
}
// w();
$(document).ready(function () {
    w();

    //遍历项目
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
    //项目编号
    // $("#ap").change(function () {
    //     var id=$("#ap").val()
    //     $.ajax({
    //         type:"post",
    //         dataType:"json",
    //         url:"/sd/SdSalesContract/getProject",
    //         success:function (data) {
    //             $.each(data,function (index,obj) {
    //                 if(obj.id==id){
    //                     $("#center input").eq(0).val(obj.code)
    //                     $("#center input").eq(1).val(obj.projectManager)
    //                     $("#center input").eq(2).val(obj.name)
    //                     $("#center input").eq(3).val(obj.userid)
    //                     $("#center input").eq(4).val(obj.dept.name)
    //                     $("#center input").eq(5).val(obj.dept.id)
    //                     $("#center input").eq(6).val(obj.site)
    //
    //
    //                 }
    //
    //             })
    //         }
    //     });
    // })
    //建设单位
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/util/getClient",
        success:function (data) {

            $.each(data,function (index,obj) {
                var html="";
                html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

                $(".crm").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })
        }
    });

})


function q(name){
    var search = document.location.search;
    var pattern = new RegExp("[?&]"+name+"\=([^&]+)", "g");
    var matcher = pattern.exec(search);
    var items = null;
    if(null != matcher){
        try{
            items = decodeURIComponent(decodeURIComponent(matcher[1]));
        }catch(e){
            try{
                items = decodeURIComponent(matcher[1]);
            }catch(e){
                items = matcher[1];
            }
        }
    }
    return items;
};