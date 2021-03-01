package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer tutorialId;

	@Column(name = "name", length = 50)
	private String tutorialName;

	@Column(name = "author", length = 20)
	private String authorName;

	@Column(name = "publish_date")
	private LocalDate publishDate;

	@Column(name = "upvotes")
	private int upVotes;

	@Column(length = 100)
	private String contents;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;

	public Tutorial() {
		// default Constructor
	}

	public Integer getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(Integer tutorialId) {
		this.tutorialId = tutorialId;
	}

	public String getTutorialName() {
		return tutorialName;
	}

	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", tutorialName="
				+ tutorialName + ", authorName=" + authorName
				+ ", publishDate=" + publishDate + ", upVotes=" + upVotes + ", contents=" + contents + "]";
	}
}
