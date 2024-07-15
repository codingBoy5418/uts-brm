package org.uts.business.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.uts.business.domain.dto.ProductDto;
import org.uts.business.domain.vo.ProductPageVo;

import java.util.List;

/**
 * @Description 商品 Mapper类
 * @Author codBoy
 * @Date 2024/7/14 20:03
 */
@Mapper
public interface ProductMapper {

    /*
     * 分页查询商品列表信息
     */
    public List<ProductDto> selectProduct(ProductPageVo productPageVo);

    /*
     * 添加商品信息
     */
    public int addProduct(ProductDto productDto);

    /*
     * 添加商品信息 - 批量
     */
    public int batchAddProduct(@Param("productDtoList") List<ProductDto> productDtoList);

    /*
     * 删除商品信息
     */
    public int deleteProductById(Long id);

    /*
     * 查询商品详情信息
     */
    public ProductDto selectById(Long id);

    /*
     * 删除商品信息 - 批量
     */
    public int batchDeleteProduct(@Param("idList") List<Long> idList);

    /*
     * 更新商品信息
     */
    public Long updateProduct(ProductDto productDto);
}
