$(function () {
	var batchCode = $("#id").val();
	if(batchCode == 0){
		addBatch();
	}else{
		selectBatch();
	}
	
	$("#batchId").change(function(){
		var batchId = $(this).val().split("|")[0];
		var batchIdJson = {"id":batchId};
		$.ajax({
	        type: "POST",
	        url: Feng.ctxPath + "/geminfo/reportcode/queryByBatch",
	        contentType: "application/json; charset=utf-8",
	        data: JSON.stringify(batchIdJson),
	        dataType: "json",
	        success: function (message) {
	            if (message.code == "0") {
	            	var str = "";
	            	for(var i = 0 ; i < message.data.length ; i++){
	            		var html = "<option value="+ message.data[i].reportCode + ">"+message.data[i].reportCode+"</option>"
	            		str += html;
	            	}
	            	$("#reportCode").html(str);
	            }else {
	            	Feng.error("失败，请联系管理员");
	            }
	        },
	        error: function (message) {
	        	Feng.error("失败，请联系管理员");
	        	closeWin();
	        }
	    });
	})
    
    var oFileInput_logo = new FileInput_logo();
    oFileInput_logo.Init("logofile", "/manage/geminfo/gem/fileUpload/1/");
    
    
});

function findKey(){
	var keyA = $("#keyA").val();
	var keyB = $("#keyB").val();
	var key = keyA + "_" + keyB;
	var keyJson = {"parmKey":key};
	$.ajax({
        type: "POST",
        url: Feng.ctxPath + "/geminfo/gemParmKey/queryByKey",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(keyJson),
        dataType: "json",
        success: function (message) {
            if (message.code == "0") {
            	$("#gemColour").val(message.data.gemColour);
            	$("#gemVibrance").val(message.data.gemVibrance);
            	$("#gemParamHue").val(message.data.gemParamHue);
            	$("#gemParamConcent").val(message.data.gemParamConcent);
            	$("#gemParamFinish").val(message.data.gemParamFinish);
            	$("#gemColourImg").val(message.data.gemImg);
            }else {
            	Feng.error("失败，请联系管理员");
            }
        },
        error: function (message) {
        	Feng.error("失败，请联系管理员");
        	closeWin();
        }
    });
}

function findByHcKey(){
	var hcKey = $("#hcKey").val();
	var keyJson = {"hcKey":hcKey};
	$.ajax({
        type: "POST",
        url: Feng.ctxPath + "/geminfo/gemHc/queryByKey",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(keyJson),
        dataType: "json",
        success: function (message) {
            if (message.code == "0") {
            	$("#gemQuality").val(message.data.hcName);
            	$("#gemHcImg").val(message.data.hcImg);
            }else {
            	Feng.error("失败，请联系管理员");
            }
        },
        error: function (message) {
        	Feng.error("失败，请联系管理员");
        	closeWin();
        }
    });
}


//关闭弹出窗口
function closeWin(){
	parent.layer.closeAll();
}

function selectBatch(){
	$.ajax({
        type: "POST",
        url: Feng.ctxPath + "/geminfo/batch/queryAll",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(),
        dataType: "json",
        success: function (message) {
            if (message.code == "0") {
            	var str = "";
            	for(var i = 0 ; i < message.data.length ; i++){
            		var html = "<option value="+ message.data[i].id + "|" + message.data[i].batchCode +">"+message.data[i].batchCode+"</option>"
            		str += html;
            	}
            	$("#batchId").html(str);
            }else {
            	Feng.error("新增失败，请联系管理员");
            }
        },
        error: function (message) {
        	Feng.error("新增失败，请联系管理员");
        	closeWin();
        }
    });
}

//保存企业信息
function addBatch(){
	$.ajax({
        type: "POST",
        url: Feng.ctxPath + "/geminfo/batch/add",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(),
        dataType: "json",
        success: function (message) {
            if (message.code == "0") {
            	$("#batch").val(message.data.batchCode);
            	$("#batchId").val(message.data.id);
            }else {
            	Feng.error("新增失败，请联系管理员");
            }
        },
        error: function (message) {
        	Feng.error("新增失败，请联系管理员");
        	closeWin();
        }
    });
}


//保存企业信息
function save(){
	var gemName = $("#gemName").val();
	var batchId = $("#batchId").val();
	var batchCode = "";
	if(batchId.indexOf("|") > 0){
		batchCode = batchId.split("|")[1];
		batchId = batchId.split("|")[0];
	}else{
		batchCode = $("#batch").val();
	}
	var reportCode = $("#reportCode").val();
	var gemWeight = $("#gemWeight").val()+$("#unit").val();
	var gemColour = $("#gemColour").val();
	var gemVibrance = $("#gemVibrance").val();
	var gemQuality = $("#gemQuality").val();
	var gemStamp = $("#gemStamp").val();
	var gemAssessmentTime = $("#gemAssessmentTime").val();
	var gemAccBody = $("#gemAccBody").val();
	var gemAccCode = $("#gemAccCode").val();
	var gemRemark = $("#gemRemark").val();
	var gemImg = $("#imgUrl").val();
	var gemQrcodeB = $("#logoimgUrl").val();
	var gemParamHue = $("#gemParamHue").val();
	var gemParamConcent = $("#gemParamConcent").val();
	var gemParamFinish = $("#gemParamFinish").val();
	var gemParamRemark = $("#gemParamRemark").val();
	var gemParamImg1 = $("#gemColourImg").val();
	var gemParamImg2 = $("#gemHcImg").val();
	if(gemParamImg1 == "" || gemParamImg1 == null || gemParamImg1 == undefined){
		Feng.error("宝石参数未设置，请先输入快捷键设置宝石参数！");
		return;
	}
	if(gemParamImg2 == "" || gemParamImg2 == null || gemParamImg2 == undefined){
		Feng.error("宝石质量信息未设置，请先输入快捷键设置宝石质量信息！");
		return;
	}
	var gemInfo = {"reportCode":reportCode,"gemName":gemName,"batchId":batchId,"batchCode":batchCode,"gemWeight":gemWeight,"gemColour":gemColour,
			"gemVibrance":gemVibrance,"gemQuality":gemQuality,"gemStamp":gemStamp,"gemAssessmentTime":gemAssessmentTime,
			"gemAccBody":gemAccBody,"gemAccCode":gemAccCode,"gemRemark":gemRemark,
			"gemParamConcent":gemParamConcent,"gemParamHue":gemParamHue,"gemParamFinish":gemParamFinish,
			"gemParamRemark":gemParamRemark,"gemImg":gemImg,"gemQrcodeB":gemQrcodeB,"gemParamImg1":gemParamImg1,
			"gemParamImg2":gemParamImg2};
	$.ajax({
        type: "POST",
        url: Feng.ctxPath + "/geminfo/gem/add",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(gemInfo),
        dataType: "json",
        success: function (message) {
            if (message.code == "0") {
            	Feng.success("新增成功!");
            }else {
            	Feng.error("新增失败，请联系管理员");
            }
        },
        error: function (message) {
        	Feng.error(message.msg);
        }
    });
}

// 放大图片
function amplifyImage() {
	$("#imageDialog").modal();
}

//如果去掉复选框则删除行业
function removeLi(obj) {
	$(obj).parent().parent().remove();
}

//关闭弹出窗口
function closeWin() {
	parent.layer.closeAll();
}

/**
 * 详情对话框（可用于添加和修改对话框）
 */
var IndustryDlg = {
    industryData: {},
    zTreeInstance : null
};


/**
 * 隐藏选择的树
 */
IndustryDlg.hideSelectTree = function() {
    $("#parentMenu").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown); // mousedown当鼠标按下就可以触发，不用弹起
}



function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "parentMenu" || $(
            event.target).parents("#parentMenu").length > 0)) {
        IndustryDlg.hideSelectTree();
    }
}

//初始化fileinput
var FileInput = function () {
    var oFile = new Object();

    //初始化fileinput控件（第一次初始化）
    oFile.Init = function(ctrlName, uploadUrl) {
    var control = $('#' + ctrlName);

    //初始化上传控件的样式
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式     
        //dropZoneEnabled: false,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    }).on("fileuploaded", function (event, data, previewId, index) {
        var data = data.response.data;
        if (data == undefined) {
            toastr.error('文件格式类型不正确');
            return;
        }
        if($("#imgUrl").val() == '' || $("#imgUrl").val() == null){
        	$("#imgDiv").prepend("<div class='left' align='left' style='float: left'><img id='imgInfo' src='/manage"+data+"' style='max-height: 160px' class='' alt='Desert' title='Desert'></div>");
        }else{
        	$("#imgInfo").attr("src",data);
        }

        $("#imgUpload").hide();
        $("#imgUrl").val(data)
        
    });
}
    return oFile;
};

//初始化fileinput
var FileInput_logo = function () {
    var oFile = new Object();

    //初始化fileinput控件（第一次初始化）
    oFile.Init = function(ctrlName, uploadUrl) {
    var control = $('#' + ctrlName);

    //初始化上传控件的样式
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式     
        //dropZoneEnabled: false,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    }).on("fileuploaded", function (event, data, previewId, index) {
        var data = data.response.data;
        if (data == undefined) {
            toastr.error('文件格式类型不正确');
            return;
        }
        if($("#logoimgUrl").val() == '' || $("#imgUrl").val() == null){
        	$("#logoimgDiv").prepend("<div class='left' align='left' style='float: left'><img id='logoimgInfo' src='/manage"+data+"' style='max-height: 160px' class='' alt='Desert' title='Desert'></div>");
        }else{
        	$("#logoimgInfo").attr("src",data);
        }

        $("#logoimgUpload").hide();
        $("#logoimgUrl").val(data)
        
    });
}
    return oFile;
};

$(function () {
    
});

