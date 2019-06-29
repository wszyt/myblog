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
import com.zyt.myblog.commons.provider.validator.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service(version = "${services.versions.commons.provider.v1}")
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

    /**
     * 保存文章
     * @param articleResult
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(ArticleResult articleResult) {

        String validator = BeanValidator.validator (articleResult);
        if (validator != null) {
            return BaseResult.fail (validator);
        }

        ArticleContent articleContent = new ArticleContent ();
        ArticleSubSort articleSubSort = new ArticleSubSort ();
        ArticleInfo articleInfo = new ArticleInfo ();
        articleResult.setModifiedBy (new Date ());

//        新增数据
        if (articleResult.getId () == null || articleResult.getId () == 0) {

            if (articleInfoMapper.titleCount (articleResult.getTitle ()) != 0) {
                return BaseResult.fail ("文章名已存在");
            }

            articleResult.setCreateBy (articleResult.getModifiedBy ());

//            插入文章信息
            articleInfo.setTitle (articleResult.getTitle ());
            articleInfo.setContent (articleResult.getContent ());
            if (articleResult.getPictureUrl () != null) {
                articleInfo.setPictureUrl (articleResult.getPictureUrl ());
            }
            articleInfo.setCreateBy (articleResult.getCreateBy ());
            articleInfo.setModifiedBy (articleResult.getModifiedBy ());
            articleInfoMapper.insertAndGetId (articleInfo);

//            插入分类信息
            articleSubSort.setSubSort (articleResult.getSubSort ());
            articleSubSort.setSortId (articleResult.getSortId ());
//            如果子分类已存在则使用子分类
            if (articleSubSortMapper.selectSubSort (articleSubSort) != null) {
                articleSubSort = articleSubSortMapper.selectSubSort (articleSubSort);
            }

//            反之新建
            else {
                articleSubSort.setCreateBy (articleResult.getCreateBy ());
                articleSubSort.setModifiedBy (articleResult.getModifiedBy ());
                articleSubSortMapper.insertAndGetId (articleSubSort);
            }

//            新增文章信息
            articleContent.setSortId (articleResult.getSortId ());
            articleContent.setSubSortId (articleSubSort.getId ());
            articleContent.setTitleId (articleInfo.getId ());
            articleContent.setSubSort (articleResult.getSubSort ());
            articleContent.setTitle (articleResult.getTitle ());
            articleContent.setTraffic (0);
            articleContent.setCreateBy (articleResult.getCreateBy ());
            articleContent.setModifiedBy (articleResult.getModifiedBy ());
            articleContentMapper.insert (articleContent);

        }

//        修改文章
        else if (articleResult.getId () != null || articleResult.getId () != 0){
            articleInfo = articleInfoMapper.selectByPrimaryKey (articleResult.getTitleId ());
            articleInfo.setModifiedBy (articleResult.getModifiedBy ());
            articleInfo.setTitle (articleResult.getTitle ());
            articleInfo.setContent (articleResult.getContent ());
            articleInfo.setPictureUrl (articleResult.getPictureUrl ());
            articleInfoMapper.updateByPrimaryKey (articleInfo);



            //            插入分类信息
            articleSubSort.setSubSort (articleResult.getSubSort ());
            articleSubSort.setSortId (articleResult.getSortId ());
//            如果子分类已存在则使用子分类
            if (articleSubSortMapper.selectSubSort (articleSubSort) != null) {
                articleSubSort = articleSubSortMapper.selectSubSort (articleSubSort);
                articleSubSort.setSortId (articleResult.getSortId ());
//                更新子分类表中的sortId
                if (articleContentMapper.count (articleResult.getSubSort ()) == 1) {
                    articleSubSortMapper.updateByPrimaryKey (articleSubSort);
                }
            }

//            反之新建
            else {
                articleSubSort.setCreateBy (articleResult.getCreateBy ());
                articleSubSort.setModifiedBy (articleResult.getModifiedBy ());
                articleSubSortMapper.insertAndGetId (articleSubSort);
            }




//            articleSubSort = articleSubSortMapper.selectByPrimaryKey (articleResult.getSubSortId ());
//            articleSubSort.setModifiedBy (articleResult.getModifiedBy ());
//            articleSubSort.setSubSort (articleResult.getSubSort ());
//            articleSubSort.setSortId (articleResult.getSortId ());
//            articleSubSortMapper.updateByPrimaryKey (articleSubSort);

            articleContent = articleContentMapper.selectByPrimaryKey (articleResult.getId ());
            articleContent.setSubSortId (articleSubSort.getId ());
            articleContent.setModifiedBy (articleResult.getModifiedBy ());
            articleContent.setSubSort (articleResult.getSubSort ());
            articleContent.setTitle (articleResult.getTitle ());
            articleContent.setSortId (articleResult.getSortId ());
            articleContentMapper.updateByPrimaryKey (articleContent);
        }

        return BaseResult.success ("编辑文章成功");
    }

    /**
     * 根据id获取文章
     * @param id
     * @return
     */
    @Override
    public ArticleResult getById(Long id) {
        return resultMapper.getById (id);
    }

    /**
     * 删除文章
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        ArticleResult articleResult = resultMapper.getById (id);

        if (articleContentMapper.count (articleResult.getSubSort ()) == 1) {
            articleSubSortMapper.deleteByPrimaryKey (articleResult.getSubSortId ());
        }
        articleInfoMapper.deleteByPrimaryKey (articleResult.getTitleId ());
        articleContentMapper.deleteByPrimaryKey (id);

    }

    @Override
    public List<ArticleResult> selectBySortId(Integer sortId) {
        return resultMapper.selectBySortId (sortId);
    }

}
