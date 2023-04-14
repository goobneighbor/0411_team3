package com.t09ether.home.service;

import java.util.List;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;

public interface OfflineService {
	public int offlineInsert(OfflineDTO dto);
	public int totalRecord(OfflinePagingVO vo);
	public List<OfflineDTO> pageSelect(OfflinePagingVO vo);
}
