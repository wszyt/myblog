package com.zyt.myblog.commons.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zyt.commons.api.ArticleInfoService;
import com.zyt.myblog.commons.domain.ArticleInfo;
import com.zyt.myblog.commons.mapper.ArticleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(version = "${services.versions.backend.v1}")
@Transactional(readOnly = true)
public class ArticleInfoServiceImpl implements ArticleInfoService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public ArticleInfo getById(Long titleId) {
        return articleInfoMapper.selectByPrimaryKey (titleId);
    }
}
