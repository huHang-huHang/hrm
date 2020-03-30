package com.hrm.company.service.impl;

import com.hrm.company.mapper.CompanyMapper;
import com.hrm.company.service.CompanyService;
import com.hrm.model.company.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-14 18:53
 **/
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int insert(Company company) {
        int insert = companyMapper.insert(company);
        return insert;
    }

    @Override
    public int delete(String id) {
        int i = companyMapper.deleteById(id);
        return i;
    }

    @Override
    public int update(Company company) {
        return companyMapper.update(company);
    }

    @Override
    public Company findById(String id) {
        return companyMapper.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return companyMapper.findAll();
    }
}
