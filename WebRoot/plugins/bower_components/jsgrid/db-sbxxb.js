(function() {


	var sbxxbdb = {
		loadData : function(filter) {
//			if(filter.cksj=="")
//				delete filter.cksj;
//			if(filter.rksj=="")
//				delete filter.rksj;
			var d = $.Deferred();
			$.ajax({
				type : "POST",
				url : "../showWithPageSizeAndPageIndexSbxxb.action",
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
			if(insertingItem.cksj=="")
				delete insertingItem.cksj;
			if(insertingItem.rksj=="")
				delete insertingItem.rksj;
			
			
			
			if(insertingItem.sbztb.sbztid==0)
				delete insertingItem.sbztb;
			if(insertingItem.sblxb.sblxid==0)
				delete insertingItem.sblxb;
			if(insertingItem.sbsylxb.sylxid==0)
				delete insertingItem.sbsylxb;
			if(insertingItem.syzt==0)
				delete insertingItem.syzt;
			
			if(insertingItem.cqb.cqid==0)
				delete insertingItem.cqb;
			if(insertingItem.khxxb.khid==0)
				delete insertingItem.khxxb;
			if(insertingItem.jfb.jfid==0)
				delete insertingItem.jfb;
			if(insertingItem.jgb.jgid==0)
				delete insertingItem.jgb;
			$.ajax({
				type : "POST",
				url : "../addSbxxb.action",
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
			if(updatingItem.cksj=="")
				delete updatingItem.cksj;
			if(updatingItem.rksj=="")
				delete updatingItem.rksj;
			
			
			if(updatingItem.sbztb.sbztid==0)
				delete updatingItem.sbztb;
			if(updatingItem.sblxb.sblxid==0)
				delete updatingItem.sblxb;
			if(updatingItem.sbsylxb.sylxid==0)
				delete updatingItem.sbsylxb;
			if(updatingItem.syzt==0)
				delete updatingItem.syzt;
			
			if(updatingItem.cqb.cqid==0)
				delete updatingItem.cqb;
			if(updatingItem.khxxb.khid==0)
				delete updatingItem.khxxb;
			if(updatingItem.jfb.jfid==0)
				delete updatingItem.jfb;
			if(updatingItem.jgb.jgid==0)
				delete updatingItem.jgb;
			$.ajax({
				type : "POST",
				url : "../updateSbxxb.action",
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
				url : "../deleteSbxxb.action",
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

	window.sbxxbdb = sbxxbdb;
	
	sbxxbdb.sbztb = [
		{ Id: 0 , Name: ""},
        { Id: 1001 , Name: "正常"},
        { Id: 1002 , Name: "故障"},
        { Id: 1003 , Name: "返修"},
        { Id: 1004 , Name: "返还"},
        { Id: 1005 , Name: "出售"},
        { Id: 1006 , Name: "报废"},
        { Id: 9001 , Name: "其他"}
    ];
	
	sbxxbdb.sblxb = [
		{ Id: 0 , Name: ""},
        { Id: 1001 , Name: "服务器"},
        { Id: 2001 , Name: "交换机"},
        { Id: 2002 , Name: "路由器"},
        { Id: 2003 , Name: "防火墙"}
    ];
	
	sbxxbdb.sbsylxb = [
		{ Id: 0 , Name: ""},
        { Id: 1001 , Name: "租用"},
        { Id: 1002 , Name: "托管"},
        { Id: 1003 , Name: "自用"},
        { Id: 1004 , Name: "云平台"},
        { Id: 1005 , Name: "占用"},
        { Id: 1006 , Name: "查扣"},
        { Id: 9001 , Name: "其他"}
    ];
	
	sbxxbdb.syztb = [
		{ Id: 0 , Name: ""},
        { Id: -1 , Name: "空闲"},
        { Id: 1 , Name: "使用"}
    ];
	
	sbxxbdb.cqb = [
		{ Id: 0 , Name: ""},
        { Id: 1001 , Name: "自有"},
        { Id: 1002 , Name: "借用"},
        { Id: 1003 , Name: "托管"},
        { Id: 1004 , Name: "其他"}
    ];

}());