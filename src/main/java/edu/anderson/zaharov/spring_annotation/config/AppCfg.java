package edu.anderson.zaharov.spring_annotation.config;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = {"***"})
@EnableJpaRepositories(basePackages = {"***"})
public class AppCfg implements WebMvcConfigurer {

    @Bean
    public DataSource dataSource() {

        try {
            System.out.println("dataSource bean");
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:sql/schema.sql", "classpath:sql/test-data.sql").build();
        } catch (Exception e) {
            System.out.println("dataSource bean error" + e.getMessage());
            return null;
        }
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        try {
            System.out.println("transactionManager");
            return new JpaTransactionManager(entityManagerFactory());
        } catch (Exception e){
            System.out.println(e.getMessage() + " " + "transactionManager");
            return null;
        }
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        try {
            System.out.println("jpaVendorAdapter");
            return new HibernateJpaVendorAdapter();
        } catch (Exception e){
            System.out.println(e.getMessage() + " " + "jpaVendorAdapter");
            return null;
        }
    }

    @Bean
    public Properties hibernateProperties() {

        try {
            System.out.println("hibernateProperties");
            Properties hibernateProp = new Properties();
            hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            hibernateProp.put("hibernate.format_sql", true);
            hibernateProp.put("hibernate.use_sql_comments", true);
            //hibernateProp.put("hibernate.show_sql", true);
            hibernateProp.put("hibernate.max_fetch_depth", 3);
            hibernateProp.put("hibernate.jdbc.batch_size", 10);
            hibernateProp.put("hibernate.jdbc.fetch_size", 50);
            return hibernateProp;
        } catch (Exception e){
            System.out.println(e.getMessage() + " " + "hibernateProperties");
            return null;
        }
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        try {
            System.out.println("entityManagerFactory");
            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setPackagesToScan("by.kit.test");
            factoryBean.setDataSource(dataSource());
            factoryBean.setJpaProperties(hibernateProperties());
            factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
            factoryBean.afterPropertiesSet();
            return factoryBean.getNativeEntityManagerFactory();
        } catch (Exception e){
            System.out.println(e.getMessage() + " " + "entityManagerFactory");
            return null;
        }
    }
}
