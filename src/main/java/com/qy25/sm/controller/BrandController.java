package com.qy25.sm.controller;

import com.qy25.sm.controller.base.BaseController;
import com.qy25.sm.entity.Brand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController extends BaseController<Brand,Long> {

}
