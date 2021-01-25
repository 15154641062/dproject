package com.bh.dproject.dao;

import com.bh.dproject.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
}
