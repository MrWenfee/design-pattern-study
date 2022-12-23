package com.wenfee.design.prototype.common;

/**
 * @author Wenfee
 * @date 2022/12/23
 * <p>
 * 解答题
 */
public class AnswerQuestion {

    /**
     * 问题
     */
    private String name;

    /**
     * 答案
     */
    private String key;


    public AnswerQuestion(String name, String key) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
