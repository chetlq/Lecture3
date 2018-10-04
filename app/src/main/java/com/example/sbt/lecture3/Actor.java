package com.example.sbt.lecture3;

public class Actor {
    private final String name;
    private final String avatar;
    private final boolean hasOscar;

    public Actor(String name, String avatar, boolean hasOscar) {
        this.name = name;
        this.avatar = avatar;
        this.hasOscar = hasOscar;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isHasOscar() {
        return hasOscar;
    }
}
