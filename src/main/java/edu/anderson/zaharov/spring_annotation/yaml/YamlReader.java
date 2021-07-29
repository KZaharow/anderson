package edu.anderson.zaharov.spring_annotation.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlReader {

    public Map getSettings() {

        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yaml");
        return yaml.load(inputStream);
    }
}
