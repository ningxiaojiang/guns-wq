/**
 * 配送管理管理初始化
 */
var Dispatching = {
    id: "DispatchingTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Dispatching.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '销售单号', field: 'salesno', align: 'center', valign: 'middle', sortable: true},
        {title: '配送单号', field: 'dispatchingno', align: 'center', valign: 'middle', sortable: true},
        {title: '销售员', field: 'staffid', align: 'center', valign: 'middle', sortable: true},
        {title: '配送员', field: 'staffids', align: 'center', valign: 'middle', sortable: true},
        {title: '客户', field: 'clientid', align: 'center', valign: 'middle', sortable: true},
        {title: '配送方式', field: 'dispatchingtype', align: 'center', valign: 'middle', sortable: true},
        {title: '配送时间', field: 'dispatchingtime', align: 'center', valign: 'middle', sortable: true},
        {title: '配送时间', field: 'dispatchingtime', align: 'center', valign: 'middle', sortable: true},
        {title: '发票', field: 'otherone', align: 'center', valign: 'middle', sortable: true},
        {title: '发票金额', field: 'othertwo', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'status', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Dispatching.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Dispatching.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加配送管理
 */
Dispatching.openAddDispatching = function () {
	if (this.check()) {
		var index = layer.open({
			type: 2,
			title: '添加配送管理',
			area: ['800px', '420px'], //宽高
			fix: false, //不固定
			maxmin: true,
			content: Feng.ctxPath + '/dispatching/dispatching_add/' + Dispatching.seItem.salesno
		});
		layer.full(index);
	}
};

/**
 * 打开查看配送管理详情
 */
Dispatching.openDispatchingDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '配送管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dispatching/dispatching_update/' + Dispatching.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除配送管理
 */
Dispatching.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/dispatching/delete", function (data) {
            Feng.success("删除成功!");
            Dispatching.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("dispatchingId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询配送管理列表
 */
Dispatching.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Dispatching.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Dispatching.initColumn();
    var table = new BSTable(Dispatching.id, "/dispatching/list", defaultColunms);
    table.setPaginationType("client");
    Dispatching.table = table.init();
});
