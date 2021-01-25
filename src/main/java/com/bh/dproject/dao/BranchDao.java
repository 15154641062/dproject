package com.bh.dproject.dao;

import com.bh.dproject.pojo.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import java.util.List;

public interface BranchDao extends JpaRepository<Branch,Integer> {
}
