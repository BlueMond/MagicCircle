package me.bluemond.magiccircle.runes;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by Cooper on 4/22/2017.
 */
public abstract class Rune {
    public static Rune instance;

    public abstract void onRightClickCore(Location loc, Player player);

    public Rune(){

        if(instance == null){
            instance = this;
        }

    }

    public static Rune getInstance(){
        return instance;
    }
}
