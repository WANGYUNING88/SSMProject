package com.wang.ssmtest.test;

import java.util.List;
import java.util.UUID;

import com.wang.ssmtest.bean.Comment;
import com.wang.ssmtest.bean.User;
import com.wang.ssmtest.dao.CommentMapper;
import com.wang.ssmtest.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wang.ssmtest.bean.Employee;
import com.wang.ssmtest.dao.DepartmentMapper;
import com.wang.ssmtest.dao.EmployeeMapper;;

/*
 * 推荐：spring的项目就可以使用spring的单元测试，可以自动注入我们需要的组件 
 * 1.导入SpringTest工具包
 * 2.@ContextConfiguration指定Spring配置文件的位置
 * 3.直接autowired要使用的组件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	/**
	 * 测试departmentMapper
	 */
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	SqlSession sqlSession;

	@Autowired
	CommentMapper commentMapper;
	
	@Test
	public void testCRUD() {


		
/*		List<Employee> selectByExampleWithDept = employeeMapper.selectByExampleWithDept(null);
		Employee employee = selectByExampleWithDept.get(0);
		System.out.println(employee.getDepartment().getDeptName());*/
		
//		//方法一：
//		//1.创建IOC容器
//		ApplicationContext ioContext 
//			= new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.从容器中获取mapper
//		DepartmentMapper bean = ioContext.getBean(DepartmentMapper.class);
		
		//方法二：spring的单元测试,使用autowired注解
		//System.out.println(departmentMapper);
		
		//1.插入几个部门
		
//		departmentMapper.insertSelective(new Department(null,"客服部"));
//		departmentMapper.insertSelective(new Department(null,"运维部"));
		
		//2.测试插入员工
//		employeeMapper.insert(new Employee(null, "Jerry", "M", "Jerry@wang.com", 1));
		
		//3.批量插入员工,使用可以批量的操作的sqlSession
		/*for() {
			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@wang.com", 1));
		}*/
		
		
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0 ; i < 1000 ; i++) {
//			String uid = UUID.randomUUID().toString().substring(0, 5);
//			mapper.insertSelective(new Employee(null, uid, "M", uid+"@wang.com", 1));
//		}
//		System.out.println("批量完成");

		//4.修改员工
//		int q = employeeMapper.updateByPrimaryKeySelective(new Employee(1, "admin", null, "admin@wang.com", null));
//		int w = employeeMapper.updateByPrimaryKeySelective(new Employee(2, null, "W", null, 2));
//		System.out.println("q="+q+" , "+"w="+w);
		
		//5.删除员工
//		int result = employeeMapper.deleteByPrimaryKey(1006);
//		System.out.println("result = "+result);

		/*User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);*/
		//int i = userMapper.insert(new User(null, "wangyuning", "123", null));
//		User admin = userMapper.selectByExample(new User(null, "admin", null, null));
////		User wanguning = userMapper.selectByExample(new User(null, "wanguning", "123", null));
////
////		System.out.println(admin);
////		System.out.println(wanguning);
		Comment comment = new Comment();
		comment.setArticleId(1);
		List<Comment> comments = commentMapper.selectByExample(comment);
		System.out.println("参数只有setArticleId");
		for (Comment comment1 : comments){
			System.out.println(comment1);
		}

		System.out.println("参数有setArticleId和setCommentId");
		comment.setCommentId(7);
		comments = commentMapper.selectByExample(comment);
		for (Comment comment1 : comments){
			System.out.println(comment1);
		}
	}
}
