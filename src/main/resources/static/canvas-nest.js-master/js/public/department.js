/**
 * Created by Administrator on 2019/4/9.
 */
//部门
$.ajax({
    type:"post",
    dataType:"json",
    url:"<%=basePath%>/json/section.json",
    success:function (data) {
        var names=data.list;
        $.each(names,function (index,obj) {
            var html="";
            // html+=' <select class="department" style="width: 100px ">';
            html+='<option value='+obj.id+'>';
            html+='<span>'+obj.name+'</span>';
            html+='</option>';
            // html+='</select>';
            $(".department").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});