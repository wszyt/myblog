package com.zyt.myblog.backend.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zyt.commons.api.ArticleContentService;
import com.zyt.commons.api.ArticleResultService;
import com.zyt.myblog.commons.domain.ArticleResult;
import com.zyt.myblog.commons.dto.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ArticleController {

    @ModelAttribute
    public ArticleResult getArticleResult(Long id) {
        ArticleResult articleResult = null;

        //id不为空，则从数据库获取
        if(id != null) {
            articleResult = articleResultService.getById (id);
        }

        else {
            articleResult = new ArticleResult ();
        }
        return articleResult;
    }

    @Reference(version = "${services.versions.backend.v1}")
    private ArticleContentService articleContentService;

    @Reference(version = "${services.versions.backend.v1}")
    private ArticleResultService articleResultService;


    @RequestMapping(value = {"list", ""}, method = RequestMethod.GET)
    public String selectAll(Model model) {
        List<ArticleResult> articleResults = articleResultService.selectAll ();
        model.addAttribute ("articleResults", articleResults);
        return "list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String list() {
        return "index";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(ArticleResult articleResult, Model model) {
        BaseResult baseResult = articleResultService.save (articleResult);
        return "redirect:/list";
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(ArticleResult articleResult) {
        return null;
    }


}
