/**
 * 库存管理管理初始化
 */
var Stock = {
    id: "StockTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Stock.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '产品', field: 'productid', align: 'center', valign: 'middle', sortable: true},
        {title: '数量', field: 'number', align: 'center', valign: 'middle', sortable: true},
        {title: '更新日期', field: 'updatetime', align: 'center', valign: 'middle', sortable: true},
        {title: '备注', field: 'otherone', align: 'center', valign: 'middle', sortable: true}
        ];
};

/**
 * 检查是否选中
 */
Stock.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Stock.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加库存管理
 */
Stock.openAddStock = function () {
    var index = layer.open({
        type: 2,
        title: '添加库存管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/stock/stock_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看库存管理详情
 */
Stock.openStockDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '库存管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/stock/stock_update/' + Stock.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除库存管理
 */
Stock.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/stock/delete", function (data) {
            Feng.success("删除成功!");
            Stock.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("stockId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询库存管理列表
 */
Stock.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Stock.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Stock.initColumn();
    var table = new BSTable(Stock.id, "/stock/list", defaultColunms);
    table.setPaginationType("client");
    Stock.table = table.init();
});
