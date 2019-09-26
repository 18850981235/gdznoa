/**
 * Created by Administrator on 2019/7/25.
 */
function w() {
    var  id=q("id");
    var url="/supplier/supplier2/QuerySupplierById?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
          html+='<table border="1">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>供应商详情</b>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">供应商名称</td>';
              html+='<td  style="width:300px ;">'+data.name+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">供应商编号</td>';
              html+='<td>'+data.code+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>法定代表人</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.legalPerson+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>注册资本</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.registeredCapital+'</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">注册地址</td>';
              html+='<td >'+data.registeredAddress+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">成立时间</td>';
              html+='<td >'+data.establishTime+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>公司电话</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.phone+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>公司传真</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.fax+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>公司邮箱</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.email+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>邮政编码</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.postalCode+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>供应商类别</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.type+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>供应商合作等级</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.grade+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>品牌信息</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.supplierTrademarks[0].supplierTrademark.name+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>公司网址</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.url+'</td>';
              html+='</tr>';

              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>开户行</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.bankname+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>银行账号</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.bankaccount+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>开户行地址</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.bankaddress+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>税号</span>';
              html+='</td>';
              html+='<td style="width:300px ;">'+data.tfn+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">';
              html+='<span>企业证书</span>';
              html+='</td>';
              // html+='<td colspan="3" style="width:300px ;">';
            if(data.credentialAccessory==undefined||data.credentialAccessory==""){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs = new Array(); //定义一数组
                strs = data.credentialAccessory.split(","); //字符分割
                html += '<td  >'
                for (i = 0; i < strs.length; i++) {
                    if (strs[i] != "") {
                        html+='<td colspan="3"  >';
                        html += '<form style="width: 170px ;display: inline-block" action="/util/fileDown" >';
                        html += '<input name="file" style="width:100px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;width:70px ;"  type="submit" value="点击下载">';
                        html += ' </form>';
                        html += '<span  style="width: 80px;display: inline-block "   >' + data.credentialAccessory + '</span>';
                        html += '</td>'
                    }
                }

            }

                html+='</tr>';

            // html+='<tr style="height:40px;">';
            //   html+='<td colspan="4" class="" style="text-align: center;background-color: #efefef;">企业合作重大事件记录';
            //
            //   html+='<span class="block" style="float: right;margin-right: 15px;cursor: pointer;color: #ff061c; ">下拉</span>';
            //   html+='<span class="none" style="float: right ;display: none;margin-right: 15px;cursor: pointer;color: #ff061c">收起</span>';
            //   html+='</td>';
            //   html+='</tr>';
              html+='</table>';


              html+='<div id="none" style="display: none">';
              html+='<table style="width: 900px ">';
              html+='<tr style="height:40px;background-color: #efefef;text-align: center">';
              html+='<td style="width:200px">时间</td>';
              html+='<td colspan="3">记录</td>';
              html+='</tr>';
              html+='</table>';
              html+='<table id="con" style="width: 900px ">';
              html+='<tr style="height:40px;">';
              html+='<td style="width:200px"><input style="width: 180px;text-align: center " placeholder="请输入时间" name=""></td>';
              html+='<td colspan="3"> <input style="width:700px " placeholder="请输入" name=""></td>';
              html+='</tr>';
              html+='</table>';
              html+='<div style="display: block;height: 30px ;text-align: center;padding-top: 6px ">';
              html+='<span id="add" >添加</span>';
              html+='<span id="remove" >删除</span>';
              html+='</div>';
              html+='</div>';


            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        date:{"id":id},
        success:function (data) {
            var html="";



            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

        }
    });
}
$(document).ready(function () {
    w();
    $("body").on("click","#add",function () {
        var text='<tr style="height:40px;"><td style="width:200px"><input style="width: 180px;text-align: center " placeholder="请输入时间" name=""></td><td colspan="3"> <input style="width:700px " placeholder="请输入" name=""></td></tr>'
        $("#con tbody").append(text);
    })
    $("body").on("click","#remove",function () {
        $("#con tr:last").remove();
    })
    $("body").on("click",".block",function () {
        $("#none").slideDown();
        $(".none").show();
        $(".block").hide();
    })
    $("body").on("click",".none",function () {
        $("#none").slideUp();
        $(".block").show();
        $(".none").hide();
    })
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