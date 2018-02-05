/**
 * 销售管理管理初始化
 */
var Sales = {
    id: "SalesTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Sales.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Sales.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Sales.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加销售管理
 */
Sales.openAddSales = function () {
    var index = layer.open({
        type: 2,
        title: '添加销售管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sales/sales_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看销售管理详情
 */
Sales.openSalesDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '销售管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sales/sales_update/' + Sales.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除销售管理
 */
Sales.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sales/delete", function (data) {
            Feng.success("删除成功!");
            Sales.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("salesId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询销售管理列表
 */
Sales.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Sales.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Sales.initColumn();
    var table = new BSTable(Sales.id, "/sales/list", defaultColunms);
    table.setPaginationType("client");
    Sales.table = table.init();
});
