package com.jzfq.house.service;

//import com.yingu.oss.bean.page.Page;


import com.jzfq.house.mybatis.exception.DBException;
import com.jzfq.house.mybatis.service.CommonsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务父类
 *
 * @author Garen Gosling
 * @create 2017-09-15 00:00
 * @since v1.0
 */
public abstract class BaseManage<PK extends Serializable> extends CommonMethods {

    protected Logger LOGGER = LoggerFactory.getLogger(getClass());
    protected static final Integer START = 0;
    protected static final Integer LENGTH = 10;

    protected Map page(List list , int count){
        Map map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return map;
    }


    private static String DB_NAME = "mysql";//ResourceBundleUtil.getConfigValue("db.name");

    /**
     * 根据<T>对象中的主键id，查询指定对象
     * @param id
     * @return
     * @throws Exception
     */
    public <T> T findById(PK id)  {
        try {
            return (T) getService().findByID(id);
        }catch (Exception e){
            throw new DBException("数据库异常-" + e.getMessage());
        }
    }

    /**
     * 根据指定条件查询唯一对象
     *
     * @param query
     * @return
     * @throws Exception
     */
    public <T,Q> T findBy(final Q query) throws Exception{

        return (T) getService().selectOneByExample(query);
    }

    /**
     * 根据指定条件查询多个<T>对象
     *
     * @param query
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T,Q> List<T> findListBy(final Q query){

        return (List<T>) getService().findBy(query);
    }

    /**
     * 根据指定条件查询多个<T>对象
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T,Q> List<T> findAll(){
        return (List<T>) getService().findAll();
    }

    /**
     * 已分页方式根据条件查询对象列表
     *
     * @param query
     * @param page
     * @return
     */
//    public <T,Q> Page<T> findPageBy(Q query, Page page){
//        RowBounds rowBounds =new RowBounds((page.getThisPageNumber()-1)*page.getPageSize(),page.getPageSize());
//        page.setResult(getService().findBy(rowBounds, query));
//        return page;
//    }

    /**
     * 持久化单个对象到数据库
     *
     * @param obj
     * @return
     */
    public <T> int create(T obj){
        return getService().save(obj,true);
    }

    /**
     * 持久化多个对象到数据库
     *
     * @param objs
     * @return
     */
    public <T> int create(List<T> objs){
        int s=0;
        for(T obj : objs){
            getService().save(obj,true);
            ++s;
        }
        return s;
    }

    /**
     * 修改单个对象属性信息
     *
     * @param obj
     * @return
     */
    public <T> int modify(T obj){
        return getService().updateByKey(obj,true);
    }

    /**
     * 按指定条件查出对象并进行修改操作
     *
     * @param record
     * @param query
     * @return
     */
    public <T,Q> int modify(T record,Q query){
        return getService().updateByQuery(record, query, true);
    }

    /**
     * 删除指定条件的对象
     *
     * @param query
     * @return
     */
    public <Q> int remove(Q query){
        return getService().delete(query);
    }

    /**
     * 根据指定id删除对象
     *
     * @param id
     * @return
     */
    public <Q> int removeById(PK id){
        return getService().deleteByID(id);
    }

    public abstract <T,Q> CommonsService<T,Q,PK> getService();

    public void printLogsInfo(String message){
        LOGGER.info("--"+this.getClass().getName()+this.getClass().getMethods()+"--"+message);
    }

    public void printLogsError(String message){
        LOGGER.error("--"+this.getClass().getName()+this.getClass().getMethods()+"--"+message);
    }

    /**
     * 判断表是否存在
     * @param table
     * @return
     */
    public boolean existTable(String table){
        String sql = "select count(*) from INFORMATION_SCHEMA.TABLES where TABLE_NAME='"+ table +"' and TABLE_SCHEMA ='"+ DB_NAME +"'";
        int i = getService().countBySQL(sql);
        return i > 0 ? true : false;
    }

    public List<Map<String,String>> selectBySQL(String sql){
        return getService().selectBySQL(sql);
    }

    public List<Map<String,Object>> findBySQL(String sql){
        return getService().findBySQL(sql);
    }

    public int countBySQL(String sql){
        return getService().countBySQL(sql);
    }

    public int updateBySQL(String sql){
        return getService().updateBySQL(sql);
    }

    public int insertBySQL(String sql){
        return getService().insertBySQL(sql);
    }

    public int deleteBySQL(String sql){
        return getService().deleteBySQL(sql);
    }

    public boolean resultFlag(int count){
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }


}
