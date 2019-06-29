package com.zyt.commons.api;

import com.zyt.myblog.commons.domain.ArticleSubSort;

import java.util.List;

public interface ArticleSubSortService {
    List<ArticleSubSort> selectBySortId(Integer sortId);
}
