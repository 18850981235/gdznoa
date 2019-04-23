/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/register/querydetailsbyid.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // $.each(data,function (index,project) {
            var lists=data.Lists;//流程
            var list=data.List[0];
            html+=' <input style="display: none" value='+data.id+' name="id">';
            html+='<table border="1">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>注册备案管理详情</b>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">备案名称</td>';
              html+='<td colspan="3">'+list.recordsName+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>申请部门:</span>';
          html+='</td>';
          html+='<td style="width:300px ;">'+list.deptName+' </td>';
              html+='<td style="width:150px ;;background-color: #efefef">申请日期:</td>';
          html+='<td style="width:300px ;"> '+list.createtime+'</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">负责人:</td>';
          html+='<td >'+list.user.name+' </td>';
          html+='<td style="width:150px ;background-color: #efefef;">注册备案类型:</td>';
          html+='<td style="width:300px ;">'+list.recordsType+' </td>';
              html+='</tr>';
            // <tr style="height:40px;">
            //     <td style="width:150px ;background-color: #efefef;">商务部按标准核定费用:</td>
            // <td ><input style="width: 300px "name="" ></td>
            //     <td style="width:150px ;background-color: #efefef;">管理负责人审批金额:</td>
            // <td ><input style="width: 300px " name=""></td>
            // </tr>
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">注册备案状态</td>';
              html+='<td colspan="3"> '+list.recordsState+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;" >附件</td>';
            if(list.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=list.accessory.split(","); //字符分割
                html += '<td colspan="3" >';
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="http://192.168.1.191:8080/util/fileDown" >';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
            html += '</tr>';
            html += '</table>';
            html += ' <table class="approval " >';
            html += '<tr style="height: 40px " >';
            html += '<td colspan="4" style="text-align: center;width: 900px ">';
            html += '<b>审批流程</b>';
            html += '</td>';
            html += '</tr>';
            html += '<tr style="text-align: center;background-color: #0099ff ;height: 45px ">';
            html += '<td style="width: 250px  ">名称</td>';
            html += '<td style="width: 250px  ">时间</td>';
            html += '<td style="width: 200px  ">审批意见</td>';
            html += '<td style="width: 200px  ">审核状态</td>';
            html += '</tr>';
            $.each(lists,function (index,obj) {
                html+='<tr style="text-align: center;height: 45px ">';
                html+='<td>'+obj.user.name+'</td>';
                html+='<td>'+obj.approvalDate+'</td>';
                html+='<td>'+obj.opinion+'</td>';
                html+='<td>'+obj.state+'</td>';
                html+='</tr>';
            })
            html += '</table>';

            $("#center").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            // })
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