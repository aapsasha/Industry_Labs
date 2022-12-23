package org.aapsasha.lab8.Decorator;

import org.aapsasha.lab8.IClothes.ClothesComponent;

public class IClothesDecorator implements ClothesComponent {
    ClothesComponent clothes;
    public IClothesDecorator(ClothesComponent clothes){
        this.clothes = clothes;
    }
}
