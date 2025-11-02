package com.zhuyt.spring.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhuyt.spring.study.entity.DifyBatchReqMessage;
import com.zhuyt.spring.study.entity.DifyBatchResMessage;
import com.zhuyt.spring.study.service.DifyLlmService;
import jakarta.annotation.Resource;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @className: DifyLlmServiceImpl
 * @Description: TODO
 * @author: zhuyt
 * @date: 25/10/21 10:47
 */
@Service
@Slf4j
public class DifyLlmServiceImpl implements DifyLlmService {

    private final Environment env;

    public DifyLlmServiceImpl(Environment env) {
        this.env = env;
    }
    @Resource
    private RestTemplate restTemplate;

    private String getQuery(String queryInput) {
        return queryInput;
    }

//    private String getReqMessageBatch(String queryInput) {
//        Map<String, Object> inputValueMap = new HashMap<String, Object>();
//        inputValueMap.put("jobName","旅游");
//
//        String query = getQuery(queryInput);
//        String reqMessage = "";
//        DifyBatchReqMessage batchReqMessage = new DifyBatchReqMessage();
//        batchReqMessage.setUser(env.getProperty("Dify.user"));
//        List<Map<String, String>> files = new LinkedList<>();
//        Map<String,String> valueMap = new HashMap<>();
//        valueMap.put("type","image");
//        valueMap.put("transfer_method","remote_url");
//        valueMap.put("url","https://cloud.dify.ai/logo/logo-site.png");
//        files.add(valueMap);
//        batchReqMessage.setFiles(files);
//        batchReqMessage.setQuery(query);
//        batchReqMessage.setInputs(inputValueMap);
//        reqMessage = JSONObject.toJSONString(batchReqMessage);
//        return reqMessage;
//    }

//    @Override
//    public Map<String, Object> getAnswerByQueryBatch(String query) {
//
//        String answer = "";
//        String reqMessage = getReqMessageBatch(query);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        httpHeaders.setBearerAuth(env.getProperty("Dify.token"));
//
//        HttpEntity<String> batchResMessageHttpEntity = new HttpEntity<>(reqMessage, httpHeaders);
//        try {
//            ResponseEntity< byte[]> entityByte = restTemplate.postForEntity(env.getProperty("Dify.url"),
//                    batchResMessageHttpEntity,  byte[].class);
////            ResponseEntity<DifyBatchResMessage> entity = restTemplate.postForEntity(env.getProperty("Dify.url"),
////                    batchResMessageHttpEntity,  DifyBatchResMessage.class);
//            if (!entityByte.getStatusCode().is2xxSuccessful()) {
//                log.error("调用Dify接口失败{}", entityByte.getStatusCode().value());
//            }
//            //获取响应体中的内容
//            byte[] responseEntityBody = entityByte.getBody();
//            //将byte[]转为JSON格式的字符串
//            String json = new String(responseEntityBody);
//            System.out.println("回应内容："+ json);
//
//
//            //answer = entity.getAnswer();
//            log.info("answer={}", answer);
//        } catch (Exception e) {
//            log.error("调用Dify接口出现异常,{}", e.getMessage());
//        }
//        Map<String, Object> result = new HashMap<>();
//        String[] split = answer.split("</think>");
//        String[] split1 = split[0].split("<think>");
//        log.info("llmSolution,{}", split[1]);
//        log.info("thinkProcess,{}", split1);
//        result.put("llmSolution", split[1]);
//        result.put("thinkProcess", split1);
//        return result;
//    }

    @Override
    public String chatWithDify(String message, String user) {
        String url = env.getProperty("Dify.url");
        Map<String, Object> inputValueMap = new HashMap<String, Object>();
        inputValueMap.put("jobName","旅游");
        // 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + env.getProperty("Dify.token"));

        // 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("inputs", inputValueMap); // 如果有输入参数
        requestBody.put("query", message);
        requestBody.put("response_mode", "blocking"); // 或 "streaming"
        requestBody.put("user", user); // 用户标识
        requestBody.put("conversation_id", ""); // 可选，会话ID

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        // 发送请求
        ResponseEntity<Map> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                Map.class
        );

        // 处理响应
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return (String) response.getBody().get("answer");
        } else {
            throw new RuntimeException("Failed to call Dify API: " + response.getStatusCode());
        }
    }
}
