package org.aapsasha.lab7;

import org.aapsasha.lab7.Decorator.COLOR;
import org.aapsasha.lab7.Decorator.ClothesColor;
import org.aapsasha.lab7.Decorator.ClothesSize;
import org.aapsasha.lab7.Decorator.Clothesmaterial;
import org.aapsasha.lab7.IClothes.ClothesDirector;
import org.aapsasha.lab7.IClothes.ClothesType;
import org.aapsasha.lab7.IClothes.IClothesBuilder;

import java.io.IOException;

import static org.aapsasha.lab7.Decorator.MATERIAL.LEATHER;
import static org.aapsasha.lab7.Decorator.SIZE.XL;


public class Main {
    public static void main(String[] args) throws IOException {
        IClothesBuilder builder = ClothesDirector.builder(ClothesType.OFFICIAL);
        System.out.println(new ClothesColor(builder.createPants(), COLOR.RED));
        System.out.println(new ClothesColor(new Clothesmaterial(builder.createShoes(),LEATHER),COLOR.GREEN));
        System.out.println(new ClothesSize(builder.createUnderwear(), XL));
    }
}
