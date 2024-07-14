package org.uts.business.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.uts.business.domain.dto.ProductDto;
import org.uts.business.domain.vo.ProductPageVo;
import org.uts.business.domain.vo.ProductVo;
import org.uts.business.mapper.ProductMapper;
import org.uts.business.service.ProductService;
import java.util.Collections;
import java.util.List;

/**
 * @Description 商品 服务实现类
 * @Author codBoy
 * @Date 2024/7/14 20:03
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /*
     * 分页查询商品列表信息
     */
    public List<ProductVo> productPage(ProductPageVo productPageVo) {
        PageHelper.startPage(productPageVo.getPageNum(),productPageVo.getPageSize());
        List<ProductDto> productDtoList = productMapper.selectProduct(productPageVo);
        return ProductDto.convertToVo(productDtoList);
    }

    /*
     * 添加商品信息
     */
    public int addProduct(ProductVo productVo) {
        return productMapper.addProduct(productVo.convertToDto());
    }

    /*
     * 查询商品详情信息
     */

    public ProductVo selectById(@PathVariable Long id){
        ProductDto productDto = productMapper.selectById(id);
        return ProductDto.convertToVo(Collections.singletonList(productDto)).get(0);
    }
}
