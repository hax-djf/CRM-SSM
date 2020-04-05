package com.al.hax.crm.mapper;

import java.util.List;

import com.al.hax.crm.pojo.Customer;
import com.al.hax.crm.pojo.QueryVo;

public interface CustomerMapper {
	/**
	 * 根据查询条件查询总的记录数
	 * @param queryvo
	 * @return 数量
	 */
	Integer queryCountByQueryVo(QueryVo queryvo);
	/**
	 * 根据条件进行分页数据查询
	 * @param queryvo
	 * @return
	 */
	List<Customer> queryCustomerByQueryVo(QueryVo queryvo);
	/**
	 * 根据id查询数据
	 * @param id
	 * @return Customer数据
	 */
	Customer queryCustomerById(Integer id);
	/**
	 * 修改客户信息
	 * @param custoemr
	 */
	void updateCustomer(Customer customer);
	/**
	 * 根据id删除用户
	 * @param id
	 */
	void deleteCustomerById(Integer id);
}
