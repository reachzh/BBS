package com.DAO;

import com.Bean.Article;

public class Test {
    public static void main(String[] args){
        Article article = new Article(1,"asd","asd",null,1);
        ArticleDAO.edit(article);
    }
}
