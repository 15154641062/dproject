package com.bh.dproject.service;

import com.bh.dproject.pojo.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    public List<Branch> finAll();       //查找所有的数据

    public Optional<Branch> findById(Integer id);      //通过id查询数据
}
