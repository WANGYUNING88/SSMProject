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
	
	//����Springmvc��IOC
	@Autowired
	WebApplicationContext context;
	//����mvc���󣬻�ȡ��������
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//ģ�������õ�����ֵ
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/emps")
				.param("pn", "5")).andReturn();
		
		//����ɹ����������л���pageInfo������ȡ��pageInfo������֤
		MockHttpServletRequest request = andReturn.getRequest();
		PageInfo<Employee> pageInfo = (PageInfo<Employee>) request.getAttribute("pageInfo");
		System.out.println("��ǰҳ�� : "+pageInfo.getPageNum());
		System.out.println("��ҳ�� : "+pageInfo.getPages());
		System.out.println("�ܼ�¼�� : "+pageInfo.getTotal());
		System.out.print("��ҳ����Ҫ������ʾ��ҳ�� : ");
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		for(int i : navigatepageNums) {
			System.out.print(i+" ");
		}
		System.out.println();
		//��ȡԱ������
		List<Employee> list = pageInfo.getList();
		for(Employee employee : list) {
			System.out.println(employee.toString());
		}
	}
	
}
