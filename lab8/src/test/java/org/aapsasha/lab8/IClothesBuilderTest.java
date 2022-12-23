package org.aapsasha.lab8;


import org.aapsasha.lab8.IClothes.*;
import org.aapsasha.lab8.IClothes.HomeClothes.HomePants;
import org.aapsasha.lab8.IClothes.HomeClothes.HomeShoes;
import org.aapsasha.lab8.IClothes.HomeClothes.HomeUnderwear;
import org.aapsasha.lab8.IClothes.OfficialClothes.OfficialPants;
import org.aapsasha.lab8.IClothes.OfficialClothes.OfficialShoes;
import org.aapsasha.lab8.IClothes.OfficialClothes.OfficialUnderwear;
import org.aapsasha.lab8.IClothes.WorkClothes.WorkPants;
import org.aapsasha.lab8.IClothes.WorkClothes.WorkShoes;
import org.aapsasha.lab8.IClothes.WorkClothes.WorkUnderwear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class IClothesBuilderTest {

    @Test
    void createOfficialShoes() {
        IShoes result = ClothesDirector.builder(ClothesType.OFFICIAL).createShoes();
        Assertions.assertTrue(result instanceof OfficialShoes);
    }

    @Test
    void createOfficialPants() {
        IPants result = ClothesDirector.builder(ClothesType.OFFICIAL).createPants();
        Assertions.assertTrue(result instanceof OfficialPants);
    }

    @Test
    void createOfficialUnderwear() {
        IUnderwear result = ClothesDirector.builder(ClothesType.OFFICIAL).createUnderwear();
        Assertions.assertTrue(result instanceof OfficialUnderwear);
    }

    @Test
    void createHomeShoes() {
        IShoes result = ClothesDirector.builder(ClothesType.HOME).createShoes();
        Assertions.assertTrue(result instanceof HomeShoes);
    }

    @Test
    void createHomePants() {
        IPants result = ClothesDirector.builder(ClothesType.HOME).createPants();
        Assertions.assertTrue(result instanceof HomePants);
    }

    @Test
    void createHomeUnderwear() {
        IUnderwear result = ClothesDirector.builder(ClothesType.HOME).createUnderwear();
        Assertions.assertTrue(result instanceof HomeUnderwear);
    }

    @Test
    void createWorkShoes() {
        IShoes result = ClothesDirector.builder(ClothesType.WORK).createShoes();
        Assertions.assertTrue(result instanceof WorkShoes);
    }

    @Test
    void createWorkPants() {
        IPants result = ClothesDirector.builder(ClothesType.WORK).createPants();
        Assertions.assertTrue(result instanceof WorkPants);
    }

    @Test
    void createWorkUnderwear() {
        IUnderwear result = ClothesDirector.builder(ClothesType.WORK).createUnderwear();
        Assertions.assertTrue(result instanceof WorkUnderwear);
    }
}