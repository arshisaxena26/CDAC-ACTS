package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Tutorial;

@Repository
public class TutorialDaoImpl implements ITutorialDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Tutorial> getAllTutorials(int topicId) {
		String jpql = "select t from Tutorial t where t.topic.topicId = :topic order by t.upVotes desc";

		return sf.getCurrentSession().createQuery(jpql, Tutorial.class).setParameter("topic", topicId).getResultList();
	}

	@Override
	public Tutorial getTutorialDetails(int tutorialId) {
		return sf.getCurrentSession().get(Tutorial.class, tutorialId);
	}

}
