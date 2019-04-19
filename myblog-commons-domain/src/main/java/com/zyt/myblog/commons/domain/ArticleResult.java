package com.zyt.myblog.commons.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleResult implements Serializable {
    private static final long serialVersionUID = -2550477189927741348L;
    private Long id;
//    分类id
    private Integer sortId;
//    子分类id
    private Long subSortId;
//    文章id
    private Long titleId;
//    浏览量
    private Integer traffic;
//    子分类名
    @Length(min = 1, max = 50,  message = "子分类名不能为空")
    private String subSort;
//    文章名
    @Length(min = 1, max = 50, message = "文章名不能为空")
    private String title;
//    文章内容
    @Length(min = 1, message = "文章内容不能为空")
    private String content;
//    图片地址
    private String pictureUrl;
    private Date createBy;
    private Date modifiedBy;
}
