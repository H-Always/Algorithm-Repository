/**
 * @ClassName: GameOfLifeTest
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/02 23:29
 * @Version: V1.0
 **/
public class GameOfLifeTest {
    public static void main(String[] args) {
        GameOfLife ys = new GameOfLife();

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        System.out.println();
        ys.gameOfLife(board);

        System.out.println();
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
