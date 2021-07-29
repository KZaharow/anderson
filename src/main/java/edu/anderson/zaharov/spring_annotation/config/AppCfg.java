package edu.anderson.zaharov.spring_annotation.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "edu.anderson.zaharov.spring_annotation")
@EnableTransactionManagement
@Slf4j
public class AppCfg {


    @Bean
    public DataSource dataSource() {

        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.
                    setType(EmbeddedDatabaseType.H2).
                    setName("myTest").
                    addScripts("classpath:sql/init.sql").
                    build();
        } catch (Exception e) {
            log.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

    private Properties hibernateProperties() {
        
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.format_sql", true);
        hibernateProp.put("hibernate.use_sql_comments", true);
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("edu.anderson.zaharov.spring_annotation.entity");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException {

        return new HibernateTransactionManager(sessionFactory());
    }
}