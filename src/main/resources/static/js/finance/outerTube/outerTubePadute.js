/**
 * Created by Administrator on 2019/8/5.
 */
function w() {
    var  id=q("id");
    var url="/ga/outerTube/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var project=data.project
            var html="";
            $("#center input").eq(0).val(project.project.id);
            $("#center input").eq(1).val(project.user.name);
            $("#center input").eq(2).val(project.user.id);
            // $("#center input").eq(3).val(project.user.id);

            $(".department option").eq(0).val(project.dept.id);
            $(".department option").eq(0).text(project.dept.name);

            $("#center input").eq(4).val(project.createtime);
            $("#center input").eq(5).val(project.relevantDocument);
            $("#center input").eq(6).val(project.accomplishTime);
            $("#center input").eq(7).val(project.validTime);

            $("#center input").eq(8).val(project.consignee);
            $("#center input").eq(9).val(project.consigneePhone);
            $("#center input").eq(10).val(project.consigneeAddress);
            $("#center input").eq(11).val(project.remark);

            $("#textarea").eq(0).text(project.content);
            $("#textarea").eq(0).val(project.content);
            $("#center input").eq(12).val(project.accessory);
            $("#center input").eq(13).val(project.id);

            // $(".content").text(project.content);
            // $(".content").val(project.content);


            // $(".type option").eq(0).val(data.type);
            // $(".type option").eq(0).text(data.type);
            //
            // $("#center input").eq(11).val(data.grade);
            // $("#center input").eq(12).val(data.supplierTrademarks[0].supplierTrademark.name);
            // $("#center input").eq(13).val(data.supplierTrademarks[0].supplierTrademark.id);
            // // $("#center input").eq(14).val();
            // $("#center input").eq(15).val(data.url);
            // $("#center input").eq(16).val(data.bankname);
            // $("#center input").eq(17).val(data.bankaccount);
            // $("#center input").eq(18).val(data.bankaddress);
            // $("#center input").eq(19).val(data.tfn);
            // $("#center input").eq(19).val(data.credentialAccessory);



            // $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
    // $.ajax({
    //     type:"get",
    //     dataType:"json",
    //     url:url,
    //     date:{"id":id},
    //     success:function (data) {
    //         var html="";
    //
    //
    //
    //         $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    //
    //     }
    // });
}
$(document).ready(function () {
    w();
    var  project= $.cookie("id");
    // var cook=$.cookie('name')
    $("#projectid").val(project)
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