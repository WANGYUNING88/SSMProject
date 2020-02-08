package com.wang.ssmtest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.ssmtest.bean.Employee;
import com.wang.ssmtest.bean.Msg;
import com.wang.ssmtest.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * URL:
	 * 1、/emp/{id} GET 查询员工
	 * 2、/emp     POST 保存员工
	 * 2、/emp/{id} PUT 修改员工
	 * 2、/emp/{id} DELETE 删除员工
	 */
	/**
	 * 员工删除
	 * id格式为1-2-3
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmpByIds(@PathVariable("ids")String ids) {
		if(ids.contains("-")) {
			String[] split = ids.split("-");
			//组装id数组
			List<Integer> idList = new ArrayList<Integer>();
			for(String string : split) {
				idList.add(Integer.parseInt(string));
			}
			employeeService.deleteEmpBatch(idList);
		}else {
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		
		return Msg.success();
	}
	
	/**
	 * 员工信息更新
	 * 
	 * 如何ajax发送type=PUT请求
	 * 封装的数据就会出现问题：请求体中有数据，但是Employee对象封账不上
	 * 
	 * 原因： Tomcat将请求体中的数据封装成一个map
	 * 		request.getParameter("empName")就会从这个mao中取值
	 * 		SpringMVC封装POJO对象的时候会把POJO中每个属性的值,request.getParameter("email0");
	 * AJAX发送PUT请求惨案
	 * 		PUT请求：请求体中的数据，request.getParameter("empName")拿不到；
	 * 		Tomcat一看是PUT请求就不会封装请求体中的数据为map，只有POST形式的请求才封装为map；
	 *	我们要能支持直接发送PUT请求还要封装请求体中数据
	 * 	配置上HttpPutFormContentFilter
	 * 	它的作用，将请求体中数据封账包装成一个map
	 *  request将被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
	 *	这就是解决方法
	 *
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg saveUpdateEmp(Employee employee) {
		System.out.println(employee.toString());
		employeeService.updateEmp(employee);
		return Msg.success();
		
	}
	
	/**
	 * 查询员工信息byid
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id) {
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	/**
	 * 检查用户名是否可用
	 * @param empName
	 * @return
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public Msg checkUser(@RequestParam("empName")String empName) {
		//先判断用户名是否合法
		String regex = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		boolean matches = empName.matches(regex);
		if(!matches) {
			return Msg.fail().add("va_msg", "empName格式不对");			
		}
		boolean flag = employeeService.checkUser(empName);	
		if(flag) {
			return Msg.success();
		}else {
			return Msg.fail().add("va_msg", "empName已存在");
		}
	}
	
	/**
	 * 新增员工保存
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveAddEmp(Employee employee) {
		employeeService.saveEmp(employee);
		return Msg.success();
	}
	
	/**
	 * 导入Jackson包
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用,传入页面以及每页显示的条数
		PageHelper.startPage(pn, 7);
		// startPage紧跟的查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// 封装了详细的分页信息，包括我们查询的数据,传入连续显示的页数
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps, 5);
		return Msg.success().add("pageInfo", pageInfo);

	}

	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用,传入页面以及每页显示的条数
		PageHelper.startPage(pn, 7);
		// startPage紧跟的查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// 封装了详细的分页信息，包括我们查询的数据,传入连续显示的页数
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps, 5);

		model.addAttribute("pageInfo", pageInfo);

		return "list";
	}

}
