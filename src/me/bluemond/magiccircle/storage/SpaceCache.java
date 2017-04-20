package me.bluemond.magiccircle.storage;

import nl.shanelab.multiblock.MultiBlockPattern;
import nl.shanelab.multiblock.PatternObject;
import org.bukkit.Color;
import org.bukkit.Location;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cooper on 4/12/2017.
 */
public class SpaceCache extends Cache {

    public SpaceCache() {
        super(Location.class, Color.class, "SpaceCache");
    }

    public boolean verify(Location loc, MultiBlockPattern blockPattern){
        //list for holding all locations to verify against cache
        ArrayList<Location> locsToVerify = new ArrayList<Location>();

        //find pattern objects from pattern to pull locations from
        List<PatternObject> patternObjects = blockPattern.getPatternObjects();

        //fill array list with patternObjects full locations
        for(PatternObject patternObject : patternObjects){
            //add offset to original location
            locsToVerify.add(loc.add(patternObject.getLocation()));
        }

        //add core block's location
        locsToVerify.add(loc);

        //verifying boolean
        boolean legit = true;

        //check all locations against cache
        for(Location space : locsToVerify){
            //find key for location in data
            if(!data.containsKey(space)){
                legit = false;
                break;
            }
        }

        return legit;
    }
}
