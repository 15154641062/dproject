package com.bh.dproject.service.impl;

import com.bh.dproject.dao.BranchDao;
import com.bh.dproject.pojo.Branch;
import com.bh.dproject.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 部门信息service
 */
@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDao branchDao;

    /**
     * 返回所有部门信息
     * @return
     */
    @Override
    public List<Branch> finAll() {
        return branchDao.findAll();
    }

    /**
     * 根据部门id返回部门信息
     * @param id
     * @return
     */
    @Override
    public Optional<Branch> findById(Integer id) {
        return branchDao.findById(id);
    }
}
