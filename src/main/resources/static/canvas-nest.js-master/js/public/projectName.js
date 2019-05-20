/**
 * Created by Administrator on 2019/4/16.
 */
//项目名称
$.ajax({
    type:"post",
    dataType:"json",
    url:"../../../json/projectName.json",
    success:function (data) {
        $.each(data,function (index,obj) {
            var html="";
            // html+='<ul class="name" >';
            html+='<option value='+obj.id+'>';
            html+='<span>'+obj.abbreviation+'</span>';
            html+='</option>';
            // html+='</ul>';
            $(".projectname").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});