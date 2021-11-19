package com.gaokao.main;

import com.gaokao.main.Mapper.UserMapper;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester();
	}

	@Test
	public void testRenderMyPage()
	{
		String config = "/spring/applicationContext.xml";

		ApplicationContext acContext = new ClassPathXmlApplicationContext(config);

		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) acContext.getBean("sqlSessionFactory");

		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//		System.out.println(userMapper.getUserByUserAccount("772557832@qq.com"));
	}

	@Test
	public void SetTest() {
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		System.out.println(set);
	}

}
