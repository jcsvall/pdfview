package com.jcsvall.pdfview.services;

import java.util.List;

import com.jcsvall.pdfview.entities.Files;

public interface FilesSevice {
	public abstract List<Files> findAll();

	public abstract Files save(Files file);
}
