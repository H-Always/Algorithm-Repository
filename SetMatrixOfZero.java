package AlgorithmPackge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName SetMatrixOfZero
 * @Description: TODO 矩阵置零，把数组中元素为零的行和列都置为0
 * @Author 余霜
 * @Date 2019/12/28 15:27
 * @Version V1.0
 **/

public class SetMatrixOfZero {
    public void setMatrixOfZero(int[][] matrix) {
        //创建一个新的二维集合，用来存放为0的元素位置
        ArrayList<ArrayList<Integer>> zeroIndex = new ArrayList<>();

        //设置标志，用来记录数组下标
        int flag = 0;

        //判断元素是否为零，如果是零，则存放在数组里
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    //把为零的点放进新集合，然后把这个集合放到结果集
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    zeroIndex.add(temp);
                }
            }
        }

        //循环下zroIndex用来把改行和该列元素置为零
        for (int i = 0; i < zeroIndex.size(); i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[zeroIndex.get(i).get(0)][j] = 0;
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][zeroIndex.get(i).get(1)] = 0;
            }
        }

        return;
    }
}
