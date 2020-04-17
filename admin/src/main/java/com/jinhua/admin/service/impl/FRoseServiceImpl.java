package com.jinhua.admin.service.impl;

import com.jinhua.admin.dao.FRoseMapper;
import com.jinhua.admin.entity.FRole;
import com.jinhua.admin.service.FRoseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roseService")
public class FRoseServiceImpl implements FRoseService {
    @Autowired
    private FRoseMapper roseMapper;


    @Override
    public int insert(FRole record) {
        return roseMapper.insert(record);
    }

    @Override
    public FRole selectByPrimaryKey(Integer fid) {
        return roseMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<FRole> selectAll() {
        return roseMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(FRole record) {
        return roseMapper.updateByPrimaryKey(record);
    }
}
