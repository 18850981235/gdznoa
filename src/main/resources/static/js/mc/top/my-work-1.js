/**
 * Created by Administrator on 2019/4/16.
 */
//流程名称
$.ajax({
    type:"post",
    dataType:"json",
    url:"/util/approvalProcess",
    success:function (data) {
            var list=data.list;

        $.each(data,function (index,obj) {
            var html="";

            // html+='<ul class="name" >';
            html+='<option value='+obj.id+'>'+obj.name+'</option>';
            // html+='</ul>';
            $(".department").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});