package com.soft1851.article.service;

import com.soft1851.pojo.Category;
import com.soft1851.pojo.bo.NewArticleBO;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
public interface ArticleService {
    /**
     * 发布文章
     * @param newArticleBO
     * @param category
     */
    void createArticle(NewArticleBO newArticleBO, Category category);
}