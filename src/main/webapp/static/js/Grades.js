var getAllGradeUrl = 'gradeadmin/grade/getAllGrades';
var saveGradeUrl='gradeadmin/grade/saveGrades';
var updateGradeUrl='gradeadmin/grade/updateGrades';
jQuery(function($) {

	ajaxRequest(getAllGradeUrl, 'GET', null, null, 'json', renderGetAll);
});

jQuery("#list").jqGrid({
	datatype : "local",
	colNames : [ '学号', '学生姓名', 'C语言程序设计', '高等数学','英语','线性代数','平均分','名次'],
	colModel : [ {
		name : 'sno',
		index : 'sno',
		width : 110,
		align : "center"
	}, {
		name : 'stuName',
		index : 'stuName',
		width : 110,
		align : "center"
	}, {
		name : 'CGrade',
		index : 'CGrade',
		width : 110,
		align : "center"
	}, {
		name : 'MGrade',
		index : 'MGrade',
		width : 110,
		align : "center"
	} ,{
		name : 'EGrade',
		index : 'EGrade',
		width : 110,
		align : "center"
	},{
		name : 'LAGrade',
		index : 'LAGrade',
		width : 110,
		align : "center"
	},{
		name : 'AVGGrade',
		index : 'AVGGrade',
		width : 110,
		align : "center"
	},{
		name : 'Rank',
		index : 'Rank',
		width : 110,
		align : "center"
	}],
	jsonReader : {
		root : "grade",
	},
	loadtext : '数据菌正在奋力加载中········',
	rowNum : 5,
	rowList : [ 10, 20, 30 ],
	pager : '#pager',
	sortname : 'Rank',
	viewrecords : true,
	sortorder : "asc",
	caption : "查看成绩信息",

});


function AddGrade() {
	$("#dialog1").dialog(
			{
				autoOpen : false,
				modal : true,
				hide : {
					effect : "puff",
					duration : 500
				},
				width : 400,

				buttons : [
						{
							text : "Ok",
							click : function() {
								
								var postData;
								var id = $("#id").val();
								var stuName = $("#stuName").val();
								var CGrade=$("#CGrade").val();
								var MGrade=$("#MGrade").val();
								var EGrade=$("#EGrade").val();
								var LAGrade=$("#LAGrade").val();		
								postData="<grade id='" + id + "' stuName='" + stuName + "' CGrade='" + CGrade + "' MGrade='"+ MGrade + "' EGrade='" + EGrade+ "' LAGrade='" + LAGrade + "'/>";
								/*postData = JSON.stringify({id : id,stuName : stuName,CGrade : CGrade,
									MGrade : MGrade, EGrade : EGrade, LAGrade : LAGrade});*/
								console.log(postData);
								ajaxRequest(saveGradeUrl, 'POST', postData, 'application/xml', 'json', afterRequest);
							
								
								
							}
						}, {
							text : "Cancel",
							click : function() {
								$(this).dialog("close");
							}
						} ]
			});
	$("#dialog1").dialog("open");
	event.preventDefault();
}
function UpdateGrade() {
	$("#dialog3").dialog(
			{
				autoOpen : false,
				modal : true,
				hide : {
					effect : "puff",
					duration : 500
				},
				width : 400,

				buttons : [
						{
							text : "Ok",
							click : function() {
								//alert("123");
								var postData;
								var id = $("#uid").val();
								var stuName = $("#ustuName").val();
								var CGrade=$("#uCGrade").val();
								var MGrade=$("#uMGrade").val();
								var EGrade=$("#uEGrade").val();
								var LAGrade=$("#uLAGrade").val();
								$("#uid").removeAttr("readonly");
								$("#ustuName").removeAttr("readonly");
								console.log(id,stuName,CGrade,MGrade,EGrade,LAGrade);
								postData="<grade id='" + id + "' stuName='" + stuName + "' CGrade='" + CGrade + "' MGrade='"+ MGrade + "' EGrade='" + EGrade+ "' LAGrade='" + LAGrade + "'/>";
								/*postData = JSON.stringify({id : id,stuName : stuName,CGrade : CGrade,
									MGrade : MGrade, EGrade : EGrade, LAGrade : LAGrade});
								*/
								ajaxRequest(updateGradeUrl, 'POST', postData, 'application/xml', 'json', afterUpdateGrade);
								
								
							}
						}, {
							text : "Cancel",
							click : function() {
								$(this).dialog("close");
							}
						} ]
			});
	$("#dialog3").dialog("open");
	event.preventDefault();
}
function afterUpdateGrade(data){
	
	ajaxRequest(getAllGradeUrl, 'GET', null, null, 'json', renderGetAll);
	$("#list").trigger("reloadGrid");
	$("#dialog3").dialog("close");
}
function afterRequest(data){	
	ajaxRequest(getAllGradeUrl, 'GET', null, null, 'json', renderGetAll);
	$("#list").trigger("reloadGrid");
	$("#dialog1").dialog("close");
}
function renderGetAll(data) {
	jQuery("#list").jqGrid("clearGridData");
	var gradelist = [];
	var Grades = data.gradeList.Grades;
	// console.log(books);
	for (var i = 0; i < Grades.length; i++) {
		gradelist.push({
			sno : Grades[i].id,
			stuName : Grades[i].stuName,
			CGrade : Grades[i].CGrade,
			MGrade : Grades[i].MGrade,
			EGrade : Grades[i].EGrade,
			LAGrade : Grades[i].LAGrade,
			AVGGrade : Grades[i].AVGGrade,
			Rank : Grades[i].Rank
			
		});

	}
	for (var i = 0; i <= gradelist.length; i++) {
		jQuery("#list").jqGrid('addRowData', i + 1, gradelist[i]);
	}
	$("#list").trigger("reloadGrid");   
	gradelist=[];
}

jQuery("#list").jqGrid('navGrid', '#pager', {
	edit : true,
	add : false,
	del : false
});
$("#list").jqGrid('navButtonAdd', '#pager', {
	caption : '添加成绩',
	buttonicon : ".ui-icon-cart",
	onClickButton : function() {
		AddGrade();

	},
	position : "first"
});
$("#list").jqGrid('navButtonAdd', '#pager', {
	caption : '修改成绩',
	buttonicon : ".ui-icon-cart",
	onClickButton : function() {
		var rowid=$("#list").jqGrid("getGridParam","selrow");
		var rowData = $("#list").jqGrid('getRowData',rowid);
		console.log(rowData);
		if(rowid===null || rowid === undefined){
			
			jQuery('#ErrorInfo').html("<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span><strong>Alert:请先选中一条记录</strong></p>");
			
			jQuery('#ErrorInfo').show();
			setTimeout(function(){jQuery('#ErrorInfo').hide();},3000);
		}else{
			$("#uid").val(rowData.sno);
			$("#ustuName").val(rowData.stuName);
			$("#uCGrade").val(rowData.CGrade);
			$("#uMGrade").val(rowData.MGrade);
			$("#uEGrade").val(rowData.EGrade);
			$("#uLAGrade").val(rowData.LAGrade);
			$("#uid").attr({ readonly: 'true' });
			$("#ustuName").attr({ readonly: 'true' });
			UpdateGrade();
		}

	},
	position : "second"
});