(function() {

	var jhjdkzybdb = {
		loadData : function(filter) {
			var d = $.Deferred();
			$.ajax({
				type : "POST",
				url : "../showWithPageSizeAndPageIndexJhjdkzyb.action",
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
			if(insertingItem.sbxxb.sbid==0)
				delete insertingItem.sbxxb;
			if(insertingItem.dkh==0)
				delete insertingItem.dkh;
			$.ajax({
				type : "POST",
				url : "../addJhjdkzyb.action",
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
			delete updatingItem.sbxxb.cksj;
			delete updatingItem.sbxxb.rksj;
			if(updatingItem.sbxxb.sbid==0)
				delete updatingItem.sbxxb;
			if(updatingItem.dkh==0)
				delete updatingItem.dkh;

			$.ajax({
				type : "POST",
				url : "../updateJhjdkzyb.action",
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
			//由于没有使用，直接删除，防止各种赋值出错
			delete deletingClient.sbxxb;
			$.ajax({
				type : "POST",
				url : "../deleteJhjdkzyb.action",
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

	window.jhjdkzybdb = jhjdkzybdb;


}());