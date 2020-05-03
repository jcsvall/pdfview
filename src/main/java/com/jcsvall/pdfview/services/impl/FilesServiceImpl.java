package com.jcsvall.pdfview.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcsvall.pdfview.entities.Files;
import com.jcsvall.pdfview.repository.FilesRepository;
import com.jcsvall.pdfview.services.FilesSevice;

@Service("filesService")
public class FilesServiceImpl implements FilesSevice {
	@Autowired
	private FilesRepository filesRepository;

	@Override
	public List<Files> findAll() {
		return filesRepository.findAll();
	}

	@Override
	public Files save(Files file) {
		return filesRepository.save(file);
	}

	@Override
	public void delete(Files file) {
		filesRepository.delete(file);
	}

	@Override
	public Files findById(Integer id) {
		return filesRepository.findById(id);
	}

}
