package com.bh.dproject.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 业务实体类
 */
@Data
@Entity     //标注该类是一个实体类
@Table(name = "branch")     //绑定数据库表
public class Branch {
    @Id         //标注主键列
    private Integer id;     //  id列
    @Column(name = "branch_name")       //绑定表字段
    private String branchName;      //部门名称
    private String location;      //部门地址
}
