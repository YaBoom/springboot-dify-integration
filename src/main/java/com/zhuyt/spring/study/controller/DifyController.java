package com.zhuyt.spring.study.controller;

import com.zhuyt.spring.study.service.DifyLlmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @className: DifyController
 * @Description: TODO
 * @author: zhuyt
 * @date: 25/10/21 10:45
 */
@RestController
@RequestMapping("/Dify")
@Slf4j
public class DifyController {
    @Autowired
    DifyLlmService difyLlmService;

//    @PostMapping("/get/llm/solution")
//    public Map<String,Object> getAnswerByQueryBatch(@RequestHeader("UserId") String UserId, @RequestParam("query") String query) {
//        log.info("入参query={}", query);
//        Map<String,Object> result= difyLlmService.getAnswerByQueryBatch(query);
////        result.put("llmSolution", query);
////        result.put("thinkProcess", "思考中"+System.currentTimeMillis());
//        return result;
//    }

    @PostMapping("/chat")
    public String chat(@RequestParam String message, @RequestParam String user) {
        return difyLlmService.chatWithDify(message, user);
    }
}
