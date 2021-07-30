package edu.anderson.zaharov;


import edu.anderson.zaharov.dao.CompanyDAO;
import edu.anderson.zaharov.dao.EmployerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateXml {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");

        CompanyDAO companyDAO = (CompanyDAO) context.getBean("companyDAO");
        System.out.println(companyDAO.findAll());

        EmployerDao employerDao = (EmployerDao) context.getBean("employerDAO");
        System.out.println(employerDao.findAll());
    }
}
