package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.CeshipingfenDao;
import com.cl.entity.CeshipingfenEntity;
import com.cl.service.CeshipingfenService;
import com.cl.entity.view.CeshipingfenView;

@Service("ceshipingfenService")
public class CeshipingfenServiceImpl extends ServiceImpl<CeshipingfenDao, CeshipingfenEntity> implements CeshipingfenService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<CeshipingfenEntity> wrapper) {
		Page<CeshipingfenView> page =new Query<CeshipingfenView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CeshipingfenEntity> page = this.selectPage(
                new Query<CeshipingfenEntity>(params).getPage(),
                new EntityWrapper<CeshipingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CeshipingfenEntity> wrapper) {
		  Page<CeshipingfenView> page =new Query<CeshipingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CeshipingfenView> selectListView(Wrapper<CeshipingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CeshipingfenView selectView(Wrapper<CeshipingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CeshipingfenEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CeshipingfenEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CeshipingfenEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
