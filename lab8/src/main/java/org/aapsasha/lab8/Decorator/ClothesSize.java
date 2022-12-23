package org.aapsasha.lab8.Decorator;

import org.aapsasha.lab8.IClothes.ClothesComponent;
import org.aapsasha.lab8.Singleton.FileSingletonlog;

import java.io.FileWriter;
import java.io.IOException;

public class ClothesSize extends IClothesDecorator{
    SIZE size;
    public ClothesSize(ClothesComponent clothes, SIZE size) throws IOException {
        super(clothes);
        this.size = size;
        FileWriter writer = FileSingletonlog.getinstance().writer;
        writer.write("object size change: " + this);
        writer.flush();
    }
    @Override
    public String toString(){
        return super.clothes.toString() + ", size: " +switch (size){
            case S -> "S";
            case M -> "M";
            case L -> "L";
            case XL -> "XL";
            case XS -> "XS";
            case XXS -> "XXS";
            case XXL -> "XXL";
        };
    }

}
