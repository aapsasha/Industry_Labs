package org.aapsasha.lab8.Decorator;

import org.aapsasha.lab8.IClothes.ClothesComponent;
import org.aapsasha.lab8.Singleton.FileSingletonlog;

import java.io.FileWriter;
import java.io.IOException;

public class Clothesmaterial extends IClothesDecorator{
    MATERIAL material;
    public Clothesmaterial(ClothesComponent clothes, MATERIAL material) throws IOException {
        super(clothes);
        this.material = material;
        FileWriter writer = FileSingletonlog.getinstance().writer;
        writer.write("object material change: " + this);
        writer.flush();
    }
    @Override
    public String toString(){
        return super.clothes.toString() + ", material: " + switch (material){
            case LEATHER -> "leather";
            case COTTON -> "cotton";
            case WOOL -> "wool";
        };
    }

}
