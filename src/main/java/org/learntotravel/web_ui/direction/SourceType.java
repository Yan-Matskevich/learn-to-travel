package org.learntotravel.web_ui.direction;

public enum SourceType {
    AZAIR("Azzair");

    private final String name;

    SourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
