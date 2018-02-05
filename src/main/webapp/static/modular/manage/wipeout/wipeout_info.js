/**
 * 初始化报销管理详情对话框
 */
var WipeoutInfoDlg = {
    wipeoutInfoData : {}
};

/**
 * 清除数据
 */
WipeoutInfoDlg.clearData = function() {
    this.wipeoutInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WipeoutInfoDlg.set = function(key, val) {
    this.wipeoutInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WipeoutInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WipeoutInfoDlg.close = function() {
    parent.layer.close(window.parent.Wipeout.layerIndex);
}

/**
 * 收集数据
 */
WipeoutInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
WipeoutInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wipeout/add", function(data){
        Feng.success("添加成功!");
        window.parent.Wipeout.table.refresh();
        WipeoutInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wipeoutInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WipeoutInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wipeout/update", function(data){
        Feng.success("修改成功!");
        window.parent.Wipeout.table.refresh();
        WipeoutInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wipeoutInfoData);
    ajax.start();
}

$(function() {

});
