package model;

import iface.Displayable;

public class User implements Displayable {
    String name;
    String bio;

    public User(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    @Override
    public String getLabel() {
        return name;
    }
}
