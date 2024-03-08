package com.inbyte.demo.web.controller;
import com.inbyte.commons.model.dto.Page;
import com.inbyte.commons.model.dto.R;
import com.inbyte.demo.web.model.demo.DemoQuery;
import com.inbyte.demo.web.model.demo.DemoUpdate;
import com.inbyte.demo.web.model.demo.DemoInsert;
import com.inbyte.demo.web.model.demo.DemoBrief;
import com.inbyte.demo.web.model.demo.DemoDetail;
import com.inbyte.demo.web.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * 演示
 *
 * @author chenjw
 * @date 2024-02-06 16:23:55
 **/
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * 新增
     *
     * @param insert
     * @return R
     **/
    @PostMapping
    public R insert(@RequestBody @Valid DemoInsert insert) {
        return demoService.insert(insert);
    }

    /**
     * 删除
     *
     * @param demoId
     * @return R
     **/
    @DeleteMapping("{demoId}")
    public R delete(@PathVariable("demoId") Integer demoId) {
        return demoService.delete(demoId);
    }

    /**
     * 更新
     *
     * @param update
     * @return R
     **/
    @PutMapping
    public R update(@RequestBody @Valid DemoUpdate update) {
        return demoService.update(update);
    }

    /**
     * 详情
     *
     * @param demoId
     * @return R<DemoDetail>
     **/
    @GetMapping("{demoId}")
    public R<DemoDetail> detail(@PathVariable("demoId") Integer demoId) {
        return demoService.detail(demoId);
    }

    /**
     * 列表
     *
     * @param query
     * @return R<Page<DemoBrief>>>
     **/
    @GetMapping
    public R<Page<DemoBrief>> list(@ModelAttribute @Valid DemoQuery query) {
        return demoService.list(query);
    }
}
