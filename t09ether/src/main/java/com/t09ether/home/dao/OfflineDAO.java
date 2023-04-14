package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;

public interface OfflineDAO {
	//�۵��
	public int offlineInsert(OfflineDTO dto);
	//�ѷ��ڵ��
	public int totalRecord(OfflinePagingVO vo);
	//�ش������� �����ϱ�
	public List<OfflineDTO> pageSelect(OfflinePagingVO vo);
}
