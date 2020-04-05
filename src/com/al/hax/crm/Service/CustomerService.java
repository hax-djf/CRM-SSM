package com.al.hax.crm.Service;

import java.util.List;

import com.al.hax.crm.pojo.Customer;
import com.al.hax.crm.pojo.QueryVo;
import com.al.hax.crm.utils.Page;

public interface CustomerService {
	/**
	 * 分页查询数据将分页的中的所有数据封装到一个page的对象中去
	 * @param queryvo
	 * @return
	 */
	Page<Customer> queryCustomerByQueryVo(QueryVo queryvo);
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Customer queryCustomerById(Integer id);
	/**
	 * 修改数据
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * 根据id删除客户
	 * @param id
	 */
	void deleteCustomerById(Integer id);
}
