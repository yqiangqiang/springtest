package com.yqq.springBoot.rest;

import com.alibaba.fastjson.JSONObject;
import com.yqq.springBoot.entity.DeptInfoEntity;
import com.yqq.springBoot.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "deptInfo/")
public class DeptInfoRest {

    @Autowired
    DeptInfoService deptInfoService;

    @GetMapping(path = "findAll")
    public String findAll(DeptInfoService.Condition condition) {
        Pageable pageable = new PageRequest(0, 3, Sort.Direction.DESC, "id");

        deptInfoService.findAll(condition,pageable);
        return JSONObject.toJSONString(pageable);
    }


}