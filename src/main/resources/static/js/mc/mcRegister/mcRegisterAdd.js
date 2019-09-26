/**
 * Created by Administrator on 2019/5/28.
 */
//用户默认申请人
$.ajax({
    type: "get",
    url: "/util/getUser",
    dataType: "json",
    success: function (data) {
        $("#center input").eq(1).val(data.name);
          $("#center input").eq(2).val(data.id);
        $("#center input").eq(3).val(data.phone);
    }
})
$.ajax({
    type:"post",
    dataType:"json",
    url:"/util/getDeptUsers",
    success:function (data) {
        // var users=data.names.users;

        $.each(data,function (index,obj) {
            var html="";
            // html+='<ul class="yiji-no">';
            // 一级
            for(i=1;i<data.length+1;i++){
                if(i==obj.id){

                    html+='<li>';
                    html+='<a class="click">'+obj.name+'</a>';
                    // 二级
                    $.each(obj.users,function (index1,obj2) {
                        html+='<ul class="name5" style="display:none " >';
                        html += '<li class="co5">';
                        html += '<a class="upload5" >';
                        html += '<span class="name-block5" >'+obj2.name+'</span>';
                        html += '<span class="name-none5" style="display: none">'+obj2.id+'</span>';
                        html += '</a>';
                        html += '</li>';
                        html+='</ul>';
                    });
                    html+='<li>';
                }
            }
            // html+='</ul>';
            $(".yiji-no5").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});

