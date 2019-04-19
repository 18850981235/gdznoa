/**
 * Created by Administrator on 2019/4/9.
 */
//单位

$.ajax({
    type:"post",
    dataType:"json",
    url:"/util/getClient",
    success:function (data) {
        var names=data;
        $.each(names,function (index,obj) {
            var html="";
            // html+='<ul class="name" >';
            html += '<li class="co1">';
            html += '<a class="upload1" >';
            html += '<span class="name-block1" >'+obj.name+'</span>';
            html += '<span class="name-none1" style="display: none">'+obj.id+'</span>';
            html += '</a>';
            html += '</li>';
            // html+='</ul>';
            $(".name1").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});