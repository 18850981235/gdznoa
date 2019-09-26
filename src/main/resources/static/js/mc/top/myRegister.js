/**
 * Created by Administrator on 2019/6/6.
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

            html+=' <input style="display: none" value='+list.id+' name="id">';
            html += ' <table border="1">';

            html += ' <tr style="height: 40px ;background-color: #efefef">';
            html += ' <td colspan="4" style="text-align: center">';
            html += ' <b>注册备案管理修改</b>';
            html += ' </td>';
            html += ' </tr>';

            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;background-color: #efefef;">';
            html += ' <span>申请部门</span>';
            html += ' </td>';
            html += ' <td style="width:300px ;">'+list.deptName+'</td>';
            html += ' <td style="width:150px ;;background-color: #efefef">申请日期</td>';
            html += ' <td style="width:300px ;">'+list.createtime+'</td>';
            html += ' </tr>';
            html += ' <tr  style="height:40px;">';
            html += ' <td     style="width:150px;background-color: #efefef  ">申请人</td>';
            html += ' <td >'+list.user.name+'</td>';
            html += ' <td   style="width:150px ;background-color: #efefef ">联系电话 </td>';
            html += ' <td style="width:300px ;">'+list.user.account+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;background-color: #efefef;">备案名称</td>';
            html += ' <td colspan="3">'+list.recordsName+'</td>';
            html += ' </tr>';
            html += ' <tr  style="height:40px;">';
            html += ' <td     style="width:150px;background-color: #efefef  ">注册备案类型</td>';
            html += ' <td >'+list.recordsState+'</td>';
            html += ' <td   style="width:150px;background-color: #efefef">管理人员 </td>';
            html += ' <td style="width:300px ;">'+list.managerUser.name+'</a>';
            html += ' </td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;background-color: #efefef;">所需资料及条件</td>';
            html += ' <td colspan="3">'+list.dataConditions+'</tr>';
            html += ' <tr  style="height:40px;">';
            html += ' <td     style="width:150px;background-color: #efefef  ">注册备案状态</td>';
            html += ' <td >'+list.recordsType+'</td>';
            html += ' <td   style="width:150px;background-color: #efefef">CA借用情况 </td>';
            html += ' <td style="width:300px ;">'+list.caBorrow+'</td>';
            html += ' </tr>';
            html += ' <tr  style="height:40px;">';
            html += ' <td     style="width:150px;background-color: #efefef  ">年审负责人</td>';
            html += ' <td >'+list.annualuser.name+'</td>';
            html += ' <td   style="width:150px;background-color: #efefef">年审时间 </td>';
            html += ' <td style="width:300px ;">'+list.annualuser.createtime+'</td>';
            html += ' </tr>';
            html += ' </table>';

            html += ' <table class="approval " style="width: 900px ">';
            html += '<tr style="height: 40px;width:900px  " >';
            html += '<td colspan="6" style="text-align: center;width: 900px ">';
            html += '<b>审批流程</b>';
// html += '<a style="float: right;color: red">'+project.processState+'</ a>';
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
                html += '<td style="width: 50px  ">' + (index+1) + '</td>';
                html += '<td style="width: 150px  ">' + lists.approvalIdentity + '</td>';
                html += '<td style="width: 150px  ">' + lists.user.name + '</td>';
                html += '<td style="width: 150px  ">' + lists.approvalDate +'</td>';
                html += '<td style="width: 250px ">' + lists.opinion + '</td>';
                html += '<td style="width: 150px  ">' + lists.state + '</td>';
                html += '</tr>';
            });
            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 50px  ">'+list.processNode+'<input style="display:none" value='+list.id+' name="approvalId">';
            html += '</td>';


            if(list.processNode==1){
                html += '<td style="width: 150px;text-align: center  ">商务部审核</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px " value="商务部审核">';
            }else if(list.processNode==2){
                html += '<td style="width: 150px;text-align: center  ">分公司总经理审准</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="分公司总经理审准">';
            }else if(list.processNode==3){
                html += '<td style="width: 150px;text-align: center  ">信息中心复核</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="信息中心复核">';
            }else if(list.processNode==4){
                html += '<td style="width: 150px;text-align: center  ">申请人归还</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="申请人归还">';
            }else if(list.processNode==5){
                html += '<td style="width: 150px;text-align: center  ">信息中心确认</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="信息中心确认">';
            }

            html += '<td style="width: 150px  ">'+list.processUser.name+'<input style="display:none" value='+list.processUser.id+' name="approvalUser"></td>';
            html += '<td style="width: 150px  "><input type="text"  id="test1" style="text-align: center" ></td>';
            html += '<td style="width: 250px  "><input style="width: 180px;text-align: center;border: 1px solid " name="opinion"></td>';
            html += '<td style="width: 150px  "><select style="height: 27px" name="state"><option value="转交">通过</option><option value="转交">转交</option></select></td>';
            html += '</tr>';
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