package com.zyt.commons.api;

import com.zyt.myblog.commons.domain.ArticleResult;
import com.zyt.myblog.commons.dto.BaseResult;

import java.util.List;

public interface ArticleResultService {
    List<ArticleResult> selectAll();

    BaseResult save(ArticleResult articleResult);

    ArticleResult getById(Long id);

    void delete(Long id);

    List<ArticleResult> selectBySortId(Integer sortId);

}
