package com.qy25.sm.controller;

import com.qy25.sm.controller.base.BaseController;
import com.qy25.sm.entity.Supplier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("supplier")
public class SupplierController extends BaseController<Supplier,Long> {

}
