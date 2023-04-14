package com.t09ether.home.dto;

public class OfflinePagingVO {
	//����¡ó���� �ʿ��� ������
		private int nowPage = 1; //����������
		private int onePageRecord = 10;//���������� ǥ���� ���ڵ� ��
		private int totalRecord;//�ѷ��ڵ��
		private int totalPage;//����������
		private int lastPageRecord;//������ �������� �����ִ� ���ڵ� ��
		
		private int onePageNumCount=5;//���������� ������ ����
		private int startPageNum=1;
		
			///////////// Getters & Setters ////////////
			public int getNowPage() {
				return nowPage;
			}

			public void setNowPage(int nowPage) {
				this.nowPage = nowPage;
				
				//����� ������
				//((����������-1)/ǥ������������)*ǥ������������+1		
				startPageNum = ((nowPage-1)/onePageNumCount)*onePageNumCount+1;
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
				
				//�� ���ڵ� ���� �̿��Ͽ� �� ������ ���� ���ϱ�
				totalPage = (int)Math.ceil((double)totalRecord/onePageRecord);
				
				//�������������� �����ִ� ���ڵ� ��
				lastPageRecord = onePageRecord; 
				if(nowPage==totalPage) {
					if(totalRecord%onePageRecord ==0){//�������� 0�� ���� lastPageRecord  <- onePageRecord
						lastPageRecord = onePageRecord;
					}else {//�������� ���� ��� �����ִ� ���ڵ� ���� lastPageRecord			
						lastPageRecord = totalRecord%onePageRecord;
					}
				}
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

			@Override
			public String toString() {
				return "OfflinePagingVO [nowPage=" + nowPage + ", onePageRecord=" + onePageRecord + ", totalRecord="
						+ totalRecord + ", totalPage=" + totalPage + ", lastPageRecord=" + lastPageRecord
						+ ", onePageNumCount=" + onePageNumCount + ", startPageNum=" + startPageNum + "]";
			}
			
			
			
}

