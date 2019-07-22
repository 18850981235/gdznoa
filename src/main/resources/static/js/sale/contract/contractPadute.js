
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/sd/SdSalesContract/getContractbyid?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {

            var html="";
            html +=' <input style="display: none" value='+data.id+' name="id">';
            html+='<table border="1">';
            html+='<tr style="height: 40px ;background-color: #efefef">';
            html+='<td colspan="4" style="text-align: center"><b>销售合同修改</b></td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;"><span>项目名称</span></td>';
            html+='<td  style="width:300px ;">';
            html+='<select id="ap" style="height: 30px " name="projectid">';
            html+='<option value='+data.project.id+'>'+data.project.name+'</option>';
            html+='</select>';
            html+='</td>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;"><span>客户名称</span></td>';
            html+='<td  style="width:300px ;">';
            html+='<input style="width: 250px " value='+data.project.client.name+' >';
            html+='<input style="display: none" name="clientid " value='+data.project.client.id+'>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">项目编号</td>';
            html+='<td style="width:300px ;">';
            html+='<input  style="width: 250px ;display: inline-block" name="projectcode" value='+data.project.code+'>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">合同编号</td>';
            html+='<td >';
            html+='<input   style="width: 250px ;display: inline-block" name="code" value='+data.code+'>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">所属机构</td>';
            html+='<td style="width:300px ;">';
            html+='<input style="width: 250px ;" value='+data.dept.name+'>';
            html+='<input   style="width: 250px ;display: none" name="deptid" value='+data.dept.id+'>';

            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">业务负责人</td>';
            html+='<td >';
            html+='<input style="width: 250px ;" value='+data.project.principalUser.name+'>';
            html+='<input   style="width: 250px ;display: none" name="principal" value='+data.project.principalUser.id+'>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">分公司负责人</td>';
            html+='<td style="width:300px ;">';
            html+='<input style="width: 250px ;" value='+data.project.branchuser.mame+'>';
            html+='<input  style="width:250px ;display: none" name="branchuser" value='+data.project.branchuser.id+'>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">区域负责人</td>';
            html+='<td >';
            html+='<input style="width: 250px ;" value='+data.project.areaManagerUser.name+'>';
            html+='<input   style="width: 250px ;display: none" name="areaManager" value='+data.project.areaManagerUser.id+'>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">税务发票类型</td>';
            html+='<td style="width:300px ;">';
            html+='<select style="height: 30px " name="invoiceType">';
            html+='<option>'+data.invoiceType+'</option>';
            html+='<option>普通发票</option>';
            html+='<option>专业发票</option>';
            html+='</select>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">合同金额</td>';
            html+='<td >';
            html+='<input   style="width: 170px ;display: inline-block" name="contractAmount" value='+data.contractAmount+'>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">增加金额</td>';
            html+='<td style="width:300px ;">';
            html+='<input name="addAmount" value='+data.addAmount+'>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">增加清单</td>';
            html+='<td >';
            html+='<select style="height: 30px " name="addList"></select>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">减少金额</td>';
            html+='<td style="width:300px ;">';
            html+='<input name="reductionAmount" value='+data.reductionAmount+'>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">减少清单</td>';
            html+='<td >';
            html+='<select style="height:30px" name="reductionList"></select>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">管理费费率</td>';
            html+='<td style="width:300px ;">';
            html+='<input name="managementRate" value='+data.managementRate+'>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">中标时间</td>';
            html+='<td >';
            html+='<input type="text"  placeholder="请选择日期" id="test1" name="bidiingTime" value='+data.bidiingTime+'>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">附件</td>';
            html+='<td colspan="3" style="width:300px ;">';
            html+='<input type="file" name="file" value='+data.accessory+'>';
            html+='</td>';
            html+='</tr>';
            html+='</table>';





            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
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
