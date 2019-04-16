package com.zyt.myblog.commons.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "article_content")
public class ArticleContent implements Serializable {
    private static final long serialVersionUID = 8539262914276823993L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类id
     */
    @Column(name = "sort_id")
    private Integer sortId;

    /**
     * 子分类id
     */
    @Column(name = "sub_sort_id")
    private Integer subSortId;

    /**
     * 文章id
     */
    @Column(name = "title_id")
    private Integer titleId;

    /**
     * 子分类
     */
    @Column(name = "sub_sort")
    private String subSort;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章访问量
     */
    private Integer traffic;

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
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类id
     *
     * @return sort_id - 分类id
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * 设置分类id
     *
     * @param sortId 分类id
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /**
     * 获取子分类id
     *
     * @return sub_sort_id - 子分类id
     */
    public Integer getSubSortId() {
        return subSortId;
    }

    /**
     * 设置子分类id
     *
     * @param subSortId 子分类id
     */
    public void setSubSortId(Integer subSortId) {
        this.subSortId = subSortId;
    }

    /**
     * 获取文章id
     *
     * @return title_id - 文章id
     */
    public Integer getTitleId() {
        return titleId;
    }

    /**
     * 设置文章id
     *
     * @param titleId 文章id
     */
    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    /**
     * 获取子分类
     *
     * @return sub_sort - 子分类
     */
    public String getSubSort() {
        return subSort;
    }

    /**
     * 设置子分类
     *
     * @param subSort 子分类
     */
    public void setSubSort(String subSort) {
        this.subSort = subSort;
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
     * 获取文章访问量
     *
     * @return traffic - 文章访问量
     */
    public Integer getTraffic() {
        return traffic;
    }

    /**
     * 设置文章访问量
     *
     * @param traffic 文章访问量
     */
    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
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