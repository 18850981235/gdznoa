/**
 * Created by Administrator on 2019/8/5.
 */
function w() {
    var  id=q("id");
    var url="/ga/outerTube/particular.html?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var project=data.project;
            var html="";
            console.log(data.project)
          html+='<table border="1" style="width: 1000px ">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center"><b>外经证详情</b></td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">申请人</td>';
              html+='<td  style="width:300px ;">'+project.user.name+'</td>';
              html+='<td style="width:150px ;background-color: #efefef">申请部门</td>';
              html+='<td style="width:300px ;">'+project.dept.name+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">日期</td>';
              html+='<td  style="width:300px ;">'+project.createtime+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">要求及所需相关文件名称</td>';
              html+='<td style="width:300px ;">'+project.relevantDocument+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">要求办理完成时间</td>';
              html+='<td  style="width:300px ;">'+project.accomplishTime+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">有效期 截止时间</td>';
          html+='<td style="width:300px ;">'+project.validTime+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">收件人</td>';
              html+='<td  style="width:300px ;">'+project.consignee+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">收件人电话</td>';
              html+='<td style="width:300px ;">'+project.consigneePhone+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">收件人地址</td>';
              html+='<td  style="width:300px ;">'+project.consigneeAddress+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">备注</td>';
              html+='<td style="width:300px ;">'+project.remark+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">申请内容</td>';
              html+='<td colspan="3"  style="width:300px ;">'+project.content+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">附件内容</td>';
            if(project.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=project.accessory.split(","); //字符分割
                html += '<td colspan="3" style="width: 600px " >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" style="width: 600px ;display: inline-block">';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
              // html+='<td colspan="3"  style="width:300px ;">'+project.accessory+'</td>';
              html+='</tr>';
              html+='</table>';
            html += ' <table class="approval " style="width: 1000px ">';
            html += '<tr style="height: 40px;width:1000px  " >';
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
            $.each(data.list, function (index, list) {
                html += '<tr style="text-align: center;width:900px ;height: 40px">';
                html += '<td style="width: 20px  ">' + (index+1) + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 50px  ">' + list.user.name + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalDate + '' +
                    '</td>';
                html += '<td style="width: 200px  ">' + list.opinion + '</td>';
                html += '<td style="width: 50px  ">' + list.state + '</td>';
                html += '</tr>';
            })
            html += '</table>';

            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
    // $.ajax({
    //     type:"get",
    //     dataType:"json",
    //     url:url,
    //     date:{"id":id},
    //     success:function (data) {
    //         var html="";
    //
    //
    //
    //         $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    //
    //     }
    // });
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