package com.cl.entity.view;

import com.cl.entity.TijiaoceshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 提交测试
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@TableName("tijiaoceshi")
public class TijiaoceshiView  extends TijiaoceshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TijiaoceshiView(){
	}
 
 	public TijiaoceshiView(TijiaoceshiEntity tijiaoceshiEntity){
 	try {
			BeanUtils.copyProperties(this, tijiaoceshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
