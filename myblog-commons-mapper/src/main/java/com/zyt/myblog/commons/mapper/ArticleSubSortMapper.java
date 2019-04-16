package com.zyt.myblog.commons.mapper;

import com.zyt.myblog.commons.domain.ArticleSubSort;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;


public interface ArticleSubSortMapper extends MyMapper<ArticleSubSort> {
    Integer selectByCreateBy(Date createBy);
}