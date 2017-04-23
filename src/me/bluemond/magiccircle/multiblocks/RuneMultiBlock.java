package me.bluemond.magiccircle.multiblocks;

import me.bluemond.magiccircle.MagicCircle;
import me.bluemond.magiccircle.runes.Rune;
import me.bluemond.magiccircle.storage.SpaceCache;
import nl.shanelab.multiblock.*;
import nl.shanelab.multiblock.patternobjects.PatternBlock;
import org.apache.commons.lang.ObjectUtils;
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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class RuneMultiBlock implements IMultiBlock{

	static Class<? extends Rune> runeClass;
	static MultiBlockPattern multiBlockPattern;


	public static void setRuneClass(Class<? extends Rune> classType){
		runeClass = classType;
	}

	public static void setMultiBlockPattern(MultiBlockPattern mbp){
		multiBlockPattern = mbp;
	}

	@Override
	public MultiBlockPattern getMultiBlockPattern(){
		return multiBlockPattern;
	}

	@Override
	public void onActivate(Plugin plugin, Location loc, Player player, MultiBlockActivation activation) {
		//get SpaceCache from plugin
		SpaceCache spaceCache = MagicCircle.getSpaceCache();

		//if the core of the rune was right clicked
		System.out.println("RUNE ACTIVATED!");
		if(activation.getType() == MultiBlockActivationType.CORE_INTERACTED && spaceCache.verify(loc, multiBlockPattern)){
			try {
				Rune rune = runeClass.newInstance().getInstance();
				rune.onRightClickCore(loc, player);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
	}


}
