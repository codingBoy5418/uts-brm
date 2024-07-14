package org.uts.business.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.uts.business.domain.vo.ProductVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 商品 dto类
 * @Author codBoy
 * @Date 2024/7/14 20:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    //商品ID
    private Long id;

    //商品名称
    private String name;

    //商品价格
    private Float price;

    //商品库存
    private Integer stock;

    //商品图片
    private String image;

    //商品简介
    private String desc;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;


    /*
    * 将商品DTO类 转换为 商品VO类
    * */
    public static List<ProductVo> convertToVo(List<ProductDto> productDtoList) {
        List<ProductVo> res = new ArrayList<>();
        if(!CollectionUtils.isEmpty(productDtoList)){
            for(ProductDto productDto : productDtoList){
                ProductVo productVo = new ProductVo();
                BeanUtils.copyProperties(productDto, productVo);
                res.add(productVo);
            }
        }
        return res;
    }
}
