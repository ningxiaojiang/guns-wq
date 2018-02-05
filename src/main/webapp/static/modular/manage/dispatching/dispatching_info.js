/**
 * 初始化配送管理详情对话框
 */
var DispatchingInfoDlg = {
	count: $("#itemSize").val(),
    mutiString: '',		//拼接字符串内容(拼接字典条目)
    itemTemplate: $("#itemTemplate").html(),
    dispatchingInfoData : {}
};
/**
 * item获取新的id
 */
DispatchingInfoDlg.newId = function () {
    if(this.count == undefined){
        this.count = 0;
    }
    this.count = this.count + 1;
    return "ProductTable" + this.count;
};


/**
 * 添加条目
 */
DispatchingInfoDlg.addItem = function () {
	$("#dispTableTop").show();
    $("#itemsArea").append(this.itemTemplate);
    $("#ProductTable").attr("id", this.newId());
};

/**
 * 删除item
 */
DispatchingInfoDlg.deleteItem = function (event) {
    var obj = Feng.eventParseObject(event);
    obj.parent().parent().remove();
};

/**
 * 清除为空的item Dom
 */
DispatchingInfoDlg.clearNullDom = function(){
    $("[name='ProductTable']").each(function(){
        var productId = $(this).find("[name='productId']").val();
        var price = $(this).find("[name='price']").val();
        var number = $(this).find("[name='numbers']").val();
        var remarks = $(this).find("[name='remarks']").val();
        if(productId == '' && price == '' && number == ''){
            $(this).remove();
        }
    });
};

/**
 * 收集添加产品清单的数据
 */
DispatchingInfoDlg.collectDatas = function () {
    this.clearNullDom();
    var mutiString = "";
    $("[name='ProductTable']").each(function(){
    	var productId = $(this).find("[name='productId']").val();
    	var salesInfoId = $(this).find("[name='salesInfoId']").val();
        var number = $(this).find("[name='numbers']").val();
        var remarks = $(this).find("[name='remarks']").val();
        mutiString = mutiString + (productId + ":"+ salesInfoId + ":"+ number + ":" + remarks + ";");
    });
    //this.dictName = $("#dictName").val();
    this.mutiString = mutiString;
};

/**
 * 清除数据
 */
DispatchingInfoDlg.clearData = function() {
    this.dispatchingInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DispatchingInfoDlg.set = function(key, val) {
    this.dispatchingInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DispatchingInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DispatchingInfoDlg.close = function() {
	var index = parent.layer.getFrameIndex(window.name);  
    parent.layer.close(index);  
    //parent.layer.close(window.parent.Dispatching.layerIndex);
}

/**
 * 收集数据
 */
DispatchingInfoDlg.collectData = function() {
    this.set('id').set('salesNo').set('disoatchingNo').set('disStaffId')
    .set('dispTime');
}

/**
 * 提交添加
 */
DispatchingInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    this.collectDatas();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dispatching/add", function(data){
        Feng.success("添加成功!");
        window.parent.Dispatching.table.refresh();
        DispatchingInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set('productes',this.mutiString);
    ajax.set(this.dispatchingInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DispatchingInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dispatching/update", function(data){
        Feng.success("修改成功!");
        window.parent.Dispatching.table.refresh();
        DispatchingInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dispatchingInfoData);
    ajax.start();
}

$(function() {
	var size = $("#itemSize").val();
	if(size > 0){
		$("#dispTableTop").show();
		$("#tj").hide();
	}else{
		$("#dispTableTop").hide();
		$("#tj").show();
	}
});
