package com.inbyte.demo.web.service;
import com.inbyte.commons.model.dto.Page;
import com.inbyte.commons.model.dto.R;
import com.inbyte.demo.web.model.demo.DemoQuery;
import com.inbyte.demo.web.model.demo.DemoCreate;
import com.inbyte.demo.web.model.demo.DemoUpdate;
import com.inbyte.demo.web.model.demo.DemoBrief;
import com.inbyte.demo.web.model.demo.DemoDetail;

/**
 * 演示服务
 *
 * @author chenjw
 * @date 2024-02-06 16:23:55
 **/
public interface DemoService {

    /**
     * 新增
     *
     * @param create
     * @return R
     **/
    R create(DemoCreate create);

    /**
     * 删除
     *
     * @param demoId
     * @return R
     **/
    R delete(Integer demoId);

    /**
     * 修改
     *
     * @param update
     * @return R
     **/
    R update(DemoUpdate update);

    /**
     * 详情
     *
     * @param demoId
     * @return DemoDetail
     **/
    R<DemoDetail> detail(Integer demoId);

    /**
     * 列表
     *
     * @param query
     * @return R<Page<DemoBrief>>>
     **/
    R<Page<DemoBrief>> list(DemoQuery query);
}
