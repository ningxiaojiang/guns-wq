/**
 * 初始化员工管理详情对话框
 */
var StaffInfoDlg = {
    staffInfoData : {}
};

/**
 * 清除数据
 */
StaffInfoDlg.clearData = function() {
    this.staffInfoData = {};
}
/**
 * 显示部门选择的树
 *
 * @returns
 */
StaffInfoDlg.showDeptSelectTree = function () {
    var cityObj = $("#deptid");
    var cityOffset = $("#deptid").offset();
    $("#menuContent").css({
        left: cityOffset.left + "px",
        top: cityOffset.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
};
function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
            event.target).parents("#menuContent").length > 0)) {
    	StaffInfoDlg.hideDeptSelectTree();
    }
}
/**
 * 隐藏部门选择的树
 */
StaffInfoDlg.hideDeptSelectTree = function () {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
};
/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StaffInfoDlg.set = function(key, val) {
    this.staffInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
StaffInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
StaffInfoDlg.close = function() {
    parent.layer.close(window.parent.Staff.layerIndex);
}

/**
 * 收集数据
 */
StaffInfoDlg.collectData = function() {
    this.set('id').set('name').set('age').set('cardId')
    .set('origin').set('entrytime').set('otherOne').set('sex')
    .set('nation').set('cardAddress').set('address').set('pay')
    .set('post').set('otherTwo').set('deptId');
}

/**
 * 提交添加
 */
StaffInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/staff/add", function(data){
        Feng.success("添加成功!");
        window.parent.Staff.table.refresh();
        StaffInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.staffInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
StaffInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/staff/update", function(data){
        Feng.success("修改成功!");
        window.parent.Staff.table.refresh();
        StaffInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.staffInfoData);
    ajax.start();
}
StaffInfoDlg.onClickDept = function (e, treeId, treeNode) {
    $("#deptid").attr("value", instance.getSelectedVal());
    $("#deptId").attr("value", treeNode.id);
};
$(function() {
	Feng.initValidator("staffInfoForm", StaffInfoDlg.validateFields);

    var ztree = new $ZTree("treeDemo", "/dept/tree");
    ztree.bindOnClick(StaffInfoDlg.onClickDept);
    ztree.init();
    instance = ztree;
});
