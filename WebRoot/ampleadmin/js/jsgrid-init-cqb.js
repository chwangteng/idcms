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
                filtering: false,
                editing: true,
                sorting: false,
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
                controller: cqbdb,
                fields: [{
                    name: "cqid",
                    type: "number",
                    width: 70,
                    title: "产权编号",
                    editing: false,
                    inserting: false,
                }, {
                    name: "cqxx",
                    type: "text",
                    width: 150,
                    title: "产权信息",
                    validate: {
                        validator: "required",
                        message: "产权信息不能为空"
                    }
                }, {
                    type: "control"
                }]
            })
        }()
}(document, window, jQuery);