/**
 * 产品类型管理管理初始化
 */
var ProductType = {
    id: "ProductTypeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProductType.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '类型', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '备注', field: 'remarks', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
ProductType.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ProductType.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品类型管理
 */
ProductType.openAddProductType = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品类型管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/productType/productType_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品类型管理详情
 */
ProductType.openProductTypeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品类型管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/productType/productType_update/' + ProductType.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品类型管理
 */
ProductType.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/productType/delete", function (data) {
            Feng.success("删除成功!");
            ProductType.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productTypeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品类型管理列表
 */
ProductType.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ProductType.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ProductType.initColumn();
    var table = new BSTable(ProductType.id, "/productType/list", defaultColunms);
    table.setPaginationType("client");
    ProductType.table = table.init();
});
