//package com.urs.systems.model;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="User")
//public class User implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
//	private String name;
//	private Long mobile;
//	private String email;
//	private String city;
//	private String state;
//	private String password;
//	
//	@OneToMany(fetch=FetchType.EAGER, targetEntity=Task.class, cascade=CascadeType.ALL)
//	@JoinColumn(name = "uid", referencedColumnName="id")
//	private List<Task> tasks;
//	
//	@OneToMany(fetch=FetchType.EAGER, targetEntity=AssignTasks.class, cascade=CascadeType.ALL)
//	@JoinColumn(name = "uid", referencedColumnName="id")
////	private List<AssignTasks> assignTasks;
//	
//	public List<AssignTasks> getAssignTasks() {
//		return assignTasks;
//	}
//
//	public void setAssignTasks(List<AssignTasks> assignTasks) {
//		this.assignTasks = assignTasks;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	
//	public Long getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(Long mobile) {
//		this.mobile = mobile;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<Task> getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(List<Task> tasks) {
//		this.tasks = tasks;
//	}
//}
