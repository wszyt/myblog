package com.zyt.myblog.backend.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zyt.commons.api.ArticleResultService;
import com.zyt.myblog.commons.domain.ArticleResult;
import com.zyt.myblog.commons.dto.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String save(ArticleResult articleResult, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = articleResultService.save (articleResult);

        if (baseResult.getStatus () == 500) {
            model.addAttribute ("baseResult", baseResult);
            return "form";
        }

        redirectAttributes.addFlashAttribute ("baseResult", baseResult);

        return "redirect:/list";
    }


    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Long id, RedirectAttributes redirectAttributes) {
        articleResultService.delete (id);
        redirectAttributes.addFlashAttribute ("baseResult", BaseResult.success ("删除文章成功"));
        return "redirect:/list";
    }

    @RequestMapping(value = "content", method = RequestMethod.GET)
    public String content(ArticleResult articleResult, Model model) {
        model.addAttribute ("articleResult", articleResult);
        return "content";
    }


}
