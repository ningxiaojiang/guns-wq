/**
 * 产品管理管理初始化
 */
var Product = {
    id: "ProductTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Product.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '名称', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '产品类型', field: 'typeid', align: 'center', valign: 'middle', sortable: true},
        {title: '单价', field: 'price', align: 'center', valign: 'middle', sortable: true},
        {title: '包装方式', field: 'packagetype', align: 'center', valign: 'middle', sortable: true},
        {title: '包装数量', field: 'packagenumber', align: 'center', valign: 'middle', sortable: true},
        {title: '备注', field: 'remarks', align: 'center', valign: 'middle', sortable: true}
        ];
};

/**
 * 检查是否选中
 */
Product.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Product.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品管理
 */
Product.openAddProduct = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/product/product_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品管理详情
 */
Product.openProductDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/product/product_update/' + Product.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品管理
 */
Product.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/product/delete", function (data) {
            Feng.success("删除成功!");
            Product.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("productId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品管理列表
 */
Product.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Product.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Product.initColumn();
    var table = new BSTable(Product.id, "/product/list", defaultColunms);
    table.setPaginationType("client");
    Product.table = table.init();
});
