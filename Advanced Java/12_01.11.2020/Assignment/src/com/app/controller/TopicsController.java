package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.service.ITopicService;

@Controller
public class TopicsController {

	@Autowired
	private ITopicService topicService;

	@PostMapping("/topic_lists")
	public String displayTopics(Model modelMap) {
		modelMap.addAttribute("topic_list", topicService.getAllTopicsFromDao());
		return "/topic/topics";
	}
}
