package org.aapsasha.lab7.IClothes;

public abstract class IUnderwear extends IClothes{
    @Override
    public String toString(){
        return "Underwear: cost: " + super.cost;
    }
}
