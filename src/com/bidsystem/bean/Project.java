package com.bidsystem.bean;

public class Project {
	private int id;
	private String projectNum; // 项目编号
	private String projectName; // 项目名称
	private String buyMethod; // 采购方式
	private String buyDepartment; // 采购部门
	private String budget; // 预算
	private String noticeTime; // 公告时间
	private String startTiem; // 开标时间
	private String startAddress; // 开标地点
	private String dealTime; // 成交公告时间
	private String dealUrl; // 成交网址
	private String dealUnit; // 成交单位
	private String dealPrice; // 成交价
	private String specialistCount; // 专家人数
	private String linkmanName; // 联系人姓名
	private String linkmanMobile; // 联系人电话
	private String projectStatus; // 项目状态(是否评标结束)
	private String dealSpecialistId; // 最终成交专家的id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBuyMethod() {
		return buyMethod;
	}

	public void setBuyMethod(String buyMethod) {
		this.buyMethod = buyMethod;
	}

	public String getBuyDepartment() {
		return buyDepartment;
	}

	public void setBuyDepartment(String buyDepartment) {
		this.buyDepartment = buyDepartment;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getStartTiem() {
		return startTiem;
	}

	public void setStartTiem(String startTiem) {
		this.startTiem = startTiem;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

	public String getDealUrl() {
		return dealUrl;
	}

	public void setDealUrl(String dealUrl) {
		this.dealUrl = dealUrl;
	}

	public String getDealUnit() {
		return dealUnit;
	}

	public void setDealUnit(String dealUnit) {
		this.dealUnit = dealUnit;
	}

	public String getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(String dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getSpecialistCount() {
		return specialistCount;
	}

	public void setSpecialistCount(String specialistCount) {
		this.specialistCount = specialistCount;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanMobile() {
		return linkmanMobile;
	}

	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getDealSpecialistId() {
		return dealSpecialistId;
	}

	public void setDealSpecialistId(String dealSpecialistId) {
		this.dealSpecialistId = dealSpecialistId;
	}
}
