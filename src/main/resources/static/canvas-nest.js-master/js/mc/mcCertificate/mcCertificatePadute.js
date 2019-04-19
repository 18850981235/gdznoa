/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="http://192.168.1.191:8080/mc/stamp/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // $.each(data,function (index,project) {
            html+='<input style="display: none" value='+data.id+' name="id">';
          html +='<table border="1">';
              html +='<tr style="height: 40px ;background-color: #efefef">';
              html +='<td colspan="4" style="text-align: center">';
              html +='<b>资历证书修改</b>';
              html +='</td>';
              html +='</tr>';
              html +='<tr style="height:40px;">';
              html +='<td style="width:150px ;background-color: #efefef;">证书名称:</td>';
          html +='<td style="width:300px ;">';
              html +='<input style="width: 280px " name="name" value='+data.name+'>';
              html +='</td>';
              html +='<td style="width:150px ;background-color: #efefef;">管理负责人:</td>';
          html +='<td >';
          html +='<input class="Eliminate" readonly value='+data.processUser.name+'>';
          html +='<input style="display: none" class="Eliminate-no" name="userid" value='+data.processUser.id+'>';
              html +='<a target="_blank " class="add-to">添加</a>';
              html +='<a class="clear-to" >';
              html +='<input value="清空" class="input"  onClick="" type="button">';
              html +='</a>';
              html +='</td>';

              html +='</tr>';
              html +='<tr  style="height:40px;">';
              html +='<td style="width:150px ;background-color: #efefef;">证书管理部门:</td>';
          html +='<td colspan="3">';
          html +='<select class="department" style="width: 100px;height: 30px " name="deptid">';
            $.ajax({
                type:"post",
                dataType:"json",
                url:"../../../json/section.json",
                success:function (data1) {
                    var names=data1.list;
                    $.each(names,function (index,obj) {
                        if(data.dept.id=obj.id){
                            html+='<option value='+obj.id+'select>';
                            html+='<span>'+obj.name+'</span>';
                            html+='</option>';
                        }else{html+='<option value='+obj.id+'>';
                            html+='<span>'+obj.name+'</span>';
                            html+='</option>';}
                        $(".department").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                    });
                }
            });
              html +='</select>';
              html +='</td>';
              html +='</tr>';
              html +='<tr style="height:40px;">';
              html +='<td style="width:150px ;background-color: #efefef;">年审时间:</td>';
          html +='<td ><input type="date" style="width: 180px " name="createtime" value='+data.processUser.createtime+'></td>';
              html +='<td style="width:150px ;background-color: #efefef;">证书状态:</td>';
          html +='<td ><input style="width: 280px " name="processState" value='+data.processState+'></td>';
              html +='</tr>';
              html +='<tr style="height:40px;">';
              html +='<td style="width:150px ;background-color: #efefef;">级别内容:</td>';
          html +='<td colspan="3"><input style="width: 700px " name="content"></td>';;
              html +='</tr>';
              html +='<tr style="height:40px;">';
              html +='<td style="width:150px ;background-color: #efefef;">证书借用情况:</td>';
          html +='<td colspan="3" ><input style="width: 700px " name="borrow"></td>';

              html +='</tr>';
              html +='<tr style="height:40px;">';
              html +='<td style="width:150px ;background-color: #efefef;">证书上传:</td>';
          html +='<td colspan="3" ><input type="file"  style="width: 700px " name="file"></td>';
          html +='</tr>';
          html +='</table>';








            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            // })
        }
    });
}
// w();
$(document).ready(function () {
    w();
})
function q(name){
    var search = document.location.search;
    var pattern = new RegExp("[?&]"+name+"\=([^&]+)", "g");
    var matcher = pattern.exec(search);
    var items = null;
    if(null != matcher){
        try{
            items = decodeURIComponent(decodeURIComponent(matcher[1]));
        }catch(e){
            try{
                items = decodeURIComponent(matcher[1]);
            }catch(e){
                items = matcher[1];
            }
        }
    }
    return items;
};