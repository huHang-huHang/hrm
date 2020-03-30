package com.hrm.company.service;

import com.hrm.model.company.entity.Company;

import java.util.List;

public interface CompanyService {
    public int insert(Company company);
    public int delete(String id);
    public int update(Company company);
    public Company findById(String id);
    public List<Company> findAll();
}
