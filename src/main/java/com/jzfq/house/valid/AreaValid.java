package com.jzfq.house.valid;

import com.jzfq.house.enums.FileType;
import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.exception.BusinessException;
import com.jzfq.house.mybatis.domain.Area;
import com.jzfq.house.service.SysUserManage;
import com.jzfq.house.swagger.model.AreaVo;
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
public class AreaValid {

    @Autowired
    SysUserManage sysUserManage;

    /**
     * 验证：新增接口
     * @param areaVo
     */
    public void saveValid(AreaVo areaVo){

    }

    /**
     * 验证：编辑接口
     * @param areaVo
     */
    public void updateValid(AreaVo areaVo){

    }

    /**
     * 验证：导入接口
     * @param rowNo
     * @param map
     * @return
     */
    public ImportExcelResult importExcelRowValid(Integer rowNo, Map<Integer, String> map){
       return new ImportExcelResult();
    }

}
