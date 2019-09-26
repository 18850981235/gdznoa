/**
 * Created by Administrator on 2019/5/30.
 */




function w() {
    var  id=q("id");
    var url="/mc/performanceDate/querybyid?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {

            var html="";
            html+='<input style="display: none" value='+data.id+'  >';
          html+='<table border="1">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>业绩资料修改</b>';

              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>项目名称</span>';
              html+='</td>';
              html+='<td colspan="3" style="width:300px ;">';
              html+='<input style="width: 700px " name="name" value='+data.project.name+'  name="project_id"  required>';
              html+='</td>';
              html+='</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">中标通知书</td>';
              html+='<td style="width:300px ;">';
              html+='<input type="file"  style="width: 170px ;display: inline-block" value='+data.biddingNotice+' name="biddingNotice">';
              html+='<input type="text"  placeholder="请选择日期" id="test1" style="width: 80px;display: inline-block " value='+data.biddingTime+' name="biddingTime" >';
              html+='</td>';
              html+='<td style="width:150px ;background-color: #efefef;">业绩合同</td>';
              html+='<td >';
              html+='<input type="file"  style="width: 170px ;display: inline-block" value='+data.performanceContract+' name="performanceContract">';
              html+='<input type="text"  placeholder="请选择日期" id="test2" style="width: 80px;display: inline-block " value='+data.signingTime+' name="signingTime">';
              html+='</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">验收报告</td>';
              html+='<td style="width:300px ;">';
              html+='<input type="file"  style="width: 170px ;display: inline-block"  name="acceptanceReport"  value='+data.acceptanceReport+'>';
              html+='<input type="text"  placeholder="请选择日期" id="test3" style="width: 80px;display: inline-block "   name="acceptanceTime" value='+data.acceptanceTime+'>';
              html+='</td>';
              html+='<td style="width:150px ;background-color: #efefef;">维保证明</td>';
              html+='<td >';
              html+='<input type="file"  style="width: 170px ;display: inline-block" value='+data.maintenanceProof+' name="maintenanceProof">';
              html+='<input type="text"  placeholder="请选择日期" id="test4" style="width: 80px;display: inline-block " value='+data.maintenanceTime+' name="maintenanceTime">';
              html+='</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">中标公示网址</td>';
              html+='<td style="width:300px ;">';
              html+='<input    style="width: 270px ;display: inline-block" value='+data.publicAddress+' name="publicAddress">';
              html+='</td>';
              html+='<td style="width:150px ;background-color: #efefef;">中标公示截图</td>';
              html+='<td >';
              html+='<input type="file"  style="width: 270px ;display: inline-block" value='+data.publicPicture+' name="publicPicture">';
              html+='</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">资料借用情况</td>';
              html+='<td  style="width:300px ;">';
              html+='<input    style="width: 270px ;display: inline-block" value='+data.borrowStada+' name="borrowStada">';
              html+='</td>';
            html+=' <td style="width:150px;background-color: #efefef">PDF导出</td>';
            html+='<td  style="width:300px ;">';
            html+='<input type="file"   style="width: 270px ;display: inline-block" name="pdfOut" value='+data.pdfOut+'>';
            html+='</td>';

             html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td     style="width:150px;background-color: #efefef  ">年审负责人</td>';
              html+='<td >';
              html+='<input  required class="Eliminate" readonly value='+data.user.name+'>';
                html+='<input style="display: none" class="Eliminate-no" name="managerId" value='+data.user.id+'>';
              html+='<a target="_blank " class="add-to">添加</a>';
              html+='<a class="clear-to" >';
              html+='<input value="清空" class="input"  onClick="" type="button">';
              html+='</a>';
              html+='</td>';
              html+='<td style="width:150px ;background-color: #efefef;">资料归档时间</td>';
              html+='<td >';

              html+='<input type="text"  placeholder="请选择日期" id="test5" style="width: 80px;display: inline-block " value='+data.filingTime+' name="filingTime">';
              html+='</td>';
              html+='</tr>';
              html+='</table>';
            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
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