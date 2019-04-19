package com.zyt.myblog.commons.mapper;

import com.zyt.myblog.commons.domain.ArticleInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;

@Repository
public interface ArticleInfoMapper extends MyMapper<ArticleInfo> {
    void insertAndGetId(ArticleInfo articleInfo);

    int titleCount(String title);
}