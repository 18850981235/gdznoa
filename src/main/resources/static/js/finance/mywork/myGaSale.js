/**
 * Created by Administrator on 2019/9/11.
 */
/**
 * Created by Administrator on 2019/8/12.
 */
/**
 * Created by Administrator on 2019/8/12.
 */
/**
 * Created by Administrator on 2019/8/19.
 */
function w() {

    var  id=q("id");
    var url="/ga/payment/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (date) {
            var data=date.gaPayment;
            var html="";
            if(data.matter=="采购付款"){
                html+='<table border="1" style="width: 1000px ">';
                html+='<tr style="height: 40px ;background-color: #efefef">';
                html+='<td colspan="4" style="text-align: center"> <b>支出项</b></td> </tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">合同名称</td>';
                html+='<td   style="width:300px ;">'+data.pdProcurementContract.project.name+'</td>';
                html+='<td style="width:150px ;;background-color: #efefef">事由</td>';
                html+='<td   style="width:300px ;">'+data.matter+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">合同金额</td>';
                html+='<td  style="width:300px ;">'+data.pdProcurementContract.total+'</td>';
                html+='<td style="width:150px ;;background-color: #efefef">付款方式</td>';
                html+='<td  style="width:300px ;">'+data.type+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">申请时间</td>';
                html+='<td  style="width:300px ;">'+data.createtime+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">申请人 </td>';
                html+='<td style="width:300px ;">'+data.user.name+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">应付金额</td>';
                html+='<td  colspan="3" style="width:300px ;">'+data.paymentMoney+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">已付金额</td>';
                html+='<td  style="width:300px ;">'+data.paid+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">未支付金额</td>';
                html+='<td style="width:300px ;">'+(data.pdProcurementContract.total-data.paid)+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">已开发票金额</td>';
                html+='<td  style="width:300px ;">'+data.ticket+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">未开发票金额</td>';
                html+='<td style="width:300px ;">'+(data.pdProcurementContract.total-data.ticket)+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">领款单位</td>';
                html+='<td  style="width:300px ;">'+data.unit+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">摘要</td>';
                html+='<td style="width:300px ;">'+data.digest+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">开户行</td>';
                html+='<td  style="width:300px ;">'+data.bankname+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">开户账户</td>';
                html+='<td style="width:300px ;">'+data.bankaccount+'</td> </tr>';
                html+='</table>';
            }else  if(data.matter=="劳务费付款"){
                html+='<table border="1" style="width: 1000px ">';
                html+='<tr style="height: 40px ;background-color: #efefef">';
                html+='<td colspan="4" style="text-align: center"> <b>支出项</b></td> </tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">合同名称</td>';
                html+='<td   style="width:300px ;">'+data.serviceContract.project.name+'</td>';
                html+='<td style="width:150px ;;background-color: #efefef">事由</td>';
                html+='<td   style="width:300px ;">'+data.matter+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">合同金额</td>';
                html+='<td  style="width:300px ;">'+data.serviceContract.total+'</td>';
                html+='<td style="width:150px ;;background-color: #efefef">付款方式</td>';
                html+='<td  style="width:300px ;">'+data.type+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">申请时间</td>';
                html+='<td  style="width:300px ;">'+data.createtime+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">申请人 </td>';
                html+='<td style="width:300px ;">'+data.user.name+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">应付金额</td>';
                html+='<td  colspan="3" style="width:300px ;">'+data.paymentMoney+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">已付金额</td>';
                html+='<td  style="width:300px ;">'+data.paid+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">未支付金额</td>';
                html+='<td style="width:300px ;">'+(data.serviceContract.total-data.paid)+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">已开发票金额</td>';
                html+='<td  style="width:300px ;">'+data.ticket+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">未开发票金额</td>';
                html+='<td style="width:300px ;">'+(data.serviceContract.total-data.ticket)+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">领款单位</td>';
                html+='<td  style="width:300px ;">'+data.unit+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">摘要</td>';
                html+='<td style="width:300px ;">'+data.digest+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">开户行</td>';
                html+='<td  style="width:300px ;">'+data.bankname+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">开户账户</td>';
                html+='<td style="width:300px ;">'+data.bankaccount+'</td> </tr>';
                html+='</table>';
            }else  if(data.matter=="中标服务费"){
                html+='<table border="1" style="width: 1000px ">';
                html+='<tr style="height: 40px ;background-color: #efefef">';
                html+='<td colspan="4" style="text-align: center"> <b>支出项</b></td> </tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">合同名称</td>';
                html+='<td   style="width:300px ;">'+data.salesContract.project.name+'</td>';
                html+='<td style="width:150px ;;background-color: #efefef">事由</td>';
                html+='<td   style="width:300px ;">'+data.matter+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">合同金额</td>';
                html+='<td  style="width:300px ;">'+data.salesContract.total+'</td>';
                html+='<td style="width:150px ;;background-color: #efefef">付款方式</td>';
                html+='<td  style="width:300px ;">'+data.type+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">申请时间</td>';
                html+='<td  style="width:300px ;">'+data.createtime+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">申请人 </td>';
                html+='<td style="width:300px ;">'+data.user.name+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">应付金额</td>';
                html+='<td  colspan="3" style="width:300px ;">'+data.paymentMoney+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">已付金额</td>';
                html+='<td  style="width:300px ;">'+data.paid+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">未支付金额</td>';
                html+='<td style="width:300px ;">'+(data.salesContract.total-data.paid)+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">已开发票金额</td>';
                html+='<td  style="width:300px ;">'+data.ticket+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">未开发票金额</td>';
                html+='<td style="width:300px ;">'+(data.salesContract.total-data.ticket)+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">领款单位</td>';
                html+='<td  style="width:300px ;">'+data.unit+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">摘要</td>';
                html+='<td style="width:300px ;">'+data.digest+'</td>';
                html+='</tr>';
                html+='<tr style="height:40px;">';
                html+='<td style="width:150px ;;background-color: #efefef">开户行</td>';
                html+='<td  style="width:300px ;">'+data.bankname+'</td>';
                html+='<td style="width:150px ;background-color: #efefef">开户账户</td>';
                html+='<td style="width:300px ;">'+data.bankaccount+'</td> </tr>';
                html+='</table>';
            }

            html += ' <table class="approval " style="width: 1000px ">';
            html += '<tr style="height: 40px;width:1000px  " >';
            html += '<td colspan="6" style="text-align: center;width: 1000px ">';
            html += '<b>审批流程</b>';
            // html += '<a style="float: right;color: red">'+project.processState+'</a>';
            html += '</td>';
            html += '</tr>';
            html += '<tr style="text-align: center;background-color: #0099ff;width:1000px ;height: 40px ">';
            html += '<td style="width: 100px  ">序号</td>';
            html += '<td style="width: 150px  ">审批部门</td>';
            html += '<td style="width: 150px  ">审批人员</td>';
            html += '<td style="width: 150px  ">审批时间</td>';
            html += '<td style="width: 300px  ">审批意见</td>';
            html += '<td style="width: 150px  ">审核状态</td>';
            html += '</tr>';
            $.each(date.list, function (index, lists) {
                html += '<tr style="text-align: center;width:1000px ;height: 40px">';
                html += '<td style="width: 100px  ">' + (index+1) + '</td>';
                html += '<td style="width: 150px  ">' + lists.approvalIdentity + '</td>';
                html += '<td style="width: 150px  ">' + lists.user.name + '</td>';
                html += '<td style="width: 150px  ">' + lists.approvalDate + '</td>';
                html += '<td style="width: 300px  ">' + lists.opinion + '</td>';
                html += '<td style="width: 150px  ">' + lists.state + '</td>';
                html += '</tr>';
            })

            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 20px  "><input style="text-align: center;border: 1px solid">';
            html += '<input style="display:none" value='+date.list.id+'>';
            html += '<input style="display:none" value='+data.matter+'>';
            if(date.list.processNode==1){
                html += '<input style="display:none" value="公司分管领导审批">';
            }else if(date.list.processNode==2){
                html += '<input style="display:none" value="财务经办">';
            }else if(date.list.processNode==3){
                html += '<input style="display:none" value="财务主管">';
            }else if(date.list.processNode==4){
                html += '<input style="display:none" value="分管领导">';
            }else if(date.list.processNode==5){
                html += '<input style="display:none" value="主管领导">';
            }

            html += '</td>';

            html += '<td style="width: 50px  ">' ;
            html +=  '<select style="height: 27px">';
            html += '<option>请选择</option>';
            html += '<option>公司分管领导审批</option>';
            html += '<option>财务经办</option>';
            html += '<option>财务主管</option>';
            html += '<option>分管领导</option>';
            html += '<option>主管领导</option>';
            html += '</select>';
            html += '</td>';
            html += '<td style="width: 50px  "><input style="text-align:center;border: 1px solid"></td>';
            html += '<td style="width: 50px  "><input type="text"  id="test1" style="text-align: center"></td>';
            html += '<td style="width: 200px  "><input style="width: 180px;text-align: center;border: 1px solid "></td>';
            html += '<td style="width: 50px  "><select style="height: 27px"><option>通过</option><option>转交</option></select></td>';
            html += '</tr>';
            html += '</table>';

            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容


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