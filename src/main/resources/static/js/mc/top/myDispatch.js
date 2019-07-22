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
            var personnelDispatched=data.personnelDispatched;
            var list=data.list;

            html+='<input style="display: none" value='+data.id+' name="id">';

            html+='<table border="1">';
            html+='<tr style="height: 40px ;background-color: #efefef">';
            html+='<td colspan="4" style="text-align: center">';
            html+='<b>人员派遣修改</b>';
            html+='<input style="display: none">';
            html+='</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">项目名</td>';
            html+='<td colspan="3" style="width:300px ;">'+personnelDispatched.project.abbreviation+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">';
            html+='<span>申请部门</span>';
            html+='</td>';
            html+='<td style="width:300px ;">'+personnelDispatched.dept.name+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">';
            html+='<span>申请人</span>';
            html+='</td>';
            html+='<td style="width:300px ;">'+personnelDispatched.user.name+'</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">申请人派遣要求</td>';
            html+='<td colspan="3">'+personnelDispatched.demand+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">预计出差时间</td>';
            html+='<td >'+personnelDispatched.evectionTime+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">派遣人员情况</td>';
            html+='<td >'+personnelDispatched.personnelCondition+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">人员费用标准</td>';
            html+='<td >'+personnelDispatched.costStandard+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">人员费用预算</td>';
            html+='<td >'+personnelDispatched.evectionBudget+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">实际出差时间</td>';
            html+='<td >'+personnelDispatched.practicalTime+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">出差情况确认</td>';
            html+='<td >'+personnelDispatched.evectionCondition+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">人员费用结算</td>';
            html+='<td >'+personnelDispatched.evectionCost+'</td>';
            html+='<td style="width:150px ;background-color: #efefef;">差旅费用结算</td>';
            html+='<td >'+personnelDispatched.travelCost+'</td>';
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
            });
            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 20px  "><input style="text-align: center;border: 1px solid">';
            html += '<input style="display:none" value='+personnelDispatched.id+'>';
            if(personnelDispatched.processNode==1){
                html += '<input style="display:none" value="商务部审核">';
            }else if(personnelDispatched.processNode==2){
                html += '<input style="display:none" value="分公司总经理审批">';
            }else if(personnelDispatched.processNode==3){
                html += '<input style="display:none" value="申请人确认">';
            }else if(personnelDispatched.processNode==4){
                html += '<input style="display:none" value="账务部结算">';
            }

            html += '</td>';

            html += '<td style="width: 50px  ">' ;
            html +=  '<select style="height: 27px">';
            html += '<option>请选择</option>';
            html += '<option>商务部审核</option>';
            html += '<option>分公司总经理审批</option>';
            html += '<option>申请人确认</option>';
            html += '<option>账务部结算</option>';
            html += '</select>';
            html += '</td>';
            html += '<td style="width: 50px  "><input style="text-align:center;border: 1px solid"></td>';
            html += '<td style="width: 50px  "><input type="text"  id="test1" style="text-align: center"></td>';
            html += '<td style="width: 200px  "><input style="width: 180px;text-align: center;border: 1px solid "></td>';
            html += '<td style="width: 50px  "><select style="height: 27px"><option>通过</option><option>转交</option></select></td>';
            html += '</tr>';
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

$(document).ready(function () {

    // var year=myDate.getFullYear(); //年
    // var mon=date.getMonth()+1;	//月
    // var day=date.getDate();		//日
    var myDate = new Date();
//获取当前年
    var year=myDate.getFullYear();
//获取当前月
    var month=myDate.getMonth()+1;
//获取当前日
    var date=myDate.getDate();
    if(month<10){
        daytime=year +"-0"+month+"-"+date;
    }else {
        daytime=year +"-"+month+"-"+date;
    }

    $("#test1").val(daytime);

})