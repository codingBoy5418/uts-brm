package org.uts.business.service;

import org.uts.business.domain.vo.BatchAddProductVo;
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
     * 查询商品详情信息
     */
    public ProductVo selectById(Long id);

    /*
     * 添加商品信息
     */
    Long addProduct(ProductVo productVo);

    /*
     * 添加商品信息 - 批量
     */
    List<Long> batchAddProduct(BatchAddProductVo batchAddProductVo);

    /*
     * 删除商品信息
     */
    public int deleteProductById(Long id);

    /*
     * 删除商品信息 - 批量
     */
    public int batchDeleteProduct(List<Long> idList);

    /*
     * 更新商品信息
     */
    public Long updateProduct(ProductVo productVo);
}
