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
            html+='<table border="1">';
            html+='   <tr style="height: 40px ;background-color: #efefef">';
            html+='   <td colspan="4" style="text-align: center">';
            html+='   <b>注册备案管理修改</b>';
            html+='  </td>';
            html+='   </tr>';
            html+='  <tr style="height:40px;">';
            html+='   <td style="width:150px ;background-color: #efefef;">申请部门</td>';
            html+=' <td style="width:300px ;">';
            html+=' <select class="department" style="width: 100px;height: 30px " name="deptid">';
            html+='  <option value="">';
            html+=' 请选择';
            html+='  </option>';
            html+=' </select>';
            html+=' </td>';
            html+='  <td style="width:150px ;;background-color: #efefef">申请日期</td>';
            html+=' <td style="width:300px ;">';
            html+=' <input type="date" style="width:280px "  name="createtime">';
            html+='  </td>';
            html+=' </tr>';
            html+=' <tr  style="height:40px;">';
            html+=' <td style="width:150px ;background-color: #efefef;">负责人</td>';
            html+='  <td >';
            html+=' <input class="Eliminate" readonly >';
            html+='<input style="display: none" class="Eliminate-no" name="principal">';
            html+='   <a target="_blank " class="add-to">添加</a>';
            html+='  <a class="clear-to" >';
            html+='  <input value="清空" class="input"  onClick="" type="button">';
            html+='  </a>';
            html+='  </td>';
            html+='  <td style="width:150px ;background-color: #efefef;">注册备案类型</td>';
            html+='  <td style="width:300px ;">';
            html+='  <select  style="width: 100px;height: 30px " name="recordsType">';
            html+=' <option value="">请选择</option>';
            html+='  <option value="公司备案">公司备案</option>';
            html+='  <option value="项目备案">项目备案</option>';
            html+='  </select>';
            html+='  </td>';
            html+=' </tr>';
            html+=' <tr style="height:40px;">';
            html+='  <td style="width:150px ;background-color: #efefef;">商务部按标准核定费用:</td>';
            html+=' <td ><input style="width: 300px "name="" ></td>';
            html+='   <td style="width:150px ;background-color: #efefef;">管理负责人审批金额:</td>';
            html+='<td ><input style="width: 300px " name=""></td>';
            html+=' </tr>';
            html+=' <tr style="height:40px;">';
            html+='  <td style="width:150px ;background-color: #efefef;">附件:</td>';
            html+='<td colspan="3"><input type="file"  style="width: 700px " name="accessory"></td>';
            html+='</tr>';
            html+='</table>';

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