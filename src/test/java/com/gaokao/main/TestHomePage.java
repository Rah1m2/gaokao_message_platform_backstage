package com.gaokao.main;

import com.gaokao.main.Mapper.UserMapper;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.wicket.util.tester.WicketTester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase
{
	private WicketTester tester;

	public void setUp()
	{
		tester = new WicketTester();
	}

	public void testRenderMyPage()
	{
		String config = "/spring/applicationContext.xml";

		ApplicationContext acContext = new ClassPathXmlApplicationContext(config);

		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) acContext.getBean("sqlSessionFactory");

		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//		System.out.println(userMapper.getUserByUserAccount("772557832@qq.com"));
	}
}
