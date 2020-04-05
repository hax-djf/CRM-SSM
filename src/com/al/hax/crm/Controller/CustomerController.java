package com.al.hax.crm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.al.hax.crm.Service.BaseDictService;
import com.al.hax.crm.Service.CustomerService;
import com.al.hax.crm.pojo.BaseDict;
import com.al.hax.crm.pojo.Customer;
import com.al.hax.crm.pojo.QueryVo;
import com.al.hax.crm.utils.Page;
import com.alibaba.druid.util.StringUtils;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	//使用配置文件引入直接使用注解操作
	//客户来源
	@Value("${fromTypeCode}")
	private String fromTypeCode;
	//客户行业
	@Value("${industryTypeCode}")
	private String industryTypeCode;
	//客户级别
	@Value("${levelTypeCode}")
	private String levelTypeCode;
	@RequestMapping("list")
	public String customer(Model model,QueryVo queryvo) {
	//get编码设置
	try {
	queryvo.setCustName(new String(queryvo.getCustName().getBytes("ISO-8859-1"),"UTF-8"));	
	} catch (Exception e) {
		// TODO: handle exception
	}
	System.out.println(queryvo.toString());
	//查询客户的来源
	List<BaseDict> fromType = this.baseDictService.getBaseDict(fromTypeCode);
	//查询客户所属的行业
	List<BaseDict> industryType = this.baseDictService.getBaseDict(industryTypeCode);
	//查询客户的级别
	List<BaseDict> levelType = this.baseDictService.getBaseDict(levelTypeCode);
	//分页模块的page的获取
	Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryvo);
	//将数据返回给页面
	model.addAttribute("fromType", fromType);
	model.addAttribute("industryType", industryType);
	model.addAttribute("levelType", levelType);
	model.addAttribute("page", page);
	//返回页面
	return "customer";
	}
	
	//修改操作，进行数据的回显(异步请求返回数据操作)json数据返回
	@RequestMapping("edit")
	@ResponseBody
	public Customer updateCustomer(Integer id) {
		Customer customer = this.customerService.queryCustomerById(id);
		return customer;
	}
	/**
	 * 修改数据  不经过试图 直接进行json数据的返回
	 * @param customer
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String updateCustomer2(Customer customer,Model model) {
		String result;
		try {
			this.customerService.updateCustomer(customer);
			return result="1";
		} catch (Exception e) {
			return result="0";
		}
	}
	@RequestMapping("delete")
	@ResponseBody
	public String deleteController(Integer id) {
		String result;
		try {
		this.customerService.deleteCustomerById(id);
		return result="1";
		} catch (Exception e) {
		return "0";
		}
	}
}
