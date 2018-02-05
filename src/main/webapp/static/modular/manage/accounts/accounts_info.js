/**
 * 初始化结算管理详情对话框
 */
var AccountsInfoDlg = {
    accountsInfoData : {}
};

/**
 * 清除数据
 */
AccountsInfoDlg.clearData = function() {
    this.accountsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AccountsInfoDlg.set = function(key, val) {
    this.accountsInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AccountsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AccountsInfoDlg.close = function() {
    parent.layer.close(window.parent.Accounts.layerIndex);
}

/**
 * 收集数据
 */
AccountsInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
AccountsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/accounts/add", function(data){
        Feng.success("添加成功!");
        window.parent.Accounts.table.refresh();
        AccountsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.accountsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AccountsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/accounts/update", function(data){
        Feng.success("修改成功!");
        window.parent.Accounts.table.refresh();
        AccountsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.accountsInfoData);
    ajax.start();
}

$(function() {

});
