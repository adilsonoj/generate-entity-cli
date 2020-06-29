package dev.oliver.cli.generateentity.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dev.oliver.cli.generateentity.model.Entity;
import dev.oliver.cli.generateentity.shell.ShellHelper;

public class CreateClass {

    private List<Entity> entityList;
    private String classname;
    private String table;
    private String pack;
    private ShellHelper shellHelper;

    public CreateClass(ShellHelper shellHelper) {
        this.shellHelper = shellHelper;
    }

    public void create() {
        shellHelper.printInfo("Gerando classe " + classname + ".java ...");

        String dir = System.getProperty("user.dir");
        String file = dir.concat("/").concat(classname).concat(".java");

        FileWriter arq;
        try {
            arq = new FileWriter(file);
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.println("package " + pack + ";"); // package
            gravarArq.println();

            gravarArq.println("@Entity");
            gravarArq.println("@Table(name = \"" + table + "\") ");
            gravarArq.println("public class " + classname.trim() + " {");
            gravarArq.println();
            entityList.stream().forEach(entity -> {
                gravarArq.println("   @Column(name=\"" + entity.getName() + "\"" + ");");
                gravarArq.println("   private " + entity.getType() + " " + entity.getNameAttribute() + ";");
                gravarArq.println();
            });

            entityList.stream().forEach(entity -> {
                // getter
                gravarArq.println("   public " + entity.getType() + " " + entity.getter() + "(){");
                gravarArq.println("      return " + entity.getNameAttribute());
                gravarArq.println("   }");
                gravarArq.println();

                // setter
                gravarArq.println("   public " + entity.getType() + " " + entity.setter() + "(" + entity.getType() + " "
                        + entity.getNameAttribute() + "){");
                gravarArq.println("      this." + entity.getNameAttribute() + " = " + entity.getNameAttribute() + ";");
                gravarArq.println("   }");
                gravarArq.println();

            });

            gravarArq.println("}");
            arq.close();
        } catch (IOException e) {
            shellHelper.printError("Erro ao criar o arquivo...");
            shellHelper.printError("Arquivo não foi criado...");
            return;
        }

        shellHelper.printInfo("Classe " + classname + ".java criada!!! :)");
    }

    public CreateClass setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
        return this;
    }

    public CreateClass setClassname(String classname) {
        this.classname = classname;
        return this;
    }

    public CreateClass setTable(String table) {
        this.table = table;
        return this;
    }

    public CreateClass setPack(String pack) {
        this.pack = pack;
        return this;
    }

}