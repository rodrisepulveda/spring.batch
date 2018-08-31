package cl.eficaciait.demobatch.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "cl.eficaciait.demobatch.mapper.db1", sqlSessionFactoryRef = "sqlSessionFactoryDb1")
public class MyBatisDb1Config {

	@Value("${base-datos.prueba1.url}")
	private String url;

	@Value("${base-datos.prueba1.username}")
	private String username;

	@Value("${base-datos.prueba1.password}")
	private String password;

	@Bean
	public DataSource dataSourceDb1() {

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(org.postgresql.Driver.class);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);

		return dataSource;

	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryDb1() throws Exception {

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

		sessionFactory.setDataSource(dataSourceDb1());

		sessionFactory.setTypeAliasesPackage("db1");

		return sessionFactory;

	}

	@Bean(name = "db1_tm")
	public DataSourceTransactionManager transactionManagerDb1() {

		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();

		dataSourceTransactionManager.setDataSource(dataSourceDb1());

		return dataSourceTransactionManager;

	}

}
