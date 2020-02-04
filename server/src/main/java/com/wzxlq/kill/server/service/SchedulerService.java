package com.wzxlq.kill.server.service;

import com.wzxlq.kill.model.entity.ItemKillSuccess;
import com.wzxlq.kill.model.mapper.ItemKillSuccessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王照轩
 * @date 2020/2/4 - 12:09
 */
@Service
public class SchedulerService {
    private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;
    @Autowired
    private Environment env;

    /**
     * 定时获取status=0的订单并判断是否超过TTL，然后进行失效
     */
    @Scheduled(cron = "0/30 * * * * ? ")
    public void scheduleExpireOrder() {
        try {
            List<ItemKillSuccess> list = itemKillSuccessMapper.selectExpireOrders();
            list.stream().forEach(i -> {
                if (i != null && i.getDiffTime() > env.getProperty("scheduler.expire.orders.time", Integer.class)) {
                    itemKillSuccessMapper.expireOrder(i.getCode());
                }
            });

        } catch (Exception e) {
            System.out.println("定时获取status=0的订单并判断是否超过TTL，然后进行失效");
        }
    }

//    @Scheduled(cron = "0/11 * * * * ? ")
//    public void scheduleExpireOrderv1() {
//        System.out.println("v1 ...");
//    }
//
//    @Scheduled(cron = "0/10 * * * * ? ")
//    public void scheduleExpireOrderv2() {
//        System.out.println("v2 ...");
//    }
}

