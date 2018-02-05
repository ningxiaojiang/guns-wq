/**
 * 库存管理管理初始化
 */
var Wq_stock = {
    id: "Wq_stockTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wq_stock.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Wq_stock.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wq_stock.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加库存管理
 */
Wq_stock.openAddWq_stock = function () {
    var index = layer.open({
        type: 2,
        title: '添加库存管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wq_stock/wq_stock_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看库存管理详情
 */
Wq_stock.openWq_stockDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '库存管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wq_stock/wq_stock_update/' + Wq_stock.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除库存管理
 */
Wq_stock.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wq_stock/delete", function (data) {
            Feng.success("删除成功!");
            Wq_stock.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wq_stockId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询库存管理列表
 */
Wq_stock.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wq_stock.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wq_stock.initColumn();
    var table = new BSTable(Wq_stock.id, "/wq_stock/list", defaultColunms);
    table.setPaginationType("client");
    Wq_stock.table = table.init();
});
