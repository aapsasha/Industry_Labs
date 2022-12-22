package org.aapsasha.lab7.Decorator;

import org.aapsasha.lab7.IClothes.ClothesComponent;
import org.aapsasha.lab7.Singleton.FileSingletonlog;

import java.io.FileWriter;
import java.io.IOException;

public class ClothesColor extends IClothesDecorator{
    COLOR color;
    public ClothesColor(ClothesComponent clothes, COLOR color) throws IOException {
        super(clothes);
        this.color = color;
        FileWriter writer = FileSingletonlog.getinstance().writer;
        writer.write("object color change: " + this);
        writer.flush();
    }
    @Override
    public String toString(){
        return super.clothes.toString() + ", color: " +
                switch (color){
                    case RED -> "red";
                    case BLUE -> "blue";
                    case GREEN -> "green";
                };
    }
}
