package org.uts.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uts.business.domain.vo.ProductPageVo;
import org.uts.business.domain.vo.ProductVo;
import org.uts.business.service.ProductService;
import org.uts.result.RestResult;

import java.util.List;

/**
 * @Description 商品 接口类
 * @Author codBoy
 * @Date 2024/7/14 18:58
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
     * 分页查询商品列表信息
     */
    @PostMapping("/page")
    public RestResult productPage(@RequestBody ProductPageVo productPageVo){
        List<ProductVo> productVoList = productService.productPage(productPageVo);
        return RestResult.createSuccessfulRest(productVoList);
    }

    /*
     * 添加商品信息
     */
    @PostMapping
    public RestResult addProduct(@RequestBody ProductVo productVo){
        int id = productService.addProduct(productVo);
        return RestResult.createSuccessfulRest(id);
    }

    /*
     * 查询商品详情信息
     */
    @GetMapping("/{id}")
    public RestResult detail(@PathVariable Long id){
        ProductVo productVo = productService.selectById(id);
        return RestResult.createSuccessfulRest(productVo);
    }
}
