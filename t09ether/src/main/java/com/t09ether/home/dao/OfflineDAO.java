package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;
import com.t09ether.home.dto.OfflineParticipantDTO;
import com.t09ether.home.dto.RegisterDTO;

public interface OfflineDAO {
	//글등록
	public int offlineInsert(OfflineDTO dto);
	//총레코드수
	public int totalRecord(OfflinePagingVO vo);
	//해당페이지 선택하기
	public List<OfflineDTO> offList(OfflinePagingVO vo);
	//글선택(off_no)
	public OfflineDTO offlineSelect(int off_no);
	//조회수증가
	public void offlineHitCount(int off_no);
	//글선택(수정폼으로이동)
	public OfflineDTO offlineEditSelect(int off_no);
	//글수정(DB등록)
	public int offlineUpdate(OfflineDTO dto);
	//글삭제
	public int offlineDelete(OfflineDTO dto);
	//공구참여시 -> 참여자의 정보(RegisterDTO)불러오기
	public RegisterDTO offlineParticipant(String userid);
	
}
