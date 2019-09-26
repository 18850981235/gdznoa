/**
 * Created by Administrator on 2019/7/25.
 */
$(document).ready(function () {
    $("body").on("click","#add",function () {
        var text='<tr style="height:40px;"><td style="width:200px"><input style="width: 180px;text-align: center " placeholder="请输入时间" name=""></td><td colspan="3"> <input style="width:700px " placeholder="请输入" name=""></td></tr>'
        $("#con tbody").append(text);
    })
    $("body").on("click","#remove",function () {
        $("#con tr:last").remove();
    })
    $("body").on("click",".block",function () {
        $("#none").slideDown();
        $(".none").show();
        $(".block").hide();
    })
    $("body").on("click",".none",function () {
        $("#none").slideUp();
        $(".block").show();
        $(".none").hide();
    })
})