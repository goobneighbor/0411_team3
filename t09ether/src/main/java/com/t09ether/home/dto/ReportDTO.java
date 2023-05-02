package com.t09ether.home.dto;

public class ReportDTO {
	private int report_no;
	private String mem_id;
	private String target_id;
	private String report_content;
	private String writedate;
	private int target_type;
	
	@Override
	public String toString() {
		return "ReportDTO [report_no=" + report_no + ", mem_id=" + mem_id + ", target_id=" + target_id
				+ ", report_content=" + report_content + ", writedate=" + writedate + ", target_type=" + target_type
				+ "]";
	}
	
	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getTarget_id() {
		return target_id;
	}
	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}
	public String getReport_content() {
		return report_content;
	}
	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public int getTarget_type() {
		return target_type;
	}
	public void setTarget_type(int target_type) {
		this.target_type = target_type;
	}
}
