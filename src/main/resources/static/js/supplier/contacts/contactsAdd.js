/**
 * Created by Administrator on 2019/7/26.
 */
$(document).ready(function () {
    $("body").on("click","#add",function () {
        var text='<tr style="height: 40px ; "><td style="width: 100px  "><input style="width:95px;text-align: center" name="name"></td><td style="width: 100px  "><input style="width:95px;text-align: center" name="role"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="phone"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="fax"></td><td style="width: 200px  "><input style="width:195px;text-align: center" name="address"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="email"></td><td style="width: 150px  "><input style="width:145px;text-align: center" name="wechat"></td><td style="width: 200px  "><input style="width:195px;text-align: center" name="jobContent"></td></tr>';
        $("#con tbody").append(text);
    });

    $("body").on("click","#remove",function () {
        if($("#con").lenth<=1){
            $("#remove").hide()
        }else {
            $("#remove").show()
            $("#con tr:last").remove();

        }
    });

    $(document).on("click","#ok",function () {
        var co=$(".contacts").val();
        var titles = $("#con").find("tr:first td");  //获得表头td数组
        //遍历非表头的，tr、td...拼装json
        var json = "{" + "\"" + "list" + "\"" + ":" + "[" + $("#con").find("tr:not(:first)").map(function(i, e) {
            var io=$(e).children("td").children("input");
                return "{" + io.map(function(j, el) {
                        return "\""+$(titles[j]).html()+"\"" + ":" + "\"" + $(el).val() + "\"";
                    }).get().join(",") + "}";
            }).get().join(",")+ "]" +","+ "\""+"supplierid"+"\"" + ":" + co +"}";


        $.ajax({
            type:"post",
            dataType:"text",
            contentType:"application/json;charset=UTF-8",
            url:"/supplier/staff/addstaff",
            data:json,
            success:function(data1){
                if(data1=="yes"){
                    alert("添加成功！")
                    window.location.href="/supplier/supplier_staff/query"
                }else {
                    alert("添加失败！")
                    window.location.href="/supplier/staff/addStaffpage"
                }
              //跳转

            }
        });

    })

    //项目名称
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/supplier/supplier/getAllSupplier",
            success:function (data) {
                $.each(data,function (index,obj) {
                    var html="";

                        html+='<option   value='+obj.id+'>'+obj.name+'</option>';

                    $(".contacts").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                })
            }
        });
})

