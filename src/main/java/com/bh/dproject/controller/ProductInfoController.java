package com.bh.dproject.controller;

import com.bh.dproject.entity.Result;
import com.bh.dproject.entity.StatusCode;
import com.bh.dproject.pojo.ProductInfo;
import com.bh.dproject.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 商品信息请求处理Controller
 */
@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;     //自动注入Service

    /**
     * 查询所有商品信息
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<ProductInfo> productInfos = productInfoService.finAll();
        return new Result(StatusCode.SUCCESS,"成功",productInfos);
    }

    /**
     * 根据商品id查询商品信息数据
     * @param id  商品id
     * @return
     */
    @RequestMapping(name = "/findById",value = "{id}")
    public Result findById(@PathVariable("id") String id){
        Optional<ProductInfo> productInfo = productInfoService.findById(id);
        if (productInfo.isPresent()){       //查询到的数据不为null则返回成功
            return new Result(StatusCode.SUCCESS,"成功",productInfo);
        }
        //查询不到数据则返回失败
        return new Result(StatusCode.FAIL,"失败");
    }
}
