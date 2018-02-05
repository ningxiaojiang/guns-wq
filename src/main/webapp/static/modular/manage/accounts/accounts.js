/**
 * 结算管理管理初始化
 */
var Accounts = {
    id: "AccountsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Accounts.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Accounts.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Accounts.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加结算管理
 */
Accounts.openAddAccounts = function () {
    var index = layer.open({
        type: 2,
        title: '添加结算管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/accounts/accounts_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看结算管理详情
 */
Accounts.openAccountsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '结算管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/accounts/accounts_update/' + Accounts.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除结算管理
 */
Accounts.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/accounts/delete", function (data) {
            Feng.success("删除成功!");
            Accounts.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("accountsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询结算管理列表
 */
Accounts.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Accounts.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Accounts.initColumn();
    var table = new BSTable(Accounts.id, "/accounts/list", defaultColunms);
    table.setPaginationType("client");
    Accounts.table = table.init();
});
