/**
 * Created by Administrator on 2019/9/11.
 */
/**
 * Created by Administrator on 2019/8/5.
 */
function w() {
    var  id=q("id");
    var url="/ga//harvestTicket/particular.html?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (date) {
            var data=date.gaHarvestTicket;
            var html="";


            html += ' <table border="1" style="width: 1000px ">';
            html += ' <tr style="height: 40px ;background-color: #efefef">';
            html += ' <td colspan="4" style="text-align: center"> <b>合约</b> </td> </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">项目名称</td>';
            html += ' <td   style="width:300px ;">'+data.project.name+'</td>';
            html += ' <td style="width:150px ;;background-color: #efefef">类型</td>';
            html += ' <td  style="width:300px ;">'+data.type+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">事由</td>';
            html += ' <td colspan="3"  style="width:300px ;">'+data.companyName+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">开票名称</td>';
            html += ' <td    style="width:300px ;">'+data.name+'</td>';
            html += ' <td style="width:150px ;;background-color: #efefef">开票时间</td>';
            html += ' <td  style="width:300px ;">'+data.createtime+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">领款单位</td>';
            html += ' <td  style="width:300px ;">'+data.accountname+'</td>';
            html += ' <td style="width:150px ;;background-color: #efefef">申请人</td>';
            html += ' <td  style="width:300px ;">'+data.user.name+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">金额</td>';
            html += ' <td  style="width:300px ;">'+data.cost+'</td>';
            html += ' <td style="width:150px ;;background-color: #efefef">电话</td>';
            html += ' <td  style="width:300px ;">'+data.phone+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">纳税人识别号</td>';
            html += ' <td  colspan="3" style="width:300px ;">'+data.identifyNumber+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px;background-color: #efefef">开票说明</td>';
            html += ' <td colspan="3"  style="width:300px ;">'+data.content+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">开户行</td>';
            html += ' <td  style="width:300px ;">'+data.bankname+'</td>';
            html += ' <td style="width:150px ;background-color: #efefef">账户 </td>';
            html += ' <td style="width:300px ;">'+data.bankaccount+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">支付账户</td>';
            html += ' <td  style="width:300px ;">'+data.payaccount+'</td>';
            html += ' <td style="width:150px ;background-color: #efefef">收款账户信息</td>';
            html += ' <td style="width:300px ;">'+data.proceedsaccount+'</td>';
            html += ' </tr>';
            html += ' <tr style="height:40px;">';
            html += ' <td style="width:150px ;;background-color: #efefef">发票上传</td>';
            if(data.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.accessory.split(","); //字符分割
                html += '<td colspan="3" style="width: 600px " >';
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

            html += ' </tr>';
            html += ' </table>';

            html += ' <table class="approval " style="width: 1000px ">';
            html += '<tr style="height: 40px;width:1000px  " >';
            html += '<td colspan="6" style="text-align: center;width: 900px ">';
            html += '<b>审批流程</b>';
            // html += '<a style="float: right;color: red">'+project.processState+'</a>';
            html += '</td>';
            html += '</tr>';
            html += '<tr style="text-align: center;background-color: #0099ff;width:1000px ;height: 40px ">';
            html += '<td style="width: 20px  ">序号</td>';
            html += '<td style="width: 50px  ">审批部门</td>';
            html += '<td style="width: 50px  ">审批人员</td>';
            html += '<td style="width: 50px  ">审批时间</td>';
            html += '<td style="width: 200px  ">审批意见</td>';
            html += '<td style="width: 50px  ">审核状态</td>';
            html += '</tr>';
            $.each(date.list, function (index, list) {
                html += '<tr style="text-align: center;width:1000px ;height: 40px">';
                html += '<td style="width: 20px  ">' + (index+1) + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 50px  ">' + list.user.name + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalDate +'</td>';
                html += '<td style="width: 200px  ">' + list.opinion + '</td>';
                html += '<td style="width: 50px  ">' + list.state + '</td>';
                html += '</tr>';
            })

            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 20px  "><input style="text-align: center;border: 1px solid">';
            html += '<input style="display:none" value='+date.list.id+'>';
            html += '<input style="display:none" value='+data.companyName+'>';
            if(date.list.processNode==1){
                html += '<input style="display:none" value="商务部审核">';
            }else if(date.list.processNode==2){
                html += '<input style="display:none" value="分公司总经理审准">';
            }else if(date.list.processNode==3){
                html += '<input style="display:none" value="公司分管领导审批">';
            }else if(date.list.processNode==4){
                html += '<input style="display:none" value="公司领导批准">';
            }else if(date.list.processNode==5){
                html += '<input style="display:none" value="经办人办理">';
            }

            html += '</td>';

            html += '<td style="width: 50px  ">' ;
            html +=  '<select style="height: 27px">';
            html += '<option>请选择</option>';
            html += '<option>商务部审核</option>';
            html += '<option>分公司总经理审准</option>';
            html += '<option>公司分管领导审批</option>';
            html += '<option>公司领导批准</option>';
            html += '<option>经办人办理</option>';
            html += '</select>';
            html += '</td>';
            html += '<td style="width: 50px"><input style="text-align:center;border: 1px solid"></td>';
            html += '<td style="width: 50px"><input type="text"  id="test1" style="text-align: center"></td>';
            html += '<td style="width: 200px"><input style="width: 180px;text-align: center;border: 1px solid "></td>';
            html += '<td style="width: 50px"><select style="height: 27px"><option>通过</option><option>转交</option></select></td>';
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


