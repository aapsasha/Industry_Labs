package org.aapsasha.lab3;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixBuilderTest {

    @Test
    @Name("create zero Matrix")
    void build1() {
        Integer[][] matrix = MatrixBuilder.build(0,0);
        Integer[][] expected = {};
        assertArrayEquals(matrix,expected);
    }
    @Test
    @Name("create ten lines Matrix")
    void build2() {
        Integer[][] matrix = MatrixBuilder.build(10,0);
        Integer[][] expected = {{0},{0},{0},{0},{0},{0},{0},{0},{0},{0}};
        assertArrayEquals(matrix,expected);
    }
    @Test
    @Name("create normal Matrix")
    void build3() {
        Integer[][] matrix = MatrixBuilder.build(10,3);
        Integer[][] expected = new Integer[10][4];
        for(int i = 0; i < 10;i++){
            expected[i][3] =  Math.max(matrix[i][1], 0);;
            System.arraycopy(matrix[i], 0, expected[i], 0, 3);
        }
        assertArrayEquals(matrix,expected);
    }


}