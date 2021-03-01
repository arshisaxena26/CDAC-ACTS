package com.app.service;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialService {
	List<Tutorial> getAllTutorialsFromDao(int topicId);

	Tutorial getTutorialDetailsFromDao(int tutorialId);
}
