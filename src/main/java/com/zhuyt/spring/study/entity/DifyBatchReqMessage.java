package com.zhuyt.spring.study.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @className: DifyBatchReqMessage
 * @Description: TODO
 * @author: zhuyt
 * @date: 25/10/21 10:46
 */
@Data
public class DifyBatchReqMessage {
    Map<String, Object> inputs = new HashMap<>();
    String query = "";
    String response_mode = "streaming";
    String conversation_id = "";
    String user = "";
    List<Map<String, String>> files = new LinkedList<>();
}
