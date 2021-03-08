package model;

import iface.Displayable;

public class House implements Displayable {
    String owner;
    String address;

    public House(String owner, String address) {
        this.owner = owner;
        this.address = address;
    }

    @Override
    public String getLabel() {
        return owner + ": " + address;
    }
}
