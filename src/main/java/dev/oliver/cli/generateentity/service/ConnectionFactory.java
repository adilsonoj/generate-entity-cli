package dev.oliver.cli.generateentity.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import dev.oliver.cli.generateentity.config.DataSourceConfig;
import dev.oliver.cli.generateentity.shell.ShellHelper;

public class ConnectionFactory {

    private String username;
    private String password;
    private String server;
    private String sid;
    private ShellHelper shellHelper;

    public ConnectionFactory(ShellHelper shellHelper) {
        this.shellHelper = shellHelper;

    }

    public Connection getConnection() {
        DataSource dataSource = DataSourceConfig.getDataSource(username, password, server, sid);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            shellHelper.getErrorMessage("Não foi possével conectar com o banco de dados...");
        }
        shellHelper.printInfo("Conectado ao Banco: " + server + ":" + sid);
        return connection;
    }

    public ConnectionFactory setUsername(String username) {
        this.username = username;
        return this;
    }

    public ConnectionFactory setPassword(String password) {
        this.password = password;
        return this;
    }

    public ConnectionFactory setServer(String server) {
        this.server = server;
        return this;
    }

    public ConnectionFactory setSid(String sid) {
        this.sid = sid;
        return this;
    }

}