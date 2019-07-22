/**
 * Created by Administrator on 2019/4/15.
 */



function w() {
    var  id=q("id");
    var url="/mc/borrow/particular.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var borrow=data.borrow;
            var list=data.list;
            var html="";
            // $.each(data,function (index,project) {
            html+='<input style="display: none" value='+data.id+' name="id">';
            html+='<table border="1">';
            html+='<tr style="height: 40px ;background-color: #efefef">';
            html+='<td colspan="4" style="text-align: center">';
            html+='<b>文件借用详情</b>';
            html+='</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td  class="Color" style="width:150px  ">';
            html+='<span>项目名称</span>';
            html+='</td>';
            html+='<td colspan="3" style="width:300px ;">'+borrow.project.abbreviation+ '</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color" style="width:150px ">';
            html+='<span>申请部门:</span>';
            html+='</td>';
            html+='<td style="width:300px ;" class="department-1">'+borrow.dept.name+'</td>';
            html+='<td class="Color" style="width:150px ">申请日期:</td>';
            html+='<td style="width:300px ;">'+borrow.createtime+'</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td  class="Color"  style="width:150px  ">申请人</td>';
            html+='<td >'+borrow.user.name+'</td>';
            html+='<td class="Color" style="width:150px  ">联系电话 </td>';
            html+='<td style="width:300px ;">'+borrow.phone+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color" style="width:150px  ">申请原件内容</td>';
            html+='<td colspan="3">'+borrow.content+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color" style="width:150px  ">原件借用用途</td>';
            html+='<td colspan="3">'+borrow.purpose+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color"  style="width:150px  " >收件人</td>';
            html+='<td >'+borrow.consignee+'</td>';
            html+='<td class="Color" style="width:150px  ">收件人电话</td>';
            html+='<td >'+borrow.consigneePhone+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color" style="width:150px  ">原件寄往地址</td>';
            html+='<td colspan="3">'+borrow.sendAddress+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color"  style="width:150px  ">快递公司（归还）</td>';
            html+='<td  >'+borrow.returnExpressageName+'</td>';
            html+='<td class="Color" style="width:150px  ">快递单号（归还）</td>';
            html+='<td >'+borrow.returnExpressageWaybill+'</td>';
            html+='</tr>';
            html+='<tr style="height: 40px ;background-color: #efefef">';
            html+='<td colspan="4" style="text-align: center">';
            html+='<span>(以下非申请人填写)</span>';
            html+='</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color" style="width:150px  ">原件名称</td>';
            html+='<td colspan="3">'+borrow.name+'</td>';

            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color"  style="width:150px  ">快递公司（寄出）</td>';
            html+='<td  >'+borrow.sendExpressageName+'</td>';
            html+='<td class="Color" style="width:150px  ">快递单号（寄出）</td>';
            html+='<td >'+borrow.sendExpressageWaybill+'</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td class="Color"  style="width:150px  ">原件寄出时间</td>';
            html+='<td colspan="3" >'+borrow.sendtime+'</td>';
            html+='</tr>';

            html+='<tr style="height:40px;">';
            html+='<td class="Color" style="width:150px  ">原件归还时间</td>';
            html+='<td style="width:300px ;" colspan="3">'+borrow.returntime+'</td>';
            html+='</tr>';

            html += ' <table class="approval " style="width: 900px ">';
            html += '<tr style="height: 40px;width:900px  " >';
            html += '<td colspan="6" style="text-align: center;width: 900px ">';
            html += '<b>审批流程2222222222222</b>';
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
            html += '<input style="display:none" value='+borrow.id+'>';
            if(borrow.processNode==1){
                html += '<input style="display:none" value="商务部审核">';
            }else if(borrow.processNode==2){
                html += '<input style="display:none" value="分公司总经理审准">';
            }else if(borrow.processNode==3){
                html += '<input style="display:none" value="信息中心复核">';
            }else if(borrow.processNode==4){
                html += '<input style="display:none" value="申请人归还">';
            }else if(borrow.processNode==5){
                html += '<input style="display:none" value="信息中心确认">';
            }

            html += '</td>';

            html += '<td style="width: 50px  ">' ;
            html +=  '<select style="height: 27px">';
            html += '<option>请选择</option>';
            html += '<option>商务部审核</option>';
            html += '<option>分公司总经理审准</option>';
            html += '<option>信息中心复核</option>';
            html += '<option>申请人归还</option>';
            html += '<option>信息中心确认</option>';
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