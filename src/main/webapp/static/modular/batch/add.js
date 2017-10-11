$(function () {
	var batchCode = $("#id").val();
});


//关闭弹出窗口
function closeWin(){
	parent.layer.closeAll();
}

//保存企业信息
function save(){
	var batchRemarl = $("#batchRemarl").val();
	var clientName = $("#clientName").val();
	var clientPhone = $("#clientPhone").val();
	var gemNum = $("#gemNum").val();
	var inspectionTime = $("#inspectionTime").val();
	var samplingTime = $("#samplingTime").val();
	var standardName = $("#standardName").val();
	var receivedPhone = $("#receivedPhone").val();
	var clientAsk = $("#clientAsk").val();
	var batchInfo = {"batchRemarl":batchRemarl,"clientName":clientName,"clientPhone":clientPhone,
			"gemNum":gemNum,"inspectionTime":inspectionTime,"samplingTime":samplingTime,"standardName":standardName,
			"receivedPhone":receivedPhone,"clientAsk":clientAsk};
	$.ajax({
        type: "POST",
        url: Feng.ctxPath + "/geminfo/batch/add",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(batchInfo),
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

// 放大图片
function amplifyImage() {
	$("#imageDialog").modal();
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




function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "parentMenu" || $(
            event.target).parents("#parentMenu").length > 0)) {
        IndustryDlg.hideSelectTree();
    }
}

