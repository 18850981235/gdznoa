/**
 * Created by Administrator on 2019/8/6.
 */
function w() {
    var  id=q("id");
    var url="/ed/EdMassageStaff/QueryOneMassageStaff?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data){
            // var data=obj.edMessage
            // var list=obj.list
            var html="";
          html += ' <table border="1" style="width: 1000px ">';
              html += ' <tr style="height: 40px ;background-color: #efefef">';
              html += ' <td colspan="4" style="text-align: center"><b>施工人员详情</b></td> </tr>';
              html += ' <tr style="height:40px;">';
              html += ' <td style="width:150px;background-color: #efefef">项目名称</td>';
              html += ' <td colspan="3" style="width:300px ;">'+data.project.name+'</td> </tr>';
              html += ' <tr style="height:40px;">';
              html += ' <td style="width:150px ;background-color: #efefef">姓名</td>';
              html += ' <td style="width:300px ;">'+data.name+'</td>';
              html += ' <td style="width:150px ;background-color: #efefef">联系电话</td>';
              html += ' <td style="width:300px ;">'+data.phone+'</td> </tr>';
              html += ' <tr style="height:40px;">';

              html += ' <td style="width:150px ;;background-color: #efefef">工作考勤时间</td>';
              html += ' <td  style="width:300px ;">'+data.attendanceTime+'</td>';
              html += ' <td style="width:150px ;background-color: #efefef">人员岗位</td>';
              html += ' <td  style="width:300px ;">'+data.staffRole+'</td> </tr>';
              html += ' <tr style="height:40px;">';
              html += ' <td style="width:150px ;;background-color: #efefef">身份证</td>';
            if(data.idfile==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.idfile.split(","); //字符分割
                html += '<td  style="width: 300px " >';
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" style="width: 300px ;display: inline-block">';
                        html += '<input name="file" style="width:200px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
              html += ' <td style="width:150px ;;background-color: #efefef">身份证号码</td>';
              html += ' <td  style="width:300px ;">'+data.identityCard+'</td> </tr>';
              html += ' <tr style="height:40px;">';
              html += ' <td style="width:150px ;background-color: #efefef">合约情况</td>';
            if(data.contractsfile==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.contractsfile.split(","); //字符分割
                html += '<td  style="width: 300px " >';
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" style="width: 300px ;display: inline-block">';
                        html += '<input name="file" style="width:200px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
              html += ' <td style="width:150px ;background-color: #efefef">医社保情况</td>';
            if(data.securityfile==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.securityfile.split(","); //字符分割
                html += '<td  style="width: 300px " >';
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" style="width: 300px ;display: inline-block">';
                        html += '<input name="file" style="width:200px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
              html += ' </tr>';
              html += ' <tr style="height:40px;">';
              html += ' <td style="width:150px ;;background-color: #efefef">意外险购买</td>';
            if(data.buyfile==undefined){
                html += '<td  >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=data.buyfile.split(","); //字符分割
                html += '<td  style="width: 300px " >';
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" style="width: 300px ;display: inline-block">';
                        html += '<input name="file" style="width:200px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
              html += ' <td style="width:150px ;;background-color: #efefef">意外险购买情况</td>';
              html += ' <td  style="width:300px ;">'+data.buyState+'</td> </tr>';
              html += ' <tr style="height:40px;">';
              html += ' <td style="width:150px ;;background-color: #efefef">管理负责人</td>';
              html += ' <td  style="width:300px ;">'+data.chargeer+'</td>';
              html += ' <td style="width:150px ;background-color: #efefef">备注</td>';
              html += ' <td  style="width:300px ;">'+data.remarks+'</td></tr>';

          html += ' </table>';

            html += ' <table class="approval " style="width: 1000px ">';
            html += '<tr style="height: 40px;width:1000px  " >';
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
            $.each(data.list, function (index, list) {
                html += '<tr style="text-align: center;width:900px ;height: 40px">';
                html += '<td style="width: 20px  ">' + (index+1) + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 50px  ">' + list.user.name + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalDate + '' +
                    '</td>';
                html += '<td style="width: 200px  ">' + list.opinion + '</td>';
                html += '<td style="width: 50px  ">' + list.state + '</td>';
                html += '</tr>';
            })
            html += '</table>';
            var id=$("#ap").val()
            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
}
// w();
$(document).ready(function () {
    w();
    var id=$("#ap").val()
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/sd/SdSalesContract/getProject",
        success:function (data) {
            $.each(data,function (index,obj) {
                if(obj.id==id){


                    $("#center input").eq(1).val(obj.name)
                    $("#center input").eq(2).val(obj.dept.name)
                    $("#center input").eq(3).val(obj.site)
                }

            })
        }
    });

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