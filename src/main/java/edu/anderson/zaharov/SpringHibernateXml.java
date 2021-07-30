package edu.anderson.zaharov;


import edu.anderson.zaharov.dao.EmployerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateXml {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");



        EmployerDao employerDao = (EmployerDao) context.getBean("employerDAO");
        System.out.println("*****" + employerDao.findAll());
    }
}
