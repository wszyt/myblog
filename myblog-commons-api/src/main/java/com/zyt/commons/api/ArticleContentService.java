package com.zyt.commons.api;

import com.github.pagehelper.PageInfo;
import com.zyt.myblog.commons.domain.ArticleContent;

import java.util.List;

public interface ArticleContentService {

    /**
     * 查询全部数据
     * @return
     */
    List<ArticleContent> selectAll1();

    /**
     * 分页查询
     * @param start 页码
     * @param length 笔数
     * @return
     */
    PageInfo<ArticleContent> page(int start, int length, ArticleContent articleContent);

}
