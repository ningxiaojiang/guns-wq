/**
 * 初始化销售管理详情对话框
 */
var SalesInfoDlg = {
	count: $("#itemSize").val(),
    mutiString: '',		//拼接字符串内容(拼接字典条目)
    itemTemplate: $("#itemTemplate").html(),
    salesInfoData : {}
};

/**
 * item获取新的id
 */
SalesInfoDlg.newId = function () {
    if(this.count == undefined){
        this.count = 0;
    }
    this.count = this.count + 1;
    return "ProductTable" + this.count;
};


/**
 * 添加条目
 */
SalesInfoDlg.addItem = function () {
	$("#tableTop").show();
    $("#itemsArea").append(this.itemTemplate);
    $("#ProductTable").attr("id", this.newId());
};

/**
 * 删除item
 */
SalesInfoDlg.deleteItem = function (event) {
    var obj = Feng.eventParseObject(event);
    obj.parent().parent().remove();
};

/**
 * 清除为空的item Dom
 */
SalesInfoDlg.clearNullDom = function(){
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
SalesInfoDlg.collectDatas = function () {
    this.clearNullDom();
    var mutiString = "";
    $("[name='ProductTable']").each(function(){
    	var productId = $(this).find("[name='productId']").val();
        var price = $(this).find("[name='price']").val();
        var number = $(this).find("[name='numbers']").val();
        var remarks = $(this).find("[name='remarks']").val();
        mutiString = mutiString + (productId + ":" + price + ":" + number + ":" + remarks + ";");
    });
    //this.dictName = $("#dictName").val();
    this.mutiString = mutiString;
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
	var index = parent.layer.getFrameIndex(window.name);  
    parent.layer.close(index);  
    //arent.layer.close(window.parent.Sales.layerIndex);
}

/**
 * 收集数据
 */
SalesInfoDlg.collectData = function() {
    this.set('id').set('salesno').set('clientid').set('price')
    .set('otherone').set('otherthree').set('staffid').set('number')
    .set('status').set('preferential').set('othertwo').set('dispatchingtype').set('dispatchingtime');
}


/**
 * 创建清单
 */
SalesInfoDlg.foundBill = function() {
	alert("创建清单xhen");
	$("#salesInfoTable").show();
}

/**
 * 提交添加
 */
SalesInfoDlg.addSubmit = function() {
	
    this.clearData();
    this.collectData();
    this.collectDatas();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sales/add", function(data){
        Feng.success("添加成功!");
        window.parent.Sales.table.refresh();
        SalesInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    alert(this.salesInfoData);
    ajax.set('productes',this.mutiString);
    ajax.set(this.salesInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SalesInfoDlg.editSubmit = function() {
    this.clearData();
    this.collectData();
    this.collectDatas();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sales/update", function(data){
        Feng.success("修改成功!");
        window.parent.Sales.table.refresh();
        SalesInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.salesInfoData);
    ajax.set('productes',this.mutiString);
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
