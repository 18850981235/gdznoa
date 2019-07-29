/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/stamp/particular.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // $.each(data,function (index,project) {
            var mcStamp=data.mcStamp;
            var list=data.list;
            // html+='<input style="display: none" value='+data.id+' name="id">';
            html += '<input style="display: none" value=' + mcStamp.id + ' name="id">';
            html += '   <table border="1" >'
            html += '<tr style="text-align: center;height: 45px ">';
            html += '<td colspan="4" style="width: 900px;background-color: #efefef "><b>商务盖章详情</b></td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>申请部门</span>';
            html += '</td>';
            html += '<td style="width:300px ;">'+mcStamp.dept.name+'</td>';
            html += '<td style="width:150px ;" class="Color">';
            html += '<span>申请日期</span>';
            html += '</td>';
            html += '<td style="width:300px ;">'+mcStamp.createtime+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';

            html += '<td style="width:150px ;" class="Color">';
            html += '<span>申请人</span>';
            html += '</td>';
            html += '<td style="width:300px ;">'+mcStamp.user.name+'</td>';
            html += '<td style="width:150px ;" class="Color">';
            html += '<span>联系电话</span>';
            html += '</td>';
            html += '<td style="width:300px ;">'+mcStamp.user.account+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>项目名称</span>';
            html += '</td>';
            html += '<td  colspan="3" style="width:300px ;">'+mcStamp.project.abbreviation+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>盖章申请内容</span>';
            html += '</td>';
            html += '<td colspan="3" >'+mcStamp.content+'</td>';

            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>所需相关文件份数</span>';
            html += '</td>';
            html += '<td colspan="3" >'+mcStamp.fileNum+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>用章类型</span>';
            html += '</td>';
            html += '<td colspan="3" >'+mcStamp.stampType+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>盖章用途说明</span>';
            html += '</td>';
            html += '<td colspan="3" >'+mcStamp.purpose+'</td>';
            html += '</tr>'
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>收件地址</span>';
            html += '</td>';
            html += '<td colspan="3" >'+mcStamp.consigneeAddress+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>收件人</span>';
            html += '</td>';
            html += '<td style="width:300px ;">'+mcStamp.consignee+'</td>';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>联系电话</span>';
            html += '</td>';
            html += '<td style="width:300px ;">'+mcStamp.consigneePhone+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>快递公司</span>';
            html += '</td>';
            if(mcStamp.expressageName==undefined){
                html += '<td style="width:300px ;">'+""+'</td>';
            }else {
                html += '<td style="width:300px ;">'+mcStamp.expressageName+'</td>';
            }
            html += '<td style="width:150px ; " class="Color">';
            html += '<span>快递单号</span>';
            html += '</td>';
            if(mcStamp.expressageWaybill==undefined){
                html += '<td style="width:300px ;">'+""+'</td>';
            }else {
                html += '<td style="width:300px ;">'+mcStamp.expressageWaybill+'</td>';
            }
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td class="Color">附件</td>';
            // html += '<td colspan="3">'+data.accessory+'</td>';
            if(mcStamp.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=mcStamp.accessory.split(","); //字符分割
                html += '<td colspan="3" >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" >';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
            html += '</tr>';
            html += '</table>';


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
            $.each(list, function (index, list) {
                html += '<tr style="text-align: center;width:900px ;height: 40px">';
                html += '<td style="width: 50px  ">' + (index+1) + '</td>';
                html += '<td style="width: 150px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 150px  ">' + list.user.name + '</td>';
                html += '<td style="width: 150px  ">' + list.approvalDate +'</td>';
                html += '<td style="width: 250px ">' + list.opinion + '</td>';
                html += '<td style="width: 150px  ">' + list.state + '</td>';
                html += '</tr>';
            });
            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 50px  ">'+mcStamp.processNode+'<input style="display:none" value='+mcStamp.id+' name="approvalId">';
            html += '</td>';


            if(mcStamp.processNode==1){
                html += '<td style="width: 150px;text-align: center  ">商务部审核</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px " value="商务部审核">';
            }else if(mcStamp.processNode==2){
                html += '<td style="width: 150px;text-align: center  ">分公司总经理审准</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="分公司总经理审准">';
            }else if(mcStamp.processNode==3){
                html += '<td style="width: 150px;text-align: center  ">信息中心复核</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="信息中心复核">';
            }else if(mcStamp.processNode==4){
                html += '<td style="width: 150px;text-align: center  ">申请人归还</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="申请人归还">';
            }else if(mcStamp.processNode==5){
                html += '<td style="width: 150px;text-align: center  ">信息中心确认</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="信息中心确认">';
            }

            html += '<td style="width: 150px  ">'+mcStamp.processUser.name+'<input style="display:none" value='+mcStamp.processUser.id+' name="approvalUser"></td>';
            html += '<td style="width: 150px  "><input type="text"  id="test1" style="text-align: center" ></td>';
            html += '<td style="width: 250px  "><input style="width: 180px;text-align: center;border: 1px solid " name="opinion"></td>';
            html += '<td style="width: 150px  "><select style="height: 27px" name="state"><option value="同意">同意</option><option value="退回">退回</option></select></td>';
            html += '</tr>';

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