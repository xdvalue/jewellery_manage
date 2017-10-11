$(function () {
	var id = $("#id").val();
	selectDetailById(id);
	initEntImageUpload();
	initBlImageUpload();
});

// 初始化企业图片上传插件
function initEntImageUpload(){ 
	// 具体参数自行查询 
	$('#uploadEntImage').fileinput({ 
		uploadUrl: Feng.ctxPath + '/common/oss/fileUpload/1', 
		uploadAsync:true, 
		showCaption: true, 
		showUpload: true,//是否显示上传按钮 
		showRemove: false,//是否显示删除按钮 
		showCaption: true,//是否显示输入框 
		showPreview:true, 
		showCancel:true, 
		dropZoneEnabled: false, 
		maxFileCount: 1, 
		validateInitialCount:true,
		initialPreviewShowDelete:true, 
		msgFilesTooMany: "选择上传的文件数量 超过允许的最大数值！", 
		previewFileIcon: '<i class="fa fa-file"></i>', 
		allowedPreviewTypes: ['image'], 
		}).off('filepreupload').on('filepreupload', function() { 
			var entImageDiv = $("#enterpriseImages").nextAll("div[name='entImage']");
			if (entImageDiv != undefined && entImageDiv.length > 6) {
				Feng.error("最多只能上传6张图片");
				return false;
			}
		}).on("fileuploaded", function(event, data) { 
			//文件上传成功后返回的数据， 将返回的url地址展示到企业图片区展示
			var data = data.response;
			if (data != null && data.length > 0) {
				var imageId = data[0].id;
				var imageUrl = data[0].attachmentKey;
				var imageHtml = '<div class="col-sm-4 col-md-3" name="entImage" ondblclick="removeImage(this,\'uploadEntImageDiv\')">'+
								    '<a onclick="amplifyImage()" class="thumbnail" name="entImage" style="height:150px;">'+
							        	'<img src="' + imageUrl + '" title="双击删除" value="'+ imageId +'" style="height:100%">'+
							        '</a>'+
							    '</div>';
				$("#uploadEntImageDiv").before(imageHtml);
				var entImageDiv = $("#enterpriseImages").nextAll("div[name='entImage']");
				if (entImageDiv != undefined && entImageDiv.length > 5) {
					$("#uploadEntImageDiv").hide();
				}
			}
	}); 
}

//初始化营业执照图片上传插件
function initBlImageUpload(){ 
	// 具体参数自行查询 
	$('#uploadBlImage').fileinput({ 
		uploadUrl: Feng.ctxPath + '/common/oss/fileUpload/1', 
		uploadAsync:true, 
		showCaption: true, 
		showUpload: true,//是否显示上传按钮 
		showRemove: false,//是否显示删除按钮 
		showCaption: true,//是否显示输入框 
		showPreview:true, 
		showCancel:true, 
		dropZoneEnabled: false, 
		maxFileCount: 1, 
		validateInitialCount:true,
		initialPreviewShowDelete:true, 
		msgFilesTooMany: "选择上传的文件数量 超过允许的最大数值！", 
		previewFileIcon: '<i class="fa fa-file"></i>', 
		allowedPreviewTypes: ['image'], 
		}).off('filepreupload').on('filepreupload', function() { 
			var blImageDiv = $("#businessLicense").nextAll("div[name='blImage']");
			if (blImageDiv != undefined && blImageDiv.length > 0) {
				Feng.error("最多只能上传1张图片");
				return false;
			}
		}).on("fileuploaded", function(event, data) { 
			//文件上传成功后返回的数据， 将返回的url地址展示到企业图片区展示
			var data = data.response;
			if (data != null && data.length > 0) {
				var imageUrl = data[0].attachmentKey;
				var imageId = data[0];
				var imageHtml = '<div class="col-sm-4 col-md-3" name="blImage" ondblclick="removeImage(this,\'uploadBlImageDiv\')">'+
								    '<a onclick="amplifyImage()" class="thumbnail" style="height:150px;">'+
							        	'<img src="' + imageUrl + '" title="双击删除" value="'+ imageId +'" style="height:100%">'+
							        '</a>'+
							    '</div>';
				$("#uploadBlImageDiv").before(imageHtml);
				$("#uploadBlImageDiv").hide();
			}
	}); 
}

//双击图片删除
function removeImage(obj,divFlag) {
	$(obj).remove();
	$("#" + divFlag).show();
}

//关闭弹出窗口
function closeWin(){
	parent.layer.closeAll();
}


function selectDetailById(id) {
	var ajax = new $ax(Feng.ctxPath + "/enterpriseManage/enterprise/selectDetailById", function (data) {
        if (data != null && data != undefined) {
        	$("#registeredNum").val(data.registeredNum);
        	$("#contactName").val(data.contactName);
        	$("#legalPerson").val(data.legalPerson);
        	$("#mobile").val(data.mobile);
        	$("#companyProperty").val(data.companyProperty);
        	$("#website").val(data.website);
        	$("#companyScale").val(data.companyScale);
        	$("#companyAddress").val(data.companyAddress);
        	// 行业回写
        	var industrys = data.industrys;
        	if (industrys != null && industrys.length >0) {
        		var liHtml = "";
        		for (var i = 0; i < industrys.length; i++) {
        			liHtml = liHtml + '<li><span><input name="industry" type="checkbox" value="'+ industrys[i].id +'" checked onclick="removeLi(this)"/><span>'+ industrys[i].industryName +'</span></span></li>';
        		}
        		$("#industrysUl").append(liHtml);
        	}
        	$("#societyCode").val(data.societyCode);
        	$("#establishDate").val(data.establishDate);
        	$("#orgCode").val(data.orgCode);
        	$("#operatingPeriod").val(data.operatingPeriod);
        	$("#operateStatus").val(data.operateStatus);
        	$("#registrationAuthority").val(data.registrationAuthority);
        	$("#registeredCapital").val(data.registeredCapital);
        	$("#registeredAddress").val(data.registeredAddress);
        	$("#businessScope").val(data.businessScope);
        	$("#companyIntro").val(data.companyIntro);
        	// 企业图片展示
        	var entImages = data.entImages;
        	var entImagesHtml = "";
        	if (entImages != null && entImages.length >0) {
        		if (entImages.length > 5) {
        			// 如果图片超过6张，则隐藏上传插件
        			$("#uploadEntImageDiv").hide();
        		}
        		for (var i = 0; i < entImages.length; i++) {
        			entImagesHtml = entImagesHtml + '<div class="col-sm-4 col-md-3" name="entImage" ondblclick="removeImage(this,\'uploadEntImageDiv\')">'+
												        '<a onclick="amplifyImage()" class="thumbnail" style="height:150px;">'+
												            '<img src="' + entImages[i].fileUrl + '" title="双击删除" value="'+ entImages[i].fileId +'" style="height:100%">'+
												        '</a>'+
												    '</div>';
        		}
        	} else {
        		//entImagesHtml = '<div class="col-sm-12 col-md-3">暂无图片</div>';
        	}
        	$("#enterpriseImages").after(entImagesHtml);
        	// 营业执照图片展示
        	var businessLicenseHtml ="";
        	if ($.trim(data.businessLicenseUrl) != "") {
        		$("#uploadBlImageDiv").hide();
        		businessLicenseHtml = '<div class="col-sm-4 col-md-3" name="blImage" ondblclick="removeImage(this,\'uploadBlImageDiv\')">'+
									        '<a onclick="amplifyImage()" class="thumbnail" style="height:150px;">'+
								            	'<img src="' + data.businessLicenseUrl + '" title="双击删除" style="height:100%">'+
								            '</a>'+
								      '</div>';
        	} else {
        		//businessLicenseHtml = "暂无图片";
        	}
        	$("#businessLicense").after(businessLicenseHtml);
        }
    }, function (data) {
        alert("查询企业详情失败");
    });
	ajax.set("id", id);
    ajax.start();
}

//保存企业信息
function save(){
	var id = $("#id").val();
	// 获取企业图片url地址
	var entImagesLabel = $("#enterpriseImages").nextAll("div[name='entImage']");
	var entImages = [];
	if (entImagesLabel != null && entImagesLabel.length > 0) {
		for (var i = 0; i < entImagesLabel.length; i++) {
			var imageId = $(entImagesLabel[i]).find("img").attr("value");
			var imageUrl = $(entImagesLabel[i]).find("img").attr("src");
			entImages.push({"fileId":imageId,"fileUrl":imageUrl});
		}
	}
	// 获取营业执照url地址
	var businessLicenseLabel = $("#businessLicense").nextAll("div[name='blImage']");
	var businessLicenseUrl = "";
	if (businessLicenseLabel != null && businessLicenseLabel.length > 0) {
		businessLicenseUrl = $(businessLicenseLabel[0]).find("img").attr("src");
	}
	// 获取行业
	var industrysLabel = $("#industrysUl").find("li :checkbox:checked");
	var industrys = [];
	if (industrysLabel.length > 0) {
		for (var i = 0; i < industrysLabel.length; i++) {
			var industryId = $(industrysLabel[i]).val();
			industrys.push({"id":industryId});
		}
	}
	var registeredNum = $("#registeredNum").val();
	var contactName = $("#contactName").val();
	var legalPerson = $("#legalPerson").val();
	var mobile = $("#mobile").val();
	var companyProperty = $("#companyProperty").val();
	var website = $("#website").val();
	var companyScale = $("#companyScale").val();
	var companyAddress = $("#companyAddress").val();
	var societyCode = $("#societyCode").val();
	var establishDate = $("#establishDate").val();
	var orgCode = $("#orgCode").val();
	var operatingPeriod = $("#operatingPeriod").val();
	var operateStatus = $("#operateStatus").val();
	var registrationAuthority = $("#registrationAuthority").val();
	var registeredCapital = $("#registeredCapital").val();
	var registeredAddress = $("#registeredAddress").val();
	var businessScope = $("#businessScope").val();
	var companyIntro = $("#companyIntro").val();
	var enterpriseManage = {"id":id,"registeredNum":registeredNum,"contactName":contactName,"legalPerson":legalPerson,
			"mobile":mobile,"companyProperty":companyProperty,"website":website,"companyScale":companyScale,
			"companyAddress":companyAddress,"societyCode":societyCode,"establishDate":establishDate,
			"orgCode":orgCode,"operatingPeriod":operatingPeriod,"operateStatus":operateStatus,
			"registrationAuthority":registrationAuthority,"registeredCapital":registeredCapital,"registeredAddress":registeredAddress,
			"businessScope":businessScope,"companyIntro":companyIntro,"businessLicenseUrl":businessLicenseUrl};
	var enterpriseVo = {"enterpriseManage":enterpriseManage,"entImages":entImages,"industrys":industrys};
	$.ajax({
        type: "POST",
        url: Feng.ctxPath + "/enterpriseManage/enterprise/updateEnterpriseById",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(enterpriseVo),
        dataType: "json",
        success: function (message) {
            if (message > 0) {
            	Feng.success("编辑成功!");
            }else {
            	Feng.error("编辑失败，请联系管理员");
            }
            parent.EnterpriseList.search();
            closeWin();
        },
        error: function (message) {
        	Feng.error("编辑失败，请联系管理员");
        	closeWin();
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

/**
 * 详情对话框（可用于添加和修改对话框）
 */
var IndustryDlg = {
    industryData: {},
    zTreeInstance : null
};

/**
 * 显示选择的树
 *
 * @returns
 */
IndustryDlg.showSelectTree = function() {
    var pName = $("#pName");
    var pNameOffset = $("#pName").offset();
    $("#parentMenu").css({
        left : pNameOffset.left + "px",
        top : pNameOffset.top + pName.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
}

/**
 * 隐藏选择的树
 */
IndustryDlg.hideSelectTree = function() {
    $("#parentMenu").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown); // mousedown当鼠标按下就可以触发，不用弹起
}

/**
 * 点击ztree列表的选项时
 *
 * @param e
 * @param treeId
 * @param treeNode
 * @returns
 */
IndustryDlg.onClickIndustry = function(e, treeId, treeNode) {
	var industryId = treeNode.id;
	var industryName = IndustryDlg.zTreeInstance.getSelectedVal();
	var existIndustyLi = $("#industrysUl").find("li");
	if (existIndustyLi != undefined && existIndustyLi.length >0) {
		//如果未存在该行业，则选中
		var ifExistLi = $(existIndustyLi).find(":checkbox[value='"+ industryId +"']");
		if (ifExistLi.length == 0) {
			var liHtml = '<li><span><input name="industry" type="checkbox" value="'+ industryId +'" checked onclick="removeLi(this)"/><span>'+ industryName +'</span></span></li>';
			$(existIndustyLi).last().after(liHtml);
		}
	} else {
		var liHtml = '<li><span><input name="industry" type="checkbox" value="'+ industryId +'" checked onclick="removeLi(this)"/><span>'+ industryName +'</span></span></li>';
		$("#industrysUl").append(liHtml);
	}
	
}

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "parentMenu" || $(
            event.target).parents("#parentMenu").length > 0)) {
        IndustryDlg.hideSelectTree();
    }
}

$(function () {
    
    var ztree = new $ZTree("parentMenuTree", "/baseinfo/industry/tree");
    ztree.bindOnClick(IndustryDlg.onClickIndustry);
    ztree.init();
    IndustryDlg.zTreeInstance = ztree;
});

