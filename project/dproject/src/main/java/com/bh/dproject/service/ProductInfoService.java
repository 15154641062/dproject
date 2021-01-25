package com.bh.dproject.service;

import com.bh.dproject.pojo.ProductInfo;

import java.util.List;
import java.util.Optional;

public interface ProductInfoService {
    public List<ProductInfo> finAll();      //查找所有的数据

    public Optional<ProductInfo> findById(String id);    //通过id查询数据
}
