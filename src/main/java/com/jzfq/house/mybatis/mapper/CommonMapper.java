package com.jzfq.house.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通用父接口
 * @param <T>
 * @param <Q>
 * @param <PK>
 */
public interface CommonMapper<T,Q,PK extends Serializable>  {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(Q example);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(Q example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(T record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(T record);

    /**
     * 批量插入记录
     */
    int insertBatch(List<T> records);

    /**
     * 根据条件查询记录集
     */
    List<T> selectByExample(Q example);
    /**
     * 根据条件查询记录集
     */
    List<T> selectByExample(RowBounds rowBounds, Q example);

    List<T> selectByExampleWithBLOBs(RowBounds rowBounds, Q example);
    /**
     * 根据主键查询记录
     */
    T selectByPrimaryKey(PK id);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") Q example);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") T record, @Param("example") Q example);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(T record);

    /**
     * 获取 序列中下一个编号
     * @return
     */
    Long getNextVal();

    @Select(value = "${sql}")
    List<Map<String,String>> selectBySQL(@Param(value = "sql") String sql);

    @Select(value = "${sql}")
    List<Map<String,Object>> findBySQL(@Param(value = "sql") String sql);

    @Select(value = "${sql}")
    int countBySQL(@Param(value = "sql") String sql);

    @Update(value = "${sql}")
    int updateBySQL(@Param(value = "sql") String sql);

//    @Options(flushCache = true, timeout = 20000)
    @Delete(value = "${sql}")
    int deleteBySQL(@Param(value = "sql") String sql);

    @Insert(value = "${sql}")
    int insertBySQL(@Param(value = "sql") String sql);


}
