package com.zyt.myblog.commons.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zyt.commons.api.ArticleResultService;
import com.zyt.myblog.commons.domain.ArticleContent;
import com.zyt.myblog.commons.domain.ArticleInfo;
import com.zyt.myblog.commons.domain.ArticleResult;
import com.zyt.myblog.commons.domain.ArticleSubSort;
import com.zyt.myblog.commons.dto.BaseResult;
import com.zyt.myblog.commons.mapper.ArticleContentMapper;
import com.zyt.myblog.commons.mapper.ArticleInfoMapper;
import com.zyt.myblog.commons.mapper.ArticleResultMapper;
import com.zyt.myblog.commons.mapper.ArticleSubSortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service(version = "${services.versions.backend.v1}")
@Transactional(readOnly = true)
public class ArticleResultServiceImpl implements ArticleResultService {

    @Autowired
    private ArticleResultMapper resultMapper;

    @Autowired
    private ArticleContentMapper articleContentMapper;

    @Autowired
    private ArticleSubSortMapper articleSubSortMapper;

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArticleResult> selectAll() {
        return resultMapper.selectAll ();
    }

    @Override
    @Transactional(readOnly = false)
    public BaseResult save(ArticleResult articleResult) {
        ArticleContent articleContent = null;
        ArticleSubSort articleSubSort = null;
        ArticleInfo articleInfo = null;
        articleResult.setModifiedBy (new Date ());

//        新增数据
        if (articleResult.getId () == null || articleResult.getId () == 0) {

            articleResult.setCreateBy (articleResult.getModifiedBy ());

            articleInfo.setTitle (articleResult.getTitle ());
            articleInfo.setContent (articleResult.getContent ());
            articleInfo.setPictureUrl (articleResult.getPictureUrl ());
            articleInfo.setCreateBy (articleResult.getCreateBy ());
            articleInfo.setModifiedBy (articleResult.getModifiedBy ());
            articleInfoMapper.insert (articleInfo);
            int infoId = articleInfoMapper.selectByCreateBy (articleResult.getCreateBy ());

            articleSubSort.setSubSort (articleResult.getSubSort ());
            articleSubSort.setCreateBy (articleResult.getCreateBy ());
            articleSubSort.setModifiedBy (articleResult.getModifiedBy ());
            articleSubSortMapper.insert (articleSubSort);
            int subSortId = articleSubSortMapper.selectByCreateBy (articleResult.getCreateBy ());

            articleContent.setSortId (articleResult.getSortId ());
            articleContent.setSubSortId (subSortId);
            articleContent.setTitleId (infoId);
            articleContent.setSubSort (articleResult.getSubSort ());
            articleContent.setTitle (articleResult.getTitle ());
            articleContent.setCreateBy (articleResult.getCreateBy ());
            articleContent.setModifiedBy (articleResult.getModifiedBy ());
            articleContentMapper.insert (articleContent);

            return BaseResult.success ("添加文章成功");
        }

//        修改文章
        else if (articleResult.getId () != null || articleResult.getId () != 0){
            articleInfo = articleInfoMapper.selectByPrimaryKey (articleResult.getTitleId ());
            articleInfo.setModifiedBy (articleResult.getModifiedBy ());
            articleInfo.setTitle (articleResult.getTitle ());
            articleInfo.setContent (articleResult.getContent ());
            articleInfo.setPictureUrl (articleResult.getPictureUrl ());
            articleInfoMapper.updateByPrimaryKey (articleInfo);


            articleSubSort = articleSubSortMapper.selectByPrimaryKey (articleResult.getSubSortId ());
            articleSubSort.setModifiedBy (articleResult.getModifiedBy ());
            articleSubSort.setSubSort (articleResult.getSubSort ());
            articleSubSortMapper.updateByPrimaryKey (articleSubSort);

            articleContent = articleContentMapper.selectByPrimaryKey (articleResult.getId ());
            articleContent.setModifiedBy (articleResult.getModifiedBy ());
            articleContent.setSubSort (articleResult.getSubSort ());
            articleContent.setTitle (articleResult.getTitle ());
            articleContent.setSortId (articleResult.getSortId ());
            articleContentMapper.updateByPrimaryKey (articleContent);

            return  BaseResult.success ("更新文章成功");

        }

        return BaseResult.fail ("操作失败");
    }

    @Override
    public ArticleResult getById(Long id) {
        return resultMapper.getById (id);
    }


}
