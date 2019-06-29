package com.zyt.myblog.article.ui.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zyt.commons.api.ArticleInfoService;
import com.zyt.commons.api.ArticleResultService;
import com.zyt.commons.api.ArticleSubSortService;
import com.zyt.myblog.commons.domain.ArticleInfo;
import com.zyt.myblog.commons.domain.ArticleResult;
import com.zyt.myblog.commons.domain.ArticleSubSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ArticleController {

    @Reference(version = "${services.versions.article.ui.v1}")
    private ArticleResultService articleResultService;

    @Reference(version = "${services.versions.article.ui.v1}")
    private ArticleSubSortService articleSubSortService;

    @Reference(version = "${services.versions.article.ui.v1}")
    private ArticleInfoService articleInfoService;

    @RequestMapping(value = {"index", ""}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "catalog/{sortId}", method = RequestMethod.GET)
    public String catalog(@PathVariable(required = true) Integer sortId, Model model) {
        List<ArticleResult> catalog = articleResultService.selectBySortId (sortId);
        List<ArticleSubSort> subSortCatalog =  articleSubSortService.selectBySortId (sortId);
        model.addAttribute ("subSortCatalog", subSortCatalog);
        model.addAttribute ("catalogs", catalog);
        return "catalog";
    }

    @RequestMapping(value = "catalog/content/{titleId}", method = RequestMethod.GET)
    public String content(@PathVariable(required = true) Long titleId, Model model) {
        ArticleInfo articleInfo = articleInfoService.getById (titleId);
        model.addAttribute ("articleInfo", articleInfo);
        return "content";
    }
}
