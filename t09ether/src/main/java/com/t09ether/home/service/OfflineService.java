package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.OffPartDTO;
import com.t09ether.home.dto.OfflineCommentDTO;
import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;
<<<<<<< HEAD
=======
import com.t09ether.home.dto.OfflineParticipantDTO;
>>>>>>> e1553b84b7f1106e38dcfebd49b677c1b3164044
import com.t09ether.home.dto.RegisterDTO;

public interface OfflineService {
	public int offlineInsert(OfflineDTO dto);
	public int totalRecord(OfflinePagingVO vo);
	public List<OfflineDTO> offList(OfflinePagingVO vo);
	public OfflineDTO offlineSelect(int off_no);
	public void offlineHitCount(int off_no);
	public OfflineDTO offlineEditSelect(int off_no);
	public int offlineUpdate(OfflineDTO dto);
	public int offlineDelete(OfflineDTO dto);
	public RegisterDTO getParticipant(String userid);
<<<<<<< HEAD
	public int participantInsert(OffPartDTO opDTO);
	public List<OffPartDTO> participantList(int off_no);
	public int currentNumCount(int off_no);
	public void currentNumPlus(int off_no);
	public List<String> getIds(int off_no);
	public void offlineClose(int off_no);

=======
	public int participantInsert(OfflineParticipantDTO opDTO);
	public List<OfflineParticipantDTO> participantList(int off_no);
	public int currentNumCount(int off_no);
	public List<String> getIds(int off_no);
>>>>>>> e1553b84b7f1106e38dcfebd49b677c1b3164044
	
}
