package com.jzfq.house.valid;

import com.jzfq.house.enums.FileType;
import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.exception.BusinessException;
import com.jzfq.house.service.SysUserManage;
import com.jzfq.house.swagger.model.ImportExcelResult;
import com.jzfq.house.swagger.model.SysUserVo;
import com.jzfq.house.util.FileHandler;
import com.jzfq.house.util.IdNumValidUtil;
import com.jzfq.house.util.PhoneValidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SysUserValid {

    @Autowired
    SysUserManage sysUserManage;

    /**
     * 验证：新增接口
     * @param sysUser
     */
    public void saveValid(SysUserVo sysUser){
        // 参数对象
        if(sysUser == null){
            throw new BadRequestException("新增用户不能为空");
        }
        // 非空验证：姓名
        if(StringUtils.isBlank(sysUser.getRealName())){
            throw new BadRequestException("姓名不能为空");
        }
        // 非空验证：手机号
        if(StringUtils.isBlank(sysUser.getPhone())){
            throw new BadRequestException("手机号不能为空");
        }
        // 昵称
        if(StringUtils.isNotBlank(sysUser.getNickName())){
            com.jzfq.house.mybatis.domain.SysUser byNickName = sysUserManage.getByNickName(sysUser.getNickName());
            if(byNickName != null){
                throw new BadRequestException("昵称已存在");
            }
        }
        // 手机号
        if(!PhoneValidUtil.isPhone(sysUser.getPhone())){
            throw new BadRequestException("手机号有误");
        }
        com.jzfq.house.mybatis.domain.SysUser byPhone = sysUserManage.getByPhone(sysUser.getPhone());
        if(byPhone != null){
            throw new BadRequestException("手机号已存在");
        }
        // 身份证
        if(StringUtils.isNotBlank(sysUser.getIdNumber())){
            if(!IdNumValidUtil.validID(sysUser.getIdNumber(), false, false)){
                throw new BadRequestException("身份证号有误");
            }
            com.jzfq.house.mybatis.domain.SysUser byIdNumber = sysUserManage.getByIdNumber(sysUser.getIdNumber());
            if(byIdNumber != null){
                throw new BadRequestException("身份证号已存在");
            }
        }
        // 微信
        if(StringUtils.isNotBlank(sysUser.getWechat())){
            com.jzfq.house.mybatis.domain.SysUser byWechat = sysUserManage.getByWechat(sysUser.getWechat());
            if(byWechat != null){
                throw new BadRequestException("微信号已存在");
            }
        }
        // QQ
        if(StringUtils.isNotBlank(sysUser.getQq())){
            com.jzfq.house.mybatis.domain.SysUser byQq = sysUserManage.getByQq(sysUser.getQq());
            if(byQq != null){
                throw new BadRequestException("QQ号已存在");
            }
        }
        // email
        if(StringUtils.isNotBlank(sysUser.getEmail())){
            if(sysUser.getEmail().indexOf('@')<1 || sysUser.getEmail().split("@").length>2){
                throw new BadRequestException("邮箱号有误");
            }
            com.jzfq.house.mybatis.domain.SysUser byEmail = sysUserManage.getByEmail(sysUser.getEmail());
            if(byEmail != null){
                throw new BadRequestException("邮箱号已存在");
            }
        }
    }

    /**
     * 验证：编辑接口
     * @param sysUser
     */
    public void updateValid(SysUserVo sysUser){
        // 参数对象
        if(sysUser == null){
            throw new BadRequestException("编辑用户不能为空");
        }
        // ID(code编码)
        if(StringUtils.isBlank(sysUser.getCode())){
            throw new BadRequestException("ID不能为空");
        }
        com.jzfq.house.mybatis.domain.SysUser byCode = sysUserManage.getByCode(sysUser.getCode());    // 原对象
        if(byCode == null){
            throw new BadRequestException("用户ID不存在");
        }
        // 昵称
        if(StringUtils.isNotBlank(sysUser.getNickName()) && !sysUser.getNickName().trim().equals(byCode.getNickName())){    // 不是空，不是原值
            com.jzfq.house.mybatis.domain.SysUser byNickName = sysUserManage.getByNickName(sysUser.getNickName());
            if(byNickName != null){
                throw new BadRequestException("昵称已存在");
            }
        }
        // 手机号
        if(StringUtils.isNotBlank(sysUser.getPhone()) && !sysUser.getPhone().trim().equals(byCode.getPhone())){ // 不是空，不是原值
            if(!PhoneValidUtil.isPhone(sysUser.getPhone())){
                throw new BadRequestException("手机号有误");
            }
            com.jzfq.house.mybatis.domain.SysUser byPhone = sysUserManage.getByPhone(sysUser.getPhone());
            if(byPhone != null){
                throw new BadRequestException("手机号已存在");
            }
        }
        // 身份证号
        if(StringUtils.isNotBlank(sysUser.getIdNumber()) && !sysUser.getIdNumber().trim().equals(byCode.getIdNumber())){ // 不是空，不是原值
            if(!IdNumValidUtil.validID(sysUser.getIdNumber(), false, false)){
                throw new BadRequestException("身份证号有误");
            }
            com.jzfq.house.mybatis.domain.SysUser byIdNumber = sysUserManage.getByIdNumber(sysUser.getIdNumber());
            if(byIdNumber != null){
                throw new BadRequestException("身份证号已存在");
            }
        }
        // 微信
        if(StringUtils.isNotBlank(sysUser.getWechat()) && !sysUser.getWechat().trim().equals(byCode.getWechat())){  // 不是空，不是原值
            com.jzfq.house.mybatis.domain.SysUser byWechat = sysUserManage.getByWechat(sysUser.getWechat());
            if(byWechat != null){
                throw new BadRequestException("微信号已存在");
            }
        }
        // QQ
        if(StringUtils.isNotBlank(sysUser.getQq()) && !sysUser.getQq().trim().equals(byCode.getQq())){  // 不是空，不是原值
            com.jzfq.house.mybatis.domain.SysUser byQq = sysUserManage.getByQq(sysUser.getQq());
            if(byQq != null){
                throw new BadRequestException("QQ号已存在");
            }
        }
        // email
        if(StringUtils.isNotBlank(sysUser.getEmail()) && !sysUser.getEmail().trim().equals(byCode.getEmail())){ // 不是空，不是原值
            if(sysUser.getEmail().indexOf('@')<1 || sysUser.getEmail().split("@").length>2){
                throw new BadRequestException("邮箱号有误");
            }
            com.jzfq.house.mybatis.domain.SysUser byEmail = sysUserManage.getByEmail(sysUser.getEmail());
            if(byEmail != null){
                throw new BadRequestException("邮箱号已存在");
            }
        }
    }

    public void importExcelValid(MultipartFile multipartFile) {
        if(multipartFile == null){
            throw new BadRequestException("excel不能为空");
        }
        try{
            InputStream inputStream = inputStream = multipartFile.getInputStream();
            if(FileHandler.getType(inputStream) != FileType.XLSX) {
                throw new BadRequestException("上传文件类型错误");
            }
        }catch(IOException e){
            throw new BusinessException("系统异常，位置：导入文件类型验证。");
        }
        if (multipartFile.getSize() > 2 * 1024 * 1024) {
            throw new BadRequestException("导入文件大小不能超过 2MB");
        }
    }

    public ImportExcelResult importExcelRowValid(Integer rowNo, Map<Integer, String> map){
        List<String> failMsgList = new ArrayList<>();
        // 非空验证：姓名
        if(StringUtils.isBlank(map.get(1))){
            failMsgList.add("姓名为空");
        }
        // 非空验证：手机号
        if(StringUtils.isBlank(map.get(2))){
            failMsgList.add("手机号为空");
        }
        // 昵称
        if(StringUtils.isNotBlank(map.get(0))){
            com.jzfq.house.mybatis.domain.SysUser byNickName = sysUserManage.getByNickName(map.get(0));
            if(byNickName != null){
                failMsgList.add("昵称已存在");
            }
        }
        // 手机号
        if(!PhoneValidUtil.isPhone(map.get(2))){
            failMsgList.add("手机号有误");
        }
        com.jzfq.house.mybatis.domain.SysUser byPhone = sysUserManage.getByPhone(map.get(2));
        if(byPhone != null){
            failMsgList.add("手机号已存在");
        }
        // 身份证
        if(StringUtils.isNotBlank(map.get(3))){
            if(!IdNumValidUtil.validID(map.get(3), false, false)){
                failMsgList.add("身份证号有误");
            }
            com.jzfq.house.mybatis.domain.SysUser byIdNumber = sysUserManage.getByIdNumber(map.get(3));
            if(byIdNumber != null){
                failMsgList.add("身份证号已存在");
            }
        }
        // 微信
        if(StringUtils.isNotBlank(map.get(6))){
            com.jzfq.house.mybatis.domain.SysUser byWechat = sysUserManage.getByWechat(map.get(6));
            if(byWechat != null){
                failMsgList.add("微信号已存在");
            }
        }
        // QQ
        if(StringUtils.isNotBlank(map.get(7))){
            com.jzfq.house.mybatis.domain.SysUser byQq = sysUserManage.getByQq(map.get(7));
            if(byQq != null){
                failMsgList.add("QQ号已存在");
            }
        }
        // email
        if(StringUtils.isNotBlank(map.get(8))){
            if(map.get(8).indexOf('@')<1 || map.get(8).split("@").length>2){
                failMsgList.add("邮箱号有误");
            }
            com.jzfq.house.mybatis.domain.SysUser byEmail = sysUserManage.getByEmail(map.get(8));
            if(byEmail != null){
                failMsgList.add("邮箱号已存在");
            }
        }
        ImportExcelResult importExcelValidResponse = new ImportExcelResult();
        importExcelValidResponse.setRowNo(rowNo);
        importExcelValidResponse.setData(map);
        importExcelValidResponse.setRes("操作成功");
        if(failMsgList.size() != 0){
            importExcelValidResponse.setRes("操作失败");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<failMsgList.size();i++) {
                sb.append(failMsgList.get(i));
                if(i<failMsgList.size()-1){
                    sb.append("，");
                }
                if(i == failMsgList.size() - 1){
                    sb.append("。");
                }
            }
            importExcelValidResponse.setMessage(sb.toString());
        }
        return importExcelValidResponse;
    }

}
