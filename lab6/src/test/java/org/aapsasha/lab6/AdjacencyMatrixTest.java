package org.aapsasha.lab6;


import org.aapsasha.lab6.ReadandWrite.TownData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMatrixTest {

    @Test
    void createnullMatrix() {

        AdjacencyMatrixCreator creator = new AdjacencyMatrixCreator(new ArrayList<>());
        int[][] expectedanswer = new int[0][0];
        assertTrue(Arrays.deepEquals(expectedanswer, creator.adjacencyMatrix));
    }
    @Test
    void create4x4Matrix(){
        List<TownData> townList= new ArrayList<TownData>();
        townList.add(new TownData("Minsk","Brest", 10));
        townList.add(new TownData("Brest","Moskow", 40));
        townList.add(new TownData("Moskow","Minsk", 45));
        townList.add(new TownData("Minsk","I", 1));
        townList.add(new TownData("I","Moskow", 70));
        AdjacencyMatrixCreator creator = new AdjacencyMatrixCreator(townList);
        int[][] expectedanswer = {{-1,10,45,1},{10,-1,40,-1},{45,40,-1,70},{1,-1,70,-1}};
        assertTrue(Arrays.deepEquals(expectedanswer, creator.adjacencyMatrix));
    }
}