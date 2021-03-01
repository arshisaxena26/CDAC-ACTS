package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITutorialDao;
import com.app.pojos.Tutorial;

@Service
@Transactional
public class TutorialServiceImpl implements ITutorialService {

	@Autowired
	private ITutorialDao tutorialDao;

	@Override
	public List<Tutorial> getAllTutorialsFromDao(int topicId) {
		return tutorialDao.getAllTutorials(topicId);
	}

	@Override
	public Tutorial getTutorialDetailsFromDao(int tutorialId) {
		return tutorialDao.getTutorialDetails(tutorialId);
	}

}
