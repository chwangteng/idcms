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
                controller: dataflowdb,
                fields: [{
                    name: "id",
                    type: "number",
                    width: 70,
                    title: "主键",
                    editing: false,
                    inserting: false,
                }, {
                    name: "jhj",
                    type: "text",
                    width: 150,
                    title: "交换机",
                }, {
                    name: "jk",
                    type: "text",
                    width: 70,
                    title: "接口",
                }, {
                    name: "lrll",
                    type: "text",
                    width: 150,
                    title: "流入流量",
                }, 
                 {
                    name: "lcll",
                    type: "text",
                    width: 150,
                    title: "流出流量",
                }, 
                 {
                    name: "time",
                    type: "text",
                    width: 150,
                    title: "时间",
                    filtering: false,
                }, 
                 {
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