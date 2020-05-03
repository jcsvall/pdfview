package com.jcsvall.pdfview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(value = "/ajax/files")
	public Object files(ModelMap model) {
		try {
			pdfComponent.files(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pdf/add :: fragmenTable";
	}

	@GetMapping(value = "/ajax/delete")
	public Object delete(@RequestParam(name = "idFile") Integer idFile, ModelMap model) {
		try {
			pdfComponent.delete(idFile, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pdf/add :: fragmenTable";
	}
	
	@GetMapping(value = "/ajax/getPdf")
	@ResponseBody
	public Object getPdf(@RequestParam(name = "idFile") Integer idFile, ModelMap model) {
		try {
			return pdfComponent.getPdf(idFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

}
