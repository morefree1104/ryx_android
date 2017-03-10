package com.neo.duan.db.base;

import java.util.List;

/**
 * @author : neo.duan
 * @date : 	 2016/9/12
 * @desc : 通用的实体操作接口
 */
public interface DAO<M>{
	/**
	 * 增加数据到数据库
	 * @param
	 * @return 是否插入成功
	 */
	boolean insert(M m);

	/**
	 * 删除该数据
	 * @param   m
	 * @return 1标示删除成功，0标示失败      
	 */
	boolean delete(M m);

	/**
	 * 通过id删除该数据
	 * @param id
	 * @return 1标示删除成功，0标示失败
     */
	boolean deleteById(String id);

	/**
	 * 更新
	 * @param m
	 * @return 是否更新成功
	 */
	boolean update(M m);


	/**
	 * 查询所有
	 * @return
     */
	List<M> getAll();

	/**
	 * 根据id查询该实体
	 * @param id
	 * @return
     */
	M get(String id);


	/**
	 * 清除所有表数据
	 */
	void clear();

}
