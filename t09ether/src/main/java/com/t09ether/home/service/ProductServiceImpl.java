package com.t09ether.home.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.t09ether.home.dao.ProductDAO;
import com.t09ether.home.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {
	@Inject
	ProductDAO dao;
	
	@Override
	public int productInsert(ProductDTO dto) {		
		return dao.productInsert(dto);
	}

}
