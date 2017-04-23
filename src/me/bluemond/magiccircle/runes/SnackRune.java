package me.bluemond.magiccircle.runes;

import nl.shanelab.multiblock.MultiBlockPattern;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by Cooper on 4/22/2017.
 */
public class SnackRune extends Rune {

    private int count = 0;

    @Override
    public void onRightClickCore(Location loc, Player player) {
        count++;
        player.sendRawMessage(ChatColor.BOLD + "" + ChatColor.BLUE + "The count is now: " + count);
    }


}
