/**
 * Created by Administrator on 2019/4/9.
 */
//负责人
$.ajax({
    type:"post",
    dataType:"json",
    url:"../../../json/personnel.json",
    success:function (data) {
        var names=data.names;
        // var users=data.names.users;
        $.each(names,function (index,obj) {
            var html="";
            // html+='<ul class="yiji-no">';
            // 一级
            for(i=1;i<names.length+1;i++){
                if(i==obj.id){

                    html+='<li>';
                    html+='<a class="click">'+obj.name+'</a>';
                    // 二级
                    $.each(obj.users,function (index1,obj2) {
                        html+='<ul class="name" style="display: none" >';
                        html += '<li class="co">';
                        html += '<a class="upload" >';
                        html += '<span class="name-block" >'+obj2.name+'</span>';
                        html += '<span class="name-none" style="display: none">'+obj2.id+'</span>';
                        html += '</a>';
                        html += '</li>';
                        html+='</ul>';
                    });
                    html+='<li>';
                }
            }
            // html+='</ul>';
            $(".yiji-no").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});