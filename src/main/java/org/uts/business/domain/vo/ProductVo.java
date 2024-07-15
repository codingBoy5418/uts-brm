package org.uts.business.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.uts.business.domain.dto.ProductDto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 商品 VO类
 * @Author codBoy
 * @Date 2024/7/14 19:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo {

    //商品ID
    private Long id;

    //商品名称
    @NotNull
    @Length(min = 2, max = 255)
    private String name;

    //商品价格
    @NotNull
    private Float price;

    //商品库存
    @NotNull
    private Integer stock;

    //商品图片
    @NotNull
    private String image;

    //商品简介
    @NotNull
    private String desc;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    /*
      将 商品VO 转换为 商品DTO
     */
    public ProductDto convertToDto() {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(this, productDto);
        return productDto;
    }

    /*
      将 商品VO列表 转换为 商品DTO列表
     */
    public static List<ProductDto> convertToDto(List<ProductVo> productVoList) {
        List<ProductDto> res = new ArrayList<>();
        if(!CollectionUtils.isEmpty(productVoList)){
            for(ProductVo productVo : productVoList){
                res.add(productVo.convertToDto());
            }
        }
        return res;
    }
}
