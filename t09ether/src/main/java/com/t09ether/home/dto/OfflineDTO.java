package com.t09ether.home.dto;


public class OfflineDTO {
	private int off_no; //�Ϸù�ȣ
	private String userid;//���̵�
	private String off_subject;//������
	private String off_content;//�۳���
	private String location;//���
	private int group_num;//�����ο�
	private int cuurent_num;//�����ο�
	private String app_time;//��ӽð�
	private String deaddate;//����������
	private String off_hit;//��ȸ��
	private String writedate;//�����
	public int getOff_no() {
		return off_no;
	}
	public void setOff_no(int off_no) {
		this.off_no = off_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOff_subject() {
		return off_subject;
	}
	public void setOff_subject(String off_subject) {
		this.off_subject = off_subject;
	}
	public String getOff_content() {
		return off_content;
	}
	public void setOff_content(String off_content) {
		this.off_content = off_content;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGroup_num() {
		return group_num;
	}
	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}
	
	public int getCuurent_num() {
		return cuurent_num;
	}
	public void setCuurent_num(int cuurent_num) {
		this.cuurent_num = cuurent_num;
	}
	public String getApp_time() {
		return app_time;
	}
	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}
	public String getDeaddate() {
		return deaddate;
	}
	public void setDeaddate(String deaddate) {
		this.deaddate = deaddate;
	}
	public String getOff_hit() {
		return off_hit;
	}
	public void setOff_hit(String off_hit) {
		this.off_hit = off_hit;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
	@Override
	public String toString() {
		return "OfflineDTO [off_no=" + off_no + ", userid=" + userid + ", off_subject=" + off_subject + ", off_content="
				+ off_content + ", location=" + location + ", group_num=" + group_num + ", cuurent_num=" + cuurent_num
				+ ", app_time=" + app_time + ", deaddate=" + deaddate + ", off_hit=" + off_hit + ", writedate="
				+ writedate + "]";
	}
	
	
	
}
