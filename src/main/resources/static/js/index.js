/**
 * Created by Administrator on 2019/5/13.
 */
$.ajax({
    type:"get",
    dataType:"json",
    url:"/page/menu",
    success:function (data) {
        var menuList=data.menuList;
        var authority=data.authority;
        $.each(menuList,function (index,obj) {
            var html="";
            if (obj.levels == 1) {
                if(obj.url==""){
                    html+='<li>';
                    html+='<a href="javascript:;">';
                    html+='<span>'+obj.name+'</span>';
                    html+='<i class="iconfont nav_right"> +</i>';
                    html+='</a>';
                    html+='<ul class="sub-menu">';
                }else {
                    html+='<li>';
                    html+="<a onclick='+xadmin.add_tab(\""+obj.name+"\",\""+obj.url+"\")'>";
                    html+='<span>'+obj.name+'</span>';
                    html+='<i class="iconfont nav_right"> +</i>';
                    html+='</a>';
                    html+='<ul class="sub-menu">';
                }
                $.each(menuList,function (index,obj1) {
                    if (obj1.levels == 2 && obj1.pcode == obj.code) {
                        var url2 = "";
                        var flge = true;
                        $.each(authority, function (i, obj2) {
                            if (obj1.id == obj2.menu) {
                                url2 = obj1.url;
                                flge = false;
                                return false;
                            }
                        })
                        if (flge) {
                            url2 = "javascript:void(0);";
                        }
                        if (obj1.url == "" || obj1.url == null) {
                            url2 = "javascript:void(0);";
                        }
                        if(obj1.url == ""|| obj1.url == null ){
                            html += '<li>';html += "<a >";
                        }else {
                            html += '<li>';html += "<a onclick='+xadmin.add_tab(\""+obj1.name+"\",\""+url2+"\")'>";
                        }

                    html += '<span>'+obj1.name+'</span></a>';
                    html += '</li>';
                    }
                });
                html+='</ul>';
                html+='</li>';
            }
            $("#nav").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        });
    }
});
$.ajax({
    type: "get",
    dataType: "json",
    url: "/user/useraction/queryUserbySelf",
    success: function (data) {
        $("#tc .name").text(data.dept.name);
        $("#tc .userName").text(data.name);
    }
})