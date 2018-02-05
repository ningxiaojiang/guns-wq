/**
 * 初始化销售管理详情对话框
 */
var SalesInfoDlg = {
    salesInfoData : {}
};

/**
 * 清除数据
 */
SalesInfoDlg.clearData = function() {
    this.salesInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SalesInfoDlg.set = function(key, val) {
    this.salesInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SalesInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SalesInfoDlg.close = function() {
    parent.layer.close(window.parent.Sales.layerIndex);
}

/**
 * 收集数据
 */
SalesInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
SalesInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sales/add", function(data){
        Feng.success("添加成功!");
        window.parent.Sales.table.refresh();
        SalesInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.salesInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SalesInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sales/update", function(data){
        Feng.success("修改成功!");
        window.parent.Sales.table.refresh();
        SalesInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.salesInfoData);
    ajax.start();
}

$(function() {

});
