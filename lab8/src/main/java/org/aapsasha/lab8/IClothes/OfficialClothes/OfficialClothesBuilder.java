package org.aapsasha.lab8.IClothes.OfficialClothes;

import org.aapsasha.lab8.IClothes.IClothesBuilder;
import org.aapsasha.lab8.IClothes.IPants;
import org.aapsasha.lab8.IClothes.IShoes;
import org.aapsasha.lab8.IClothes.IUnderwear;

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
