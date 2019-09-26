/**
 * Created by Administrator on 2019/5/29.
 */
//用户默认申请人
$.ajax({
    type: "get",
    url: "/util/getUser",
    dataType: "json",
    success: function (data) {
        $("#center input").eq(2).val(data.name);
        $("#center input").eq(3).val(data.id);
        $("#center input").eq(4).val(data.account);
    }
})