package org.aapsasha.lab7.Decorator;

import org.aapsasha.lab7.IClothes.ClothesComponent;

public class IClothesDecorator implements ClothesComponent {
    ClothesComponent clothes;
    public IClothesDecorator(ClothesComponent clothes){
        this.clothes = clothes;
    }
}
