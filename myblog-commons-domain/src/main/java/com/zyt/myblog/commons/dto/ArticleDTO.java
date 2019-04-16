package com.zyt.myblog.commons.dto;

import java.util.Date;

public class ArticleDTO {
    private Long id;
//    分类id
    private Long sortId;
//    子分类id
    private Long subSortId;
//    文章id
    private Long titleId;
//    浏览量
    private Long traffic;
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
