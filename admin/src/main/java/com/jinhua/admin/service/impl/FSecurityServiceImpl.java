package com.jinhua.admin.service.impl;

import com.jinhua.admin.dao.FSecurityMapper;
import com.jinhua.admin.entity.FSecurity;
import com.jinhua.admin.service.FSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("securityService")
public class FSecurityServiceImpl implements FSecurityService {
    @Autowired
    private FSecurityMapper securiMapper;


    @Override
    public int insert(FSecurity security) {
        return securiMapper.insert(security);
    }

    @Override
    public FSecurity selectByPrimaryKey(Integer fid) {
        return securiMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<FSecurity> selectAll() {
        return securiMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(FSecurity security) {
        return securiMapper.updateByPrimaryKey(security);
    }

    @Override
    public int del(Integer fid) {
        return securiMapper.deleteByPrimaryKey(fid);
    }

    @Override
    public int getChildCount(Integer fid) {
        return securiMapper.getChildCount(fid);
    }

}
