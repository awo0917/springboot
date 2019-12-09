package com.lzl.platform.service;

import com.alibaba.fastjson.JSON;
import com.lzl.platform.dao.mapper.GasMapper;
import com.lzl.platform.model.Gas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Create by awo
 * @date: 2019/12/7
 * @Discription:
 **/
@Service
@Slf4j
public class DemoService {

    @Autowired
    private GasMapper gasMapper;

    public void doSomeThing() {
        Gas gas = gasMapper.getGasByGasId("LJ000001260");
        log.info("【demo】【{}】", JSON.toJSONString(gas));
    }
}
