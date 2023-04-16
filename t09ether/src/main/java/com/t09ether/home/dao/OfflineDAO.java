package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;

public interface OfflineDAO {
	//글등록
	public int offlineInsert(OfflineDTO dto);
	//총레코드수
	public int totalRecord(OfflinePagingVO vo);
	//해당페이지 선택하기
	public List<OfflineDTO> offList(OfflinePagingVO vo);
	//글선택(off_no)
	public OfflineDTO offlineSelect(int no);
}
