package edu.anderson.zaharov.sql;

import edu.anderson.zaharov.connector.PoolConnector;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
class TestInitSql {

    @Test
    void initScript() {

        PoolConnector instance = PoolConnector.getInstance();
        try (Connection con = instance.getConnection()) {
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = null;
            try {
                reader = new BufferedReader(new FileReader("D:\\java\\anderson\\src\\test\\resources\\sql\\testInit.sql"));
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
            }
            sr.runScript(reader);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
