/**
 * Created by Administrator on 2019/4/9.
 */
//查看者
$.ajax({
    type:"post",
    dataType:"json",
    url:"../../../json/personnel.json",
    success:function (data) {
        var names=data.names;
        // var users=data.names.users;
        $.each(names,function (index,obj) {
            var html="";
            // 一级
            for(i=1;i<names.length+1;i++){

                if(i==obj.id){

                    html+='<li>';
                    html+='<a class="click">'+obj.name+'</a>';
                    // 二级
                    $.each(obj.users,function (index1,obj1) {
                        html+='<ul class="name2" style="display: none" >';
                        html += '<li>';
                        html += '<a class="upload-noe" >';
                        html += '<span class="name-block2" >'+obj1.name+'</span>';
                        html += '<span class="name-none2" style="display: none">'+obj1.id+'</span>';
                        html += '</a>';
                        html += '</li>';
                        html+='</ul>';
                    });
                    html+='<li>';
                }
            }
            $(".yiji-no2").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});