package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;

public interface OfflineService {
	public int offlineInsert(OfflineDTO dto);
	public int totalRecord(OfflinePagingVO vo);
	public List<OfflineDTO> offList(OfflinePagingVO vo);
	public OfflineDTO offlineSelect(int off_no);
	public void offlineHitCount(int off_no);
	public OfflineDTO offlineEditSelect(int off_no);
	public int offlineUpdate(OfflineDTO dto);
	public int offlineDelete(OfflineDTO dto);
}
