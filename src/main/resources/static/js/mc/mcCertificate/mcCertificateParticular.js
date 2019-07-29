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
            var list=data.List;
            var lists=data.Lists;
            // console.log(list.user.name)
            html+='<input style="display: none" value='+list.id+' name="id">';
            
            html+='<table border="1">';
            html+='<tr style="height: 40px ;background-color: #efefef">';
            html+='<td colspan="4" style="text-align: center">';
            html+='<b>资历证书详情</b>';
            html+='</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">';
            html+='<span>证书名称</span>';
            html+='</td>';
            html+='<td style="width:300px ;">'+list[0].name+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">管理负责人</td>';
            html+='<td style="width:300px ;">'+list[0].user.name+'</td>';

            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">证书类型</td>';
            html+='<td style="width:300px ;">'+list[0].type+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">证书管理部门</td>';
            html+='<td >'+list[0].user.company+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">级别内容</td>';
            html+='<td >'+list[0].content+'</td>';
            html+='<td style="width:150px;background-color: #efefef;">证书状态</td>';
            html+='<td >'+list[0].type+'</td>';
            html+='</tr>';

            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">证书借用情况</td>';
            html+='<td >'+list[0].borrow+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">年审时间</td>';
            html+='<td  >'+list[0].annualTime+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">年审负责人</td>';
            html+='<td >';
            html+='<input class="Eliminate-6" readonly value='+list[0].annualUser.name+' >';
            html+='<input style="display: none" class="Eliminate-no-6" name="annualPrincipal" value='+list[0].annualUser.id+'>';
            html+='<a target="_blank " class="add-to6">添加</a>';
            html+='<a class="clear-to6" >';
            html+='<input value="清空" class="input6"  onClick="" type="button">';
            html+='</a>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">PDF导出</td>';
            html+='<td >';
            html+='<a target="_blank" href="/mc/qualification/pdf">添加水印</a>';
            html+='</td>';

            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">证书</td>';
            if(list[0].filename==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=list[0].filename.split(","); //字符分割
                html += '<td colspan="3" style="width: 600px " >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" style="width: 600px ;display: inline-block">';
                        html += '<input name="filename" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
            html+='</tr>';
            html+='</table>';

            html += ' <table class="approval " style="width: 900px ">';
            html += '<tr style="height: 40px;width:900px  " >';
            html += '<td colspan="6" style="text-align: center;width: 900px ">';
            html += '<b>审批流程</b>';
            // html += '<a style="float: right;color: red">'+project.processState+'</a>';
            html += '</td>';
            html += '</tr>';
            html += '<tr style="text-align: center;background-color: #0099ff;width:900px ;height: 40px ">';
            html += '<td style="width: 20px  ">序号</td>';
            html += '<td style="width: 50px  ">审批部门</td>';
            html += '<td style="width: 50px  ">审批人员</td>';
            html += '<td style="width: 50px  ">审批时间</td>';
            html += '<td style="width: 200px  ">审批意见</td>';
            html += '<td style="width: 50px  ">审核状态</td>';
            html += '</tr>';
            $.each(lists, function (index, lists) {
                html += '<tr style="text-align: center;width:900px ;height: 40px">';
                html += '<td style="width: 20px  ">' + (index+1) + '</td>';
                html += '<td style="width: 50px  ">' + lists.approvalIdentity + '</td>';
                html += '<td style="width: 50px  ">' + lists.user.name + '</td>';
                html += '<td style="width: 50px  ">' + lists.approvalDate + '' +
                    '</td>';
                html += '<td style="width: 200px  ">' + lists.opinion + '</td>';
                html += '<td style="width: 50px  ">' + lists.state + '</td>';
                html += '</tr>';
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



