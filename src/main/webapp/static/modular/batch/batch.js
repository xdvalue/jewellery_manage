/**
 * 日志管理初始化
 */
var BatchList = {
    id: "batchTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
BatchList.initColumn = function () {
    return [
    	{field: 'selectItem', checkbox: true},
    	{title: '批次编码', field: 'batchCode', align: 'center', valign: 'middle', sortable: true,
    		formatter: function (value, row, index) {
        		return BatchList.getDetailLink(value,row);
        	}},
    	{title: '委托方名称', field: 'clientName', align: 'center', valign: 'middle', sortable: true},
    	{title: '样品数量', field: 'gemNum', align: 'center', valign: 'middle', sortable: true},
        {title: '采用标准', field: 'standardName', align: 'center', valign: 'middle', sortable: true},
        {title: '送检时间', field: 'inspectionTime', align: 'center', valign: 'middle', sortable: true},
        {title: '取样时间', field: 'samplingTime', align: 'center', valign: 'middle', sortable: true},
        {title: '委托方联系电话', field: 'clientPhone', align: 'center', valign: 'middle', sortable: true}];
};

//返回获取用户详情链接
BatchList.getDetailLink = function(value,row) {
	value = '<a onclick = BatchList.toViewDetailPage("'+ row.id+'")>'+ value +'</a>'
	return value;
}

// 添加数据
BatchList.add = function (code) {
	BatchList.toAddPage(code);
} 

//编辑数据
BatchList.edit = function () {
	var selected = BatchList.getSelected();
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
	        content: Feng.ctxPath + '/geminfo/batch/viewDetail?id=' + id
	    });
	    this.layerIndex = index;
	}
} 


/**
 * 点击查看用户详情
 */
BatchList.toViewDetailPage = function (id) {
	window.open(Feng.ctxPath + "/geminfo/batch/print?id="+id);
};

/**
 * 点击查看用户详情
 */
BatchList.toAddPage = function (batchCode) {
    var index = layer.open({
        type: 2,
        title: '新增批次',
        area: ['900px', '600px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/geminfo/batch/addPage?batchCode=' + batchCode
    });
    this.layerIndex = index;
};


/**
 * 检查是否选中
 */
BatchList.getSelected = function () {
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
BatchList.search = function () {
    var queryData = {};

    queryData['batchCode'] = $("#batchCode").val();
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();

   BatchList.table.refresh({query: queryData});
};

$(function () {

    init();
    var defaultColunms = BatchList.initColumn();
    var table = new BSTable(BatchList.id, "/geminfo/batch/list", defaultColunms);
    table.setPaginationType("server");
    BatchList.table = table.init();
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
