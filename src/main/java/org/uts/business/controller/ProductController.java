package org.uts.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.uts.business.domain.vo.BatchAddProductVo;
import org.uts.business.domain.vo.BatchDelProductVo;
import org.uts.business.domain.vo.ProductPageVo;
import org.uts.business.domain.vo.ProductVo;
import org.uts.business.service.ProductService;
import org.uts.result.RestResult;
import org.uts.valid.*;
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
     * 查询商品详情信息
     */
    @GetMapping("/{id}")
    public RestResult detail(@PathVariable Long id){
        ProductVo productVo = productService.selectById(id);
        return RestResult.createSuccessfulRest(productVo);
    }

    /*
     * 添加商品信息
     */
    @PostMapping
    public RestResult addProduct(@RequestBody @Validated(Add.class) ProductVo productVo){
        Long id = productService.addProduct(productVo);
        return RestResult.createSuccessfulRest(id);
    }

    /*
     * 添加商品信息 - 批量
     */
    @PostMapping("/batch")
    public RestResult batchAddProduct(@RequestBody @Validated(BatchAdd.class) BatchAddProductVo batchAddProductVo){
        List<Long> productIdList = productService.batchAddProduct(batchAddProductVo);
        return RestResult.createSuccessfulRest(productIdList);
    }

    /*
     * 删除商品信息
     */
    @DeleteMapping("/{id}")
    public RestResult deleteProductById(@PathVariable Long id){
        int res = productService.deleteProductById(id);
        return RestResult.createSuccessfulRest(res);
    }

    /*
     * 删除商品信息 - 批量
     */
    @DeleteMapping("/batch")
    public RestResult batchDeleteProduct(@RequestBody @Validated(BatchDelete.class)BatchDelProductVo batchDelProductVo){
        int res = productService.batchDeleteProduct(batchDelProductVo.getIdList());
        return RestResult.createSuccessfulRest(res);
    }

    /*
     * 更新商品信息
     */
    @PutMapping
    public RestResult updateProduct(@RequestBody ProductVo productVo){
        Long res = productService.updateProduct(productVo);
        return RestResult.createSuccessfulRest(res);
    }

}
