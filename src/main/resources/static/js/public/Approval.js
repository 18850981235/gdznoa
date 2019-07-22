/**
 * Created by Administrator on 2019/4/9.
 */
//单位
$.ajax({
    type:"post",
    dataType:"json",
    url:"/myWork",
    // url:"/util/getClient",
    success:function (data) {

        var path= window.location.pathname+"Detailed";
            var html="";
            // html+='<ul class="name" >';
        html+='<form method="post" action='+path+'>';
             html += '<table border="1">';
        html += '<tr style="height: 40px ">';
        html += '<td colspan="4" style="width: 750px;background-color: #eeeeee;text-align: center "><b>审批</b></td>';

        html += '</tr>';
        html += '<tr style="height: 40px ">';
        html += '<td style="width:150px ;">是否通过</td>';
        html += '<td colspan="3" style="width: 750px ">';
        html += '<select style="height: 30px " name="state">';
        html += '<option>通过</option>';
        html += '<option>不通过</option>';
        html += '</select>';
        html +='<input style="display: none" name="approvalId" value='+data.list[0].id+'>'
        html += '</td>';
        html += '</tr>';
        html += '<tr >';
        html += '<td style="width:150px ;">审批内容</td>';
        html += '<td colspan="3" style="width: 750px ">';
        html += '<textarea style="width:700px ;height: 50px  " name="opinion"></textarea>';
        html += '</td>';
        html += '</tr>';
        html += '</table >';
        html += ' <input id="ok" type="submit" value="保存" style="margin-left: 350px ">';
        html += ' <a href="" id="no" style="margin-left: 15px ">返回</a>';
        html+='</form>';
            $("#Approval").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

    }
});