package net.sai.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "net.sai.backend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	// change the below DB Details based on the DBMS you have chosen
	private final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/sai-shop";
	private final String DATABASE_DRIVER_CLASSNAME = "org.h2.Driver";
	private final String DATABASE_USER = "sa";
	private final String DATABASE_PASSWORD = "";
	private final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	
	@Bean
	private DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER_CLASSNAME);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.sai.backend.dto");
		return builder.buildSessionFactory();
	}

	// All the hibernate properties will be written here
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.setProperty("hibernate_dialect", DATABASE_DIALECT);
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql","true");
		return properties;
	}
	
	
	//transactionManager
	@Bean
	public HibernateTransactionManager geHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
}
