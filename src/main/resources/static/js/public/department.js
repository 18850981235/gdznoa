/**
 * Created by Administrator on 2019/4/9.
 */
//部门
$.ajax({
    type:"post",
    dataType:"json",
    // url:"/util/getDept",
    url:"/util/areaManagerUser",
    success:function (data) {
        var names=data;
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