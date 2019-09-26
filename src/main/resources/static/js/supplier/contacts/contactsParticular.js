/**
 * Created by Administrator on 2019/6/10.
 */

function w() {
    var  id=q("id");
    var url="/supplier/staff/querystaffbyid?id="+id;

    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        date:{"id":id},
        success:function (data) {
            var listInventory=data.listInventory;
            var html="";
            $("#id").text(data[0].supplier.name);

            $.each(data,function (index,obj) {
                var html="";

                html+='<tr class="huo" style="height: 40px; ">';
                // html+='<td style="width: 40px; "> '+obj.serialnum+'</td>';
                // html+='<td style="width: 130px; "> '+obj.code+'</td> ';
                // html+='<td style="width: 131px;"> '+obj.name+'</td> ';
                // html+='<td style="width: 100px; "> '+obj.model+'</td> ';
                // html+='<td style="width: 100px; "> '+obj.parameter+'</td> ';
                // html+='<td style="width: 150px;padding: 3px "> '+obj.trademark+'</td> ';
                // html+='<td style="width: 100px; "> '+obj.unit+'</td> ';
                // html+='<td style="width: 100px "> '+obj.num+'</td> ';
                // html+='<td style="width: 100px; "> '+obj.unitCost+'</td> ';
                // html+='<td style="width: 100px; "> '+obj.subtotal+'</td> ';
                // html+='<td style="width: 150px; "> '+obj.remarks+'</td> ';

              html+='<td style="width: 100px  ">'+obj.name+'</td>';
                  html+='<td style="width: 100px  ">'+obj.role+'</td>';
                  html+='<td style="width: 150px  ">'+obj.phone+'</td>';
                  html+='<td style="width: 150px  ">'+obj.fax+'</td>';
                  html+='<td style="width: 200px  ">'+obj.address+'</td>';
                  html+='<td style="width: 150px  ">'+obj.email+'</td>';
                  html+='<td style="width: 150px  ">'+obj.wechat+'</td>';
                  html+='<td style="width: 200px  ">'+obj.jobContent+'</td>';
                html+='</tr> ';

                $("#con").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })





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