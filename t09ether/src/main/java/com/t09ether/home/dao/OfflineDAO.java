package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;

public interface OfflineDAO {
	//글등록
	public int offlineInsert(OfflineDTO dto);
	//총레코드수
	public int totalRecord(OfflinePagingVO vo);
	//전체레코드 담아오기
	public List<OfflineDTO> offList(OfflinePagingVO vo);
	//글선택(off_no)
	public OfflineDTO offlineSelect(int off_no);
	//조회수증가
	public void offlineHitCount(int off_no);
}
