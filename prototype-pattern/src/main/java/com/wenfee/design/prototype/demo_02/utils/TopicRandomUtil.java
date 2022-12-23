package com.wenfee.design.prototype.demo_02.utils;

import java.util.*;

/**
 * @author Wenfee
 * @date 2022/12/23
 * <p>
 * 选择打乱工具
 */
public class TopicRandomUtil {

    /**
     * 乱序Map元素，记录对应答案key
     *
     * @param option 题目
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    static public Topic random(Map<String, String> option, String key) {
        Set<String> keySet = option.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        // 对 keyList 打乱顺序
        Collections.shuffle(keyList);
        // 打乱后的选项
        HashMap<String, String> optionNew = new HashMap<String, String>();

        String keyNew = "";
        int idx = 0;
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            // 打乱顺序后的答案处理
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }
}
