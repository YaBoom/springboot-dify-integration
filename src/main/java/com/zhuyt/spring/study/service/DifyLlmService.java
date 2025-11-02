package com.zhuyt.spring.study.service;

import java.util.Map;

/**
 * @className: DifyLlmService
 * @Description: TODO
 * @author: zhuyt
 * @date: 25/10/21 10:45
 */
public interface DifyLlmService {
    //Map<String, Object> getAnswerByQueryBatch(String query);
    String chatWithDify(String message, String user);
}
