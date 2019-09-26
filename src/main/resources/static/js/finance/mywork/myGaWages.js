/**
 * Created by Administrator on 2019/9/11.
 */
/**
 * Created by Administrator on 2019/8/15.
 */
function w() {
    var  id=q("id");
    var url="/ga/paymentSalaryUpdate/particular.html?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (date) {
            var html="";
            var data=date.gaPayment

            $("#center input").eq(0).val(data.project.abbreviation);
            $("#center input").eq(1).val(data.project.id)
            $("#center input").eq(2).val(data.name)
            $("#center input").eq(3).val(data.unit)
            $("#center input").eq(4).val(data.user.name)
            $("#center input").eq(5).val(data.user.id)

            $(".type option").eq(0).val(data.type)
            $(".type option").eq(0).text(data.type)

            $("#center input").eq(6).val(data.bankname)
            $("#center input").eq(7).val(data.bankaccount)
            $("#center input").eq(8).val(data.digest)
            $("#center input").eq(9).val(data.id)

            $(".he input").eq(0).val(data.paymentMoney)

            $.each(date.salaryList,function (index,obj) {
                var html="";
                html+='<tr style="height: 35px ;">';
                html+='<td style="width:100px;display: none">'+obj.id+'</td>';
                html+='<td style="width:100px;">'+obj.name+'</td>';
                html+='<td style="width:100px;">'+obj.post+'</td>';
                html+='<td style="width:100px;">'+obj.clockinIn+'</td>';
                html+='<td style="width:100px;">'+obj.salary+'</td>';
                html+='<td style="width:100px;">'+obj.time+'</td>';
                html+='<td style="width:100px;">'+obj.socialSecurity+'</td>';
                html+='<td style="width:100px;">'+obj.leave+'</td>';
                html+='<td style="width:100px;">'+obj.insurance+'</td>';
                html+='<td style="width:100px;">'+obj.rests+'</td>';
                html+='<td style="width:100px;">'+obj.netPay+'</td> ';
                html+='</tr>';
                $("#con").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内
            })


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
            $.each(date.list, function (index, list) {
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
            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 20px  "><input style="text-align: center;border: 1px solid">';
            html += '<input style="display:none" value='+date.list.id+'>';
            html += '<input style="display:none" value='+data.matter+'>';
            if(date.list.processNode==1){
                html += '<input style="display:none" value="公司分管领导审批">';
            }else if(date.list.processNode==2){
                html += '<input style="display:none" value="财务经办">';
            }else if(date.list.processNode==3){
                html += '<input style="display:none" value="财务主管">';
            }else if(date.list.processNode==4){
                html += '<input style="display:none" value="分管领导">';
            }else if(date.list.processNode==5){
                html += '<input style="display:none" value="主管领导">';
            }

            html += '</td>';

            html += '<td style="width: 50px  ">' ;
            html +=  '<select style="height: 27px">';
            html += '<option>请选择</option>';
            html += '<option>公司分管领导审批</option>';
            html += '<option>财务经办</option>';
            html += '<option>财务主管</option>';
            html += '<option>分管领导</option>';
            html += '<option>主管领导</option>';
            html += '</select>';
            html += '</td>';
            html += '<td style="width: 50px  "><input style="text-align:center;border: 1px solid"></td>';
            html += '<td style="width: 50px  "><input type="text"  id="test1" style="text-align: center"></td>';
            html += '<td style="width: 200px  "><input style="width: 180px;text-align: center;border: 1px solid "></td>';
            html += '<td style="width: 50px  "><select style="height: 27px"><option>通过</option><option>转交</option></select></td>';
            html += '</tr>';
            html += '</table>';

            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
}

$(document).ready(function () {
    w();




});
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