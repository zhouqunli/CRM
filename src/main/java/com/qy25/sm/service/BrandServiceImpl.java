package com.qy25.sm.service;

import com.qy25.sm.entity.Brand;
import com.qy25.sm.service.base.BaseService;
import com.qy25.sm.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand,String>implements BrandService {
}
