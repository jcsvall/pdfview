package com.jcsvall.pdfview.forms;

import org.springframework.web.multipart.MultipartFile;

import com.jcsvall.pdfview.entities.Files;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormFile {
	private Files files;
	private MultipartFile fileData;
}
