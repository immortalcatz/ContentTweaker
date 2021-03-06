package com.teamacronymcoders.contenttweaker.api.wrappers.biome;

import minetweaker.mc1112.world.MCBiome;
import net.minecraft.world.biome.Biome;

public class CTBiome extends MCBiome implements ICTBiome {
    private Biome biome;

    public CTBiome(Biome biome) {
        super(biome);
        this.biome = biome;
    }

    @Override
    public float getTemperature() {
        return this.biome.getTemperature();
    }

    @Override
    public float getRainfall() {
        return this.biome.getRainfall();
    }

    @Override
    public boolean canRain() {
        return this.biome.canRain();
    }

    @Override
    public boolean canSnow() {
        return this.biome.isSnowyBiome();
    }

    @Override
    public float getHeightVariance() {
        return this.biome.getHeightVariation();
    }
}
