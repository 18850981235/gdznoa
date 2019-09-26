$(document).ready(function () {
    console.log(1)
    //所有职位
    //所有部门
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/sys/role/getAllRole",
        success:function (data) {
            var names=data;

            $.each(names,function (index,obj) {
                var html="";
                html+='<li>'+obj.name+'</li>';
                $("#dept").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            });
        }
    });
    // $.ajax({
    //     type:"get",
    //     dataType:"json",
    //     url:"sys/role/getAllRole",
    //     success:function (data) {
    //         console.log(data)
    //         console.log("---"+1);
    //
    //         // $.each(data,function (index,obj) {
    //         //     var html="";
    //         //     html+='<li>'+obj.name+'</li>';
    //         //     $("#dept").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    //         // })
    //     },
    //     error:function (obj) {
    //     console.log(obj);
    //     }
    // });

    //点击增加
    $(document).on("click","#Add-in",function () {
        var Add=$("#Add").val();
        console.log(Add)
        $.ajax({
            type: "post",
            url: "/sys/role/addRole",
            dataType: "text",
            data:{"name":Add},
            success: function (data) {
                if(data=="yes"){
                    alert("增加成功")
                    window.location.href="/sys/role/query";
                }else if(data=="nothing"){
                    alert("请输入数据！")
                    window.location.href="/sys/role/query";
                }else {
                    alert("增加失败")
                    window.location.href="/sys/role/query";
                }
            },
            error:function (obj) {

            }
        })
    })
    //点击修改
    $(document).on("click","#change-in",function () {
        var Change=$("#change").val();
        var Changeno=$("#change-on").val();

        $.ajax({
            type: "post",
            url: "/sys/role/updateRole",
            dataType: "text",
            data:{"id":Change,"name":Changeno},
            success: function (data) {
                if(data=="yes"){
                    alert("修改成功")
                    window.location.href="/sys/role/query";
                }else if(data=="nothing"){
                    alert("请输入数据！")
                    window.location.href="/sys/role/query";
                }else {
                    alert("修改失败")
                    window.location.href="/sys/role/query";
                }
            },
            error:function (data) {

            }
        })
    })
    //点击删除
    $(document).on("click","#delete-in",function () {
        var Delete=$("#delete").val();
//          var delete=$("#delete").val();
        $.ajax({
            type: "post",
            url: "/sys/role/deleteRole",
            dataType: "text",
            data:{"id":Delete},
            success: function (data) {
                if(data=="yes"){
                    alert("删除成功")
                    window.location.href="/sys/role/query";
                }else if(data=="no") {
                    alert("删除失败")
                    window.location.href="/sys/role/query";
                }else{
                    alert("删除失败,该分支下有人，不可删除！")
                    window.location.href="/sys/role/query";
                }
            },
            error:function (data) {

            }
        })
    })
})