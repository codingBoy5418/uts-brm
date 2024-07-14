package org.uts.business.mapper;

import org.apache.ibatis.annotations.Mapper;
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
     * 查询商品详情信息
     */
    public ProductDto selectById(Long id);
}
