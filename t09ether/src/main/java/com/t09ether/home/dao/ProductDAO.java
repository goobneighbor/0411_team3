package com.t09ether.home.dao;

import com.t09ether.home.dto.ProductDTO;

public interface ProductDAO {
	
	//상품등록
	public int productInsert(ProductDTO dto); 
}
