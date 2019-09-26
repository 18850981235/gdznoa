/**
 * Created by Administrator on 2019/4/25.
 */
//区域负责人
$.ajax({
    type:"post",
    dataType:"json",
    // url:"/util/areaManagerUser",
    url:"/util/getDept",
    success:function (data) {
        var names=data;
        $.each(names,function (index,obj) {
            var html="";
            // html+='<ul class="name" >';
            html += '<li class="co3">';
            html += '<a class="upload3" >';
            html += '<span class="name-block3" >'+obj.name+'</span>';
            html += '<span class="name-none3" style="display: none">'+obj.id+'</span>';
            html += '</a>';
            html += '</li>';
            // html+='</ul>';
            $(".name3").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});