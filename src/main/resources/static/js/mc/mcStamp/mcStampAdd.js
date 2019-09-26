/**
 * Created by Administrator on 2019/5/8.
 */
$.ajax({
    type:"post",
    dataType:"json",
    url:"/util/getUser",
    success:function (data) {
        var html="";
       $("#dept option").eq(0).text(data[0].dept);
       $("#dept option").eq(0).val(data[0].deptid);


    }
});
$.ajax({
    type:"post",
    dataType:"json",
    url:"/util/getUser",
    success:function (data) {
        var html="";
        $("#center input").eq(1).val(data.name);
        $("#center input").eq(2).val(data.id);
        $("#center input").eq(3).val(data.phone);

    }
});