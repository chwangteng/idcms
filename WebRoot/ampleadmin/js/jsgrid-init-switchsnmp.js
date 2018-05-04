! function(document, window, $) {
    "use strict";
    var Site = window.Site;
    $(document).ready(function($) {
            
        }), jsGrid.setDefaults({
            tableClass: "jsgrid-table table table-striped table-hover"
        }), jsGrid.setDefaults("text", {
            _createTextBox: function() {
                return $("<input>").attr("type", "text").attr("class", "form-control input-sm")
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
                controller: switchsnmpdb,
                fields: [{
                    name: "id",
                    type: "text",
                    width: 70,
                    title: "主键",
                    validate: {
                        validator: "required",
                        message: "主键不能为空"
                    }
                },{
                    name: "deviceid",
                    type: "text",
                    width: 100,
                    title: "设备ID",
                    validate: {
                        validator: "required",
                        message: "设备ID不能为空"
                    }
                }, {
                    name: "devicename",
                    type: "text",
                    width: 100,
                    title: "设备名称",
                    validate: {
                        validator: "required",
                        message: "设备名称不能为空"
                    }
                }, {
                    name: "ipaddr",
                    type: "text",
                    width: 100,
                    title: "设备IP地址",
                    validate: {
                        validator: "required",
                        message: "设备IP地址不能为空"
                    }
                }, {
                    name: "ifoid",
                    type: "text",
                    width: 100,
                    title: "接口oid",
                    validate: {
                        validator: "required",
                        message: "接口oid不能为空"
                    }
                }, {
                    name: "flowoid",
                    type: "text",
                    width: 100,
                    title: "入流量接口oid",
                    validate: {
                        validator: "required",
                        message: "入流量接口oid不能为空"
                    }
                }, {
                    name: "community",
                    type: "text",
                    width: 100,
                    title: "团体字",
                    validate: {
                        validator: "required",
                        message: "团体字不能为空"
                    }
                }, {
                    name: "flowoutoid",
                    type: "text",
                    width: 100,
                    title: "出流量接口oid",
                    validate: {
                        validator: "required",
                        message: "出流量接口oid不能为空"
                    }
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