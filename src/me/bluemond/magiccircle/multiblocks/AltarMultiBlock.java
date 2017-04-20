package me.bluemond.magiccircle.multiblocks;

import java.util.ArrayList;

import nl.shanelab.multiblock.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import nl.shanelab.multiblock.patternobjects.PatternBlock;
import org.bukkit.util.Vector;

public class AltarMultiBlock implements IMultiBlock{

	MultiBlockPattern multiBlockPattern;


	@Override
	public MultiBlockPattern getMultiBlockPattern() {
		SpecificMaterial slab = SpecificMaterial.SLAB_STONE;

		multiBlockPattern = new MultiBlockPattern(
				Material.DIAMOND_BLOCK,
				new PatternBlock(slab, -1, 0, -1),
				new PatternBlock(slab, -1, 0, 0),
				new PatternBlock(slab, -1, 0, 1),
				new PatternBlock(slab, 0, 0, 1),
				new PatternBlock(slab, 1, 0, 1),
				new PatternBlock(slab, 1, 0, 0),
				new PatternBlock(slab, 1, 0, -1),
				new PatternBlock(slab, 0, 0, -1)
		);
		
		return multiBlockPattern;
	}

	@Override
	public void onActivate(Plugin plugin, Location loc, Player player, MultiBlockActivation activation) {
		//if the core of the altar was right clicked

		System.out.println("ALTAR ACTIVATED!");
		if(activation.getType() == MultiBlockActivationType.CORE_INTERACTED){
			
			//check the player's hand for gold pickaxe
			ItemStack item = player.getInventory().getItemInMainHand();
			ItemMeta goldPick = new ItemStack(Material.GOLD_PICKAXE).getItemMeta();

			if(item.getType() == Material.GOLD_PICKAXE && item.getItemMeta().equals(goldPick)){
				
				//do some cool shit
				activateAltar(loc, item);
			}
		}
	}

	private void activateAltar(Location loc, ItemStack item) {

		//create item meta data
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName("Rune Writer");

		ArrayList<String> text = new ArrayList<String>();
		text.add("Rune Writer");
		text.add("Harnesses rune essence to draw rune glyphs");
		itemMeta.setLore(text);


		//remove and modify the pickaxe
		ItemStack tool = item.clone();
		item.setAmount(0);
		tool.setItemMeta(itemMeta);

		World world = loc.getWorld();


		//drop the pickaxe and add some effects
		Location dropLoc = loc.add(.5, 1.5, .5);
		Entity itemEntity = loc.getWorld().dropItem(dropLoc, tool);
		itemEntity.setGravity(false);
		itemEntity.setVelocity(new Vector(0, 0, 0));
		itemEntity.setGlowing(true);
		itemEntity.setCustomName("RUNE WRITER");
		itemEntity.setCustomNameVisible(true);

		loc.getWorld().strikeLightningEffect(dropLoc);
	}

}
