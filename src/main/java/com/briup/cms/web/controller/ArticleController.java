package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
@Api(description = "信息管理")
public class ArticleController {
    @Autowired
    private IArticleService articleService;
    @PostMapping("/add")
    @ApiOperation(value = "添加信息",notes = "category.code&category.name&clickTime&publishDate不写")
    public Message addArticle(Article article) {
    articleService.saveOrUpdateArticle(article);
    return MessageUtil.success();
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除信息")
    @ApiImplicitParam(name = "id",value = "信息id",paramType = "query",dataType = "int",required = true)
    public Message deleteArticleById(int id) {
    articleService.deleteArticleById(id);
    return MessageUtil.success();
    }
    @GetMapping("/queryById")
    @ApiOperation(value = "根据id查询信息")
    @ApiImplicitParam(name = "id",value = "信息id",paramType = "query",dataType = "int",required = true)

    public Message<Article> queryArticleById(int id) {
        Article article = articleService.queryArticleById(id);
        return MessageUtil.success(article);

    }
    @GetMapping("/queryAll")
    @ApiOperation(value = "查询全部")
    public Message<List<Article>> queryAll() {
        List<Article> articles = articleService.queryAll();
        return MessageUtil.success(articles);
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改信息")
    public Message updateArticle(Article article) {
        articleService.saveOrUpdateArticle(article);
        return MessageUtil.success();
    }
}
