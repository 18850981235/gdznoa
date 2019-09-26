/**
 * Created by Administrator on 2019/8/2.
 */
function w() {
    var  id=q("id");
    var url="/supplier/trademark/QueryTrademarkByid?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // console.log(data.ContractInventory[0].project.name)
            // console.log(data.id)
            // $("#center input").eq(0).val(data.id)
            //
            // $(".contacts option").eq(0).val(data.system.id);
            // $(".contacts option").eq(0).text(data.system.name);
            //
            // $("#center input").eq(1).val(data.product)
            // $("#center input").eq(2).val(data.name)
            // $("#center input").eq(3).val(data.englishName)
            // $("#center input").eq(4).val(data.enterpriseName)
            // $("#center input").eq(5).val(data.originPlace)
            // $("#center input").eq(6).val(data.url)


          html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>供应商人员详情</b>';
            html+='<input style="display: none" value='+data.id+' >';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef">系统名称</td>';
              html+='<td   style="width:250px ;">'+data.system.name+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">主要产品及设备</td>';
              html+='<td   style="width:250px ;">'+data.product+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef">品牌</td>';
              html+='<td   style="width:250px ;">'+data.name+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">英文</td>';
              html+='<td   style="width:250px ;">'+data.englishName+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef">企业名称</td>';
              html+='<td   style="width:250px ;">'+data.enterpriseName+'</td>';
              html+='<td style="width:150px ;;background-color: #efefef">原产地</td>';
              html+='<td   style="width:250px ;">'+data.originPlace+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef">厂家网址</td>';
              html+='<td colspan="3"  style="width:650px ;">'+data.url+'</td>';
              html+='</tr>';
            $("table").append(html);
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