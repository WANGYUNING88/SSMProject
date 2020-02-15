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
 * �Ƽ���spring����Ŀ�Ϳ���ʹ��spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ����� 
 * 1.����SpringTest���߰�
 * 2.@ContextConfigurationָ��Spring�����ļ���λ��
 * 3.ֱ��autowiredҪʹ�õ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	/**
	 * ����departmentMapper
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
		
//		//����һ��
//		//1.����IOC����
//		ApplicationContext ioContext 
//			= new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.�������л�ȡmapper
//		DepartmentMapper bean = ioContext.getBean(DepartmentMapper.class);
		
		//��������spring�ĵ�Ԫ����,ʹ��autowiredע��
		//System.out.println(departmentMapper);
		
		//1.���뼸������
		
//		departmentMapper.insertSelective(new Department(null,"�ͷ���"));
//		departmentMapper.insertSelective(new Department(null,"��ά��"));
		
		//2.���Բ���Ա��
//		employeeMapper.insert(new Employee(null, "Jerry", "M", "Jerry@wang.com", 1));
		
		//3.��������Ա��,ʹ�ÿ��������Ĳ�����sqlSession
		/*for() {
			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@wang.com", 1));
		}*/
		
		
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0 ; i < 1000 ; i++) {
//			String uid = UUID.randomUUID().toString().substring(0, 5);
//			mapper.insertSelective(new Employee(null, uid, "M", uid+"@wang.com", 1));
//		}
//		System.out.println("�������");

		//4.�޸�Ա��
//		int q = employeeMapper.updateByPrimaryKeySelective(new Employee(1, "admin", null, "admin@wang.com", null));
//		int w = employeeMapper.updateByPrimaryKeySelective(new Employee(2, null, "W", null, 2));
//		System.out.println("q="+q+" , "+"w="+w);
		
		//5.ɾ��Ա��
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
		System.out.println("����ֻ��setArticleId");
		for (Comment comment1 : comments){
			System.out.println(comment1);
		}

		System.out.println("������setArticleId��setCommentId");
		comment.setCommentId(7);
		comments = commentMapper.selectByExample(comment);
		for (Comment comment1 : comments){
			System.out.println(comment1);
		}
	}
}
