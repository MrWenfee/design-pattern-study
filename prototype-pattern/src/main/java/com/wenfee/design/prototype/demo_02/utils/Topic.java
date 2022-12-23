package com.wenfee.design.prototype.demo_02.utils;

import java.util.Map;

/**
 * @author Wenfee
 * @date 2022/12/23
 */
public class Topic {

    /**
     * 选项；A、B、C、D
     */
    private Map<String, String> option;

    /**
     * 答案；B
     */
    private String key;

    public Topic() {
    }

    public Topic(Map<String, String> option, String key) {
        this.option = option;
        this.key = key;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
