(function() {

	var cqbdb = {
		loadData : function(filter) {
			var d = $.Deferred();
			$.ajax({
				type : "POST",
				url : "../showWithPageSizeAndPageIndexCqb.action",
				data : JSON.stringify(filter),
				dataType : "json",
				contentType: "application/json",
			}).done(function(response) {
				var params={
						data:[],
						itemsCount: 0,	
				};
				params.data=response.resultlist;
				params.itemsCount=response.itemsCount;
				d.resolve(params);
			}).fail(function() {
				$.toast({
			         heading: '与服务器查询出错',
			         text: '您可以尝试点击刷机表格按钮或刷新网页',
			         position: 'top-right',
			         icon: 'error',
			     });
			});
			return d.promise();
		},

		insertItem : function(insertingItem) {
			$.ajax({
				type : "POST",
				url : "../addCqb.action",
				data : JSON.stringify(insertingItem),
				dataType : "json",
				contentType: "application/json",
			}).done(function(response){
				$.toast({
			         heading: '新增成功',
			         text: '即将自动更新视图',
			         position: 'top-right',
			         icon: 'success',
			         stack: 6
			     });
				//导航到最后一页，好像没有预置的方法？
//				var pageSize = $("#grid").jsGrid("option", "pageSize");
//				var lastPage=Math.floor((response.itemsCount+pageSize-1)/pageSize);
//				$("#jsgrid").jsGrid("openPage("+lastPage+")");
			}).fail(function(){
				$.toast({
			         heading: '插入出错',
			         position: 'top-right',
			         icon: 'error',
			     });
			});
		},

		updateItem : function(updatingItem) {
			$.ajax({
				type : "POST",
				url : "../updateCqb.action",
				data : JSON.stringify(updatingItem),
				dataType : "json",
				contentType: "application/json",
			}).done(function(response){
				$.toast({
			         heading: '更新成功',
			         position: 'top-right',
			         icon: 'success',
			     });
			}).fail(function(){
				$.toast({
			         heading: '更新出错',
			         position: 'top-right',
			         icon: 'error',
			     });
			});
		},

		deleteItem : function(deletingClient) {
			$.ajax({
				type : "POST",
				url : "../deleteCqb.action",
				data : JSON.stringify(deletingClient),
				dataType : "json",
				contentType: "application/json",
			}).done(function(response){
				$.toast({
			         heading: '删除成功',
			         position: 'top-right',
			         icon: 'success',
			     });
			}).fail(function(){
				$.toast({
			         heading: '删除出错',
			         position: 'top-right',
			         icon: 'error',
			     });
			});
		}
	};

	window.cqbdb = cqbdb;


}());