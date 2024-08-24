package com.cl.entity.view;

import com.cl.entity.CeshipingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 测试评分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@TableName("ceshipingfen")
public class CeshipingfenView  extends CeshipingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CeshipingfenView(){
	}
 
 	public CeshipingfenView(CeshipingfenEntity ceshipingfenEntity){
 	try {
			BeanUtils.copyProperties(this, ceshipingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
