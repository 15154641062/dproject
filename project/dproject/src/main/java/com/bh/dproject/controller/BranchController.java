package com.bh.dproject.controller;

import com.bh.dproject.entity.Result;
import com.bh.dproject.entity.StatusCode;
import com.bh.dproject.pojo.Branch;
import com.bh.dproject.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 部门信息请求处理controller
 */
@RestController     //返回字符串而非跳转视图
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    /**
     * 查找表所有数据
     * @return
     */
    @RequestMapping("/findAll")
    public Result finAll(){
        List<Branch> branches = branchService.finAll();
        return new Result(StatusCode.SUCCESS,"成功",branches);
    }

    /**
     * 通过id查询数据
     * @param id
     * @return
     */
    @RequestMapping(name = "/findById",value = "{id}")
    public Result findById(@PathVariable("id") Integer id){
        Optional<Branch> data = branchService.findById(id);
        if (data.isPresent()){      //查询到的数据不为null则返回成功
            return new Result(StatusCode.SUCCESS,"成功",data);
        }
        //查询不到数据则返回失败
        return new Result(StatusCode.FAIL,"失败");
    }
}
