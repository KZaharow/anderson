package edu.anderson.zaharov.yaml;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class YamlReaderTest {

    @Test
    @DisplayName("Test read yaml")
    void getSettings() {

        String key = "user";
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
        log.info("read yaml data: key{} = {}", key, obj.get(key));
        assertEquals("u", obj.get(key));
    }
}