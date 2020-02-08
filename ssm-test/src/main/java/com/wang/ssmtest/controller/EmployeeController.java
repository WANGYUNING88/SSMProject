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
	 * 1��/emp/{id} GET ��ѯԱ��
	 * 2��/emp     POST ����Ա��
	 * 2��/emp/{id} PUT �޸�Ա��
	 * 2��/emp/{id} DELETE ɾ��Ա��
	 */
	/**
	 * Ա��ɾ��
	 * id��ʽΪ1-2-3
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmpByIds(@PathVariable("ids")String ids) {
		if(ids.contains("-")) {
			String[] split = ids.split("-");
			//��װid����
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
	 * Ա����Ϣ����
	 * 
	 * ���ajax����type=PUT����
	 * ��װ�����ݾͻ�������⣺�������������ݣ�����Employee������˲���
	 * 
	 * ԭ�� Tomcat���������е����ݷ�װ��һ��map
	 * 		request.getParameter("empName")�ͻ�����mao��ȡֵ
	 * 		SpringMVC��װPOJO�����ʱ����POJO��ÿ�����Ե�ֵ,request.getParameter("email0");
	 * AJAX����PUT����Ұ�
	 * 		PUT�����������е����ݣ�request.getParameter("empName")�ò�����
	 * 		Tomcatһ����PUT����Ͳ����װ�������е�����Ϊmap��ֻ��POST��ʽ������ŷ�װΪmap��
	 *	����Ҫ��֧��ֱ�ӷ���PUT����Ҫ��װ������������
	 * 	������HttpPutFormContentFilter
	 * 	�������ã��������������ݷ��˰�װ��һ��map
	 *  request�������°�װ��request.getParameter()����д���ͻ���Լ���װ��map��ȡ����
	 *	����ǽ������
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
	 * ��ѯԱ����Ϣbyid
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
	 * ����û����Ƿ����
	 * @param empName
	 * @return
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public Msg checkUser(@RequestParam("empName")String empName) {
		//���ж��û����Ƿ�Ϸ�
		String regex = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		boolean matches = empName.matches(regex);
		if(!matches) {
			return Msg.fail().add("va_msg", "empName��ʽ����");			
		}
		boolean flag = employeeService.checkUser(empName);	
		if(flag) {
			return Msg.success();
		}else {
			return Msg.fail().add("va_msg", "empName�Ѵ���");
		}
	}
	
	/**
	 * ����Ա������
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveAddEmp(Employee employee) {
		employeeService.saveEmp(employee);
		return Msg.success();
	}
	
	/**
	 * ����Jackson��
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// �ⲻ�Ƿ�ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ���Լ�ÿҳ��ʾ������
		PageHelper.startPage(pn, 7);
		// startPage�����Ĳ�ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ�������
		// ��װ����ϸ�ķ�ҳ��Ϣ���������ǲ�ѯ������,����������ʾ��ҳ��
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps, 5);
		return Msg.success().add("pageInfo", pageInfo);

	}

	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// �ⲻ�Ƿ�ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ���Լ�ÿҳ��ʾ������
		PageHelper.startPage(pn, 7);
		// startPage�����Ĳ�ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ�������
		// ��װ����ϸ�ķ�ҳ��Ϣ���������ǲ�ѯ������,����������ʾ��ҳ��
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps, 5);

		model.addAttribute("pageInfo", pageInfo);

		return "list";
	}

}
