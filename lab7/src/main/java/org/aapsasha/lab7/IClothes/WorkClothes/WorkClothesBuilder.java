package org.aapsasha.lab7.IClothes.WorkClothes;

import org.aapsasha.lab7.IClothes.IClothesBuilder;
import org.aapsasha.lab7.IClothes.IPants;
import org.aapsasha.lab7.IClothes.IShoes;
import org.aapsasha.lab7.IClothes.IUnderwear;

public class WorkClothesBuilder implements IClothesBuilder {
    @Override
    public IShoes createShoes() {
        return new WorkShoes();
    }

    @Override
    public IPants createPants() {
        return new WorkPants();
    }

    @Override
    public IUnderwear createUnderwear() {
        return new WorkUnderwear();
    }
}
