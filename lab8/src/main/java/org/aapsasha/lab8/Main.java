package org.aapsasha.lab8;

import org.aapsasha.lab8.Decorator.COLOR;
import org.aapsasha.lab8.Decorator.ClothesColor;
import org.aapsasha.lab8.Decorator.ClothesSize;
import org.aapsasha.lab8.Decorator.Clothesmaterial;
import org.aapsasha.lab8.IClothes.ClothesDirector;
import org.aapsasha.lab8.IClothes.ClothesType;
import org.aapsasha.lab8.IClothes.IClothesBuilder;
import org.aapsasha.lab8.Decorator.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        IClothesBuilder builder = ClothesDirector.builder(ClothesType.OFFICIAL);
        System.out.println(new ClothesColor(builder.createPants(), COLOR.RED));
        System.out.println(new ClothesColor(new Clothesmaterial(builder.createShoes(), MATERIAL.LEATHER),COLOR.GREEN));
        System.out.println(new ClothesSize(builder.createUnderwear(), SIZE.XL));
    }
}
