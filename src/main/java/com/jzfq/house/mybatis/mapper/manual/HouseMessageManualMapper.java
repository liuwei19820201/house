package com.jzfq.house.mybatis.mapper.manual;

import com.github.pagehelper.Page;
import com.jzfq.house.model.req.HouseMessageSearch;
import com.jzfq.house.model.req.HouseSearch;
import com.jzfq.house.model.res.HouseMessageRes;
import com.jzfq.house.model.res.HouseRes;

/**
 * @Title: HouseManualMapper
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 14:16
 * @Description:
 */
public interface HouseMessageManualMapper {
    /**
     * 分页筛选查询
     *
     * @param search
     * @return
     */
    Page<HouseMessageRes> findList(HouseMessageSearch search);
}
