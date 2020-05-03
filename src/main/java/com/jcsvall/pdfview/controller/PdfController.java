package com.jcsvall.pdfview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcsvall.pdfview.components.PdfComponent;
import com.jcsvall.pdfview.forms.FormFile;

@Controller
@RequestMapping("/pdf/visor")
public class PdfController {
	@Autowired
	@Qualifier("pdfComponent")
	private PdfComponent pdfComponent;

	@RequestMapping(value = { "/", "" })
	public String frases(ModelMap model) {
		pdfComponent.setForm(model);
		return "pdf/add";
	}

	@PostMapping(value = "/ajax/save")
	@ResponseBody
	public Object save(@ModelAttribute FormFile formFile, ModelMap model) {
		try {
			pdfComponent.save(formFile);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
