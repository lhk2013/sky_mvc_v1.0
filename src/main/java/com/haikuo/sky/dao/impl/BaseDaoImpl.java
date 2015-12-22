package com.haikuo.sky.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.haikuo.sky.annotation.Column;
import com.haikuo.sky.annotation.TableName;
import com.haikuo.sky.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    private Class<T> clazz;
    @SuppressWarnings("unchecked")
	public BaseDaoImpl(){
        //使用反射技术得到T的真实类型
        //获取当前new的对象的泛型的父类
        ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        System.out.println("clazz--->"+clazz);
    }

	@Override
	public int save(T entity) {
		// TODO Auto-generated method stub
		Class clz= entity.getClass();
		Field[] fields = clz.getDeclaredFields();
		String tableName  = entity.getClass().getAnnotation(TableName.class).value();
		
		
		String sql =" insert into "+tableName;
		String sql2 = " values ";
		List<Object> params = new ArrayList<Object>();
		List<Object> columnName = new ArrayList<Object>();
		int i = 0;
		for (Field field : fields) {
//			params.add(fiel)
			String  cName = field.getAnnotation(Column.class).value();
			params.add(getFieldValue(entity, field));
			columnName.add(cName);
			if(i==0){
				sql +="(";
				sql2 +="(";
			}
			sql += cName+",";
			sql2 += "?,";
			i++;
		}
		sql = sql.substring(0,sql.length()-1);
		sql2 = sql2.substring(0,sql2.length()-1);
		sql +=")";
		sql2 +=")";
		int gId = jdbcTemplate.update(sql+sql2, params.toArray());
		System.out.println(gId);
		return 0;
	}
	
	@SuppressWarnings("unused")
	private Object getFieldValue(Object obj,Field field){  
		try {
			String name = field.getName();
			String c = name.substring(0, 1);
			name = name.replaceFirst(c, c.toUpperCase());
			Method m = obj.getClass().getMethod("get"+name, new Class<?>[]{});
			return  m.invoke(obj, new Object[]{});
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Object();
	 }  

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		System.out.println(clazz.getFields());
		return null;
	}

}
