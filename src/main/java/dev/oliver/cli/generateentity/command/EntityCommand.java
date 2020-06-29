package dev.oliver.cli.generateentity.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import dev.oliver.cli.generateentity.model.Entity;
import dev.oliver.cli.generateentity.repository.DescribeDao;
import dev.oliver.cli.generateentity.service.ConnectionFactory;
import dev.oliver.cli.generateentity.service.CreateClass;
import dev.oliver.cli.generateentity.shell.ShellHelper;

@ShellComponent
public class EntityCommand {

    @Autowired
    ShellHelper shellHelper;

    @ShellMethod("Create new entity from oracle table \n      ex: (create --schema amdba --username admin --password adminsystem --sid xe -table MEVU_CTRT -server localhost --classname Contrato)")
    public void create(@ShellOption({ "-S", "--schema" }) String schema,
            @ShellOption({ "-U", "--username" }) String username, @ShellOption({ "-P", "--password" }) String password,
            @ShellOption({ "-T", "--table" }) String table, @ShellOption({ "-SE", "--server" }) String server,
            @ShellOption({ "-SI", "--sid" }) String sid, @ShellOption({ "-CN", "--classname" }) String classname,
            @ShellOption(defaultValue = "br.mil.mar.amrj.modelo") String pack) {
        String message = "criando class para" + " servidor: " + server + " schema: " + schema + " table: " + table;

        shellHelper.print(message);
        shellHelper.print(" user: " + username + " password: " + password);

        try {
            Connection connection = new ConnectionFactory(shellHelper).setSid(sid).setServer(server)
                    .setUsername(username).setPassword(password).getConnection();

            List<Entity> entityList = new DescribeDao(connection, shellHelper).setSchema(schema).setTable(table)
                    .executeQuery();

            new CreateClass(shellHelper).setEntityList(entityList).setClassname(classname).setPack(pack).setTable(table)
                    .create();

        } catch (SQLException e) {
            shellHelper.printError(e.getMessage());
        }

    }

}