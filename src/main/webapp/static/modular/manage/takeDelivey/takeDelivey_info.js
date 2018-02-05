/**
 * 初始化收货管理详情对话框
 */
var TakeDeliveyInfoDlg = {
	count: $("#itemSize").val(),
    mutiString: '',		//拼接字符串内容(拼接字典条目)
    itemTemplate: $("#itemTemplate").html(),
    takeDeliveyInfoData : {}
};
/**
 * item获取新的id
 */
TakeDeliveyInfoDlg.newId = function () {
    if(this.count == undefined){
        this.count = 0;
    }
    this.count = this.count + 1;
    return "ProductTable" + this.count;
};


/**
 * 添加条目
 */
TakeDeliveyInfoDlg.addItem = function () {
	$("#tableTop").show();
    $("#itemsArea").append(this.itemTemplate);
    $("#ProductTable").attr("id", this.newId());
};

/**
 * 删除item
 */
TakeDeliveyInfoDlg.deleteItem = function (event) {
    var obj = Feng.eventParseObject(event);
    obj.parent().parent().remove();
};

/**
 * 清除为空的item Dom
 */
TakeDeliveyInfoDlg.clearNullDom = function(){
    $("[name='ProductTable']").each(function(){
        var productId = $(this).find("[name='productId']").val();
        var id = $(this).find("[name='id']").val();
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
TakeDeliveyInfoDlg.collectDatas = function () {
    this.clearNullDom();
    var mutiString = "";
    $("[name='ProductTable']").each(function(){
    	var id = $(this).find("[name='id']").val();
    	var productId = $(this).find("[name='productId']").val();
        var number = $(this).find("[name='numbers']").val();
        var numbery = $(this).find("[name='numbersy']").val();
        var remarks = $(this).find("[name='remarks']").val();
        mutiString = mutiString + (TakeDeliveyInfoDlg.test(id) + ":" +TakeDeliveyInfoDlg.test(productId) + ":"+ TakeDeliveyInfoDlg.test(number) + ":" + TakeDeliveyInfoDlg.test(remarks) + ":" + TakeDeliveyInfoDlg.test(numbery) + ";");
    });
    //this.dictName = $("#dictName").val();
    this.mutiString = mutiString;
};
TakeDeliveyInfoDlg.test = function(value){
	if(value == null || value == "" || typeof(value) == undefined){
		return "null";
	}else{
		return value;
	}
}
/**
 * 清除数据
 */
TakeDeliveyInfoDlg.clearData = function() {
    this.takeDeliveyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TakeDeliveyInfoDlg.set = function(key, val) {
    this.takeDeliveyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TakeDeliveyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TakeDeliveyInfoDlg.close = function() {
	var index = parent.layer.getFrameIndex(window.name);  
    parent.layer.close(index);  
    //parent.layer.close(window.parent.TakeDelivey.layerIndex);
}

/**
 * 收集数据
 */
TakeDeliveyInfoDlg.collectData = function() {
    this.set('id').set('otherone').set('staffid').set('date')
    .set('money').set('type').set('remarks');
}

/**
 * 提交添加
 */
TakeDeliveyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    this.collectDatas();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/takeDelivey/add", function(data){
        Feng.success("添加成功!");
        window.parent.TakeDelivey.table.refresh();
        TakeDeliveyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set('productes',this.mutiString);
    ajax.set(this.takeDeliveyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TakeDeliveyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    this.collectDatas();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/takeDelivey/update", function(data){
        Feng.success("修改成功!");
        window.parent.TakeDelivey.table.refresh();
        TakeDeliveyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set('productes',this.mutiString);
    ajax.set(this.takeDeliveyInfoData);
    ajax.start();
}

$(function() {
	var size = $("#itemSize").val();
	if(size > 0){
		$("#tableTop").show();
		$("#tj").hide();
	}else{
		$("#tableTop").hide();
		$("#tj").show();
	}
});
