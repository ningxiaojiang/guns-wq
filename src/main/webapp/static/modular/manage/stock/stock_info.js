/**
 * 初始化库存管理详情对话框
 */
var StockInfoDlg = {
    stockInfoData : {}
};

/**
 * 清除数据
 */
StockInfoDlg.clearData = function() {
    this.stockInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StockInfoDlg.set = function(key, val) {
    this.stockInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StockInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
StockInfoDlg.close = function() {
    parent.layer.close(window.parent.Stock.layerIndex);
}

/**
 * 收集数据
 */
StockInfoDlg.collectData = function() {
    this.set('id').set('productid').set('number').set('otherone');
}

/**
 * 提交添加
 */
StockInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/stock/add", function(data){
        Feng.success("添加成功!");
        window.parent.Stock.table.refresh();
        StockInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.stockInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
StockInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/stock/update", function(data){
        Feng.success("修改成功!");
        window.parent.Stock.table.refresh();
        StockInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.stockInfoData);
    ajax.start();
}

$(function() {

});
