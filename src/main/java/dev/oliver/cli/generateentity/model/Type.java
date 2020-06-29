package dev.oliver.cli.generateentity.model;

public enum Type {
    VARCHAR2("String"), NUMBER("Integer"), CHAR("char"), DATE("Date");

    public final String label;

    Type(String label) {
        this.label = label;
    }
}
