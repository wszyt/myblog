package com.zyt.myblog.commons.mapper;

import com.zyt.myblog.commons.domain.ArticleInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;


public interface ArticleInfoMapper extends MyMapper<ArticleInfo> {
    Integer selectByCreateBy(Date createBy);
}