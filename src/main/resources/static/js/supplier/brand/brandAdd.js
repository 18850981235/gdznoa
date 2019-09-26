/**
 * Created by Administrator on 2019/8/1.
 */
$.ajax({
    type:"post",
    dataType:"json",
    url:"/supplier/trademark/getAllSysytem",
    success:function (data) {
        $.each(data,function (index,obj) {
            var html="";
            if(obj.f_id==0||obj.f_id=="0"){
                html+='<option value='+obj.id+'>';
                html+='<span>'+obj.name+'</span>';
                html+='</option>';
            }
            $(".contacts").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});