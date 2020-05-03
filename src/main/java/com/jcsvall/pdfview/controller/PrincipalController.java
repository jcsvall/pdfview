package com.jcsvall.pdfview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PrincipalController {
	@RequestMapping(value = {"/",""})
	public String frases(ModelMap model) {
		return "pdf/index";
	}
}
