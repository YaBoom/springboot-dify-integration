package com.zhuyt.spring.study.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: DifyBatchResMessage
 * @Description: TODO
 * @author: zhuyt
 * @date: 25/10/21 10:50
 */
@Data
public class DifyBatchResMessage {
    String event = "";
    String task_id = "";
    String id = "";
    String message_id = "";
    String conversation_id = "";
    String mode = "";
    String answer = "";
    Map<String, Object> metadata = new HashMap<>();
    String created_at = "";
}
