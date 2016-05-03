function ajaxRequest(url, httpMethod, param, contenttype, datatype, callback) {

	var request = jQuery.ajax({type : httpMethod, url : url, data : param, contentType : contenttype, dataType : datatype});

	request.done(function(data) {
		try {
			if (data === null || data === undefined) {
				
				callback(data);
			} else {
				
				callback(data);
			}
		} catch (e) {
			/*jQuery('#ErrorInfo').html("<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span><strong>Alert:"+e+"</strong></p>");
			jQuery('#ErrorInfo').show();
			setTimeout(function(){jQuery('#ErrorInfo').hide();},3000);*/
		}
	});
	request.fail(function(textStatus, errorThrown) {
		jQuery('#ErrorInfo').html("<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span><strong>Alert:"+errorThrown + " status=" + textStatus.status+"</strong></p>");
		jQuery('#ErrorInfo').show();
		setTimeout(function(){jQuery('#ErrorInfo').hide();},3000);
	});
}