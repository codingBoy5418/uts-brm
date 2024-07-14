package org.uts.business.service;

import org.uts.business.domain.vo.ProductPageVo;
import org.uts.business.domain.vo.ProductVo;

import java.util.List;

/**
 * @Description 商品 服务类
 * @Author codBoy
 * @Date 2024/7/14 18:58
 */
public interface ProductService {

    /*
     * 分页查询商品列表信息
     */
    List<ProductVo> productPage(ProductPageVo productPageVo);

    /*
     * 添加商品信息
     */
    int addProduct(ProductVo productVo);

    /*
     * 查询商品详情信息
     */
    public ProductVo selectById(Long id);
}
