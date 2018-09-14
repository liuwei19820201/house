package com.jzfq.house.mybatis.mapper;

import com.jzfq.house.mybatis.domain.SysDictionary;
import com.jzfq.house.mybatis.domain.SysDictionaryQuery;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface SysDictionaryMapper <T,Q,PK extends Serializable> extends CommonMapper<T, Q, PK> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int countByExample(SysDictionaryQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int deleteByExample(SysDictionaryQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int insert(SysDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int insertSelective(SysDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    List<SysDictionary> selectByExample(SysDictionaryQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    SysDictionary selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysDictionary record, @Param("example") SysDictionaryQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int updateByExample(@Param("record") SysDictionary record, @Param("example") SysDictionaryQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int updateByPrimaryKeySelective(SysDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dictionary
     *
     * @mbggenerated Tue May 15 14:45:43 CST 2018
     */
    int updateByPrimaryKey(SysDictionary record);
}