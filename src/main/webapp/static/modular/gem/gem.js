/**
 * 日志管理初始化
 */
var GemList = {
    id: "gemTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

GemList.batchPrint = function(){
	var selected = GemList.getSelected();
	if (selected == null || selected.length != 1) {
		Feng.info('请选择一条记录进行操作！');
	} else {
		var id = "";
		for(var i = 0 ; i < selected.length ; i++){
			id += selected[i].id + "|";
		}
		gemInfo = {"id" : id};
		$.ajax({
	        type: "POST",
	        url: Feng.ctxPath + "/geminfo/gem/batchPrint",
	        contentType: "application/json; charset=utf-8",
	        data: JSON.stringify(gemInfo),
	        dataType: "json",
	        success: function (message) {
	            if (message.code == "0") {
	            	Feng.success(message.msg);
	            }else {
	            	Feng.error("生成批量打印失败，连接超时");
	            }
	        },
	        error: function (message) {
	        	Feng.error("生成批量打印失败，连接超时");
	        	closeWin();
	        }
		});
	}
}

/**
 * 初始化表格的列
 */
GemList.initColumn = function () {
    return [
    	{field: 'selectItem', checkbox: true},
    	{title: '批次编号', field: 'batchCode', align: 'center', valign: 'middle', sortable: true},
    	{title: '宝石名称', field: 'gemName', align: 'center', valign: 'middle', sortable: true,
    		formatter: function (value, row, index) {
        		return GemList.getDetailLink(value,row);
        	}
    	},
    	{title: '报告编号', field: 'reportCode', align: 'center', valign: 'middle', sortable: true},
        {title: '宝石重量', field: 'gemWeight', align: 'center', valign: 'middle', sortable: true},
        {title: '宝石颜色', field: 'gemColour', align: 'center', valign: 'middle', sortable: true},
        {title: '宝石鲜艳度', field: 'gemVibrance', align: 'center', valign: 'middle', sortable: true},
        {title: '宝石浓度', field: 'gemParamConcent', align: 'center', valign: 'middle', sortable: true},
        {title: '宝石质量', field: 'gemQuality', align: 'center', valign: 'middle', sortable: true},
        {title: '评定日期', field: 'gemAssessmentTime', align: 'center', valign: 'middle', sortable: true}];
};

//返回获取用户详情链接
GemList.getDetailLink = function(value,row) {
	value = '<a onclick = GemList.toViewDetailPage("'+ row.id+'")>'+ value +'</a>'
	return value;
}

// 添加数据
GemList.add = function (code) {
	GemList.toAddPage(code);
} 

//编辑数据
GemList.edit = function () {
	var selected = GemList.getSelected();
	if (selected == null || selected.length != 1) {
		Feng.info('请选择一条记录进行操作！');
	} else {
		var id = selected[0].id;
		var index = layer.open({
	        type: 2,
	        title: '宝石编辑',
	        area: ['900px', '600px'], //宽高
	        fix: false, //不固定
	        maxmin: true,
	        content: Feng.ctxPath + '/geminfo/gem/viewDetail?id=' + id
	    });
	    this.layerIndex = index;
	}
} 

//编辑数据
GemList.copy = function () {
	var selected = GemList.getSelected();
	if (selected == null || selected.length != 1) {
		Feng.info('请选择一条记录进行操作！');
	} else {
		var id = selected[0].id;
		var index = layer.open({
	        type: 2,
	        title: '宝石编辑',
	        area: ['900px', '600px'], //宽高
	        fix: false, //不固定
	        maxmin: true,
	        content: Feng.ctxPath + '/geminfo/gem/copy?id=' + id
	    });
	    this.layerIndex = index;
	}
} 

//删除数据
GemList.batchRemove = function () {
	var selected = GemList.getSelected();
	if (selected == null) {
		Feng.info('请至少选择一条记录进行操作！');
	} else {
		var enterpriseIds = "";
		var enterpriseIdArray = [];
		for (var i = 0; i < selected.length; i++) {
			enterpriseIdArray.push(selected[i].ID);
		}
		if (enterpriseIdArray.length >0) {
			enterpriseIds = enterpriseIdArray.join(',');
			if (confirm("您确定要删除所选的记录吗?")){
				var ajax = new $ax(Feng.ctxPath + "/enterpriseManage/enterprise/batchRemove", function () {
			        Feng.success("操作成功!");
			        GemList.table.refresh();
			    }, function (data) {
			        Feng.error("操作失败!" + data.responseJSON.message + "!");
			        GemList.table.refresh();
			    });
				ajax.set("enterpriseIds", enterpriseIds);
			    ajax.start();
			}
		} else {
			Feng.info('删除失败，请至少选择一条记录进行操作！');
		}
	}
} 

/**
 * 点击查看用户详情
 */
GemList.toViewDetailPage = function (id) {
    var index = layer.open({
        type: 2,
        title: '宝石信息',
        area: ['900px', '600px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/geminfo/gem/viewDetail?id=' + id
    });
    this.layerIndex = index;
};

/**
 * 点击查看用户详情
 */
GemList.toAddPage = function (batchCode) {
    var index = layer.open({
        type: 2,
        title: '新增宝石',
        area: ['900px', '600px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/geminfo/gem/addPage?batchCode=' + batchCode
    });
    this.layerIndex = index;
};


/**
 * 检查是否选中
 */
GemList.getSelected = function () {
	var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        return null;
    } else {
        return selected;
    }
};



/**
 * 查询宝石列表
 */
GemList.search = function () {
    var queryData = {};

    queryData['batchCode'] = $("#batchCode").val();
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();

   GemList.table.refresh({query: queryData});
};

$(function () {

    init();
    var defaultColunms = GemList.initColumn();
    var table = new BSTable(GemList.id, "/geminfo/gem/list", defaultColunms);
    table.setPaginationType("server");
    GemList.table = table.init();
});

//初始化fileinput
var importExcel = function () {
    var oFile = new Object();

    //初始化fileinput控件（第一次初始化）
    oFile.Init = function(ctrlName, uploadUrl) {
    var control = $('#' + ctrlName);

    //初始化上传控件的样式
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        allowedFileExtensions: ['xls', 'xls','xlsx'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式     
        dropZoneEnabled: false,//是否显示拖拽区域
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
       alert(data.response);
    });
}
    return oFile;
};


function init() {

    var BootstrapTable = $.fn.bootstrapTable.Constructor;
    BootstrapTable.prototype.onSort = function (event) {
        var $this = event.type === "keypress" ? $(event.currentTarget) : $(event.currentTarget).parent(),
            $this_ = this.$header.find('th').eq($this.index()),
            sortName = this.header.sortNames[$this.index()];

        this.$header.add(this.$header_).find('span.order').remove();

        if (this.options.sortName === $this.data('field')) {
            this.options.sortOrder = this.options.sortOrder === 'asc' ? 'desc' : 'asc';
        } else {
            this.options.sortName = sortName || $this.data('field');
            this.options.sortOrder = $this.data('order') === 'asc' ? 'desc' : 'asc';
        }
        this.trigger('sort', this.options.sortName, this.options.sortOrder);

        $this.add($this_).data('order', this.options.sortOrder);

        // Assign the correct sortable arrow
        this.getCaret();

        if (this.options.sidePagination === 'server') {
            this.initServer(this.options.silentSort);
            return;
        }

        this.initSort();
        this.initBody();
    };
    BootstrapTable.prototype.getCaret = function () {
        var that = this;

        $.each(this.$header.find('th'), function (i, th) {
            var sortName = that.header.sortNames[i];
            $(th).find('.sortable').removeClass('desc asc').addClass((sortName || $(th).data('field')) === that.options.sortName ? that.options.sortOrder : 'both');
        });
    };
}
