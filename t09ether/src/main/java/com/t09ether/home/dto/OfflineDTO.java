package com.t09ether.home.dto;

import java.util.Date;

public class OfflineDTO {
	private int off_no; //�Ϸù�ȣ
	private String userid;//���̵�
	private String off_subject;//������
	private String off_content;//�۳���
	private String location;//���
	private int group_num;//�����ο�
	private int current_num;//�����ο�
	private String app_time;//��ӽð�
	private String deaddate;//����������
	private int off_hit;//��ȸ��
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
	
	public int getCurrent_num() {
		return current_num;
	}
	public void setCurrent_num(int current_num) {
		this.current_num = current_num;
	}
	public String getApp_time() {
		return app_time;
	}
	public void setApp_time(Date app_time) {
		this.app_time = app_time.toString();
	}
	public String getDeaddate() {
		return deaddate;
	}
	public void setDeaddate(Date deaddate) {
		this.deaddate = deaddate.toString();
	}
	
	public int getOff_hit() {
		return off_hit;
	}
	public void setOff_hit(int off_hit) {
		this.off_hit = off_hit;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate.toString();
	}
	@Override
	public String toString() {
		return "OfflineDTO [off_no=" + off_no + ", userid=" + userid + ", off_subject=" + off_subject + ", off_content="
				+ off_content + ", location=" + location + ", group_num=" + group_num + ", current_num=" + current_num
				+ ", app_time=" + app_time + ", deaddate=" + deaddate + ", off_hit=" + off_hit + ", writedate="
				+ writedate + "]";
	}
	
	
	
	
	
}
