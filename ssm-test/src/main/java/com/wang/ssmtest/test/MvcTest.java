package com.wang.ssmtest.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.wang.ssmtest.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class MvcTest {
	
	//传入Springmvc的IOC
	@Autowired
	WebApplicationContext context;
	//虚拟mvc请求，获取到处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//模拟请求拿到返回值
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/emps")
				.param("pn", "5")).andReturn();
		
		//请求成功后，请求域中会有pageInfo，我们取出pageInfo尽心验证
		MockHttpServletRequest request = andReturn.getRequest();
		PageInfo<Employee> pageInfo = (PageInfo<Employee>) request.getAttribute("pageInfo");
		System.out.println("当前页码 : "+pageInfo.getPageNum());
		System.out.println("总页码 : "+pageInfo.getPages());
		System.out.println("总记录数 : "+pageInfo.getTotal());
		System.out.print("在页面需要连续显示的页码 : ");
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		for(int i : navigatepageNums) {
			System.out.print(i+" ");
		}
		System.out.println();
		//获取员工数据
		List<Employee> list = pageInfo.getList();
		for(Employee employee : list) {
			System.out.println(employee.toString());
		}
	}
	
}
