package com.chris.driverslicense.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chris.driverslicense.dojosandninjas.models.Dojo;
import com.chris.driverslicense.dojosandninjas.services.DojoService;

@Controller
public class DojoControllers {
	private final DojoService dojoService;

	public DojoControllers (DojoService dojoService) {
		this.dojoService=dojoService;
	}

	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}

	@RequestMapping(value = "/dojos", method = RequestMethod.POST)
	public String dojoToDb(@ModelAttribute("dojo") Dojo dojo) {
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
	}

	@RequestMapping("/dojos/{id}")
	public String dojoView(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "/dojos/view.jsp";
	}
}
