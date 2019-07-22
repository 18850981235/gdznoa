/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/dispatched/particular.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            var oa=data.personnelDispatched;
            var list=data.list;


              html+='<input style="display: none" value='+oa.id+'  >';
          html+='<table border="1">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>人员派遣修改</b>';
              html+='<input style="display: none">';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">项目名</td>';
              html+='<td colspan="3" style="width:300px ;">'+oa.project.abbreviation+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>申请部门</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+oa.dept.name+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>申请人</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+oa.user.name+'</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">申请人派遣要求</td>';
              html+='<td colspan="3">'+oa.demand+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">预计出差时间</td>';
              html+='<td >'+oa.evectionTime+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">派遣人员情况</td>';
              html+='<td >'+oa.personnelCondition+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">人员费用标准</td>';
              html+='<td >'+oa.costStandard+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">人员费用预算</td>';
              html+='<td >'+oa.evectionBudget+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">实际出差时间</td>';
              html+='<td >'+oa.practicalTime+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">出差情况确认</td>';
              html+='<td >'+oa.evectionCondition+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">人员费用结算</td>';
              html+='<td >'+oa.evectionCost+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">差旅费用结算</td>';
              html+='<td >'+oa.travelCost+'</td>';
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
            $.each(list, function (index, list) {
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