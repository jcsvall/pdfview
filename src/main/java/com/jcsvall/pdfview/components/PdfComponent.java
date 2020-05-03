package com.jcsvall.pdfview.components;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import com.jcsvall.pdfview.entities.Files;
import com.jcsvall.pdfview.forms.FormFile;
import com.jcsvall.pdfview.services.FilesSevice;

@Component("pdfComponent")
public class PdfComponent {
	@Autowired
	FilesSevice fileService;

	public void setForm(ModelMap model) {
		model.put("formFile", new FormFile());

		List<Files> filesList = fileService.findAll();
		model.put("filesList", filesList);
	}

	public void getFiles() {
		System.out.println("TEST");
	}

	public void save(FormFile formFile) throws IOException {
		MultipartFile inputFile = formFile.getFileData();
		String fileName = inputFile.getOriginalFilename();
		byte[] byteStream = inputFile.getBytes();

		Files file = formFile.getFiles();
		file.setFileName(fileName);
		file.setFileStream(byteStream);
		fileService.save(file);
		System.out.println("Guardado");
	}

	public void files(ModelMap model) {
		List<Files> filesList = fileService.findAll();
		model.put("filesList", filesList);
	}

	public void delete(Integer idFile, ModelMap model) {
		Files file = new Files();
		file.setId(idFile);
		fileService.delete(file);
		model.put("filesList", fileService.findAll());
	}
	
	public Object getPdf(Integer idFile) {
		Files file = fileService.findById(idFile);
		byte[] byteFile = file.getFileStream();
		String encodedText = Base64Utils.encodeToString(byteFile);
		return encodedText;
	}

}
