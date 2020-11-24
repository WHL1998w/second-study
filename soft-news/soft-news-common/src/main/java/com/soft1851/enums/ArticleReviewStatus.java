package com.soft1851.enums;

public enum ArticleReviewStatus {
    REVIEWING(1,"审核中（用户已提交）"),
    WAITING_MANUAL(2,"机审技术，等待人工审核"),
    SUCCESS(3,"审核通过（已发布）"),
    FAILED(4,"审核未通过"),
    WITHDRAW(5,"文章撤回");

    public final Integer type;
    public final String value;

    ArticleReviewStatus(Integer type,String value){
        this.type = type;
         this.value = value;
    }

    public static boolean isArticleStatusValid(Integer tempStatus){
        if (tempStatus != null){
            if (tempStatus == REVIEWING.type
                    || tempStatus == WAITING_MANUAL.type
                    || tempStatus == SUCCESS.type
                    || tempStatus == FAILED.type
                    || tempStatus == WITHDRAW.type){
                return true;
            }
        }
        return false;
    }
}
