package com.t09ether.home.dao;

import java.util.List;

import com.t09ether.home.dto.OfflineCommentDTO;

public interface OfflineCommentDAO {
	//댓글목록
	public List<OfflineCommentDTO> commentListSelect(int off_no);
	
}
