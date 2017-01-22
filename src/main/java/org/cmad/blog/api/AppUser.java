package org.cmad.blog.api;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table (name="APPUSER")
public class AppUser {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPUSER_ID")
	private int appUserId;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="APPUSER_PASSWORD")
	private String password;
	
	@Embedded
//	@OneToOne(cascade = CascadeType.ALL)
	private PersonalInfo personalInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="USER_TOPIC",joinColumns=@JoinColumn(name="USER_ID"),
	inverseJoinColumns=@JoinColumn(name="TOPIC_ID")
	)
	private Topic topic;
	
	public AppUser(){
		
	}

	public AppUser(String email,PersonalInfo personalInfo, Topic topic) {
		super();
		this.email = email;
		this.personalInfo = personalInfo;
		this.topic = topic;
	}
	
	public AppUser(String email, String password, PersonalInfo personalInfo, Topic topic) {
		super();
		this.email = email;
		this.password = password;
		this.personalInfo = personalInfo;
		this.topic = topic;
	}
	
	public AppUser(int appUserId,String email, String password, PersonalInfo personalInfo, Topic topic) {
		this(email,password,personalInfo,topic);
		this.appUserId = appUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Topic getInterests() {
		return topic;
	}

	public void setInterests(Topic interests) {
		this.topic = interests;
	}

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
