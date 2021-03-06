package com.jzfq.house.mybatis.mapper;

import com.jzfq.house.mybatis.domain.PayReqRel;
import com.jzfq.house.mybatis.domain.PayReqRelQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayReqRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int countByExample(PayReqRelQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int deleteByExample(PayReqRelQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int insert(PayReqRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int insertSelective(PayReqRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    List<PayReqRel> selectByExample(PayReqRelQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    PayReqRel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int updateByExampleSelective(@Param("record") PayReqRel record, @Param("example") PayReqRelQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int updateByExample(@Param("record") PayReqRel record, @Param("example") PayReqRelQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int updateByPrimaryKeySelective(PayReqRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_req_rel
     *
     * @mbggenerated Mon Sep 10 15:03:50 CST 2018
     */
    int updateByPrimaryKey(PayReqRel record);
}