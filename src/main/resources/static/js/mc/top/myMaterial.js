/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/materials/particular.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // $.each(data,function (index,project) {
            var materials=data.materials;
            var list=data.list;
            html+='   <input style="display: none" value='+data.id+' name="id">';
            html += '<table border="1">';
            html += '<tr style="text-align: center;height: 45px ">';
            html += '<td colspan="4" style="width: 900px;background-color: #efefef "><b>商务材料详情</b></td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;"><span>申请部门</span></td>';
            html += '<td style="width:300px ;">'+materials.dept.name+'</td>';
            html += '<td style="width:150px ;;background-color: #efefef"><span>申请日期</span></td>';
            html += '<td style="width:300px ;">'+materials.createtime+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px">';
            html += '<td style="width:150px;background-color: #efefef;"><span>申请人</span></td>';
            html += '<td style="width:300px;">'+materials.user.name+'</td>';
            html += '<td style="width:150px;background-color: #efefef">';
            html += '<span>联系电话</span>';
            html += '</td>';
            html += '<td style="width:300px ;">'+materials.user.account+'</td>';
            html += '</tr>';
            html += '<tr  style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;"><span>项目名称</span></td>';
            html += '<td colspan="3" style="width:300px ;">'+materials.projectName+'</td>';
            html += '</tr>';
            html += '<tr  style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;"><span>非盖章申请内容</span></td>';
            html += '<td colspan="3"   style="width:300px ;">'+materials.content+'</td>';
            html += '</tr>';
            html += '<tr  style="height: 45px ">';

            html += '<td style="width:150px ;background-color: #efefef;"><span>用途说明</span></td>';
            html += '<td colspan="3"   style="width:300px ;">'+materials.purpose+'</td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">附件</td>';
            if(materials.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=materials.accessory.split(","); //字符分割
                html += '<td colspan="3" >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" >';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent"  type="submit" value="点击下载">';
                        html += '</form>';
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
            html += '<input style="display:none" value='+materials.id+'>';
            if(materials.processNode==1){
                html += '<input style="display:none" value="商务部办理">';
            }

            html += '</td>';

            html += '<td style="width: 50px  ">' ;
            html +=  '<select style="height: 27px">';
            html += '<option>请选择</option>';
            html += '<option>商务部办理</option>';
            html += '</select>';
            html += '</td>';
            html += '<td style="width: 50px  "><input style="text-align:center;border: 1px solid"></td>';
            html += '<td style="width: 50px  "><input type="text"  id="test1" style="text-align: center"></td>';
            html += '<td style="width: 200px  "><input style="width: 180px;text-align: center;border: 1px solid "></td>';
            html += '<td style="width: 50px  "><select style="height: 27px"><option>通过</option><option>转交</option></select></td>';
            html += '</tr>';
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