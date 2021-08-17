package com.chris.driverslicense.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chris.driverslicense.dojosandninjas.models.Ninja;
import com.chris.driverslicense.dojosandninjas.services.DojoService;
import com.chris.driverslicense.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public NinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService=dojoService;
		this.ninjaService=ninjaService;
	}

	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "/ninjas/new.jsp";
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String addNinjaToDb(@ModelAttribute("ninja") Ninja ninja, @RequestParam("dojo_id") Long dojoId) {
		ninja.setDojo(dojoService.findDojo(dojoId));
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
}
