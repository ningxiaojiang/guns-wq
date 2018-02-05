/**
 * 报销管理管理初始化
 */
var Wipeout = {
    id: "WipeoutTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wipeout.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Wipeout.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wipeout.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加报销管理
 */
Wipeout.openAddWipeout = function () {
    var index = layer.open({
        type: 2,
        title: '添加报销管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wipeout/wipeout_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看报销管理详情
 */
Wipeout.openWipeoutDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '报销管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wipeout/wipeout_update/' + Wipeout.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除报销管理
 */
Wipeout.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wipeout/delete", function (data) {
            Feng.success("删除成功!");
            Wipeout.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wipeoutId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询报销管理列表
 */
Wipeout.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wipeout.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wipeout.initColumn();
    var table = new BSTable(Wipeout.id, "/wipeout/list", defaultColunms);
    table.setPaginationType("client");
    Wipeout.table = table.init();
});
