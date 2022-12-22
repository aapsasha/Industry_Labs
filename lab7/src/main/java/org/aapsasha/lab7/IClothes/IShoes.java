package org.aapsasha.lab7.IClothes;

public abstract class IShoes extends IClothes{
    @Override
    public String toString(){
        return "Shoes: cost: " + super.cost;
    }
}
