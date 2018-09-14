package com.jzfq.house.service;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.SysUser;
import com.jzfq.house.mybatis.domain.SysUserQuery;
import com.jzfq.house.mybatis.service.SysUserService;
import com.jzfq.house.swagger.model.ImportExcelResult;
import com.jzfq.house.swagger.model.SysUserExport;
import com.jzfq.house.swagger.model.SysUserSearch;
import com.jzfq.house.swagger.model.SysUserVo;
import com.jzfq.house.util.*;
import com.jzfq.house.valid.SysUserValid;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SysUserManage extends BaseManage<Long>{
    @Autowired
    SysUserService<SysUser, SysUserQuery, Long> service;

    @Override
    public SysUserService<SysUser, SysUserQuery, Long> getService() {
        return service;
    }

    @Autowired
    SysUserValid sysUserValid;
    @Autowired
    POIHandler poiHandler;

    /**
     * 新增
     * @param sysUser
     * @return
     */
    public boolean save(SysUserVo sysUser){
        // 校验入参
        sysUserValid.saveValid(sysUser);
        // 对象转化
        com.jzfq.house.mybatis.domain.SysUser dist = new com.jzfq.house.mybatis.domain.SysUser();
        TransferUtil.transfer(dist, sysUser);
        // 特殊属性赋值
        dist.setCode("ID-" + UniqueCodeUtil.idCode());
        if(StringUtils.isBlank(dist.getNickName())){
            dist.setNickName("N-" + UniqueCodeUtil.idCodeShort());
        }
        dist.setPassword(MD5Util.getMD5String("111"));
        // 持久化
        int i = create(dist);
        // 返回结果
        if(i == 1){
            return true;
        }
        return false;
    }

    /**
     * 修改
     * @param sysUser
     * @return
     */
    public boolean update(SysUserVo sysUser){
        // 校验入参
        sysUserValid.updateValid(sysUser);
        // 对象转化
        com.jzfq.house.mybatis.domain.SysUser dist = new com.jzfq.house.mybatis.domain.SysUser();
        TransferUtil.transfer(dist, sysUser);
        // 持久化
        int i = modify(dist);
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
            int i = removeById(Long.parseLong(id));
            if(i == 1){
                count ++;
            }else{
                SysUser byId = findById(Long.parseLong(id));
                failList.add(byId.getNickName());
            }
        }
        return failMsg(count, ids, failList);
    }

    /**
     * 分页构建query
     * @param sysUserSearch
     * @return
     */
    private SysUserQuery buildQuery(SysUserSearch sysUserSearch){
        SysUserQuery query = new SysUserQuery();
        SysUserQuery.Criteria criteria = query.createCriteria();
        if(sysUserSearch != null){
            if(sysUserSearch.getStart() == null){
                sysUserSearch.setStart(0);
            }
            if(sysUserSearch.getLength() == null){
                sysUserSearch.setLength(5);
            }
            if(StringUtils.isNotBlank(sysUserSearch.getCode())){
                criteria.andCodeEqualTo(sysUserSearch.getCode().trim());
            }
            if(StringUtils.isNotBlank(sysUserSearch.getNickName())){
                criteria.andNickNameEqualTo(sysUserSearch.getNickName().trim());
            }
            if(StringUtils.isNotBlank(sysUserSearch.getRealName())){
                criteria.andRealNameLike("%"+sysUserSearch.getRealName().trim()+"%");
            }
            if(StringUtils.isNotBlank(sysUserSearch.getPhone())){
                criteria.andPhoneEqualTo(sysUserSearch.getPhone().trim());
            }
        }
        return query;
    }

    private String buildSqlSearch(SysUserSearch sysUserSearch){
        String sql = "select su.id, su.code, su.nick_name as nickName, su.real_name as realName, su.password, su.phone, su.id_number as idNumber, su.province, sa.label as provinceLabel,su.city, sa1.label as cityLabel, su.wechat, su.qq, su.email, su.roles, su.create_time as createTime from sys_user su left join sys_area sa on su.province = sa.id left join sys_area sa1 on su.city = sa1.id where 1=1 ";
        if(sysUserSearch != null){
            if(StringUtils.isNotBlank(sysUserSearch.getCode())){
                sql += " and su.code = " + EsapiUtil.sql(sysUserSearch.getCode().trim());
            }
            if(StringUtils.isNotBlank(sysUserSearch.getNickName())){
                sql += " and su.nick_name = " + EsapiUtil.sql(sysUserSearch.getNickName().trim());
            }
            if(StringUtils.isNotBlank(sysUserSearch.getRealName())){
                sql += " and su.real_name like '%"+ EsapiUtil.sql(sysUserSearch.getRealName().trim()) +"%'";
            }
            if(StringUtils.isNotBlank(sysUserSearch.getPhone())){
                sql += " and su.phone = " + EsapiUtil.sql(sysUserSearch.getPhone());
            }
        }
        return sql;
    }

    /**
     * 分页列表
     * @param sysUserSearch
     * @return
     */
    public List<SysUser> getByPage(SysUserSearch sysUserSearch){
        SysUserQuery query = buildQuery(sysUserSearch);
        query.setOrderByClause("id desc");
        return getService().findBy(new RowBounds(sysUserSearch.getStart(), sysUserSearch.getLength()), query);
    }

    /**
     * 分页总数量
     * @param sysUserSearch
     * @return
     */
    public int getPageCount(SysUserSearch sysUserSearch) {
        return getService().countByExample(buildQuery(sysUserSearch));
    }

    /**
     * 编码查询
     * @param code
     * @return
     */
    public SysUser getByCode(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        return getSingleByParamsOr(code, null, null, null, null, null, null);
    }

    /**
     * 昵称查询
     * @param nickName
     * @return
     */
    public SysUser getByNickName(String nickName){
        if(StringUtils.isBlank(nickName)){
            return null;
        }
        return getSingleByParamsOr(null, nickName, null, null, null, null, null);
    }

    /**
     * 手机号查询
     * @param phone
     * @return
     */
    public SysUser getByPhone(String phone){
        if(StringUtils.isBlank(phone)){
            return null;
        }
        return getSingleByParamsOr(null,null, phone, null, null, null, null);
    }

    /**
     * 身份证号查询
     * @param idNumber
     * @return
     */
    public SysUser getByIdNumber(String idNumber){
        if(StringUtils.isBlank(idNumber)){
            return null;
        }
        return getSingleByParamsOr(null,null, null, idNumber, null, null, null);
    }

    /**
     * 微信号查询
     * @param wechat
     * @return
     */
    public SysUser getByWechat(String wechat){
        if(StringUtils.isBlank(wechat)){
            return null;
        }
        return getSingleByParamsOr(null,null, null, null, wechat, null, null);
    }

    /**
     * qq号查询
     * @param qq
     * @return
     */
    public SysUser getByQq(String qq){
        if(StringUtils.isBlank(qq)){
            return null;
        }
        return getSingleByParamsOr(null,null, null, null, null, qq, null);
    }

    /**
     * 邮箱号查询
     * @param email
     * @return
     */
    public SysUser getByEmail(String email){
        if(StringUtils.isBlank(email)){
            return null;
        }
        return getSingleByParamsOr(null,null, null, null, null, email, null);
    }

    /**
     * 通过属性查询单个用户，组合查询方式“或”
     * @param nickName
     * @param phone
     * @param idNumber
     * @param wechat
     * @param qq
     * @param email
     * @return
     */
    public SysUser getSingleByParamsOr(String code, String nickName, String phone, String idNumber, String wechat, String qq, String email){
        List<SysUser> listByParamsOr = getListByParamsOr(code, nickName, phone, idNumber, wechat, qq, email);
        if(!CollectionUtils.isEmpty(listByParamsOr) && listByParamsOr.size() > 0){
            return listByParamsOr.get(0);
        }
        return null;
    }

    /**
     * 通过属性查询多个用户，组合查询方式“或”
     * @param nickName
     * @param phone
     * @param idNumber
     * @param wechat
     * @param qq
     * @param email
     * @return
     */
    public List<SysUser> getListByParamsOr(String code, String nickName, String phone, String idNumber, String wechat, String qq, String email){
        SysUserQuery query = new SysUserQuery();
        SysUserQuery.Criteria criteria = query.or();
        if(StringUtils.isNotBlank(code)){
            criteria.andCodeEqualTo(code);
        }
        if(StringUtils.isNotBlank(nickName)){
            criteria.andNickNameEqualTo(nickName);
        }
        if(StringUtils.isNotBlank(phone)){
            criteria.andPhoneEqualTo(phone);
        }
        if(StringUtils.isNotBlank(idNumber)){
            criteria.andIdNumberEqualTo(idNumber);
        }
        if(StringUtils.isNotBlank(wechat)){
            criteria.andWechatEqualTo(wechat);
        }
        if(StringUtils.isNotBlank(qq)){
            criteria.andQqEqualTo(qq);
        }
        if(StringUtils.isNotBlank(email)){
            criteria.andEmailEqualTo(email);
        }
        return getService().findBy(query);
    }

    /**
     * 导入Excel格式的用户数据
     * @param file
     * @return
     * @throws IOException
     */
    public Map<String, List<ImportExcelResult>> importExcel(MultipartFile file){
        Map<String, List<ImportExcelResult>> result = new HashedMap();
        sysUserValid.importExcelValid(file);
        List<Map<Integer, String>> rows = poiHandler.readExcel(file);
        List<ImportExcelResult> successList = new ArrayList<>();
        List<ImportExcelResult> failList = new ArrayList<>();
        if(rows.size() == 0){
            throw new BadRequestException("操作失败，原因：Excel无数据");
        }
        for(int i=0;i<rows.size();i++){
            ImportExcelResult importExcelResponse = sysUserValid.importExcelRowValid(i + 2, rows.get(i));
            if("操作失败".equals(importExcelResponse.getRes())){
                failList.add(importExcelResponse);
            } else {
                Map<Integer, String> map = rows.get(i);
                SysUserVo sysUserVo = new SysUserVo();
                sysUserVo.setNickName(map.get(0));
                sysUserVo.setRealName(map.get(1));
                sysUserVo.setPhone(map.get(2));
                sysUserVo.setIdNumber(map.get(3));
                sysUserVo.setProvince(map.get(4));
                sysUserVo.setCity(map.get(5));
                sysUserVo.setWechat(map.get(6));
                sysUserVo.setQq(map.get(7));
                sysUserVo.setEmail(map.get(8));
                if(save(sysUserVo)){
                    importExcelResponse.setRes("操作成功");
                    importExcelResponse.setMessage("操作成功");
                    successList.add(importExcelResponse);
                } else {
                    importExcelResponse.setRes("操作失败");
                    importExcelResponse.setMessage("保存失败");
                    failList.add(importExcelResponse);
                }
            }
        }
        result.put("successList", successList);
        result.put("failList", failList);
        return result;
    }

    /**
     * 导出Excel
     * @param sysUserSearch
     * @param response
     * @return
     */
    public void exportExcel(SysUserSearch sysUserSearch, HttpServletResponse response){
        List<Map<String, Object>> maps = getByParams(sysUserSearch);
        List<SysUserExport> list = new ArrayList<>();
        for(Map<String, Object> map : maps){
            SysUserExport sysUserExport = new SysUserExport();
            sysUserExport.setNickName((String) map.get("nick_name"));
            sysUserExport.setRealName((String) map.get("real_name"));
            sysUserExport.setPhone((String) map.get("phone"));
            sysUserExport.setIdNumber((String) map.get("id_number"));
            sysUserExport.setProvince((String) map.get("province"));
            sysUserExport.setCity((String) map.get("city"));
            sysUserExport.setWechat((String) map.get("wechat"));
            sysUserExport.setQq((String) map.get("qq"));
            sysUserExport.setEmail((String) map.get("email"));
            sysUserExport.setRoles((String) map.get("roles"));
            list.add(sysUserExport);
        }
        String fileName = "用户信息";
        String[] columnNames = {"用户名", "姓名（必填）", "手机号（必填）", "身份证号", "省份", "城市", "微信号", "QQ号", "邮箱", "角色"};
        poiHandler.export(fileName, columnNames, list, response);
    }

    public List<Map<String, Object>> getByParamsSearch(SysUserSearch sysUserSearch){
        if(sysUserSearch.getStart() == null){
            sysUserSearch.setStart(0);
        }
        if(sysUserSearch.getLength() == null){
            sysUserSearch.setLength(5);
        }
        String sql = buildSqlSearch(sysUserSearch) + " order by id desc limit " + sysUserSearch.getStart() + "," + sysUserSearch.getLength();
        return getService().findBySQL(sql);
    }

    private List<Map<String, Object>> getByParams(SysUserSearch sysUserSearch){
        if(sysUserSearch.getStart() == null){
            sysUserSearch.setStart(0);
        }
        String sql = buildSql(sysUserSearch) + " order by id desc limit " + sysUserSearch.getStart() + ",10000";
        return getService().findBySQL(sql);
    }

    private String buildSql(SysUserSearch sysUserSearch){
        StringBuilder sb = new StringBuilder();
        sb.append("select nick_name,real_name,phone,id_number,province,city,wechat,qq,email,roles from sys_user where 1=1 ");
        if(sysUserSearch != null){
            if(StringUtils.isNotBlank(sysUserSearch.getCode())){
                sb.append(" and code = '" + EsapiUtil.sql(sysUserSearch.getCode()) + "'");
            }
            if(StringUtils.isNotBlank(sysUserSearch.getNickName())){
                sb.append(" and nick_name = '" + EsapiUtil.sql(sysUserSearch.getNickName()) + "'");
            }
            if(StringUtils.isNotBlank(sysUserSearch.getRealName())){
                sb.append(" and real_name = '" + EsapiUtil.sql(sysUserSearch.getRealName()) + "'");
            }
            if(StringUtils.isNotBlank(sysUserSearch.getPhone())){
                sb.append(" and phone = '" + EsapiUtil.sql(sysUserSearch.getPhone()) + "'");
            }
        }
        return sb.toString();
    }

}
