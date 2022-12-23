package org.aapsasha.lab8.IClothes;

import lombok.Setter;

@Setter
public abstract class IPants extends IClothes {
    @Override
    public String toString(){
        return "Pants: cost: " + super.cost;
    }
}
