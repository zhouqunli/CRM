package com.qy25.sm.controller;

import com.qy25.sm.controller.base.BaseController;
import com.qy25.sm.entity.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<Category,Long> {
}
