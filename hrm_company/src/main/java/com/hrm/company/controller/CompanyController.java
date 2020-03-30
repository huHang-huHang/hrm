package com.hrm.company.controller;

import com.hrm.common.entity.Result;
import com.hrm.common.utils.IdWorker;
import com.hrm.company.service.impl.CompanyServiceImpl;
import com.hrm.model.company.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-14 18:55
 **/
@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyServer;
    @Autowired
    private IdWorker idWorker;
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insertCompany(@RequestBody Company company) {
        company.setId(idWorker.nextId()+"");
       /* company.setName("hh");
        company.setManagerId("admin");
        company.setState(1);
        company.setBalance((double)0);*/
        company.setCreateTime(new Date());
        int insert = companyServer.insert(company);
        if (insert > 0) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value = "/delete{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id){
        int delete = companyServer.delete(id);
        if (delete>0){
            return Result.SUCCESS();
        }else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Result update(@RequestBody Company company){
        /*company.setId("1");
        company.setName("hh");*/
        int update = companyServer.update(company);
        if (update>0){
            return Result.SUCCESS();
        }else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value = "/findById{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id){
        Company byId = companyServer.findById(id);
        if (byId!=null){
            return Result.SUCCESS(byId);
        }else {
            return Result.FAIL();
        }
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Result findAll(){
        return Result.SUCCESS(companyServer.findAll());
    }

}
