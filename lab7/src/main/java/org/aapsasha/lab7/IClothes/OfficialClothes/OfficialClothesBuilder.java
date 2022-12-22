package org.aapsasha.lab7.IClothes.OfficialClothes;

import org.aapsasha.lab7.IClothes.IClothesBuilder;
import org.aapsasha.lab7.IClothes.IPants;
import org.aapsasha.lab7.IClothes.IShoes;
import org.aapsasha.lab7.IClothes.IUnderwear;

public class OfficialClothesBuilder implements IClothesBuilder {
    @Override
    public IShoes createShoes() {
        return new OfficialShoes();
    }

    @Override
    public IPants createPants() {
        return new OfficialPants();
    }

    @Override
    public IUnderwear createUnderwear() {
        return new OfficialUnderwear();
    }
}
