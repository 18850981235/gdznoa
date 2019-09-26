/**
 * Created by Administrator on 2019/8/5.
 */

$(document).ready(function () {
    $("body").on("click",".block-1",function () {
        $("#none-1").slideDown();
        $(".none-1").show();
        $(".block-1").hide();
    })
    $("body").on("click",".none-1",function () {
        $("#none-1").slideUp();
        $(".block-1").show();
        $(".none-1").hide();
    })
    $("body").on("click",".block-2",function () {
        $("#none-2").slideDown();
        $(".none-2").show();
        $(".block-2").hide();
    })
    $("body").on("click",".none-2",function () {
        $("#none-2").slideUp();
        $(".block-2").show();
        $(".none-2").hide();
    })
    $("body").on("click",".block-3",function () {
        $("#none-3").slideDown();
        $(".none-3").show();
        $(".block-3").hide();
    })
    $("body").on("click",".none-3",function () {
        $("#none-3").slideUp();
        $(".block-3").show();
        $(".none-3").hide();
    })
    $("body").on("click",".block-4",function () {
        $("#none-4").slideDown();
        $(".none-4").show();
        $(".block-4").hide();
    })
    $("body").on("click",".none-4",function () {
        $("#none-4").slideUp();
        $(".block-4").show();
        $(".none-4").hide();
    })
    //计算器
    $(".vat").mouseout(function () {
        var vat=$(".vat").val()

    })
    $(".corporate-income").mouseout(function () {
        var income=$(".corporate-income").val()

    })

        // $.ajax({
        //     type:"post",
        //     dataType:"json",
        //     url:"/util/getGCProject",
        //     success:function (data) {
        //         $.each(data,function (index,obj) {
        //             var html="";
        //             // html+='<ul class="name" >';
        //             html+='<option value='+obj.id+'>';
        //             html+='<span>'+obj.abbreviation+'</span>';
        //             html+='</option>';
        //             // html+='</ul>';
        //             $(".customer").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        //         });
        //
        //     }
        // });
        $.ajax({
            type:"post",
            dataType:"json",
            url:"/util/getGCProject",
            success:function (data) {
                $.each(data,function (index,obj) {
                    var html="";
                    // html+='<ul class="name" >';
                    html+='<option value='+obj.id+'>';
                    html+='<span>'+obj.abbreviation+'</span>';
                    html+='</option>';
                    // html+='</ul>';
                    $(".project").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                });

            }
        });

        //点击选择项目
        $(".project").change(function () {
            $.removeCookie('id');
            $.removeCookie('name');
            var po=$(".project option:selected").val();
            var pop=$(".project option:selected").text();
            // $(".herf-on").hide();
            // $("form").show();
            // console.log(po)
            // console.log(pop)
            $.cookie("id",po);
            $.cookie("name",pop);
            sessionStorage.setItem("id",po);
            sessionStorage.setItem("name",pop);
            if(po!=""){
                $.ajax({
                    type:"post",
                    dataType:"json",
                    url:"/bd/project/queryAllSome.json?id="+po,
                    // dta:{"id":po},
                    success:function (data) {
                        $("#center input").eq(0).val(data.project.name);
                        $("#center input").eq(1).val(data.project.code);
                        $("#center input").eq(2).val(data.project.dept.name);
                        $("#center input").eq(3).val(data.list[0].bankAccount);
                        $("#center input").eq(4).val(data.newtotal);
                        // $("#center input").eq(5).val(data.addstotal);
                        // $("#center input").eq(6).val(data.addpo);
                        $("#center input").eq(7).val(data.addstotal);
                        $("#center input").eq(8).val(data.deletotal);
                        $("#center input").eq(9).val(data.addpo);
                    }
                });
            }
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/ga/harvestTicket/sumMoneyAndCompanyName?projectid="+po,
                // dta:{"id":po},
                success:function (data) {

                    $("#none-3 input").eq(0).val(data.sumMoney*0.02*0.02)
                    $("#none-3 input").eq(1).val(data.sumMoney*0.02*0.07)
                    $("#none-3 input").eq(2).val(data.sumMoney*0.02*0.03)
                    $("#none-3 input").eq(3).val(data.sumMoney*0.96*0.0003)
                    $("#none-3 input").eq(4).val(data.sumMoney*0.0003)

                    $("#none-3 input").eq(5).val(data.sumMoney*0.0009)

                    $("#none-3 input").eq(6).val(data.sumMoney*0.015)
                    $("#none-3 input").eq(7).val(data.sumMoney*0.015)
                    $("#none-3 input").eq(10).val(data.sumMoney*0.015)
                    $("#none-3 input").eq(11).val(data.sumMoney*0.015)

                }
            });
        })
    //点击计算
        $(document).on("click",".count-1",function () {
            var po=$(".project option:selected").val();
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/ga/harvestTicket/sumMoneyAndCompanyName?projectid="+po,
                // dta:{"id":po},
                success:function (data) {
                    var a=$(".vat").val()
                    if(data.companyName=="设备销项专用发票管理"){
                        $(".vat-on").val(a*0.015)
                    }else if(data.companyName=="建安销项专用发票管理"){
                        $(".vat-on").val(a*0.02)
                    }else if(data.companyName=="服务销项专用发票管理"){
                        $(".vat-on").val(a*0.06)
                    }

                }
            });
        })
        $(document).on("click",".count-2",function () {
            var po=$(".project option:selected").val();
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/ga/harvestTicket/sumMoneyAndCompanyName?projectid="+po,
                // dta:{"id":po},
                success:function (data) {
                    var a=$(".corporate-income").val()
                    if(data.companyName=="设备销项专用发票管理"){
                        $(".corporate-income-on").val(a*0.015)
                    }else if(data.companyName=="建安销项专用发票管理"){
                        $(".corporate-income-on").val(a*0.015)
                    }else if(data.companyName=="服务销项专用发票管理"){
                        $(".corporate-income-on").val(a*0.015)
                    }

                }
            });
        })
        //返回时显示上一次选择的项目
        var id=$.cookie("id");
        var name=$.cookie("name");
        // var id=sessionStorage.getItem('op')
        //  var name=sessionStorage.getItem('pop')
        console.log(id);
        console.log(name);
        if(id!=""||id!=undefined){
            $(".project option").eq(0).val(id)
            $(".project option").eq(0).text(name)
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/bd/project/queryAllSome.json?id="+id,
                // dta:{"id":po},
                success:function (data) {
                    $("#center input").eq(0).val(data.project.name);
                    $("#center input").eq(1).val(data.project.code);
                    $("#center input").eq(2).val(data.project.dept.name);
                    $("#center input").eq(3).val(data.list[0].bankAccount);
                    $("#center input").eq(4).val(data.newtotal);
                    // $("#center input").eq(5).val(data.addstotal);
                    // $("#center input").eq(6).val(data.addpo);
                    $("#center input").eq(7).val(data.addstotal);
                    $("#center input").eq(8).val(data.deletotal);
                    $("#center input").eq(9).val(data.addpo);
                }
            });
        }
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/ga/harvestTicket/sumMoneyAndCompanyName?projectid="+id,
        // dta:{"id":po},
        success:function (data) {

            $("#none-3 input").eq(0).val(data.sumMoney*0.02*0.02)
            $("#none-3 input").eq(1).val(data.sumMoney*0.02*0.07)
            $("#none-3 input").eq(2).val(data.sumMoney*0.02*0.03)
            $("#none-3 input").eq(3).val(data.sumMoney*0.96*0.0003)
            $("#none-3 input").eq(4).val(data.sumMoney*0.0003)

            $("#none-3 input").eq(5).val(data.sumMoney*0.0009)

            $("#none-3 input").eq(6).val(data.sumMoney*0.02)
            $("#none-3 input").eq(7).val(data.sumMoney*0.015)
            $("#none-3 input").eq(10).val(data.sumMoney*0.02)
            $("#none-3 input").eq(11).val(data.sumMoney*0.015)

        }
    });
        // $(document).on("click",".herf0",function () {
        //     $.removeCookie('id');
        //     $.removeCookie('name');
        //     var po=$(".project").val();
        //     var pop=$(".project").text();
        //     $(".herf-on").hide();
        //     $("form").show();
        //     $.cookie("id",po,{ expires: 7, path: '/' });
        //     $.cookie("name",pop,{ expires: 7, path: '/' });
        //
        //
        //     // $.cookie('name',cook, { expires: 7, path: '/' });
        //     //基础信息
        //     // $.ajax({
        //     //     type:"post",
        //     //     dataType:"json",
        //     //     url:"/util/getGCProject",
        //     //     // data:po,
        //     //     success:function (data) {
        //     //         $.each(data,function (index,obj) {
        //     //             var html="";
        //     //             // html+='<ul class="name" >';
        //     //             html+='<option value='+obj.id+'>';
        //     //             html+='<span>'+obj.abbreviation+'</span>';
        //     //             html+='</option>';
        //     //             // html+='</ul>';
        //     //             $(".project").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        //     //         });
        //     //
        //     //     }
        //     // });
        // })
    //判断返回后会话域判断是否有项目

    // if($.cookie("name")!=""||$.cookie("name")!=null||$.cookie("name")!=undefined){
    //     var name=$.cookie("name")
    //     var id=$.cookie("id")
    //      $(".project option").eq(0).val();
    //     $(".project option").eq(0).text();
    //
    // }
    //给按钮添加名称会话域
        $(document).on("click",".herf",function () {
            $.removeCookie('herf');
            var herf=$(this).siblings("span").text()
            $.cookie("herf",herf,{ expires: 7, path: '/' });

            var name=$.cookie("name")
            var id=$.cookie("id")

        })
    $(document).on("click",".herf2",function () {
        $.removeCookie('herf2');
        var herf2="支出"
        $.cookie("herf2",herf2,{ expires: 7, path: '/' });

    })
    $(document).on("click",".herf3",function () {
        $.removeCookie('herf2');
        var herf2="收入"
        $.cookie("herf2",herf2,{ expires: 7, path: '/' });

    })
    $(document).on("click",".herf-z",function () {
        $.removeCookie('herf');
        var herf=$(this).siblings("span").text()
        var ferf=herf+"支出"
        $.cookie("herf",ferf,{ expires: 7, path: '/' });

        var name=$.cookie("name")
        var id=$.cookie("id")

    })
    $(document).on("click",".herf-s",function () {
        $.removeCookie('herf');
        var herf=$(this).siblings("span").text()
        var ferf=herf+"收入"

        $.cookie("herf",ferf,{ expires: 7, path: '/' });

        var name=$.cookie("name")
        var id=$.cookie("id")

    })

})
$(document).ready(function () {

})
