package com.t09ether.home.dto;

public class AdminOrderPagingVO {
	private int nowPage2 = 1; // 현재 페이지
	private int onePageRecord2=3; // 한 페이지에 표시할 레코드 수
	private int totalRecord2; // 총 레코드 수
	private int totalPage2; // 총 페이지 수
	
	private int lastPageRecord2;//마지막 페이지에 남아 있는 레코드수
	
	private int onePageNumCount2=5;//한 페이지 당 페이지 갯수
	private int startPageNum2 = 1;
	
	//검색에 필요한 변수들
	private String searchKey2;
	private String searchWord2;
	private String userid;
	@Override
	public String toString() {
		return "PagingVO [nowPage2=" + nowPage2 + ", onePageRecord2=" + onePageRecord2 + ", totalRecord2=" + totalRecord2
				+ ", totalPage2=" + totalPage2 + ", lastPageRecord2=" + lastPageRecord2 + ", onePageNumCount2="
				+ onePageNumCount2 + ", startPageNum2=" + startPageNum2 + ", searchKey2=" + searchKey2 + ", searchWord2="
				+ searchWord2 + "]";
	}
	
	
	


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}





	public void setTotalRecord2(int totalRecord2) {
		this.totalRecord2 = totalRecord2;
	}


	public int getNowPage2() {
		return nowPage2;
	}
	public void setNowPage2(int nowPage2) {
		this.nowPage2 = nowPage2;
		
		//출력할 페이지 시작 번호를 계산
		//((현재 페이지-1)/표시할 페이지 수)*표시할 페이수 + 1
		startPageNum2 = ((nowPage2-1)/onePageNumCount2)*onePageNumCount2+1;
		
	}
	
	public int getOnePageRecord2() {
		return onePageRecord2;
	}

	public void setOnePageRecord2(int onePageRecord2) {
		this.onePageRecord2 = onePageRecord2;
	}

	public int getTotalRecord2() {
		return totalRecord2;
	}
	public void setTotalRecord(int totalRecord2) {
		this.totalRecord2 = totalRecord2;
		
		//총 레코드수를 이용하여 총 페이지 수를 구하기
		totalPage2 = (int)Math.ceil((double)totalRecord2/onePageRecord2);
		
		//마지막 페이지에 남아 있는 레코드 수
		lastPageRecord2 = onePageRecord2;
		if(nowPage2==totalPage2) {
			if(totalRecord2%onePageRecord2==0){//나머지가 0일 경우 lastPageRecord = onePageRecord
				lastPageRecord2 = onePageRecord2;
			}else {//나머지가 있을 경우 남아있는 레코드 수를 lastPageRecord
				lastPageRecord2 = totalRecord2 % onePageRecord2;
			}
		}
	
	}
	public int getTotalPage2() {
		return totalPage2;
	}
	public void setTotalPage2(int totalPage2) {
		this.totalPage2 = totalPage2;
	}
	public int getLastPageRecord2() {
		return lastPageRecord2;
	}
	public void setLastPageRecord2(int lastPageRecord2) {
		this.lastPageRecord2 = lastPageRecord2;
	}

	public int getOnePageNumCount2() {
		return onePageNumCount2;
	}

	public void setOnePageNumCount2(int onePageNumCount2) {
		this.onePageNumCount2 = onePageNumCount2;
	}

	public int getStartPageNum2() {
		return startPageNum2;
	}

	public void setStartPageNum2(int startPageNum2) {
		this.startPageNum2 = startPageNum2;
	}

	public String getSearchKey2() {
		return searchKey2;
	}

	public void setSearchKey2(String searchKey2) {
		this.searchKey2 = searchKey2;
	}

	public String getSearchWord2() {
		return searchWord2;
	}

	public void setSearchWord2(String searchWord2) {
		this.searchWord2 = searchWord2;
	}
}
