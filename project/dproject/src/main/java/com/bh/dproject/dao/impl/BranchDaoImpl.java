package com.bh.dproject.dao.impl;

import com.bh.dproject.dao.BranchDao;
import com.bh.dproject.pojo.Branch;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

//public class BranchDaoImpl implements BranchDao {
//    @Override
//    public List<Branch> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Branch> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public List<Branch> findAllById(Iterable<Integer> iterable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Branch> List<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Branch> S saveAndFlush(S s) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<Branch> iterable) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Branch getOne(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public <S extends Branch> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Branch> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Branch> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Branch> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public Optional<Branch> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Branch branch) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Branch> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Branch> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Branch> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Branch> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Branch> boolean exists(Example<S> example) {
//        return false;
//    }
//}
