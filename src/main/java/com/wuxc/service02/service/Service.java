package com.wuxc.service02.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Service {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);


    @PostConstruct
    public void init() throws InterruptedException {
        logger.warn("start");




        logger.warn("end");
    }
}
