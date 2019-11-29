package com.briup.cms.bean.ex;

import com.briup.cms.bean.Article;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cms_category")
public class CategoryEX {
    @Id
    private int id;
    private long code;
    private String name;
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Article> articles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
