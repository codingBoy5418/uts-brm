package org.uts.business.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description 商品分页 VO类
 * @Author codBoy
 * @Date 2024/7/14 19:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPageVo extends PageVo{

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
}
