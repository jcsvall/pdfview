var baseUrl = "/pdf/visor";
function save(){
	var formFile=$("#form-file")[0];
	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url: baseUrl + "/ajax/save",
		data: new FormData(formFile),
		processData: false,
		contentType: false,
		cache: false,
		//timeout: 600000,
		success: function (data) {
			//alert(data);
			updateElement("tableContent",baseUrl + "/ajax/files");
			formFile.reset();
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

function updateElement(idContenedorTable,url){
	$("#"+idContenedorTable).load(url, function( response, status, xhr ) {
		  if( status == "error" ) {
			  alert("Error");
		  }		  
		});
}

function deleteFile(idFile){
	updateElement("tableContent",baseUrl + "/ajax/delete?idFile="+idFile);
}
