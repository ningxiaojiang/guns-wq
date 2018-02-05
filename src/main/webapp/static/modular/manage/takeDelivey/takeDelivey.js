/**
 * 收货管理管理初始化
 */
var TakeDelivey = {
    id: "TakeDeliveyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TakeDelivey.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '货单号', field: 'otherone', align: 'center', valign: 'middle', sortable: true},
        {title: '提货人', field: 'staffid', align: 'center', valign: 'middle', sortable: true},
        {title: '提货日期', field: 'date', align: 'center', valign: 'middle', sortable: true},
        {title: '运费', field: 'money', align: 'center', valign: 'middle', sortable: true},
        {title: '提货方式', field: 'type', align: 'center', valign: 'middle', sortable: true},
        {title: '备注', field: 'remarks', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
TakeDelivey.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TakeDelivey.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加收货管理
 */
TakeDelivey.openAddTakeDelivey = function () {
    var index = layer.open({
        type: 2,
        title: '添加收货管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/takeDelivey/takeDelivey_add'
    });
    layer.full(index);
    //this.layerIndex = index;
};

/**
 * 打开查看收货管理详情
 */
TakeDelivey.openTakeDeliveyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '收货管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/takeDelivey/takeDelivey_update/' + TakeDelivey.seItem.id
        });
        layer.full(index);
    }
};

/**
 * 删除收货管理
 */
TakeDelivey.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/takeDelivey/delete", function (data) {
            Feng.success("删除成功!");
            TakeDelivey.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("takeDeliveyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询收货管理列表
 */
TakeDelivey.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TakeDelivey.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TakeDelivey.initColumn();
    var table = new BSTable(TakeDelivey.id, "/takeDelivey/list", defaultColunms);
    table.setPaginationType("client");
    TakeDelivey.table = table.init();
});
