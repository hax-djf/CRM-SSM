package com.al.hax.crm.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al.hax.crm.Service.CustomerService;
import com.al.hax.crm.mapper.CustomerMapper;
import com.al.hax.crm.pojo.Customer;
import com.al.hax.crm.pojo.QueryVo;
import com.al.hax.crm.utils.Page;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	/**
	 * 根据条件查询分页封装到一个page对象中
	 */
	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryvo) {
		//当前的查询数目等于 当前的页码数-1*每页显示的数据多少
		queryvo.setStart((queryvo.getPage()-1)*queryvo.getRows());
		//查询总的记录数
		Integer total = this.customerMapper.queryCountByQueryVo(queryvo);
		//查询结果集
		List<Customer> queryCustomerByQueryVo = this.customerMapper.queryCustomerByQueryVo(queryvo);
		//实例化page对象
		/**
		 * @param total查询数据总条数
		 * @param page当前页码数
		 * @param size每页显示数据条数        
		 * @param rows查询结果集
		 */
		Page<Customer> page=new Page<Customer>(total, queryvo.getPage(), queryvo.getRows(), queryCustomerByQueryVo);
		return page;
	}
	/**
	 * 根据id查询数据
	 */
	@Override
	public Customer queryCustomerById(Integer id) {
	
		return this.customerMapper.queryCustomerById(id);
	}
	/**
	 * 修改客户数据
	 */
	@Override
	public void updateCustomer(Customer customer) {
		this.customerMapper.updateCustomer(customer);	
	}
	/*
	 * 删除用户
	 */
	@Override
	public void deleteCustomerById(Integer id) {
		this.customerMapper.deleteCustomerById(id);	
	}

}
