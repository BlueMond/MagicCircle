package me.bluemond.magiccircle;

import java.util.logging.Logger;

import me.bluemond.magiccircle.listeners.EventListener;
import me.bluemond.magiccircle.multiblocks.RuneMultiBlock;
import me.bluemond.magiccircle.multiblocks.SnackRuneMultiBlock;
import me.bluemond.magiccircle.runes.SnackRune;
import me.bluemond.magiccircle.storage.EssenceCache;
import me.bluemond.magiccircle.storage.SpaceCache;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.bluemond.magiccircle.multiblocks.AltarMultiBlock;
import nl.shanelab.multiblock.MultiBlockFactory;

public class MagicCircle extends JavaPlugin{
	
	private Logger logger;
	private static EssenceCache essenceCache;
	private static SpaceCache spaceCache;
	
	@Override
	public void onEnable(){
		
		//retrieve the minecraft logger and description
		logger = this.getLogger();
		PluginDescriptionFile desc = this.getDescription();

		//creates class instances of rune files
		initializeRunes();

		//register caches
		registerCaches();

		//register event listeners
		registerListeners();
		
		//register multiblocks
		registerMultiBlocks();
		
		//log success
		logger.info(desc.getName() + " version(" + desc.getVersion() + ") has been successfully started!");
		
	}

	private void initializeRunes() {
		new SnackRune();
	}

	@Override
	public void onDisable(){
		
	}

	private void registerCaches(){
		essenceCache = new EssenceCache();
		spaceCache = new SpaceCache();
	}
	
	private void registerMultiBlocks(){
		MultiBlockFactory.INSTANCE.register(this, AltarMultiBlock.class);
		MultiBlockFactory.INSTANCE.register(this, SnackRuneMultiBlock.class);
	}
	
	private void registerListeners() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new EventListener(), this);
	}


	public static SpaceCache getSpaceCache(){
		return spaceCache;
	}
	
}
