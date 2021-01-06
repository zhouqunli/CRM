package com.qy25.sm.service.impl;

import com.qy25.sm.entity.Category;
import com.qy25.sm.service.Base.BaseService;
import com.qy25.sm.service.Base.impl.BaseServiceImpl;
import com.qy25.sm.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CayegoryServiceImpl extends BaseServiceImpl<Category,Long> implements CategoryService {
}
