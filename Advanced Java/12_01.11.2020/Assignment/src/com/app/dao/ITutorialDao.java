package com.app.dao;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialDao {
	List<Tutorial> getAllTutorials(int topicId);

	Tutorial getTutorialDetails(int tutorialId);
}
