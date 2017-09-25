package ojs.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import spittr.db.hibernate4.HibernateSpitterRepository;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"ojs.service"})
public class DataConfig {

/*
  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .build();
  }
  
  @Bean
  public JdbcOperations jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
*/
	
	
	 
	

	/*@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/online_judge_system?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("sahriar");
        dataSource.setPassword("2010332034");
        return dataSource();
	}*/


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");


        //BasicDataSource dataSource=new BasicDataSource();
        //	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //  dataSource.setUrl("jdbc:mysql://localhost:3307/online_judge_system?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

//	        dataSource.setUrl("jdbc:mysql://localhost:3307/ojt?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        //	dataSource.setUrl("jdbc://mysql://localhost:3307/online_judge_system?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ojs");

        dataSource.setUsername("root");
        dataSource.setPassword("2010332034");

        return dataSource;
		
	       /* dataSource.setUsername("root");
	        dataSource.setPassword("2010332034");
	        return dataSource();*/


        //dataSource.setUrl("jdbc:mysql://localhost:3307/online_judge_system?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");


    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource());
        //sfb.setPackagesToScan(new String[] { "spittr.domain" });
        sfb.setPackagesToScan(new String[]{"ojs.domain"});
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.current_session_context_class", "thread");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.format_sql", "true");
        //props.setProperty("hibernate.current_session_context_class","thread");
        props.setProperty("hibernate.show_sql", "true");
        //props.setProperty("hibernate.useSSL", "false");
        sfb.setHibernateProperties(props);
        return sfb;
    }
	
	
	/*
	@Bean
	public HibernateSpitterRepository spitterRepository(SessionFactory sessionFactory)
	{
		HibernateSpitterRepository hb=new HibernateSpitterRepository(sessionFactory);
		return hb;
	}
	*/
    //@Autowired
    //public SessionFactory sessionFactory;

    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        //this.sessionFactory=sessionFactory;
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
	/*
	 @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	*/
}
