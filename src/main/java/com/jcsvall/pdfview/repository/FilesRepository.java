package com.jcsvall.pdfview.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcsvall.pdfview.entities.Files;

@Repository("filesRepository")
public interface FilesRepository extends JpaRepository<Files, Serializable> {
	public Files findById(Integer id);
}
