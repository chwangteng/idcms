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
                editing: false,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 15,
                inserting: false,
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
                controller: attackinfoesdb,
                fields: [{
                    name: "id",
                    type: "text",
                    width: 70,
                    title: "主键",
                    editing: false,
                    inserting: false,
                }, {
                    name: "status",
                    type: "text",
                    width: 30,
                    title: "是否成功（0表示成功，非0表示不成功）",
                },{
                    name: "count",
                    type: "text",
                    width: 30,
                    title: "峰值包数",
                },{
                    name: "deftype",
                    type: "text",
                    width: 30,
                    title: "防护方式",
                },{
                    name: "SIp",
                    type: "text",
                    width: 30,
                    title: "被攻击地址",
                },{
                    name: "startTime",
                    type: "text",
                    width: 30,
                    title: "起始时间",
                },{
                    name: "dropCount",
                    type: "text",
                    width: 30,
                    title: "拦截包数",
                },{
                    name: "SPortList",
                    type: "text",
                    width: 30,
                    title: "目的端口",
                },{
                    name: "CPortList",
                    type: "text",
                    width: 30,
                    title: "源端口",
                },{
                    name: "CIpList",
                    type: "text",
                    width: 30,
                    title: "攻击源地址",
                },{
                    name: "packetType",
                    type: "text",
                    width: 30,
                    title: "包类型",
                },{
                    name: "endTime",
                    type: "text",
                    width: 30,
                    title: "结束时间",
                },{
                    name: "duration",
                    type: "text",
                    width: 30,
                    title: "持续时间",
                },{
                    name: "dropSize",
                    type: "text",
                    width: 30,
                    title: "拦截流量",
                },{
                    name: "size",
                    type: "text",
                    width: 30,
                    title: "峰值攻击流量（字节）",
                }, {
                    type: "control"
                }]
            })
        }()
}(document, window, jQuery);