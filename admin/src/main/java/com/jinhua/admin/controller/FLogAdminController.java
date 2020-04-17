package com.jinhua.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jinhua.admin.entity.FLogAdmin;
import com.jinhua.admin.service.IFLogAdminService;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jinhua.common.Enum.FlogAdminStatusEnum.getEnumString;

/**
 * 管理员日志记录
 */
@Controller
public class FLogAdminController {

    //打印日志
    private static Logger logger = LoggerFactory.getLogger(FLogAdminController.class);

    @Autowired
    private IFLogAdminService fLogAdminService;

    /**
     * 根据id查日志详情
     *
     * @param fid
     * @return
     */
    @RequestMapping("/flogAdmin/selectLogAdmin/{fid}")
    @ResponseBody
    public Map<String, Object> selectLogAdminById(@PathVariable("fid") Integer fid) {
        Map<String, Object> ret = new HashMap<>();
        FLogAdmin fLogAdmin = fLogAdminService.selectLogAdminById(fid);
        if (fLogAdmin.getFtype() != null) {
            fLogAdmin.setType(getEnumString(fLogAdmin.getFtype()));
        }
        if (fLogAdmin.getFadmintype() != null) {
            if (fLogAdmin.getFadmintype() == 1) {
                fLogAdmin.setAdmintype("超级管理员");
            } else if (fLogAdmin.getFadmintype() == 2) {
                fLogAdmin.setAdmintype("普通管理员");
            } else if (fLogAdmin.getFadmintype() == 3) {
                fLogAdmin.setAdmintype("临时管理员");
            }
        }

        ret.put("fLogAdmin", fLogAdmin);
        ret.put("code", 0);
        ret.put("message", fid + "日志成功");
        return ret;
    }

    /**
     * 日志列表
     *
     * @param page
     * @param limit
     * @param fLogAdmin
     * @return
     */
    @RequestMapping(value = "/flogAdmin/selectLogAdminList")
    @ResponseBody
    public Map<String, Object> selectLogAdminList(@RequestParam(value = "page") Integer page,
                                                  @RequestParam(value = "limit") Integer limit,
                                                  FLogAdmin fLogAdmin) {
        Map<String, Object> ret = new HashMap<>();
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageSize(limit);
        pageQuery.setPageNum(page);
        PageInfo<FLogAdmin> list = fLogAdminService.selectLogAdminByPage(pageQuery, fLogAdmin);
        ret.put("code", 0);
        ret.put("msg", "List查询成功!");
        ret.put("count", list.getTotal());
        ret.put("data", list.getList());

        return ret;
    }

    /**
     * 导出日志
     *
     * @param begin
     * @param end
     * @param response
     * @param fLogAdmin
     * @return
     * @throws IOException
     */
    @RequestMapping("/flogAdmin/ExcelDownload")
    @ResponseBody
    public void exportLog(@RequestParam(value = "begin") String begin,
                          @RequestParam(value = "end") String end,
                          HttpServletResponse response, FLogAdmin fLogAdmin) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> params = new HashMap<>();
        if (begin != null && !"".equals(begin)) {
            params.put("beginTime", begin);
        }
        if (end != null && !"".equals(end)) {
            params.put("endTime", end);
        }
        fLogAdmin.setParams(params);

        String sheetName = "日志统计";
        String fileName = "管理员日志_" + sdf.format(new Date()) + ".xls";
        List<FLogAdmin> lists = fLogAdminService.selectLogAdminList(fLogAdmin);
        List<List<String>> excelData = fLogAdminService.changeExcel(lists);
        ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 15);
    }


}
