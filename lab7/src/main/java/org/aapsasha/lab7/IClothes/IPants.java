package org.aapsasha.lab7.IClothes;

import lombok.Setter;

@Setter
public abstract class IPants extends IClothes {
    @Override
    public String toString(){
        return "Pants: cost: " + super.cost;
    }
}
