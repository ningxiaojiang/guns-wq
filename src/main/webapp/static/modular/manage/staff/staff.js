/**
 * 员工管理管理初始化
 */
var Staff = {
    id: "StaffTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Staff.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '身份证号', field: 'card_id', align: 'center', valign: 'middle', sortable: true},
        {title: '民族', field: 'nation', align: 'center', valign: 'middle', sortable: true},
        {title: '年龄', field: 'age', align: 'center', valign: 'middle', sortable: true},
        {title: '性别', field: 'sexName', align: 'center', valign: 'middle', sortable: true},
        {title: '籍贯', field: 'origin', align: 'center', valign: 'middle', sortable: true},
        {title: '住址', field: 'address', align: 'center', valign: 'middle', sortable: true},
        {title: '部门', field: 'dept_id', align: 'center', valign: 'middle', sortable: true},
        {title: '薪资', field: 'pay', align: 'center', valign: 'middle', sortable: true,formatter:function(value,row,index){
      	  return value+".00";  
        }},
        {title: '入职时间', field: 'entrytime', align: 'center', valign: 'middle', sortable: true},
        {title: '职位', field: 'post', align: 'center', valign: 'middle', sortable: true},
        {title: '证件地址', field: 'card_address', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Staff.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Staff.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加员工管理
 */
Staff.openAddStaff = function () {
    var index = layer.open({
        type: 2,
        title: '添加员工管理',
        area: ['900px', '520px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/staff/staff_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看员工管理详情
 */
Staff.openStaffDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '员工管理详情',
            area: ['900px', '520px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/staff/staff_update/' + Staff.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除员工管理
 */
Staff.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/staff/delete", function (data) {
            Feng.success("删除成功!");
            Staff.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("staffId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询员工管理列表
 */
Staff.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Staff.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Staff.initColumn();
    var table = new BSTable(Staff.id, "/staff/list", defaultColunms);
    table.setPaginationType("client");
    //debugger;
    /*table.responseHandler=function (res) {
    	alert(res);
    	alert(res.DATA);
        return res.DATA;
    };*/
    Staff.table = table.init();
    /*$.post("/staff/list",{},function(data){
    	alert(date[0].name);
    });*/
});
