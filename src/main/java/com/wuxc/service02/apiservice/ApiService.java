package com.wuxc.service02.apiservice;

import com.wuxc.service02.okhttp.OkHttp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by silivar on 2018/9/18.
 */
//1.标注成为一个spring mvc的Controller

@RestController
@RequestMapping("/rest/v1")
public class ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    private static String service01_host = System.getenv("SERVICE_01_HOST");

    @RequestMapping(value = "/service02")
    public String hello() {

        logger.error("index start");
        return "service02_" + OkHttp.get(service01_host + "/rest/v1/service01");
    }


}
