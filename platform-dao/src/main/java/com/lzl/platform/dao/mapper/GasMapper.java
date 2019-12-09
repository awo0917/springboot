package com.lzl.platform.dao.mapper;

import com.lzl.platform.model.Gas;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Create by awo
 * @date: 2019/12/7
 * @Discription:
 **/

public interface GasMapper {

    @Select("select id,`name`,gasId,address,lon,lat,icon,created,updated from privilege_gas where gasId = #{gasId} and del = 1")
    Gas getGasByGasId(String gasId);
}
