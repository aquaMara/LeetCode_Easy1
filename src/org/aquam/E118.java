package org.aquam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E118 {

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(List.of(1));
        for (int row = 2; row <= numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            List<Integer> previousList = pascalsTriangle.get(pascalsTriangle.size() - 1);
            rowList.add(0, previousList.get(0));
            rowList.add(row - 1, previousList.get(previousList.size() - 1));

            for (int rowLength = 0; rowLength < row; ++rowLength) {
                int i = previousList.get(row - 1) + previousList.get(row);
                rowList.add(row, i);
            }

            pascalsTriangle.add(rowList);
        }
        return pascalsTriangle;
    }
}
