/**
 * Created by Administrator on 2019/6/10.
 */
$.ajax({
    type:"post",
    dataType:"json",
    url:"/util/getGCProject",
    success:function (data) {
        $.each(data,function (index,obj) {
            var html="";

            html+='<option class="pop"  value='+obj.id+'>'+obj.name+'</option>';

            $("#ap").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        })
    }
});
$(document).ready(function () {
        var wo=$("#contract").text()
    if(wo==""){
        $("#contract-no").show();
    }else {
        $("#contract-no").hide();
    }
    $(document).on("click",".refresh",function () {
        $(".addList").html(value="");
        $(".reductionList").html(value="");
        $.ajax({
            type: "get",
            url: "/mc/borrow/queryMailFile",
            dataType: "json",
            success: function (data) {
                var  qualification=data.McQualificationCertificate;
                var html="";
                html += '<ul>';
                $.each(qualification,function (index,obj) {
                    html +='<li class="noe-in"><a class="noe-in-1">'+obj.name+'</a></li>';
                })
                html += '</ul>';
                $(".addList").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            }
        })
        $.ajax({
            type: "get",
            url: "/mc/borrow/queryMailFile",
            dataType: "json",
            success: function (data) {
                var  qualification=data.McQualificationCertificate;
                var html="";
                html += '<ul>';
                $.each(qualification,function (index,obj) {
                    html +='<li class="noe-in"><a class="noe-in-1">'+obj.name+'</a></li>';
                })
                html += '</ul>';
                $(".reductionList").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            }
        })
    })

    $("#ap").change(function () {
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/sd/SdSalesContract/getProject",
            success:function (data) {
                $.each(data,function (index,obj) {
                    var html="";
                    var qo=$("#ap").val()
                    if(obj.id==qo){
                        $("#number").val(obj.code)
                        $(".Eliminate-1").val(obj.client.name)
                        $(".Eliminate-no-1").val(obj.client.id)

                    }
                })
            }
        });
    })
});
