package org.learntotravel.web_ui.direction;

public enum SourceType {
    AZAIR(1, "Azzair");

    private final int type;
    private final String name;

    SourceType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
