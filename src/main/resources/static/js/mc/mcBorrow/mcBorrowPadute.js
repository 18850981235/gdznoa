
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/borrow/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // $.each(data,function (index,project) {
            html+='<input style="display: none" value='+data.id+' name="id">';
             html += '<table border="1">';
             html += '<tr style="height: 40px ;background-color: #efefef">';
             html += '<td colspan="4" style="text-align: center">';
             html += '<b>原件借用修改</b>';
             html += '</td>';
             html += '</tr>';
             html += '<tr style="height:40px;">';
             html += '<td style="width:150px ;background-color: #efefef">申请部门</td>';
            html += '<td style="width:300px ;">';
             html += '<select class="department" style="width: 100px;height: 30px " name="deptid">';
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/util/getDept",
                success:function (data1) {
                    var names=data1.list;
                    $.each(names,function (index,obj) {
                        if(data.dept.id=obj.id){
                            html+='<option value='+obj.id+'select>';
                            html+='<span>'+obj.name+'</span>';
                            html+='</option>';
                        }else{html+='<option value='+obj.id+'>';
                            html+='<span>'+obj.name+'</span>';
                            html+='</option>';}
                        $(".department").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                    });
                }
            });
             html += '</select>';
             html += '</td>';
             html += '<td style="width:150px ;;background-color: #efefef">申请日期:</td>';
            html += '<td style="width:300px ;">';
            html += '<input type="date" style="width:280px " name="createtime" value='+data.createtime+'>';
             html += '</td>';
             html += '</tr>';
             html += '<tr  style="height:40px;">';
             html += '<td style="width:150px ;background-color: #efefef;">项目负责人:</td>';
             html += '<td >';
             html += '<input class="Eliminate" readonly  name="" value='+data.user.name+'>';
            html += '<input style="display: none" class="Eliminate-no" name="userid" value='+data.user.id+'>';
             html += '<a target="_blank " class="add-to">添加</a>';
             html += '<a class="clear-to" >';
             html += '<input value="清空" class="input"  onClick="" type="button">';
             html += '</a>';
             html += '</td>';
             html += '<td style="width:150px ;background-color: #efefef;">联系电话:</td>';
         html += '<td style="width:300px ;">';
             html += '<input style="width:280px " name="phone" value='+data.phone+'>';
             html += '</td>';
             html += '</tr>';
             html += '<tr style="height:40px;">';
             html += '<td style="width:150px ;background-color: #efefef;">原件名称</td>';
             html += '<td colspan="3"><input style="width: 700px " name="name" value='+data.name+'></td>';
             html += '</tr>';
             html += '<tr style="height:40px;">';
             html += '<td style="width:150px ;background-color: #efefef;">原件借用用途</td>';
             html += '<td ><input style="width: 280px " name="purpose" value='+data.purpose+'></td>';
            html += '<td style="width:150px ;background-color: #efefef;">数量</td>';
            html += '<td ><input style="width: 280px " name="fileNum" value='+data.fileNum+'></td>';
             html += '</tr>';
             // html += '<tr style="height:40px;">';
             // html += '<td style="width:150px ;background-color: #efefef;">原件寄出时间</td>';
             // html += '<td style="width:300px ;">';
             // html += '<input  style="width:280px " name="" value='+data.purpose+'>';
             // html += '</td>';
             // html += '<td style="width:150px ;background-color: #efefef;">原件寄往地址</td>';
             // html += '<td colspan="3">';
             // html += '<input  style="width:280px " name="consigneeAddress" value='+data.consigneeAddress+'>';
             // html += '</td>';
             // html += '</tr>';
             html += '<tr style="height:40px;">';
             html += '<td style="width:150px ;background-color: #efefef;">收件人</td>';
             html += '<td style="width:300px ;">';
             html += '<input  style="width:280px "name="consignee"value='+data.consignee+'>';
             html += '</td>';
             html += '<td style="width:150px ;background-color: #efefef;">联系电话</td>';
             html += '<td style="width:300px ;">';
             html += '<input  style="width:280px " name="consigneePhone" value='+data.consigneePhone+'>';
             html += '</td>';
             html += '</tr>';
             html += '<tr style="height:40px;">';
             html += '<td style="width:150px ;background-color: #efefef;">原件归还时间</td>';
             html += '<td style="width:300px ;">';
             html += '<input  style="width:280px " type="date" name="returntime" value='+data.returntime+'>';
             html += '</td>';
             html += '<td style="width:150px ;background-color: #efefef;">原件归还地址</td>';
             html += '<td style="width:300px ;">';
             html += '<input  style="width:280px "name="consigneeAddress" value='+data.consigneeAddress+'>';
             html += '</td>';
             html += '</tr>';
            html += '<tr style="height:40px;">';
            html += '<td style="width:150px ;background-color: #efefef;">附件</td>';
            html += '<td colspan="3"><input type="file"  style="width: 700px " name="file" value='+data.accessory+'></td>';
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