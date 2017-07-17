package me.devanonymous.Server.API;

import org.bukkit.Location;

public final class DevWorld {
    public static Location centerLocation(Location location1, Location location2) {
        if (location1.getWorld() != location2.getWorld()) return null;
        return new Location(location1.getWorld(), ((location1.getX() + location2.getX()) / 2), ((location1.getY() + location2.getY()) / 2), ((location1.getZ() + location2.getZ()) / 2));
    }
}
