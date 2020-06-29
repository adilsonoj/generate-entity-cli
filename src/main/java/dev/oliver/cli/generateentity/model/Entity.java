package dev.oliver.cli.generateentity.model;

public class Entity {

    private String name;
    private Type type;

    public static void main(String[] args) {
        System.out.println(Type.VARCHAR2.label);
        System.out.println(Type.valueOf("NUMBER").label);
    }

    public String getNameAttribute() {
        String nome[] = this.name.toLowerCase().split("_");
        String resp = "";
        for (int i = 0; i < nome.length; i++) {
            resp = resp + nome[i].toLowerCase().substring(0, 1).toUpperCase() + nome[i].substring(1);
        }
        return resp.substring(0, 1).toLowerCase() + resp.substring(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type.label;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Entity [name=" + name + ", type=" + getType() + "]";
    }

    public String getter() {
        return "get" + this.getNameAttribute().substring(0, 1).toUpperCase() + this.getNameAttribute().substring(1);
    }

    public String setter() {
        return "set" + this.getNameAttribute().substring(0, 1).toUpperCase() + this.getNameAttribute().substring(1);
    }

}
