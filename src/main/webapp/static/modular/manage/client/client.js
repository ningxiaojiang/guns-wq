/**
 * 产品类型管理管理初始化
 */
var Client = {
    id: "ClientTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Client.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '年龄', field: 'age', align: 'center', valign: 'middle', sortable: true},
        {title: '性别', field: 'sexName', align: 'center', valign: 'middle', sortable: true},
        {title: '籍贯', field: 'nativplace', align: 'center', valign: 'middle', sortable: true},
        {title: '公司', field: 'dt', align: 'center', valign: 'middle', sortable: true},
        {title: '职位', field: 'othertwo', align: 'center', valign: 'middle', sortable: true},
        {title: '电话', field: 'tel', align: 'center', valign: 'middle', sortable: true},
        {title: '手机', field: 'phone', align: 'center', valign: 'middle', sortable: true},
        {title: '住址', field: 'otherone', align: 'center', valign: 'middle', sortable: true},
        {title: '生日', field: 'brithday', align: 'center', valign: 'middle', sortable: true},
        {title: '备注', field: 'remearks', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Client.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Client.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加产品类型管理
 */
Client.openAddClient = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品类型管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/client/client_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看产品类型管理详情
 */
Client.openClientDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '产品类型管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/client/client_update/' + Client.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品类型管理
 */
Client.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/client/delete", function (data) {
            Feng.success("删除成功!");
            Client.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("clientId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询产品类型管理列表
 */
Client.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Client.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Client.initColumn();
    var table = new BSTable(Client.id, "/client/list", defaultColunms);
    table.setPaginationType("client");
    Client.table = table.init();
});
