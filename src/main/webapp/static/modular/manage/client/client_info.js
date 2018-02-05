/**
 * 初始化产品类型管理详情对话框
 */
var ClientInfoDlg = {
    clientInfoData : {}
};

/**
 * 清除数据
 */
ClientInfoDlg.clearData = function() {
    this.clientInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ClientInfoDlg.set = function(key, val) {
    this.clientInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ClientInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ClientInfoDlg.close = function() {
    parent.layer.close(window.parent.Client.layerIndex);
}

/**
 * 收集数据
 */
ClientInfoDlg.collectData = function() {
    this.set('id').set('name').set('sex').set('dt')
    .set('tel').set('otherone').set('remearks').set('age').set('nativplace')
    .set('othertwo').set('phone').set('birthday');
}

/**
 * 提交添加
 */
ClientInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/client/add", function(data){
        Feng.success("添加成功!");
        window.parent.Client.table.refresh();
        ClientInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.clientInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ClientInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/client/update", function(data){
        Feng.success("修改成功!");
        window.parent.Client.table.refresh();
        ClientInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.clientInfoData);
    ajax.start();
}

$(function() {

});
