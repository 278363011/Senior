     //全屏
        function fullScreen(){
            var el = document.documentElement;
            var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullscreen;      
                if(typeof rfs != "undefined" && rfs) {
                    rfs.call(el);
                };

              return;
        }
        //退出全屏
        function exitScreen(){
            if (document.exitFullscreen) {  
                document.exitFullscreen();  
            }  
            else if (document.mozCancelFullScreen) {  
                document.mozCancelFullScreen();  
            }  
            else if (document.webkitCancelFullScreen) {  
                document.webkitCancelFullScreen();  
            }  
            else if (document.msExitFullscreen) {  
                document.msExitFullscreen();  
            } 
            if(typeof cfs != "undefined" && cfs) {
                cfs.call(el);
            }

            
        }
        //ie低版本的全屏，退出全屏都这个方法
        function iefull(){
            var el = document.documentElement;
            var rfs =  el.msRequestFullScreen;
            if(typeof window.ActiveXObject != "undefined") {
                //这的方法 模拟f11键，使浏览器全屏
                var wscript = new ActiveXObject("WScript.Shell");
                if(wscript != null) {
                    wscript.SendKeys("{F11}");
                }
            }

        }


        //判断是否是全屏
		    function checkFull() {
		      		 //监听状态变化
      				  if (window.addEventListener) {
				        document.addEventListener('fullscreenchange', function(){ 
				          if($("#fullscreen span").text() == "开启全屏"){
				            $("#fullscreen span").text("退出全屏");
				          }else{
				           $("#fullscreen span").text("开启全屏");
				          		 //监听 ESC键盘事件
								$(document).keyup(function(event) {
									switch(event.keyCode) {
									case 27:
											screentotal++;
											return;
									}
								});
				          }
				        });
				        document.addEventListener('webkitfullscreenchange', function(){ 
				          if($("#fullscreen span").text() == "开启全屏"){
				            $("#fullscreen span").text("退出全屏");
				          }else{
				            $("#fullscreen span").text("开启全屏");
				             //监听 ESC键盘事件
								$(document).keyup(function(event) {
									switch(event.keyCode) {
									case 27:
											screentotal++;
											return;
									}
								});
				          }
				        });
				        document.addEventListener('mozfullscreenchange', function(){ 
				          if($("#fullscreen span").text() == "开启全屏"){
				            $("#fullscreen span").text("退出全屏"); 
				          }else{
				            $("#fullscreen span").text("开启全屏");
				             //监听 ESC键盘事件
								$(document).keyup(function(event) {
									switch(event.keyCode) {
									case 27:
											screentotal++;
											return;
									}
								});
				          }
				        });
				        document.addEventListener('MSFullscreenChange', function(){ 
				          if($("#fullscreen span").text() == "开启全屏"){
				            $("#fullscreen span").text("退出全屏");
				          }else{
				           $("#fullscreen span").text("开启全屏");
				            //监听 ESC键盘事件
								$(document).keyup(function(event) {
									switch(event.keyCode) {
									case 27:
											screentotal++;
											return;
									}
								});
				          }
				        });
				      }
		    }
        
      				   checkFull();
				// 		fullScreen
				var screentotal=2;
				$("#fullscreen").on("click",function(){
					if(screentotal%2==0){
						fullScreen();
						screentotal++;
					}else{
						exitScreen();
				        screentotal++;
					}
				});


//回到顶部 功能
    $(window).scroll(function(){
                if ($(window).scrollTop()>30){
                    $("#goup").fadeIn(1000);
                }
                else
                {
                    $("#goup").fadeOut(1000);
                }
            });

            //当点击跳转链接后，回到页面顶部位置

            $("#goup").click(function(){
                $('body,html').animate({scrollTop:0},1000);
                return false;
            });

//下拉隐藏菜单
$("#xl").on("click",function(){
	$(".scollmode").slideToggle(1000);
});

//点击隐藏聊天好友列表
 $(".fa.fa-chevron-down").click(function(){
  $(this).parent().next().slideToggle("slow");
  });


//聊天滑动效果
$("#chat").on("click",function(){
	$("#right-sidebar").fadeToggle(1000);
	
});


//点击侧边栏加载iframe
 $("li[role='presentation']").on("click",function(){
 	$("li[role='presentation']").each(function(){
 		if($(this).hasClass("active")){
 			$(this).removeClass("active");
 		}
 	});
 	$(this).addClass("active");
 	$("#iframepage").attr("src",$(this).attr("id"));
 	
 });



//服务平台选择字体变化
$("#servershop li").on("click",function(){
	$("#platfont").text($(this).text());
});


//点击头像显示聊天框
$(".chat-name").on("click",function(){
	if($("#chatinfouser").hasClass("hide-it")){
		$("#chatinfouser").removeClass("hide-it");
		$("#chatinfowindow").removeClass("chatbox-show");
		
	}else{
		$("#chatinfouser").addClass("hide-it");
		$("#chatinfowindow").addClass("chatbox-show");
	}
});


//点击后退返回
$("#close-user-chat").on("click",function(){
	if($("#chatinfouser").hasClass("hide-it")){
		$("#chatinfouser").removeClass("hide-it");
		$("#chatinfowindow").removeClass("chatbox-show");
		
	}else{
		$("#chatinfouser").addClass("hide-it");
		$("#chatinfowindow").addClass("chatbox-show");
	}
});




$("#attach_photo_btn").on("click",function(){
	if($("#sendMsg").val()!=""){
	$("ul.chat-ui.chat-messages").append('<li class="chat-me"><p class="avatar"><img src="img/48.jpg" alt="SuggeElson"></p><p class="chat-name">谢连武 <span class="chat-time">10分钟以前</span></p><span class="status online"><i class="en-dot"></i></span><p class="chat-txt">'+$("#sendMsg").val()+'</p></li>')
	$("ul.chat-ui.chat-messages").scrollTop($("ul.chat-ui.chat-messages")[0].scrollHeight);
	$("#sendMsg").val("");
	}
});

//聊天框的高度跟随输入框动态变化
//$(window).on("resize",function(){
//	var legth=$("#sendMsg").offset().top - $(window).scrollTop();
//	$("ul.chat-ui.chat-messages").height(legth-150);
//	$("ul.chat-ui.chat-messages").css("overflow","auto");
//});





//$.ajax({
//	url : "/oderList.do",
//	type : "POST",
//	async : true,
//	data : {
//	},
//	success : function(data) {
//		alert(data);
//		alert(typeof data);
//		var str=JSON.stringify(data.data);
//		alert(JSON.stringify(data.data));
//		jtableseting.aaData=str;
////		console.log(JSON.stringify(data.data));
////		$("#printshipping").dataTable(jtableseting);
//		$("#printshipping").dataTable().fnClearTable();
//		$("#printshipping").dataTable().fnDestroy();
////		$("#printshipping").dataTable().fnAddData(data.data,true);
//		$("#printshipping").dataTable(jtableseting);
//		
//	}
//
//});

$('#table').bootstrapTable({
    url:"/oderList.do",//请求数据url
    queryParams: function (params) {
        return {
            offset: params.offset,  //页码
            limit: params.limit,   //页面大小
            search : params.search, //搜索
            order : params.order, //排序
            ordername : params.sort, //排序
            pagenow:1,
            pagesize:10,
//            goodsParam:{
//            	//页码
//            	page:params.offset,
//            	pageSize:params.limit,
//            	//退款状态
//            	refundStatus:$("#back-status").val(),
//            	//交易类型
//            	tradeType:" ",
//            	//业务类型
//            	bizTypes:" ",
//            	//商品名称
//            	productName:" ",
//            	//交易类型
//            	tradeType:" ",
//            	//订单状态
//            	orderStatus: $("#order-status").val(),
//            	//是否查询历史订单表
//            	isHis:"",
//            	//下单结束时间
//            	createEndTime:"",
//            	//下单开始时间
//            	createStartTime:"",
//            }
            
        };
    },
    
  //是否显示全屏框
//    showFullscreen:true,
    //最小列隐藏的数量
    minimumCountColumns:2,
    //自定义的toolbar
    toolbar:"#toolbar",
    //显示card视图按钮
    showToggle:true,
    //是否一开始就显示card视图
    cardView:false,
    //舒适化搜索模式
//    searchText:"请输入搜索...",
    showHeader : true,
    showColumns : true,
    showRefresh : true,
    //是否显示行间隔色  
//    striped: true,  
    //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）       
    cache: false,
    pagination: true,//分页
    sidePagination : 'server',//服务器端分页
    pageNumber : 1,
    pageList: [5, 10, 20, 50],//分页步进值
    search: true,//显示搜索框
    //显示行下拉
    detailView:true,
    
    clickToSelect:true,
  //是否显示导出
    showExport: true,     
  //basic', 'all', 'selected'.
    exportDataType: "selected",              
    
    
    //根据需求显示不同行样式
//    rowStyle: function (row, index) {
        //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
//        var strclass = "";
//        if (row.role == "1") {
//            strclass = 'success';//还有一个active
//        }
//        else if (row.role == "2") {
//            strclass = 'danger';
//        }
//        else {
//        	  strclass = 'warning';
//        }
//        return { classes: strclass }
//    },
    
    
    //表格的列
    columns: [
    	{
    		checkbox:true,
    		align:"center",
            valign:"middle",
    	},
        {	
            field: 'ordercode',//域值
            title: '订单编号',//标题
            visible: true,//false表示不显示
            sortable: true,//启用排序
            align:"center",
            valign:"middle",
//            width : '5%',
        },
        {
            field: 'orderstatus',//域值
            title: '订单状态',//标题
            visible: true,//false表示不显示
            sortable: true,//启用排序
            class: 'text-danger',
            align:"center",
            valign:"middle",
//            width : '30%',
//            editable:true,
            formatter:function(value,row,index){
            	var tempvalue=value;
            	if(value=="success"){
            		tempvalue="交易成功";
            	}else if(value=="cancel"){
            		tempvalue="交易取消";
            	}
            	return tempvalue;
            },
        },
        {
            field: 'buyername',//域值
            title: '买家昵称',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
            formatter:function(value,row,index){
            	return value+'<a href="javascript:void(0)""><img class="aliliwangwang" style="width:18px;height:18px;" src="/img/aliwangwang.jpg" /></a>';
            },
        },
        {
            field: 'ordertimes',//域值
            title: '订单时间',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
            formatter:function(value,row,index){
            	var arry=value.split(";");
            	var tempstr="";
            	for(var i=0;i<arry.length;i++){
            		tempstr+=arry[i]+"</br>"
            	}
            	return tempstr;
            },
        },
        {
            field: 'nums',//域值
            title: '数量',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
        },
        {
            field: 'productsingleprice',//域值
            title: '单价',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
        },
        {
            field: 'moneyamount',//域值
            title: '实付',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
            formatter:function(value,row,index){
            	var arry=value.split(";");
            	var tempstr="";
            	for(var i=0;i<arry.length;i++){
            		tempstr+=arry[i]+"</br>"
            	}
            	return tempstr;
            },
            
        },
        {
            field: 'productname',//域值
            title: '商品名称',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
            formatter:function(value,row,index){
            	var tempvalue="";
            	var size=value.length;
				var total=size/20;
            	for(var i=0;i<total;i++){
            		tempvalue+=value.slice(20*i,20*(i+1))+"</br>";
           		 }
            	tempvalue+=value.slice(20*(i+1),value.length);
            	return tempvalue;
            },
        },
        {
            field: 'productsmallimg',//域值
            title: '商品图片(点击放大)',//内容
            visible: true,
            align:"center",
            valign:"middle",
            formatter:function(value,row,index){
            		return '<a href="javascript:void(0)" class="bigimg" srcurl="'+row.productsbigimg+'"><img style="width:40px;height:40px;"  src="'+value+'" /></a>';
            },
        },
        {
            field: 'reciveinfo',//域值
            title: '收货人信息',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
            formatter:function(value,row,index){
            	var arry=value.split(";");
            	var tempstr="";
            	for(var i=0;i<arry.length;i++){
            		tempstr+=arry[i]+"</br>"
            	}
            	return tempstr;
            },
        },
        {
            field: 'buyersay',//域值
            title: '买家留言',//内容
            visible: true,//false表示不显示
            align:"center",
            valign:"middle",
            formatter:function(value,row,index){
            	var size=value.length;
				var total=size/20;
				var tempvalue="";
            	for(var i=0;i<total;i++){
            		tempvalue+=value.slice(20*i,20*(i+1))+"</br>";
           		 }
            	tempvalue+=value.slice(20*(i+1),value.length);
            	return tempvalue;
            },
        },
    ],
    
    
});
//小图片显示大图片


//单机某一行
//$("#table").on("click-row.bs.table",function(e,row, $element){
//	console.log($element.css("color","red"));
//});
//刷新按钮
//$("#table").on("refresh.bs.table",function(){
//	
//	alert("刷新");
//});
//在表格 body 渲染完成后触发。
$("#table").on("post-body.bs.table",function(){
//	alert("加载完成");
});
//在表格 body 渲染之前触发。
$("#table").on("pre-body.bs.table",function(){
//	alert("开始加载");
});
//点开详细视图的“+”号触发的事件
$("#table").on("expand-row.bs.table",function(index, row, $detail){
	alert("11");
});


//查看大图
$(document).on("click",".bigimg",function(){
	var tempsrcurl=$(this).attr("srcurl");
	layer.open({
		  type: 1,
		  title: false,
		  closeBtn: 0,
		  area: ['600px', '360px'],
		  skin: 'layui-layer-nobg', //没有背景色
		  shadeClose: true,
		  content: '<img src='+tempsrcurl+' />'
		});
});







//表格工具栏 bootstrap datepicker设置----------------------------------
var datepickerstart= $('#datetimepickerstart').datetimepicker({
		format:'yyyy-mm-dd HH:ii p',
	    weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
       showMeridian: 1,
       language:'zh-CN',
});
var datepickerend=$('#datetimepickerend').datetimepicker({
	format:'yyyy-mm-dd HH:ii p',
    weekStart: 1,
   todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	forceParse: 0,
   showMeridian: 1,
   language:'zh-CN',
});
$("#startremove").on("click",function(e){
	$('#datetimepickerstart').val("");
});
$("#endremove").on("click",function(e){
	$('#datetimepickerend').val("");
});
$("#starttime").on("click",function(e){
	datepickerstart.datetimepicker('show');
});
$("#endtime").on("click",function(e){
	datepickerend.datetimepicker('show');
});







/**
 * order_code
 * order_status
 * back_status
 * yd_code
 * bussiness_type
 * history
 * 
 * 
 */




















































