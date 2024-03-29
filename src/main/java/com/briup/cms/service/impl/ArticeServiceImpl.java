package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArticleDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticeServiceImpl  implements IArticleService {
    @Autowired
    private IArticleDao articleDao;
    @Override
    public void saveOrUpdateArticle(Article article) throws CustomerException {
        if (article == null || article.getCategory() == null) {
            throw new CustomerException(CodeUtil.PARAM_NULL,"参数为空");
        }
        article.setClickTimes(0);
        article.setPublishDate(new Date());
        articleDao.save(article);
    }

    @Override
    public void deleteArticleById(int id) throws CustomerException {
        articleDao.deleteById(id);
    }

    @Override
    public Article queryArticleById(int id) throws CustomerException {

        return articleDao.queryById(id);
    }

    @Override
    public List<Article> queryAll() throws CustomerException {


        return  articleDao.findAll();
    }
}
