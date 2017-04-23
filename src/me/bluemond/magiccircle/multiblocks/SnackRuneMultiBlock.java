package me.bluemond.magiccircle.multiblocks;


import me.bluemond.magiccircle.runes.SnackRune;
import nl.shanelab.multiblock.MultiBlockPattern;
import nl.shanelab.multiblock.SpecificMaterial;
import nl.shanelab.multiblock.patternobjects.PatternBlock;

/**
 * Created by Cooper on 4/23/2017.
 */
public class SnackRuneMultiBlock extends RuneMultiBlock {

    public SnackRuneMultiBlock(){
        SpecificMaterial carp = SpecificMaterial.CARPET_WHITE;
        MultiBlockPattern mbp = new MultiBlockPattern(
                SpecificMaterial.CARPET_WHITE,
                new PatternBlock(carp, -1, 0, -1),
                new PatternBlock(carp, -1, 0, 0),
                new PatternBlock(carp, -1, 0, 1),
                new PatternBlock(carp, 0, 0, -1),
                new PatternBlock(carp, 0, 0, 1),
                new PatternBlock(carp, 1, 0, -1),
                new PatternBlock(carp, 1, 0, 0),
                new PatternBlock(carp, 1, 0, 1)
        );

        super.setMultiBlockPattern(mbp);
        super.setRuneClass(SnackRune.class);
    }
}
