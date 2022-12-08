package global.scit.LibraryProject.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	//원래는 public static, static은 한번생성하면 더이상 생성못함
	//static은 sqlSessionFactory를 딱 한번만 만든다(=딱 한번만 DB와 연결한다는 의미)
	
	//static블럭 ==> 생성자와 유사, static멤버를 초기화 하는 용도로 사용
	
	static {
		//mybatis-config.xml을 읽어와서 Oracle과 연결하는sqlSessionFactory를 초기화하는 작업
		String resource = "mybatis-config.xml";
		
		try { //오류날 확률이 높으니 try-catch문 사용
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}

}
