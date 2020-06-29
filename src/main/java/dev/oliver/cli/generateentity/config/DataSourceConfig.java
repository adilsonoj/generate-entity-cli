package dev.oliver.cli.generateentity.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

public class DataSourceConfig {

    public static DataSource getDataSource(String username, String password, String server, String nameSpace) {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@" + server + ":1521:" + nameSpace + "");
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}