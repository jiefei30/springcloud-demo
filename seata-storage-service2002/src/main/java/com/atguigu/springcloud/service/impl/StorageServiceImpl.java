package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DELL
 * @date 2020/3/25 20:14
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("storage-service中扣减库存结束");
    }
}
