package edu.anderson.zaharov.connector;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import edu.anderson.zaharov.exception.NoSuchYamlFileException;
import edu.anderson.zaharov.exception.PoolConnectorInitException;
import edu.anderson.zaharov.exception.ResourceBundleException;
import edu.anderson.zaharov.yaml.YamlReader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

@Slf4j
public class PoolConnector {

    private static PoolConnector instance;

    private static final String DRIVER = "driver";

    private final static String USER = "user";

    private final static String PASS = "password";

    private final static String URL = "url";

    private String user, pass, url, driver;

    private final ComboPooledDataSource dataSource = new ComboPooledDataSource();

    private PoolConnector() {

        initPoolConnector();
    }

    public static PoolConnector getInstance() {

        if (instance == null) {
            instance = new PoolConnector();
        }
        return instance;
    }

    private void initPoolConnector() {

        try {
            initProperties();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(pass);

            Properties properties = new Properties();
            properties.setProperty("useUnicode", "true");
            properties.setProperty("characterEncoding", "UTF8");

            dataSource.setMaxStatements(180);
            dataSource.setMaxStatementsPerConnection(180);
            dataSource.setMinPoolSize(50);
            dataSource.setAcquireIncrement(10);
            dataSource.setMaxPoolSize(60);
            dataSource.setMaxIdleTime(30);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new PoolConnectorInitException("Can't create pool connector");
        }
    }

    private void initProperties() {
        try {
            YamlReader yr = new YamlReader();
            Map<String, String> yamlProperties = yr.getSettings();
            user = yamlProperties.get(USER);
            pass = yamlProperties.get(PASS);
            url = yamlProperties.get(URL);
            driver = yamlProperties.get(DRIVER);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new NoSuchYamlFileException("Error yaml file reading");
        }
    }

    /**
     * Returns Connection
     */
    public synchronized Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Problem with getting connection from pool!");
        }
    }
}
