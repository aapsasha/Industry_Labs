package org.aapsasha.lab7.IClothes.HomeClothes;

import org.aapsasha.lab7.IClothes.IClothesBuilder;
import org.aapsasha.lab7.IClothes.IPants;
import org.aapsasha.lab7.IClothes.IShoes;
import org.aapsasha.lab7.IClothes.IUnderwear;

public class HomeClothesBuilder implements IClothesBuilder {

    @Override
    public IShoes createShoes() {
        return new HomeShoes();
    }

    @Override
    public IPants createPants() {
        return new HomePants();
    }

    @Override
    public IUnderwear createUnderwear() {
        return new HomeUnderwear();
    }
}
