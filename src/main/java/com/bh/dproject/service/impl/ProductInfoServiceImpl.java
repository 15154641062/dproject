package com.bh.dproject.service.impl;

import com.bh.dproject.dao.ProductInfoDao;
import com.bh.dproject.pojo.ProductInfo;
import com.bh.dproject.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 商品信息service
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;

    /**
     * 返回所有商品信息
     * @return
     */
    @Override
    public List<ProductInfo> finAll() {
        return productInfoDao.findAll();
    }

    /**
     * 根据商品id查询商品信息
     * @param id
     * @return
     */
    @Override
    public Optional<ProductInfo> findById(String id) {
        return productInfoDao.findById(id);
    }
}
