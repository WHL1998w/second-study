package com.soft1851.enums;

public enum YesOrNo {
    NO(0,"否"),
    Yes(1,"是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value){
        this.type = type;
        this.value = value;
    }
}
