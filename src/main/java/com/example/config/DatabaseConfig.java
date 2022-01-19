package com.example.config;
// 설정의 대한 클레스이다.
// SpringExampleApplication에 설정하면 보기 불편하므로 분리해서 설정하는 방법

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@MapperScan(basePackages = "com.example.*")  // mapper scan 추가!!! 순서는 안중요하지만 클래스위에 있으면 된다.
											// xml과 자바의 연결점을 찾는것!!
@Configuration	// 설정 클레스라는 어노테이션이다.!!
public class DatabaseConfig {
	@Bean	// bean은 객체 bean을 가져오는 설정하는법 (찾아보면 나온다.)
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); // 이름을 잘 봐야한다. 오타는 경로가 벗어날 경우 찾지 못한다. 
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }
	
	
	
	
}
