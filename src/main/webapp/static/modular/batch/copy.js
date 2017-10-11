$(function () {
	var id = $("#id").val();
	selectDetailById(id);
	var oFileInput_gem = new FileInput();
	oFileInput_gem.Init("gemfile", "/manage/geminfo/gem/fileUpload/0/");
    
    var oFileInput_logo = new FileInput_logo();
    oFileInput_logo.Init("logofile", "/manage/geminfo/gem/fileUpload/1/");
});

function selectDetailById(id) {
	var ajax = new $ax(Feng.ctxPath + "/geminfo/gem/detail", function (data) {
        if (data.data != null && data.data != undefined) {
        	$("#batchId").val(data.data.batchId);
        	$("#batchCode").val(data.data.batchCode);
        	$("#gemName").val(data.data.gemName);
        	$("#gemWeight").val(data.data.gemWeight);
        	$("#gemColour").val(data.data.gemColour);
        	$("#gemVibrance").val(data.data.gemVibrance);
        	$("#gemQuality").val(data.data.gemQuality);
        	$("#gemStamp").val(data.data.gemStamp);
        	$("#gemAssessmentTime").val(data.data.gemAssessmentTime);
        	$("#gemAccBody").val(data.data.gemAccBody);
        	$("#gemAccCode").val(data.data.gemAccCode);
        	$("#gemRemark").val(data.data.gemRemark);
        	$("#gemParamHue").val(data.data.gemParamHue);
        	$("#gemParamConcent").val(data.data.gemParamConcent);
        	$("#gemParamFinish").val(data.data.gemParamFinish);
        	$("#gemParamRemark").val(data.data.gemParamRemark);
        	if(data.data.gemImg != null && data.data.gemImg != ""){
        		$("#imgUrl").val(data.data.gemImg);
        		$("#imgDiv").prepend("<div class='left' align='left' style='float: left'><img id='imgInfo' src='/manage"+data.data.gemImg+"' style='max-height: 160px' class='' alt='Desert' title='Desert'></div>");
        	}
        	if(data.data.gemQrcodeB != null && data.data.gemQrcodeB != ""){
        		$("#logoimgUrl").val(data.data.gemQrcodeB);
        		$("#logoimgDiv").prepend("<div class='left' align='left' style='float: left'><img id='logoimgInfo' src='/manage"+data.data.gemQrcodeB+"' style='max-height: 160px' class='' alt='Desert' title='Desert'></div>");
        	}
        }
    }, function (data) {
        alert("查询详情失败");
    });
	ajax.set("id", id);
    ajax.start();
}

function openPrint(){
	window.open(Feng.ctxPath + "/geminfo/gem/draw?id="+$("#id").val());
}

function save(){
	var gemName = $("#gemName").val();
	var gemWeight = $("#gemWeight").val();
	var batchId = $("#batchId").val();
	var batchCode = $("#batchCode").val();
	var gemColour = $("#gemColour").val();
	var gemVibrance = $("#gemVibrance").val();
	var gemQuality = $("#gemQuality").val();
	var gemStamp = $("#gemStamp").val();
	var gemAssessmentTime = $("#gemAssessmentTime").val();
	var gemAccBody = $("#gemAccBody").val();
	var gemAccCode = $("#gemAccCode").val();
	var gemRemark = $("#gemRemark").val();
	var gemParamHue = $("#gemParamHue").val();
	var gemImg = $("#imgUrl").val();
	var gemQrcodeB = $("#logoimgUrl").val();
	var gemParamConcent = $("#gemParamConcent").val();
	var gemParamFinish = $("#gemParamFinish").val();
	var gemParamRemark = $("#gemParamRemark").val();
	var gemInfo = {"gemName":gemName,"gemWeight":gemWeight,"gemColour":gemColour,
			"gemVibrance":gemVibrance,"gemQuality":gemQuality,"gemStamp":gemStamp,"gemAssessmentTime":gemAssessmentTime,
			"gemAccBody":gemAccBody,"gemAccCode":gemAccCode,"gemRemark":gemRemark,
			"gemParamConcent":gemParamConcent,"gemParamHue":gemParamHue,"gemParamFinish":gemParamFinish,
			"gemParamRemark":gemParamRemark,"gemImg":gemImg,"gemQrcodeB":gemQrcodeB,"batchId":batchId,"batchCode":batchCode};
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
        	Feng.error("新增失败，请联系管理员");
        	closeWin();
        }
    });
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

//关闭弹出窗口
function closeWin() {
	parent.layer.closeAll();
}

// 放大图片
function amplifyImage() {
	$("#imageDialog").modal();
}
