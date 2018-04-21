! function(document, window, $) {
    "use strict";
    var Site = window.Site;
    
    //测试datepicker
    var MyDateField = function(config) {
        jsGrid.Field.call(this, config);
    };
 
    MyDateField.prototype = new jsGrid.Field({
        sorter: function(date1, date2) {
            return new Date(date1) - new Date(date2);
        },
 
        itemTemplate: function(value) {
            //return new Date(value).toDateString();
        	return value;
        },
 
        insertTemplate: function(value) {
            //return this._insertPicker = $("<input>").datepicker({ defaultDate: new Date() });
        	return this._insertPicker = $("<input>").attr("class", "form-control input-sm").datetimepicker({
                showSecond: true, //显示秒
                timeFormat: 'HH:mm:ss' //格式化时间
            });
        },
 
        editTemplate: function(value) {
            //return this._editPicker = $("<input>").datepicker().datepicker("setDate", new Date(value));
        	return this._editPicker = $("<input>").attr("class", "form-control input-sm").datetimepicker({
                showSecond: true, //显示秒  
                timeFormat: 'HH:mm:ss' //格式化时间  
            }).datepicker("setDate", new Date(value));
        },
 
        insertValue: function() {
        	if(this._insertPicker.datetimepicker("getDate")==""||this._insertPicker.datetimepicker("getDate")==null)
        		return "";
            var ISOStr=this._insertPicker.datetimepicker("getDate").toISOString();//可以得到形如2018-04-09T09:46:13.119Z 可是时区不对啊
            ISOStr=ISOStr.substring(0,10);//我只要日期
            var timestr=this._insertPicker.datetimepicker("getDate").toTimeString(); //可以得到形如17:39:18 GMT+0800 (China Standard Time) 取前8个字符
            timestr=timestr.substring(0,8);//我只要时间
            return ISOStr+" "+timestr;//拼接
        },
 
        editValue: function() {
        	if(this._editPicker.datetimepicker("getDate")==""||this._editPicker.datetimepicker("getDate")==null)
        		return "";
            var ISOStr=this._editPicker.datetimepicker("getDate").toISOString();//可以得到形如2018-04-09T09:46:13.119Z 可是时区不对啊
            ISOStr=ISOStr.substring(0,10);//我只要日期
            var timestr=this._editPicker.datetimepicker("getDate").toTimeString(); //可以得到形如17:39:18 GMT+0800 (China Standard Time) 取前8个字符
            timestr=timestr.substring(0,8);//我只要时间
            return ISOStr+" "+timestr;//拼接
        }
    });
 
    jsGrid.fields.myDateField = MyDateField;
    
    //测试datepickker
    
    $(document).ready(function($) {
    	
        }), jsGrid.setDefaults({
            tableClass: "jsgrid-table table table-striped table-hover"
        }), jsGrid.setDefaults("text", {
            _createTextBox: function() {
                return $("<input>").attr("type", "text").attr("class", "form-control input-sm");
            }
        }), jsGrid.setDefaults("number", {
            _createTextBox: function() {
                return $("<input>").attr("type", "number").attr("class", "form-control input-sm")
            }
        }), jsGrid.setDefaults("textarea", {
            _createTextBox: function() {
                return $("<input>").attr("type", "textarea").attr("class", "form-control")
            }
        }), jsGrid.setDefaults("control", {
            _createGridButton: function(cls, tooltip, clickHandler) {
                var grid = this._grid;
                return $("<button>").addClass(this.buttonClass).addClass(cls).attr({
                    type: "button",
                    title: tooltip
                }).on("click", function(e) {
                    clickHandler(grid, e)
                })
            }
        }), jsGrid.setDefaults("select", {
            _createSelect: function() {
                var $result = $("<select>").attr("class", "form-control input-sm"),
                    valueField = this.valueField,
                    textField = this.textField,
                    selectedIndex = this.selectedIndex;
                return $.each(this.items, function(index, item) {
                    var value = valueField ? item[valueField] : index,
                        text = textField ? item[textField] : item,
                        $option = $("<option>").attr("value", value).text(text).appendTo($result);
                    $option.prop("selected", selectedIndex === index)
                }), $result
            }
        }),
        function() {
            $("#jsgrid").jsGrid({
            	pageLoading: true,
                height: "auto",
                width: "100%",
                filtering: true,
                editing: true,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 15,
                inserting: true,
                pageButtonCount: 5,
                deleteConfirm: "确定要删除吗?",
                pagerContainer: null,
                pagerContainer: "#topPager",
                pagerFormat: "页面: {first} {prev} {pages} {next} {last}  第  {pageIndex} 页， 共  {pageCount} 页,  {itemCount} 条记录",
                pagePrevText: "上一页",
                pageNextText: "下一页",
                pageFirstText: "第一页",
                pageLastText: "最后一页",
                invalidMessage: "非法数据!",
                noDataContent: "没有找到您要的结果",
                loadIndication: true,
                loadIndicationDelay: 0,
                loadMessage: "加载中请稍后...",
                loadShading: true,
                controller: sbxxbdb,
                fields: [{
                    name: "sbid",
                    type: "number",
                    width: 30,
                    title: "设备编号",
                    editing: false,
                    inserting: false,
                }, {
                    name: "sbbm",
                    type: "text",
                    width: 30,
                    title: "设备编码"
                },  {
                    name: "sbmc",
                    type: "text",
                    width: 30,
                    title: "设备名称",
                    validate: {
                        validator: "required",
                        message: "设备名称不能为空"
                    }
                }, {
                    name: "sbztb.sbztid",
                    type: "select",
                    width: 30,
                    title: "设备状态",
                    items: sbxxbdb.sbztb,
                    valueField: "Id",
                    textField: "Name"
                }, {
                    name: "sblxb.sblxid",
                    type: "select",
                    width: 30,
                    title: "设备类型",
                    items: sbxxbdb.sblxb,
                    valueField: "Id",
                    textField: "Name"
                }, {
                    name: "sbsylxb.sylxid",
                    type: "select",
                    width: 30,
                    title: "使用类型",
                    items: sbxxbdb.sbsylxb,
                    valueField: "Id",
                    textField: "Name"
                }, {
                    name: "syzt",
                    type: "select",
                    width: 30,
                    title: "使用状态",
                    items: sbxxbdb.syztb,
                    valueField: "Id",
                    textField: "Name"
                }, {
                    name: "gg",
                    type: "text",
                    width: 30,
                    title: "规格(仅限服务器)"
                }, {
                    name: "czxt",
                    type: "text",
                    width: 30,
                    title: "操作系统(仅限服务器)"
                }, {
                    name: "czxt",
                    type: "text",
                    width: 30,
                    title: "阵列型号(仅限服务器)"
                }, {
                    name: "cpu",
                    type: "text",
                    width: 30,
                    title: "CPU(仅限服务器)"
                }, {
                    name: "nc",
                    type: "text",
                    width: 30,
                    title: "内存(仅限服务器)"
                }, {
                    name: "yp",
                    type: "text",
                    width: 30,
                    title: "硬盘(仅限服务器)"
                }, {
                    name: "rksj",
                    type: "myDateField",
                    width: 30,
                    title: "入库时间",
                    filterTemplate: function() {
                    	//返回一个用于筛选的文本框
                    	return this._filterBox = $("<input>").attr("type", "text").attr("class", "form-control input-sm");
                    },
                    filterValue: function() { 
                    	//返回文本框的值
                    	return this._filterBox.val();
                    }
                }, {
                    name: "cksj",
                    type: "myDateField",
                    width: 30,
                    title: "出库时间",
                    filterTemplate: function() {
                    	return this._filterBox = $("<input>").attr("type", "text").attr("class", "form-control input-sm");
                    },
                    filterValue: function() { 
                    	return this._filterBox.val();
                    }
                },{
                    name: "sbcs",
                    type: "text",
                    width: 30,
                    title: "设备厂商"
                },{
                    name: "sbxh",
                    type: "text",
                    width: 30,
                    title: "设备型号"
                },{
                    name: "gldz",
                    type: "text",
                    width: 30,
                    title: "管理地址(除服务器外)"
                },{
                    name: "vlanh",
                    type: "text",
                    width: 30,
                    title: "VLAN号(除服务器外)"
                },{
                    name: "cqb.cqid",
                    type: "select",
                    width: 30,
                    title: "产权",
                    items: sbxxbdb.cqb,
                    valueField: "Id",
                    textField: "Name"
                },{
                    name: "khxxb.khid",
                    type: "number",
                    width: 30,
                    title: "所属产权客户编号"
                },{
                    name: "jfb.jfid",
                    type: "number",
                    width: 30,
                    title: "所属机房编号"
                },{
                    name: "jgb.jgid",
                    type: "number",
                    width: 30,
                    title: "所属机柜编号"
                }, {
                    type: "control",
                    searchModeButtonTooltip: "切换到搜索模式", // tooltip of switching filtering/inserting button in inserting mode
                    insertModeButtonTooltip: "切换到添加模式", // tooltip of switching filtering/inserting button in filtering mode
                    editButtonTooltip: "编辑",                      // tooltip of edit item button
                    deleteButtonTooltip: "删除",                  // tooltip of delete item button
                    searchButtonTooltip: "搜索",                  // tooltip of search button
                    clearFilterButtonTooltip: "清空筛选规则",       // tooltip of clear filter button
                    insertButtonTooltip: "插入",                  // tooltip of insert button
                    updateButtonTooltip: "更新",                  // tooltip of update item button
                    cancelEditButtonTooltip: "取消编辑",         // tooltip of cancel editing button
                }]
            })
        }()
}(document, window, jQuery);