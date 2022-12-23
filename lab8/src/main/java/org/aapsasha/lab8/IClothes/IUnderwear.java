package org.aapsasha.lab8.IClothes;

public abstract class IUnderwear extends IClothes{
    @Override
    public String toString(){
        return "Underwear: cost: " + super.cost;
    }
}
