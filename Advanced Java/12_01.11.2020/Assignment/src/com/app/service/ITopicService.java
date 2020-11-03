package com.app.service;

import java.util.List;

import com.app.pojos.Topic;

public interface ITopicService {
	List<Topic> getAllTopicsFromDao();
}
