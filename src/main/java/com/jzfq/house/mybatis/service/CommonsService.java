package com.jzfq.house.mybatis.service;


import com.jzfq.house.mybatis.exception.DBException;
import com.jzfq.house.mybatis.mapper.CommonMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * <B>文件名称：</B>CommonsService<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>东方银谷 研发二部 CBG<BR>
 * <B>创建时间：</B>2017/02/21<BR>
 *
 * @author 吕宏业  lvhongye@yingu.com
 * @version 1.0
 **/
public abstract class CommonsService<T,Q,PK extends Serializable>{

   @Transactional(readOnly = true)
   public List<T> findBy(Q query){
       return getMapper().selectByExample(query);
   }

    public T findByOne(Q query){
        List<T> list = findBy(query);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

   public List<T> findAll(){
       return getMapper().selectByExample(null);
   }

   @Transactional(readOnly = true)
   public int countByExample(Q query){
       return getMapper().countByExample(query);
   }

   @Transactional(readOnly = true)
   public List<T> findBy(RowBounds rowBounds, Q query){
       return getMapper().selectByExample(rowBounds,query);
   }
//    selectByExampleWithBLOBs
   @Transactional(readOnly = true)
   public List<T> findByWithBLOBs(RowBounds rowBounds, Q query){
       return getMapper().selectByExampleWithBLOBs(rowBounds,query);
   }


   @Transactional(readOnly = true)
   public T findByID(final PK id){
       return (T) getMapper().selectByPrimaryKey(id);
   }

   @Transactional(readOnly = true)
   public  T selectOneByExample(Q query)  {
       List<T> list = (List<T>) findBy(query);
       if(CollectionUtils.isEmpty(list)){
           return null;
       }else if(list.size()>1){
           throw new DBException("获取多个结果集");
       }
       return (T) list.get(0);
   }


   public int save(T record){
       return save(record,true);
   }


   public int save(T record,boolean isSelective){
       if(isSelective){
         return getMapper().insertSelective(record);
       }else{
         return getMapper().insert(record);
       }

   }

   public int batchSave(List<T> tsr){
       for(T t : tsr){
            getMapper().insert(t);
       }
       return tsr.size();
//       return getMapper().insertBatch(tsr);
   }

   public int updateByKey(T record){
//        Assert.notNull(record);
       return updateByKey(record,true);
   }

   public int updateByKey(T record,boolean isSelective){
       if(isSelective){
           return getMapper().updateByPrimaryKeySelective(record);
       }else{
           return getMapper().updateByPrimaryKey(record);
       }
   }

   public int updateByQuery(T record,Q query){
       return updateByQuery(record,query,true);
   }

   public int updateByQuery(T record,Q query,boolean isSelective){
       if(isSelective){
           return getMapper().updateByExampleSelective(record, query);
       }else{
           return getMapper().updateByExample(record, query);
       }
   }

   public int delete(Q query){
       return getMapper().deleteByExample(query);
   }

   public int deleteByID(final PK id){
       return getMapper().deleteByPrimaryKey(id);
   }

   public List<Map<String,String>> selectBySQL(String sql){
       return getMapper().selectBySQL(sql);
   }

   public List<Map<String,Object>> findBySQL(String sql){
       return getMapper().findBySQL(sql);
   }

   public int updateBySQL(String sql){
       return getMapper().updateBySQL(sql);
   }

   public int countBySQL(String sql){
       return getMapper().countBySQL(sql);
   }

   public int deleteBySQL(String sql){
       return getMapper().deleteBySQL(sql);
   }

   public int insertBySQL(String sql){
       return getMapper().insertBySQL(sql);
   }

   public abstract CommonMapper<T, Q, PK> getMapper();

}
