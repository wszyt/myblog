package com.zyt.myblog.article.ui.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zyt.commons.api.ArticleResultService;
import com.zyt.myblog.commons.domain.ArticleResult;
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

    @RequestMapping(value = {"index", ""}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "catalog/{sortId}", method = RequestMethod.GET)
    public String catalog(@PathVariable(required = true) Integer sortId, Model model) {
        List<ArticleResult> catalog = articleResultService.selectBySortId (sortId);
        model.addAttribute ("catalog", catalog);
        return "catalog";
    }
}
