/**
 * Created by Administrator on 2019/8/19.
 */
function w() {
    var  id=q("id");
    var url="/ga/comego/particular.html?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (date) {
            var html="";
            var data=date.gaComeGo;
            // var oa=date.personnelDispatched;
            var list=date.list;

          html += '<table border="1" style="width: 1000px ">';
              html += '<tr style="height: 40px ;background-color: #efefef">';
              html += '<td colspan="4" style="text-align: center">';
              html += '<b>支出付款详情</b>';
              html += '</td>';
              html += '</tr>';
              html += '<tr style="height:40px;">';
              html += '<td style="width:150px ;;background-color: #efefef">项目名称</td>';
              html += '<td    style="width:300px ;">'+data.project.abbreviation+'</td>';
              html += '<td style="width:150px ;;background-color: #efefef">事由</td>';
              html += '<td  style="width:300px ;">'+data.matter+'</td>';
          html += '</tr>';
          html += '<tr style="height:40px;">';
              html += '<td style="width:150px ;;background-color: #efefef">领款单位</td>';
              html += '<td  style="width:300px ;">'+data.unit+'</td>';
              html += '<td style="width:150px ;;background-color: #efefef">申请人</td>';
              html += '<td  style="width:300px ;">'+data.user.name+'</td> ';
              html += '</tr>';
              html += '<tr style="height:40px;">';
              html += '<td style="width:150px ;;background-color: #efefef">金额</td>';
              html += '<td  style="width:300px ;">'+data.paymentMoney+'</td>';
              html += '<td style="width:150px ;;background-color: #efefef">付款方式</td>';
              html += '<td  style="width:300px ;">'+data.type+'</select>';
              html += '</td> </tr>';
              html += '<tr style="height:40px;">';
              html += '<td style="width:150px;background-color: #efefef">摘要</td>';
              html += '<td colspan="3"  style="width:300px ;">'+data.digest+'</td> </tr>';
              html += '<tr style="height:40px;">';
              html += '<td style="width:150px ;;background-color: #efefef">开户行</td>';
              html += '<td  style="width:300px ;">'+data.bankname+'</td>';
              html += '<td style="width:150px ;background-color: #efefef">账户 </td>';
              html += '<td style="width:300px ;">'+data.bankaccount+'</td>';
              html += '</tr>';
              html += '</table>';
         

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
            $.each(list, function (index, list) {
                html += '<tr style="text-align: center;width:1000px ;height: 40px">';
                html += '<td style="width: 100px  ">' + (index+1) + '</td>';
                html += '<td style="width: 150px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 150px  ">' + list.user.name + '</td>';
                html += '<td style="width: 150px  ">' + list.approvalDate + '' +
                    '</td>';
                html += '<td style="width: 300px  ">' + list.opinion + '</td>';
                html += '<td style="width: 150px  ">' + list.state + '</td>';
                html += '</tr>';
            })
            html += '</table>';

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