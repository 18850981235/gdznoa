/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/qualification/querydetailbyid.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            var personnelDispatched=data.personnelDispatched;
            var list=data.List[0];
            var lists=data.Lists;
            // console.log(list.user.name)
            html+='<input style="display: none" value='+list.id+' name="id">';

          html+='<table border="1">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>资历证书详情</b><input style="display: none" name="id"></td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">证书名称</td>';
              html+='<td style="width:300px ;"> '+list.name+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">管理负责人</td>';

              html+='<td >'+list.user.name+' </td>';

              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">证书类型</td>';
              html+='<td style="width:300px ;"> '+list.type+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">证书管理部门</td>';
              html+='<td style="width:300px ;">'+list.user.dept+' </td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">年审时间</td>';
              html+='<td >'+list.annualTime+' </td>';
              html+='<td style="width:150px ;background-color: #efefef;">证书状态</td>';
              html+='<td > '+list.state+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">级别内容</td>';
              html+='<td colspan="3" > '+list.content+'</td>';

              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">证书借用情况</td>';
              html+='<td colspan="3" >'+list.borrow+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">证书附件</td>';

            if(list.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=list.accessory.split(","); //字符分割
                html += '<td colspan="3" style="width: 600px " >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="http://192.168.1.191:8080/util/fileDown" style="width: 600px ;display: inline-block">';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
            html+='</tr>';

            html+='</table>';

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
            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            // })
        }
    });
}
//
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



