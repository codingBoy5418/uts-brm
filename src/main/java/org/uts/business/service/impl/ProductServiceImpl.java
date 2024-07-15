package org.uts.business.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.uts.business.domain.dto.ProductDto;
import org.uts.business.domain.vo.BatchAddProductVo;
import org.uts.business.domain.vo.ProductPageVo;
import org.uts.business.domain.vo.ProductVo;
import org.uts.business.mapper.ProductMapper;
import org.uts.business.service.ProductService;

import java.util.ArrayList;
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
     * 查询商品详情信息
     */
    public ProductVo selectById(@PathVariable Long id){
        ProductDto productDto = productMapper.selectById(id);
        if(productDto == null){
            return null;
        }
        return ProductDto.convertToVo(Collections.singletonList(productDto)).get(0);
    }

    /*
     * 添加商品信息
     */
    public Long addProduct(ProductVo productVo) {
        ProductDto productDto = productVo.convertToDto();
        productMapper.addProduct(productDto);
        return productDto.getId();
    }

    /*
     * 添加商品信息 - 批量
     */
    public List<Long> batchAddProduct(BatchAddProductVo batchAddProductVo) {
        List<Long> res = new ArrayList<>();
        if(!CollectionUtils.isEmpty(batchAddProductVo.getProductVoList())){
            List<ProductDto> productDtoList = ProductVo.convertToDto(batchAddProductVo.getProductVoList());
            productMapper.batchAddProduct(productDtoList);
            productDtoList.forEach(o -> res.add(o.getId()));
        }
        return res;
    }

    /*
     * 删除商品信息
     */
    public int deleteProductById(Long id){
        int res = -1;
        if(id != null){
            res = productMapper.deleteProductById(id);
        }
        return res;
    }

    /*
     * 删除商品信息 - 批量
     */
    public int batchDeleteProduct(List<Long> idList) {
        int res = -1;
        if(!CollectionUtils.isEmpty(idList)){
            res = productMapper.batchDeleteProduct(idList);
        }
        return res;
    }

    /*
     * 更新商品信息
     */
    public Long updateProduct(ProductVo productVo) {
        if(productVo != null){
            return productMapper.updateProduct(productVo.convertToDto());
        }
        return -1L;
    }
}
