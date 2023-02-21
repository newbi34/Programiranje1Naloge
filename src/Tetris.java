import java.util.Scanner;
import java.lang.Math;

public class Tetris {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfShapes = sc.nextInt();
        int[] height = new int[2005];
        int shapeIndex = 0;
        int coordinate = 0;

        int[][] shapeHeights = {
            {1, 1, 1, 1},
            {4},
            {2, 2},
            {1, 2, 1},
            {2, 3},
            {2, 2, 2},
            {3, 2},
            {3, 1},
            {1, 1, 2},
            {3, 3},
            {2, 2, 2},
            {1, 3},
            {2, 2, 2},
            {3, 3},
            {2, 1, 1},
            {2, 2, 1},
            {2, 3},
            {1, 2, 2},
            {3, 2}
        };

        int[][] shapeNegSpaces = {
            {0, 0, 0, 0},
            {0},
            {0, 0},
            {0, 0, 0},
            {1, 0},
            {1, 0, 1},
            {0, 1},
            {0, 0},
            {0, 0, 0},
            {2, 0},
            {0, 1, 1},
            {0, 0},
            {1, 1, 0},
            {0, 2},
            {0, 0, 0},
            {1, 0, 0},
            {0, 1},
            {0, 0, 1},
            {1, 0}
        };
            

        for (int i = 0; i < numberOfShapes; i++) {
            shapeIndex = sc.nextInt();
            coordinate = sc.nextInt() + 1000;
            calculateHeight(height, shapeIndex, coordinate, shapeHeights, shapeNegSpaces);
        }
        sc.close();

        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
            System.out.printf("%d: %d%n", i - 1000, height[i]);
            }
        }
    }

    public static void calculateHeight (int[] height, int shapeIndex, int coordinate, int[][] shapeHeights, int[][] shapeNegSpaces) {
        int[] shapeHeight = shapeHeights[shapeIndex];
        int[] shapeNegSpace = shapeNegSpaces[shapeIndex];

        int base = 0;
        for (int i = 0; i < shapeHeight.length; i++) {
            base = Math.max(base, height[ i + coordinate] - shapeNegSpace[i]);
        }

        for (int i = 0; i < shapeHeight.length; i++) {
            height[i + coordinate] = base + shapeHeight[i];
        }
    }
}
