package com.t09ether.home.dto;

public class OfflinePagingVO {
	//페이징처리시 필요한 변수들
		private int nowPage = 1; //현재페이지
		private int onePageRecord = 10;//한페이지에 표시할 레코드 수
		private int totalRecord;//총레코드수
		private int totalPage;//총페이지수
		private int lastPageRecord;//마지막 페이지에 남아있는 레코드 수
		
		private int onePageNumCount=5;//한페이지당 페이지 갯수
		private int startPageNum=1;
		
		//검색에 필요한 변수들
		private String searchKey;
		private String searchWord;
		
		
		
		public int getNowPage() {
			return nowPage;
		}
		public void setNowPage(int nowPage) {
			this.nowPage = nowPage;
		}
		public int getOnePageRecord() {
			return onePageRecord;
		}
		public void setOnePageRecord(int onePageRecord) {
			this.onePageRecord = onePageRecord;
		}
		public int getTotalRecord() {
			return totalRecord;
		}
		public void setTotalRecord(int totalRecord) {
			this.totalRecord = totalRecord;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getLastPageRecord() {
			return lastPageRecord;
		}
		public void setLastPageRecord(int lastPageRecord) {
			this.lastPageRecord = lastPageRecord;
		}
		public int getOnePageNumCount() {
			return onePageNumCount;
		}
		public void setOnePageNumCount(int onePageNumCount) {
			this.onePageNumCount = onePageNumCount;
		}
		public int getStartPageNum() {
			return startPageNum;
		}
		public void setStartPageNum(int startPageNum) {
			this.startPageNum = startPageNum;
		}
		public String getSearchKey() {
			return searchKey;
		}
		public void setSearchKey(String searchKey) {
			this.searchKey = searchKey;
		}
		public String getSearchWord() {
			return searchWord;
		}
		public void setSearchWord(String searchWord) {
			this.searchWord = searchWord;
		}
		@Override
		public String toString() {
			return "OfflinePagingVO [nowPage=" + nowPage + ", onePageRecord=" + onePageRecord + ", totalRecord="
					+ totalRecord + ", totalPage=" + totalPage + ", lastPageRecord=" + lastPageRecord
					+ ", onePageNumCount=" + onePageNumCount + ", startPageNum=" + startPageNum + ", searchKey="
					+ searchKey + ", searchWord=" + searchWord + "]";
		}
		
		
	
}
