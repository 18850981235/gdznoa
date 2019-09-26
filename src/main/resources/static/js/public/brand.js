/**
 * Created by Administrator on 2019/8/1.
 */
//品牌
$.ajax({
    type:"post",
    dataType:"json",
    url:"/supplier/trademark/getAllTrademark",
    success:function (data) {
        var names=data;
        $.each(names,function (index,obj) {
            var html="";
            // html+='<ul class="name" >';
            html += '<li class="co7">';
            html += '<a class="upload7" >';
            html += '<span class="name-block7" >'+obj.name+'</span>';
            html += '<span class="name-none7" style="display: none">'+obj.id+'</span>';
            html += '</a>';
            html += '</li>';
            // html+='</ul>';
            $(".name7").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});