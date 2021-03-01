package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITopicDao;
import com.app.pojos.Topic;

@Service
@Transactional
public class TopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicDao topicDao;

	@Override
	public List<Topic> getAllTopicsFromDao() {
		return topicDao.getAllTopics();
	}

}
