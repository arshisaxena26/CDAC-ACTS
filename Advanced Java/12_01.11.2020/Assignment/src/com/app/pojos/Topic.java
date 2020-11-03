package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer topicId;

	@Column(name = "name", length = 20, unique = true)
	private String topicName;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<Tutorial> tutorials;

	public Topic() {
		// default Constructor
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + "]";
	}

	// Helper Methods
	public void addTutorialToTopic(Tutorial t) {
		getTutorials().add(t);
		t.setTopic(this);
	}

	public void removeTutorialFromTopic(Tutorial t) {
		getTutorials().remove(t);
		t.setTopic(null);
	}

}
