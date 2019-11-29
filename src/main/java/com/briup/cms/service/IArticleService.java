package com.briup.cms.service;

import com.briup.cms.bean.Article;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface IArticleService {
    void saveOrUpdateArticle(Article article) throws CustomerException;

    void deleteArticleById(int id) throws CustomerException;

    Article queryArticleById(int id) throws CustomerException;

    List<Article> queryAll() throws CustomerException;
}
