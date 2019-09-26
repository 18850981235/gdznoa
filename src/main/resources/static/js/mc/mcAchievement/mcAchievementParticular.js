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
            html+='<b>业绩资料详情</b>';

            html+='</td>';
            html+='</tr>';
            html+='<tr style="height:40px;">';
            html+='<td style="width:150px ;background-color: #efefef;">';
            html+='<span>项目名称</span>';
            html+='</td>';
            html+='<td colspan="3" style="width:300px ;">'+data.project.name+'</td>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">中标通知书</td>';
            if(data.biddingNotice==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.biddingNotice.split(","); //字符分割
                html += '<td  >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form style="width: 170px ;display: inline-block" action="/util/fileDown" >';
                        html += '<input name="file" style="width:100px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;width:70px ;"  type="submit" value="点击下载">';
                        html += ' </form>';
                        html+='<span  style="width: 80px;display: inline-block "   >'+data.biddingTime+'</span>';
                    }
                }
                html +='</td>';
            }
            // html+='<td style="width:300px ;">';
            // html+='<span    style="width: 170px ;display: inline-block"  >'+data.biddingNotice+'</span>';
            // html+='<span  style="width: 80px;display: inline-block "   >'+data.biddingTime+'</span>';
            // html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">业绩合同</td>';
            if(data.performanceContract==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.performanceContract.split(","); //字符分割
                html += '<td  >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form style="width: 170px;display: inline-block " action="/util/fileDown" >';
                        html += '<input name="file" style="width:100px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;width:70px ;"  type="submit" value="点击下载">';
                        html += ' </form>';
                        html+='<span  style="width: 80px;display: inline-block "   >'+data.signingTime+'</span>';
                    }
                }
                html +='</td>';
            }
            // html+='<td >';
            // html+='<span  style="width: 170px ;display: inline-block" >'+data.performanceContract+'</span>';
            // html+='<span   style="width: 80px;display: inline-block "  >'+data.signingTime+'</span>';
            // html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">验收报告</td>';
            if(data.acceptanceReport==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.acceptanceReport.split(","); //字符分割
                html += '<td  >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form style="width: 170px;display: inline-block " action="/util/fileDown" >';
                        html += '<input name="file" style="width:100px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;width:70px ;"  type="submit" value="点击下载">';
                        html += ' </form>';
                        html+='<span  style="width: 80px;display: inline-block "   >'+data.acceptanceTime+'</span>';
                    }
                }
                html +='</td>';
            }
            // html+='<td style="width:300px ;">';
            // html+='<span   style="width: 170px ;display: inline-block"  >'+data.acceptanceReport+'</span>';
            // html+='<span t  style="width: 80px;display: inline-block "  >'+data.acceptanceTime+'</span>';
            // html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">维保证明</td>';
            if(data.maintenanceProof==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.maintenanceProof.split(","); //字符分割
                html += '<td  >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form style="width: 170px;display: inline-block " action="/util/fileDown" >';
                        html += '<input name="file" style="width:100px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;width:70px ;"  type="submit" value="点击下载">';
                        html += ' </form>';
                        html+='<span  style="width: 80px;display: inline-block "   >'+data.maintenanceTime+'</span>';
                    }
                }
                html +='</td>';
            }
            // html+='<td >';
            // html+='<span   style="width: 170px ;display: inline-block"  >'+data.maintenanceProof+'</span>';
            // html+='<span  style="width: 80px;display: inline-block "  >'+data.maintenanceTime+'</span>';
            // html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">中标公示网址</td>';
            html+='<td style="width:300px ;">';
            html+='<span    style="width: 270px ;display: inline-block"  >'+data.publicAddress+'</span>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">中标公示截图</td>';
            html+='<td >';
            html+='<span    style="width: 270px ;display: inline-block"  >'+data.publicPicture+'</span>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td style="width:150px ;;background-color: #efefef">资料借用情况</td>';
            html+='<td   style="width:300px ;">';
            html+='<span    style="width: 270px ;display: inline-block"  >'+data.borrowStada+'</span>';
            html+='</td>';
            html+=' <td style="width:150px;background-color: #efefef">PDF导出</td>';
            html+='<td  style="width:300px ;">';
            html+='<input type="file"   style="width: 270px ;display: inline-block" name="pdfOut" value='+data.pdfOut+'>';
            html+='</td>';
            html+='</tr>';
            html+='<tr  style="height:40px;">';
            html+='<td     style="width:150px;background-color: #efefef  ">年审负责人</td>';
            html+='<td >';
            html+='<span>'+data.user.name+'</span>';

            html+='</a>';
            html+='</td>';
            html+='<td style="width:150px ;background-color: #efefef;">资料归档时间</td>';
            html+='<td >';

            html+='<span   placeholder="请选择日期"  style="width: 80px;display: inline-block " >'+data.filingTime+'</span>';
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