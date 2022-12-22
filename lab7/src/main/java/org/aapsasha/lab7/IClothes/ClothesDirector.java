package org.aapsasha.lab7.IClothes;

import org.aapsasha.lab7.IClothes.HomeClothes.HomeClothesBuilder;
import org.aapsasha.lab7.IClothes.OfficialClothes.OfficialClothesBuilder;
import org.aapsasha.lab7.IClothes.WorkClothes.WorkClothesBuilder;

public class ClothesDirector {
    static public IClothesBuilder builder(ClothesType type){
        return switch (type){
            case OFFICIAL -> new OfficialClothesBuilder();
            case HOME -> new HomeClothesBuilder();
            case WORK -> new WorkClothesBuilder();
        };
    }
}
