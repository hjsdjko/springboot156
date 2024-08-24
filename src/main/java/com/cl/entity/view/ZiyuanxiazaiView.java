package com.cl.entity.view;

import com.cl.entity.ZiyuanxiazaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 资源下载
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-19 12:35:39
 */
@TableName("ziyuanxiazai")
public class ZiyuanxiazaiView  extends ZiyuanxiazaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZiyuanxiazaiView(){
	}
 
 	public ZiyuanxiazaiView(ZiyuanxiazaiEntity ziyuanxiazaiEntity){
 	try {
			BeanUtils.copyProperties(this, ziyuanxiazaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
