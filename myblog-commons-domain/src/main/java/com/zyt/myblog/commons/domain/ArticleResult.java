package com.zyt.myblog.commons.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleResult implements Serializable {
    private static final long serialVersionUID = -2550477189927741348L;
    private Long id;
//    分类id
    private Integer sortId;
//    子分类id
    private Integer subSortId;
//    文章id
    private Integer titleId;
//    浏览量
    private Integer traffic;
//    子分类名
    private String subSort;
//    文章名
    private String title;
//    文章内容
    private String content;
//    图片地址
    private String pictureUrl;
    private Date createBy;
    private Date modifiedBy;
}
