package com.soft1851.article.service;

import com.soft1851.pojo.Category;

import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
public interface CategoryService {
    /**
     * 查询所有文章分类
     * @return
     */
    List<Category> selectAll();
}
