package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.ITutorialService;

@Controller
public class TutorialController {

	@Autowired
	private ITutorialService tutorialService;

	@PostMapping("/tutorial_lists")
	public String displayTutorials(Model modelMap, @RequestParam int topicID) {
		modelMap.addAttribute("tutorial_list", tutorialService.getAllTutorialsFromDao(topicID));
		return "/tutorial/tutorials";
	}

	@GetMapping("/tutorial_details")
	public String displayTutorialDetails(Model modelMap, @RequestParam int tutorialID) {
		modelMap.addAttribute("tutorial_details", tutorialService.getTutorialDetailsFromDao(tutorialID));
		return "/tutorial/tutorial_details";
	}

}
