package com.zyt.commons.api;

import com.zyt.myblog.commons.domain.ArticleInfo;

public interface ArticleInfoService {
    ArticleInfo getById(Long titleId);
}
