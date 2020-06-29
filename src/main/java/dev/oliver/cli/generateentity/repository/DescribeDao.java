package dev.oliver.cli.generateentity.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.oliver.cli.generateentity.model.Entity;
import dev.oliver.cli.generateentity.model.Type;
import dev.oliver.cli.generateentity.shell.ShellHelper;

public class DescribeDao {

    private final Connection connection;
    private ShellHelper shellHelper;
    private String schema;
    private String table;

    public DescribeDao(final Connection connection, final ShellHelper shellHelper) {
        this.connection = connection;
        this.shellHelper = shellHelper;
    }

    public List<Entity> executeQuery() throws SQLException {
        shellHelper.printInfo("Executando query...");
        final List<Entity> entityList = new ArrayList<>();
        PreparedStatement prepareStatement;
        final String sql = "select * from " + schema + "." + table;

        prepareStatement = connection.prepareStatement(sql);

        final ResultSet resultSet = prepareStatement.executeQuery();
        final ResultSetMetaData metaData = resultSet.getMetaData();

        int column;
        for (column = 1; column <= metaData.getColumnCount(); column++) {
            entityList
                    .add(new Entity(metaData.getColumnName(column), Type.valueOf(metaData.getColumnTypeName(column))));
        }

        connection.close();
        shellHelper.printInfo("Query executada...");
        return entityList;
    }

    public DescribeDao setSchema(final String schema) {
        this.schema = schema;
        return this;
    }

    public DescribeDao setTable(final String table) {
        this.table = table;
        return this;
    }

}