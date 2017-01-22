package org.cmad.blog.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table (name="POST")
public class Post {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_ID")
	private int id;
	
	@Column(name="POST_TITLE")
	private String title;
	
	@Column(name="POST_DESC")
	private String description;
	
	@Column(name="POST_CREATION_TIME")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdTime;
	//private Date modifiedTime;
	
	@OneToOne
	@JoinTable(name="POST_TOPIC",joinColumns=@JoinColumn(name="POST_ID"),
	inverseJoinColumns=@JoinColumn(name="TOPIC_ID")
	)
	private Topic topic;
	
	@OneToMany
	@JoinTable(name="POST_COMMENT",joinColumns=@JoinColumn(name="POST_ID"),
	inverseJoinColumns=@JoinColumn(name="COMMENT_ID")
	)
	private Collection<Comment> comment = new ArrayList<Comment>();
	
	public Post(){
		
	}
	
	public Post(String title, String description, Date createdTime, Topic topic, Comment comment) {
		super();
		this.title = title;
		this.description = description;
		this.createdTime = createdTime;
		this.topic = topic;
//		this.comment = (Collection<Comment>) comment;
	}
	
	public Post(int id, String title, String description, Date createdTime, Topic topic, Comment comment) {
		this(title,description,createdTime,topic,comment);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Collection<Comment> getComment() {
		return comment;
	}

	public void setComment(Collection<Comment> comment) {
		this.comment = comment;
	}
	
}
