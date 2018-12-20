package com.bidsystem.bean;

public class Specialist {
	private int id;// 主键，自增 long
	private String name;// 专家姓名 varchar
	private String gender;// 专家性别 varchar
	private String born;// 出生日期 varchar
	private String identityCard;// 身份证 varchar
	private String workStatus;// 工作状态 varchar
	private String graduateCollege;// 毕业学员 varchar
	private String hightestEducation;// 最高学历 varchar
	private String professional;// 专业
	private String workTime;// 工作时间
	private String workUnit;// 工作单位
	private String post;// 岗位
	private String technicalTitles;// 技术职称
	private String mobile;// 联系电话
	private String address;// 所在地
	private String joinDomain;// 参加评审专业

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getGraduateCollege() {
		return graduateCollege;
	}

	public void setGraduateCollege(String graduateCollege) {
		this.graduateCollege = graduateCollege;
	}

	public String getHightestEducation() {
		return hightestEducation;
	}

	public void setHightestEducation(String hightestEducation) {
		this.hightestEducation = hightestEducation;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTechnicalTitles() {
		return technicalTitles;
	}

	public void setTechnicalTitles(String technicalTitles) {
		this.technicalTitles = technicalTitles;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoinDomain() {
		return joinDomain;
	}

	public void setJoinDomain(String joinDomain) {
		this.joinDomain = joinDomain;
	}
}
