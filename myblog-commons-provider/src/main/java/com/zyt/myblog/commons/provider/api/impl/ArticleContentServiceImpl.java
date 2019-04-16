package com.zyt.myblog.commons.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyt.commons.api.ArticleContentService;
import com.zyt.myblog.commons.domain.ArticleContent;
import com.zyt.myblog.commons.mapper.ArticleContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "${services.versions.backend.v1}")
@Transactional(readOnly = true)
public class ArticleContentServiceImpl implements ArticleContentService {

    @Autowired
    private ArticleContentMapper articleContentMapper;

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<ArticleContent> selectAll1() {
        Example example = new Example (ArticleContent.class);
        return articleContentMapper.selectByExample (example);
    }

    /**
     * 分页查询
     * @param start 页码
     * @param length 笔数
     * @param articleContent
     * @return
     */
    @Override
    public PageInfo<ArticleContent> page(int start, int length, ArticleContent articleContent) {
        PageHelper.offsetPage (start, length);
        PageInfo<ArticleContent> pageInfo = new PageInfo<> (articleContentMapper.select (articleContent));
        return null;
    }
}
