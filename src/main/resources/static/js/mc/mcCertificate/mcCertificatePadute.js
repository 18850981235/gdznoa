/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/qualification/querybyid.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        date:{"id":id},
        success:function (data) {
            var html="";
            html+='<input style="display: none" value='+data.id+' name="id">';
          html+='<table border="1">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>资历证书修改</b>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>证书名称</span>';
              html+='</td>';
              html+='<td style="width:300px ;">';
              html+='<input style="width: 280px " value='+data[0].name+' name="name">';
              html+='</td>';
              html+='<td style="width:150px ;background-color: #efefef;">管理负责人</td>';
              html+='<td >';
              html+='<input  class="Eliminate" readonly  value='+data[0].user.name+'>';
                html+='<input required style="display: none" class="Eliminate-no" value='+data[0].user.id+' name="userid">';
              html+='<a target="_blank " class="add-to">添加</a>';
              html+='<a class="clear-to" >';
              html+='<input value="清空" class="input"  onClick="" type="button">';
              html+='</a>';
              html+='</td>';

              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">证书类型</td>';
              html+='<td style="width:300px ;">';
              html+='<select style="width: 100px;height: 30px " name="type">';
              html+='<option  > '+data[0].type+'</option>';
              html+='<option>类型1</option>';
              html+='<option>类型2</option>';
              html+='</select>';
              html+='</td>';
              html+='<td style="width:150px ;background-color: #efefef;">证书管理部门</td>';
              html+='<td >';
              html+='<select class="department" style="width: 100px;height: 30px " name="deptid">';
              html+='<option value='+data[0].user.deptid+'>'+data[0].user.nema+'</option>';
              html+='</select>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">级别内容</td>';
              html+='<td > <select required style="width: 100px;height:30px " name="content">';
              html+='<option>'+data[0].content+'</option>';
              html+='<option>类型1</option>';
              html+='<option>类型2</option>';
              html+='</select></td>';
              html+='<td style="width:150px;background-color: #efefef;">证书状态</td>';
              html+='<td >';
              html+='<select style="width: 100px;height: 30px " name="state">';
              html+='<option  > '+data[0].type+'</option>';
              html+='<option>类型1</option>';
              html+='<option>类型2</option>';
              html+='</select>';
              html+='</td>';
              html+='</tr>';

              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">证书借用情况</td>';
              html+='<td ><input style="width: 280px " value='+data[0].borrow+' name="borrow"></td>';
              html+='<td style="width:150px ;background-color: #efefef;">年审时间</td>';
              html+='<td  ><input style="width: 280px "   type="text"   placeholder="请选择日期" id="test1" value='+data[0].annualTime+' name="annualTime"  ></td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">年审负责人</td>';
              html+='<td >';
              html+='<input style="width: 280px " name="annualPrincipal">';
              html+='</td>';
              html+='<td style="width:150px ;background-color: #efefef;">PDF导出</td>';
              html+='<td >';
              html+='<form  href="/mc/qualification/pdf" >';
              html+='<input type="file" value="添加水印" />';
              html+='<input type="submit" value="制作"/>';
              html+='</form>';
              html+='</td>';

              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">证书</td>';
              html+='<td colspan="3">';
              html+='<input  type=file value='+data[0].accessory+' name="filename">'

            html+='</td>';

              html+='</tr>';
              html+='</table>';

            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
}
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