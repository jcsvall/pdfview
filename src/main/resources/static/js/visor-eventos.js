var VISOR_PDFJS = "/pdfjs/web/viewer.html?file=";
//Funciones para carga de pdf en visor
//from server
function pdfFromServer(idFile){
	var completeURL = baseUrl + "/ajax/getPdf?idFile="+idFile;
	$.get(completeURL, function(data,status,xhr){		  
		  if(status=="success"){
			  showPdf(data);
		  }else{
			  alert("Error");
		  }
		});
}

function showPdf(stringBase64){	
	$('#pdfViewModal').modal('show');	
	var blob = stringBase64toBlob(stringBase64);
	var url = URL.createObjectURL(blob);
	var urlFrame = VISOR_PDFJS + encodeURIComponent(url);
	var content = '<iframe src="'+urlFrame+'" id="if" width="100%" height="450px" style="border: none;"></iframe>';
	$("#pdf").html(content); 		
}

function stringBase64toBlob(arrayBuffer) {
    var byteString = atob(arrayBuffer);
    var ab = new ArrayBuffer(byteString.length);
    var ia = new Uint8Array(ab);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }
    return new Blob([ab], { type: 'application/pdf' });
}
// end from server

//preview before upload
function previewPdf(){
	//var dataFile = document.querySelector('input[type=file]').files[0]; 
	var dataFile = ($("#fileData"))[0].files[0];
	if(dataFile == undefined){
		alert("No se ha seleccionado un archivo");
	}else{
	  $('#pdfViewModal').modal('show');	
	
	  var reader = new FileReader();
      reader.onload = function(){
        var arrayBuffer = reader.result;       
  	    var blob = new Blob([arrayBuffer], {type: 'application/pdf'});
  	    var url = URL.createObjectURL(blob);
  	    var urlFrame = VISOR_PDFJS + encodeURIComponent(url);
  	  
  	    var content = '<iframe src="'+urlFrame+'" id="if" width="100%" height="450px" style="border: none;"></iframe>';
	    $("#pdf").html(content);
  	    var $iframe = $("#if");	
      };
    
      reader.readAsArrayBuffer(dataFile);	
	}
}