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


import com.cl.dao.KaogongziyuanDao;
import com.cl.entity.KaogongziyuanEntity;
import com.cl.service.KaogongziyuanService;
import com.cl.entity.view.KaogongziyuanView;

@Service("kaogongziyuanService")
public class KaogongziyuanServiceImpl extends ServiceImpl<KaogongziyuanDao, KaogongziyuanEntity> implements KaogongziyuanService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<KaogongziyuanEntity> wrapper) {
		Page<KaogongziyuanView> page =new Query<KaogongziyuanView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaogongziyuanEntity> page = this.selectPage(
                new Query<KaogongziyuanEntity>(params).getPage(),
                new EntityWrapper<KaogongziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaogongziyuanEntity> wrapper) {
		  Page<KaogongziyuanView> page =new Query<KaogongziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KaogongziyuanView> selectListView(Wrapper<KaogongziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaogongziyuanView selectView(Wrapper<KaogongziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
