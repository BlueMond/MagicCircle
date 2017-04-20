package me.bluemond.magiccircle.storage;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by Cooper on 4/12/2017.
 */
public class EssenceCache extends Cache{

    public EssenceCache(){
        super(Player.class, Integer.class, "EssenceCache");
    }
}
