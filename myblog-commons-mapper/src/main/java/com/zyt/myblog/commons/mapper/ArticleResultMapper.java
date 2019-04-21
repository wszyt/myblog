package com.zyt.myblog.commons.mapper;

import com.zyt.myblog.commons.domain.ArticleResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleResultMapper {
    List<ArticleResult> selectAll();

    ArticleResult getById(Long id);

    List<ArticleResult> selectBySortId(Integer sortId);
}
