package com.inbyte.demo.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inbyte.demo.web.model.demo.DemoPo;
import com.inbyte.demo.web.model.demo.DemoQuery;
import com.inbyte.demo.web.model.demo.DemoBrief;
import com.inbyte.demo.web.model.demo.DemoDetail;
import java.util.List;

/**
 * 演示
 *
 * 表名InbyteCG  demo
 * @author chenjw
 * @date 2024-02-06 16:23:55
 */
public interface DemoMapper extends BaseMapper<DemoPo> {

    /**
     * 详情
     *
     * @param demoId
     * @return DemoDetail
     **/
    DemoDetail detail(Integer demoId);

    /**
     * 查询列表
     * @param query
     * @return List<DemoBrief>
     **/
    List<DemoBrief> list(DemoQuery query);
}
