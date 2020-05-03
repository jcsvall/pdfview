var baseUrl = "/pdf/visor";
function save(){
	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url: baseUrl + "/ajax/save",
		data: new FormData($("#form-file")[0]),
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data) {
			alert(data);
		},
		error: function (e) {
			console.log(e);
			alert("Error"+e);
		},
		beforeSend: function () {
			
        },
        complete: function () {
        	
        }
	});
}