/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="http://192.168.1.191:8080/mc/stamp/particular.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // $.each(data,function (index,project) {
            var mcStamp=data.mcStamp;
            var list=data.list;
            html+='<input style="display: none" value='+data.id+' name="id">';
            html += '<table border="1" >';
            html += ' <tr style="text-align: center;height: 45px ">';
            html += ' <td colspan="4" style="width: 900px;background-color: #efefef ">';
            html += '<b>商务盖章详情</b>';
            html += '</td>';
            html += '</tr>';
            html += '  <tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">申请部门</td>';
            html += '<td style="width:300px ;">'+mcStamp.dept.name+'</td>';
            html += ' <td style="width:150px ;;background-color: #efefef">申请日期</td>';
            html += '<td style="width:300px ;">'+mcStamp.updatetime+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;;background-color: #efefef">联系电话</td>';
            html += '<td style="width:300px ;">'+mcStamp.phone+'</td>';
            html += ' <td style="width:150px ;;background-color: #efefef">所需相关文件份数</td>';
            html += '<td style="width:300px ;">'+mcStamp.fileNum+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += ' <td style="width:150px ;;background-color: #efefef">用章类型说明</td>';
            html += '<td colspan="3" style="width:300px ;">'+mcStamp.stampType+'</td>';
            html += '</tr>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += ' <td style="width:150px ;;background-color: #efefef">盖章用途说明</td>';
            html += '<td colspan="3" style="width:300px ;">'+mcStamp.content+'</td>';
            html += '</tr>';
            html += '</tr>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += ' <td style="width:150px ;;background-color: #efefef">收件地址</td>';
            html += '<td colspan="3" style="width:300px ;">'+mcStamp.consigneeAddress+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '   <td style="width:150px ;background-color: #efefef;">收件人</td>';
            html += '    <td style="width:300px ;">'+mcStamp.consignee+'   </td>';
            html += '   <td style="width:150px ;;background-color: #efefef">联系电话</td>';
            html += '    <td style="width:300px ;">'+mcStamp.consigneePhone+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style=";background-color: #efefef">附件</td>';
            // html += '<td colspan="3">'+data.accessory+'</td>';
            if(mcStamp.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=mcStamp.accessory.split(","); //字符分割
                html += '<td colspan="3" >'
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
            $.each(list,function (index,list) {
                html+='<tr style="text-align: center;height: 45px ">';
                html+='<td>'+list.user.name+'</td>';
                html+='<td>'+list.approvalDate+'</td>';
                html+='<td>'+list.opinion+'</td>';
                html+='<td>'+list.state+'</td>';
                html+='</tr>';
            })
            html += '</table>';
            html += '<a href="#" id="no" style="color: #333;margin-left: 400px ">返回 </a>';
            $("#center").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
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