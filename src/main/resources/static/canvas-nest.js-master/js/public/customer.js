/**
 * Created by Administrator on 2019/4/12.
 */
//客户单位
$.ajax({
    type:"post",
    dataType:"json",
    url:"<%=basePath%>/json/customer.json",
    success:function (data) {
        var names=data;
        $.each(names,function (index,obj) {
            var html="";
            // html+='<ul class="name" >';
            html+='<option value='+obj.id+'>';
            html+='<span>'+obj.name+'</span>';
            html+='</option>';
            // html+='</ul>';
            $(".customer").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});