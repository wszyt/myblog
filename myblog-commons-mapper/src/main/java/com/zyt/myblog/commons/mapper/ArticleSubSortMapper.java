package com.zyt.myblog.commons.mapper;

import com.zyt.myblog.commons.domain.ArticleSubSort;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

@Repository
public interface ArticleSubSortMapper extends MyMapper<ArticleSubSort> {
    ArticleSubSort selectSubSort(ArticleSubSort articleSubSort);

    void insertAndGetId(ArticleSubSort articleSubSort);

    List<ArticleSubSort> selectBySortId(Integer sortId);
}