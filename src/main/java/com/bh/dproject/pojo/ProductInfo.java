package com.bh.dproject.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 商品信息实体类
 */

@Data
@Entity
@Table(name = "product_info")
public class ProductInfo {
    @Id
    private String productId;   //商品id

    private String productName;     //商品名称

    private BigDecimal productPrice;      //商品单价

    private Integer productStock;       //商品库存

    private String productDescription;      //描述

    private String productIcon;     //小图

    private Integer productStatus;      //商品状态,0正常1下架

    private Integer categoryType;       //类目编号

    private Timestamp createTime;      //创建时间

    private Timestamp updateTime;      //修改时间

}
