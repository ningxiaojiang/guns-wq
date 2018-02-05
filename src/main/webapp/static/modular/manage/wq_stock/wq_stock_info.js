/**
 * 初始化库存管理详情对话框
 */
var Wq_stockInfoDlg = {
    wq_stockInfoData : {}
};

/**
 * 清除数据
 */
Wq_stockInfoDlg.clearData = function() {
    this.wq_stockInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wq_stockInfoDlg.set = function(key, val) {
    this.wq_stockInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Wq_stockInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Wq_stockInfoDlg.close = function() {
    parent.layer.close(window.parent.Wq_stock.layerIndex);
}

/**
 * 收集数据
 */
Wq_stockInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
Wq_stockInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wq_stock/add", function(data){
        Feng.success("添加成功!");
        window.parent.Wq_stock.table.refresh();
        Wq_stockInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wq_stockInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Wq_stockInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wq_stock/update", function(data){
        Feng.success("修改成功!");
        window.parent.Wq_stock.table.refresh();
        Wq_stockInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wq_stockInfoData);
    ajax.start();
}

$(function() {

});
