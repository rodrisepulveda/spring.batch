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
@MapperScan(basePackages = "cl.eficaciait.demobatch.mapper.db2", sqlSessionFactoryRef = "sqlSessionFactoryDb2")
public class MyBatisDb2Config {

	@Value("${base-datos.prueba2.url}")
	private String url;

	@Value("${base-datos.prueba2.username}")
	private String username;

	@Value("${base-datos.prueba2.password}")
	private String password;

	@Bean
	public DataSource dataSourceDb2() {

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(org.postgresql.Driver.class);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);

		return dataSource;

	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryDb2() throws Exception {

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

		sessionFactory.setDataSource(dataSourceDb2());

		sessionFactory.setTypeAliasesPackage("db2");

		return sessionFactory;

	}

	@Bean(name = "db2_tm")
	public DataSourceTransactionManager transactionManagerDb2() {

		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();

		dataSourceTransactionManager.setDataSource(dataSourceDb2());

		return dataSourceTransactionManager;

	}

}
