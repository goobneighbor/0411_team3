package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.OfflineDTO;
import com.t09ether.home.dto.OfflinePagingVO;

public interface OfflineDAO {
	//�۵��
	public int offlineInsert(OfflineDTO dto);
	//�ѷ��ڵ��
	public int totalRecord(OfflinePagingVO vo);
	//DB�� �ִ� DTO �迭�� ���
	public List<OfflineDTO> offList(OfflinePagingVO vo);
}
