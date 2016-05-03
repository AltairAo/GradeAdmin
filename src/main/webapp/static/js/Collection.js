var CalAllAVGUrl="gradeadmin/grade/CalAllAVG";
var CalSingleAVGUrl="gradeadmin/grade/CalSingleAVG";
var CalRankUrl="gradeadmin/grade/CalRank";
var IndicateByPartUrl="gradeadmin/grade/IndicateByPart"

function CalAllAVG(){
	ajaxRequest(CalAllAVGUrl, 'GET', null, null, 'json', renderGetAll);
}
function CalSingleAVG(item){
	postData = item.toString();
	/*postData = JSON.stringify({courseName : item});*/
	
	ajaxRequest(CalSingleAVGUrl, 'POST', postData, 'text/xml', 'text', afterCalSingleAVG);
}
function  afterCalSingleAVG(data){
	
	jQuery('#SingleAVG').html(data);
	$("#SingleAVG").attr({ readonly: 'true' });
	$("#dialog-calsingleavg").dialog(
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
								$("#SingleAVG").removeAttr("readonly");
								jQuery('#SingleAVG').html("");
								$(this).dialog("close");
							}
						}, {
							text : "Cancel",
							click : function() {
								$("#SingleAVG").removeAttr("readonly");
								jQuery('#SingleAVG').html("");
								$(this).dialog("close");
							}
						} ]
			});
	$("#dialog-calsingleavg").dialog("open");
	event.preventDefault();
	
}

function CalRank(){
	ajaxRequest(CalRankUrl, 'GET', null, null, 'json', renderGetAll);
}
function IndicateByPart(part){
	postData = part;
	ajaxRequest(IndicateByPartUrl, 'POST', postData, 'text/xml', 'text', afterIndicateByPart);
}
function afterIndicateByPart(data){
	console.log(data);
	jQuery('#IndicateByPart').html("<p><span class='ui-icon ui-icon-info' style='float: left; margin-right: .3em;'></span><strong>该分数段人数为："+data+"</strong> </p>");
}


