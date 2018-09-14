package com.jzfq.house.service;

import com.jzfq.house.mybatis.domain.Area;
import com.jzfq.house.mybatis.domain.AreaQuery;
import com.jzfq.house.mybatis.service.AreaService;
import com.jzfq.house.swagger.model.AreaSearch;
import com.jzfq.house.swagger.model.AreaVo;
import com.jzfq.house.util.EsapiUtil;
import com.jzfq.house.util.TransferUtil;
import com.jzfq.house.valid.AreaValid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AreaManage extends BaseManage<Integer>{
    @Autowired
    AreaService<Area, AreaQuery, Integer> service;
    @Autowired
    AreaValid areaValid;

    @Override
    public AreaService<Area, AreaQuery, Integer> getService() {
        return service;
    }

    public boolean save(AreaVo areaVo){
        // 校验入参
        areaValid.saveValid(areaVo);
        // 对象转化
        Area area = new Area();
        TransferUtil.transfer(area, areaVo);
        // 特殊属性赋值
        area.setCreateTime(new Date());
        // 持久化
        int i = create(area);
        // 返回结果
        if(i == 1){
            return true;
        }
        return false;
    }

    /**
     * 修改
     * @param areaVo
     * @return
     */
    public boolean update(AreaVo areaVo){
        // 校验入参
        areaValid.updateValid(areaVo);
        // 对象转化
        Area area = new Area();
        TransferUtil.transfer(area, areaVo);
        // 持久化
        int i = modify(area);
        // 返回结果
        if(i == 1){
            return true;
        }
        return false;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public String batchRemove(String ids){
        int count = 0;
        List<String> failList = new ArrayList<>();
        for(String id : ids.split(",")){
            int i = removeById(Integer.parseInt(id));
            if(i == 1){
                count ++;
            }else{
                Area byId = findById(Integer.parseInt(id));
                failList.add(byId.getName());
            }
        }
        return failMsg(count, ids, failList);
    }
    /**
     * 分页列表
     * @param areaSearch
     * @return
     */
    public List<Map<String, Object>> getPage(AreaSearch areaSearch){
        if(areaSearch.getStart() == null){
            areaSearch.setStart(0);
        }
        if(areaSearch.getLength() == null){
            areaSearch.setLength(5);
        }
        String sql = buildSqlSearch(areaSearch, false) + " order by id desc limit " + areaSearch.getStart() + "," + areaSearch.getLength();
        return getService().findBySQL(sql);
    }

    /**
     * 分页总数量
     * @param areaSearch
     * @return
     */
    public int getPageCount(AreaSearch areaSearch) {
        return getService().countBySQL(buildSqlSearch(areaSearch, true));
    }

    /**
     * 查询SQL
     * @param areaSearch
     * @return
     */
    private String buildSqlSearch(AreaSearch areaSearch, boolean isCount){
        String sql = "SELECT a.id id, a.name name, a.address address, a.longitude longitude, a.latitude latitude, a.description description, a.del del, DATE_FORMAT(a.create_time, '%Y-%m-%d %H:%i:%s') createTime, DATE_FORMAT(a.update_time, '%Y-%m-%d %H:%i:%s') updateTime, update_user updateUser ";
        if(isCount){
            sql = "SELECT COUNT(*) ";
        }
        sql +=" FROM area a WHERE 1=1 ";
        if(areaSearch != null){
            if(StringUtils.isNotBlank(areaSearch.getName())){
                sql += " and a.name like '%"+EsapiUtil.sql(areaSearch.getName().trim())+"%' ";
            }
            if(StringUtils.isNotBlank(areaSearch.getAddress())){
                sql += " and a.address like '%"+EsapiUtil.sql(areaSearch.getAddress())+"%' ";
            }
            if(areaSearch.getDel() != null){
                sql += " and a.del = "+ EsapiUtil.sql(areaSearch.getDel()+"");
            }
        }
        return sql;
    }
}
