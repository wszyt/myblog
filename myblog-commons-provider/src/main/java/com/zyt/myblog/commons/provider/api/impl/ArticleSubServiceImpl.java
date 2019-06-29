package com.zyt.myblog.commons.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zyt.commons.api.ArticleSubSortService;
import com.zyt.myblog.commons.domain.ArticleSubSort;
import com.zyt.myblog.commons.mapper.ArticleSubSortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "${services.versions.backend.v1}")
@Transactional(readOnly = true)
public class ArticleSubServiceImpl implements ArticleSubSortService {

    @Autowired
    private ArticleSubSortMapper articleSubSortMapper;

    @Override
    public List<ArticleSubSort> selectBySortId(Integer sortId) {
        return articleSubSortMapper.selectBySortId (sortId);
    }
}
