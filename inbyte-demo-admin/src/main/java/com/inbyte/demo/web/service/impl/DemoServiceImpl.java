package com.inbyte.demo.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.inbyte.commons.model.dto.Page;
import com.inbyte.commons.model.dto.R;
import com.inbyte.commons.util.PageUtil;
import com.inbyte.component.admin.system.user.SessionUtil;
import com.inbyte.demo.web.dao.DemoMapper;
import com.inbyte.demo.web.service.DemoService;
import com.inbyte.demo.web.model.demo.DemoPo;
import com.inbyte.demo.web.model.demo.DemoQuery;
import com.inbyte.demo.web.model.demo.DemoCreate;
import com.inbyte.demo.web.model.demo.DemoUpdate;
import com.inbyte.demo.web.model.demo.DemoBrief;
import com.inbyte.demo.web.model.demo.DemoDetail;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * 演示服务
 *
 * @author chenjw
 * @date 2024-02-06 16:23:55
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public R create(DemoCreate create) {
        DemoPo demoPo = DemoPo.builder()
                //.mctNo(SessionUtil.getDefaultMctNo())
                .createTime(LocalDateTime.now())
                .createUserId(SessionUtil.getUserId())
                .createUserName(SessionUtil.getUserName())
                .build();
        BeanUtils.copyProperties(create, demoPo);
        demoMapper.insert(demoPo);
        return R.ok("新增成功");
    }

    @Override
    public R delete(Integer demoId) {
        LambdaQueryWrapper<DemoPo> queryWrapper = new LambdaQueryWrapper<DemoPo>()
            .eq(DemoPo::getDemoId, demoId);
            //.eq(DemoPo::getMctNo, SessionUtil.getDefaultMctNo());
        demoMapper.delete(queryWrapper);
        return R.ok("删除成功");
    }

    @Override
    public R update(DemoUpdate update) {
        DemoPo demoPo = DemoPo.builder()
                .updateTime(LocalDateTime.now())
                .build();
        BeanUtils.copyProperties(update, demoPo);

        LambdaQueryWrapper<DemoPo> queryWrapper = new LambdaQueryWrapper<DemoPo>()
                .eq(DemoPo::getDemoId, update.getDemoId());
                //.eq(DemoPo::getMctNo, SessionUtil.getDefaultMctNo());
        demoMapper.update(demoPo, queryWrapper);
        return R.ok("修改成功");
    }

    @Override
    public R<DemoDetail> detail(Integer demoId) {
        return R.ok(demoMapper.detail(demoId));
    }

    @Override
    public R<Page<DemoBrief>> list(DemoQuery query) {
        if (query.getEndDate() != null) {
            query.setEndDate(query.getEndDate().plusDays(1));
        }
        PageUtil.startPage(query);
        return R.page(demoMapper.list(query));
    }
}
