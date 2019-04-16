package com.zyt.myblog.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "myblog..article_info")
public class ArticleInfo {
    /**
     * 主键,文章id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 图片地址
     */
    @Column(name = "picture_url")
    private String pictureUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_by")
    private Date createBy;

    /**
     * 修改日期
     */
    @Column(name = "modified_by")
    private Date modifiedBy;

    /**
     * 获取主键,文章id
     *
     * @return id - 主键,文章id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键,文章id
     *
     * @param id 主键,文章id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取图片地址
     *
     * @return picture_url - 图片地址
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 设置图片地址
     *
     * @param pictureUrl 图片地址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取创建时间
     *
     * @return create_by - 创建时间
     */
    public Date getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建时间
     *
     * @param createBy 创建时间
     */
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取修改日期
     *
     * @return modified_by - 修改日期
     */
    public Date getModifiedBy() {
        return modifiedBy;
    }

    /**
     * 设置修改日期
     *
     * @param modifiedBy 修改日期
     */
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}