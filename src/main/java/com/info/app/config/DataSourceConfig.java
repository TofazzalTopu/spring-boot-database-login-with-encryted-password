package com.info.app.config;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;
    @Bean
    public DataSource getDataSource() {
        Map<String, String> map = getPass();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
        dataSourceBuilder.url(map.get("host"));
        dataSourceBuilder.username(map.get("userName"));
        dataSourceBuilder.password(map.get("decryptedPassword"));
        return dataSourceBuilder.build();
    }

    public Map<String, String> getPass() {
        String mpCryptoPassword = "MY_SECRET";
        Map<String, String> map = new HashMap<>();
        String url = env.getProperty("spring.datasource.url");
        String encryptedUserName = env.getProperty("spring.datasource.username");
        String encryptedPassword = env.getProperty("spring.datasource.password");

        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(mpCryptoPassword);
        String decryptedUsername = decryptor.decrypt(encryptedUserName);
        String decryptedPassword = decryptor.decrypt(encryptedPassword);
        System.out.println(decryptor.decrypt(encryptedPassword));

        map.put("host", url);
        map.put("userName", decryptedUsername);
        map.put("decryptedPassword", decryptedPassword);
        return map;
    }
}
