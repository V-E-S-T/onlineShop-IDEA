package md.kniga.backendOnlineShop.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "md.kniga.backendOnlineShop.dto")
@EnableTransactionManagement
public class HibernateConfig {

    private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshop";
    private final static String DATABASE_DRIVER = "org.h2.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private final static String DATABASE_USER = "h2";
    private final static String DATABASE_PASSWORD = "";

    //datasource bean
    @Bean
    public DataSource getDataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();

        //Providing database connection information
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USER);
        dataSource.setPassword(DATABASE_PASSWORD);



        return dataSource;

    }

    //sessionFactory bean
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource)
    {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(getHibernateProperties());
        builder.scanPackages("md.kniga.backendOnlineShop.dto");

        return builder.buildSessionFactory();
    }

    //All the hibernate properties will be return on this method
    private Properties getHibernateProperties() {

        Properties properties = new Properties();
        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);


        return properties;
    }

    //transactionManager bean
    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }

}