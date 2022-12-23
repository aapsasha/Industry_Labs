package org.aapsasha.lab8.IClothes.WorkClothes;

import org.aapsasha.lab8.IClothes.IClothesBuilder;
import org.aapsasha.lab8.IClothes.IPants;
import org.aapsasha.lab8.IClothes.IShoes;
import org.aapsasha.lab8.IClothes.IUnderwear;

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
