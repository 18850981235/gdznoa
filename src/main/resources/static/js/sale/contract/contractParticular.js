
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/sd/SdSalesContract/querydetailsbyid?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (obj) {
            var data=obj.SdSalesContract;
            var SysApprovalDetailed=data.SysApprovalDetailed;
            var html="";

         html += ' <table border="1">';
             html += '<tr style="height: 40px ;background-color: #efefef">';
             html += '<td colspan="4" style="text-align: center">';
             html += '<b>销售合同新增</b>';
            html += '<input style="display:none;" name="id">';
             html += '</td>';
             html += '</tr>';
             html += '<tr style="height:40px;">';
             html += '<td style="width:150px ;background-color: #efefef;">';
             html += '<span>项目名称</span>';
             html += '</td>';
             html += '<td  style="width:300px ;">'+data.project.name+'</td>';
             html += '<td style="width:150px ;background-color: #efefef;">';
             html += '<span>客户名称</span>';
             html += '</td>';
             html += '<td style="width:300px;">'+data.project.client.name+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">项目编号</td>';
             html += '<td style="width:300px ;">'+data.project.code+'</td>';
            html += ' <td style="width:150px ;background-color: #efefef;">合同编号</td>';
             html += '<td >'+data.code+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">所属机构</td>';
             html += '<td style="width:300px ; ">'+data.dept.name+'</td>';
             html += '<td style="width:150px ;background-color: #efefef;">业务负责人</td>';
             html += '<td >'+data.principalUser.name+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">分公司负责人</td>';
             html += '<td style="width:300px ;">'+data.branchUseruser.name+'</td>';
             html += '<td style="width:150px ;background-color: #efefef;">区域负责人</td>';
             html += '<td >'+data.areaManagerUser.name+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">税务发票类型</td>';
             html += '<td style="width:300px ;">'+data.invoiceType+'</td>';
             html += '<td style="width:150px ;background-color: #efefef;">合同金额</td>';
             html += '<td >'+data.contractAmount+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">增加金额</td>';
             html += '<td style="width:300px ;">'+data.addAmount+'</td>';
             html += '<td style="width:150px ;background-color: #efefef;">增加清单</td>';
             html += '<td>'+data.addList+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">减少金额</td>';
             html += '<td style="width:300px ;">'+data.reductionAmount+'</td>';
             html += '<td style="width:150px ;background-color: #efefef;">减少清单</td>';
             html += '<td >'+data.reductionList+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">管理费费率</td>';
             html += '<td style="width:300px ;">'+data.managementRate+'</td>';
             html += '<td style="width:150px ;background-color: #efefef;">中标时间</td>';
             html += '<td >'+data.bidiingTime+'</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;;background-color: #efefef">附件</td>';
            if(data.accessory==undefined||data.accessory==null||data.accessory==""){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.accessory.split(","); //字符分割
                html += '<td colspan="3" style="width: 600px " >'
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
             // html += '<td colspan="3" style="width:300px ;"></td>';
             html += '</tr>';
            html += '</table>';



            html += ' <table class="approval " style="width: 900px ">';
            html += '<tr style="height: 40px;width:900px" >';
            html += '<td colspan="6" style="text-align:center;width:900px">';
            html += '<b>审批流程</b>';
            // html += '<a style="float: right;color: red">'+project.processState+'</a>';
            html += '</td>';
            html += '</tr>';
            html += '<tr style="text-align:center;background-color: #0099ff;width:900px ;height: 40px ">';
            html += '<td style="width:20px">序号</td>';
            html += '<td style="width:50px">审批部门</td>';
            html += '<td style="width:50px">审批人员</td>';
            html += '<td style="width:50px">审批时间</td>';
            html += '<td style="width:200px">审批意见</td>';
            html += '<td style="width:50px">审核状态</td>';
            html += '</tr>';
            $.each(SysApprovalDetailed, function (index, list) {
                html += '<tr style="text-align: center;width:900px ;height: 40px">';
                html += '<td style="width: 20px  ">' + (index+1) + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 50px  ">' + list.user.name+'</td>';
                html += '<td style="width: 50px  ">' + list.approvalDate + '</td>';
                html += '<td style="width: 200px  ">' + list.opinion + '</td>';
                html += '<td style="width: 50px  ">' + list.state + '</td>';
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
