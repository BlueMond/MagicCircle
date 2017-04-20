package me.bluemond.magiccircle.listeners;

import me.bluemond.magiccircle.MagicCircle;
import me.bluemond.magiccircle.storage.SpaceCache;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fusesource.jansi.Ansi;

public class EventListener implements Listener {
	private SpaceCache spaceCache;
	
	
	public EventListener(){
		spaceCache = MagicCircle.getSpaceCache();
	}
	

	/*

	Used to handle when a player attempts to place a rune using the rune writer
	(right click w/ rune writer)

	 */

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		World world = player.getWorld();

		//is block right clicked?
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			ItemStack item = player.getInventory().getItemInMainHand();

			//check for gold pickaxe in hand
			if(item.getType().equals(Material.GOLD_PICKAXE)){

				//check for correct item meta
				ItemMeta itemMeta = item.getItemMeta();
				if(itemMeta.hasLore()){
					if(itemMeta.getLore().get(0).equalsIgnoreCase("rune writer")){

						//check if correct block face
						if(event.getBlockFace().equals(BlockFace.UP)){
							event.setCancelled(true);

							//get the location above the block
							Location loc = event.getClickedBlock().getLocation().add(0, 1, 0);


							/*
							Todo
							Check player's current rune placement toggle through data class
							 */



							//use that location to place a rune space
							world.getBlockAt(loc).setType(Material.CARPET);
							world.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 1);


							spaceCache.setEntry(loc, Color.BLACK);
							/*
							Todo
							Add rune to space cache
								-most likely a hashmap in a class that stores, saves,
								and loads rune spaces
							 */
						}
					}
				}
			}
		}
	}
}
