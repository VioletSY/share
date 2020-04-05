var isNull = function(val){
	if(val){
		if(val == "" || val == null || val == "null" || val == undefined || val == "undefined")
			return true;
		else
			return false;
	}
	else{
		return true;
	}
};
var noNull = function(val){
	return !isNull(val);
};
var isNullToDefaultString = function(val,def){
	if(val){
		if(val == "" || val == null || val == "null" || val == undefined || val == "undefined")
			return def;
		else
			return val;
	}
	else{
		return def;
	}
};
/*********************************************jQuery  load  封装  2017-11-8 13:58:34wdm***************************************************************/
function jload(object,url,data,$layer,loadingStyle){
	var index;
	if(isNull(loadingStyle)){
		loadingStyle={shade: [0.5,'#EAEDF1'] };
	}
//	$.ajaxSetup({cache: false,
//		beforeSend:function(){
//			index = $layer.load(1,loadingStyle);
//		},
//		complete:function(){
//			$layer.close(index);
//		}
//	});//禁用缓存
	$(object).off().html('');//清空  off防止 动态绑定的js脚本重复加载
	$.ajax({
		cache: false,
		type:"post",
		url:url,
		data:data,
		success:function(val){
			$(object).html(val);
		},
		error:function(val){
			$layer.alert("页面加载失败,请刷新页面重新尝试!","E");
		},
		beforeSend:function(val){
			index = $layer.load(2,loadingStyle);
		},
		complete:function(){
			$layer.close(index);
		}
	});
//	$(object).load(url,data,function(responseTxt,statusTxt,xhr){
//		if(statusTxt=="success"){
//			callback();
//		}else{
//			$layer.alert("页面加载失败,请刷新页面重新尝试!","E");
//		}
//	});
}
//ajax请求后台数据 执行相关操作
function getData(_data,_url,_success,_contentType,_errorText){
	_contentType=isNull(_contentType)?'application/x-www-form-urlencoded; charset=UTF-8':_contentType;
	var index;
	$.ajax({
		type:"post",
		url:_url,
		data:_data,
		contentType:_contentType,
		dataType:'json',
		success:function(val){
			if(noNull(_success)){
				_success(val);
			}
		},
		error:function(val){
			_errorText=isNull(_errorText)?"系统繁忙,请稍候重试！！":_errorText;
			layer.alert(_errorText, {icon:5});
		},
		beforeSend:function(val){
//			index = $layer.load(1, {
//				  shade: [0.5,'#E5F7FE'] 
//			});
			index = layer.load(2);
		},
		complete:function(){
			layer.close(index);
		}
	});
}
//ajax请求后台数据 执行相关操作
function getDataNoLoad(_data,_url,_success,_contentType,_errorText){
	_contentType=isNull(_contentType)?'application/x-www-form-urlencoded; charset=UTF-8':_contentType;
	var index;
	$.ajax({
		type:"post",
		url:_url,
		data:_data,
		contentType:_contentType,
		dataType:'json',
		success:function(val){
			if(noNull(_success)){
				_success(val);
			}
		},
		error:function(val){
		},
		beforeSend:function(val){
		},
		complete:function(){
		}
	});
}
//ajax请求后台数据 执行相关操作
function getDataNoloading(_data,_url,_success,$layer,_contentType,_errorText){
	_contentType=isNull(_contentType)?'application/x-www-form-urlencoded; charset=UTF-8':_contentType;
	$.ajax({
		type:"post",
		url:_url,
		data:_data,
		contentType:_contentType,
		dataType:'json',
		success:function(val){
			if(noNull(_success)){
				_success(val);
			}
		},
		error:function(val){
			_errorText=isNull(_errorText)?"系统繁忙,请稍候重试!!":_errorText;
			$layer.alert(_errorText, {icon:5});
		}
	});
}
//系统登出
function signout($ctx,$layer){
	$layer.open({
		  layer:1,
		  content: '<div class="message-box"><div class="mb-container"><div class="mb-middle">'+
			                  '<div class="mb-title"><span class="fa fa-sign-out"></span>退出登录</div>'+
			                  '<div class="mb-content"><p style="letter-spacing: 2px;">您确定要注销当前登录用户吗？</p></div>'+
			                  '<div class="mb-footer">'+
			                      '<div class="pull-right">'+
			                         ' <a href="'+$ctx+'/index/logout" class="layui-btn layui-btn-normal">注销</a>'+
			                         ' <button class="layui-btn layui-btn-primary btn-close"  data-dismiss="modal">返回</button>'+
			                     ' </div>'+
			                  '</div></div></div></div>',
		  area: '100%',
		  title: false,
		  btn:false,
		  closeBtn: 0,
		  id:"layer-signout",
		  shade: [0.85,'#000'] ,
//		  shadeClose:true,
		  anim:6,
		  scrollbar :false,
		  success:function(layero,index){
			  $("#layer-signout").on("click",".btn-close",function(){
				  $layer.close(index);
			  });
		  }
		});
}

