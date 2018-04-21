! function(document, window, $) {
    "use strict";
    var Site = window.Site;
    
  //myImgField
    var MyImgField = function(config) {
        jsGrid.Field.call(this, config);
    };
 
    MyImgField.prototype = new jsGrid.Field({
        sorter: function(date1, date2) {
            //return new Date(date1) - new Date(date2);
        	return 1;
        },
 
        itemTemplate: function(value) {
            //return new Date(value).toDateString();
        	return $("<div>").addClass("yyzz zoom-gallery m-t-30").attr("onclick","event.cancelBubble=true;")//取消click的传递
        			.append(
        			$("<a>").attr("title","营业执照").attr("href", value).attr("data-source",value)
        			.append($("<img>").attr("src",value)))
        			.magnificPopup({
                		delegate: 'a',
                		type: 'image',
                		closeOnContentClick: true,
                		closeBtnInside: true,
                		mainClass: 'mfp-with-zoom mfp-img-mobile',
                		image: {
                			verticalFit: true,
                			titleSrc: function(item) {
                				return item.el.attr('title') + ' &middot; <a class="image-source-link" href="'+item.el.attr('data-source')+'" target="_blank">下载源文件</a>';
                			}
                		},
                		gallery: {
                			enabled: false
                		},
                		zoom: {
                			enabled: true,
                			duration: 300, // don't foget to change the duration also in CSS
                			opener: function(element) {
                				return element.find('img');
                			}
                		}
                	});
        },
 
        insertTemplate: function(value) {
        	$("#hiddenfile").text("");//清空
        	//每次change将base64保存到一个display：none（不影响绘图性能）的div中，实在想不出其他方法了
        	return this._insertFile = $("<input>").attr("type","file").attr("id","myfile").change(function(){
            	var file = document.getElementById("myfile").files[0];
            	var r = new FileReader();  //本地预览
            	r.readAsDataURL(file);    //Base64
            	r.onload = function (e) {
            		$("#hiddenfile").text(e.target.result);
                }
        	});
        },
 
        editTemplate: function(value) {
        	$("#hiddenfile").text("");//清空
        	return this._editFile = $("<input>").attr("type","file").attr("id","myfileEdit").change(function(){
            	var file = document.getElementById("myfileEdit").files[0];
            	var r = new FileReader();  //本地预览
            	r.readAsDataURL(file);    //Base64
            	r.onload = function (e) {
            		$("#hiddenfile").text(e.target.result);
                }
        	});
        },
 
        insertValue: function() {
        	return $("#hiddenfile").text();
        },
 
        editValue: function() {
        	return $("#hiddenfile").text();
        }
    });
 
    jsGrid.fields.myImgField = MyImgField;
    
    //myImgField
    
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
                controller: khxxbdb,
                fields: [{
                    name: "khid",
                    type: "number",
                    width: 20,
                    title: "客户编号",
                    editing: false,
                    inserting: false,
                }, {
                    name: "khm",
                    type: "text",
                    width: 30,
                    title: "客户名",
                    validate: {
                        validator: "required",
                        message: "客户名不能为空"
                    }
                }, {
                    name: "khdz",
                    type: "text",
                    width: 100,
                    title: "客户地址"
                }, {
                    name: "tyxydm",
                    type: "text",
                    width: 30,
                    title: "统一信用代码"
                }, {
                    name: "yyzz",
                    type: "myImgField",
                    width: 30,
                    title: "营业执照"
                },{
                    name: "lxr",
                    type: "text",
                    width: 30,
                    title: "联系人"
                },{
                    name: "lxrdh",
                    type: "text",
                    width: 30,
                    title: "联系人电话"
                },{
                    name: "lxryx",
                    type: "text",
                    width: 30,
                    title: "联系人邮箱"
                },{
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