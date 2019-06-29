package com.zyt.myblog.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "myblog..article_sub_sort")
public class ArticleSubSort {
    /**
     * 主键,子分类id
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
     * 子分类
     */
    @Column(name = "sub_sort")
    private String subSort;

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
     * 获取主键,子分类id
     *
     * @return id - 主键,子分类id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键,子分类id
     *
     * @param id 主键,子分类id
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