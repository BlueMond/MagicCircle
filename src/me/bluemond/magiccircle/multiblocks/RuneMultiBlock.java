package me.bluemond.magiccircle.multiblocks;

import me.bluemond.magiccircle.MagicCircle;
import me.bluemond.magiccircle.storage.SpaceCache;
import nl.shanelab.multiblock.*;
import nl.shanelab.multiblock.patternobjects.PatternBlock;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class RuneMultiBlock implements IMultiBlock{

	MultiBlockPattern multiBlockPattern;


	@Override
	public MultiBlockPattern getMultiBlockPattern() {
		SpecificMaterial carp = SpecificMaterial.CARPET_WHITE;

		multiBlockPattern = new MultiBlockPattern(
				carp,
				new PatternBlock(carp, -1, 0, -1),
				new PatternBlock(carp, -1, 0, 0),
				new PatternBlock(carp, -1, 0, 1),
				new PatternBlock(carp, 0, 0, 1),
				new PatternBlock(carp, 1, 0, 1),
				new PatternBlock(carp, 1, 0, 0),
				new PatternBlock(carp, 1, 0, -1),
				new PatternBlock(carp, 0, 0, -1)
		);
		
		return multiBlockPattern;
	}

	@Override
	public void onActivate(Plugin plugin, Location loc, Player player, MultiBlockActivation activation) {
		//get SpaceCache from plugin
		SpaceCache spaceCache = MagicCircle.getSpaceCache();

		//if the core of the rune was right clicked
		System.out.println("RUNE ACTIVATED!");
		if(activation.getType() == MultiBlockActivationType.CORE_INTERACTED && spaceCache.verify(loc, multiBlockPattern)){
			
			player.sendRawMessage("You a lil bitch.");
		}
	}


}
