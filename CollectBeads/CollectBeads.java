import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: collectBeads
 * @Description: 理琥珀珠简化问题
 * @Author: 余霜
 * @date: 2020/2/15/18:01
 * @Version: 1.0
 */

public class CollectBeads {
    public int[][] collectBeads(int n, int amberIndex) {

        List<List<Integer>> op = new ArrayList<>();
        int target = amberIndex;
        while (target>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(target);
            temp.add(0);
            op.add(temp);
            target--;
        }
        int num = (n-1)-amberIndex;
        if (num>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(1);
            op.add(temp);
            num--;
        }
        while (num>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(++amberIndex);
            temp.add(1);
            op.add(temp);
            num--;
        }
        int[][] operations = new int[op.size()][2];
        for (int i = 0; i < operations.length; i++) {
            for (int j = 0; j < 2; j++) {
                operations[i][j] = op.get(i).get(j);
            }
        }
        return operations;

    }

    public int[][] collectBeads_1(int n, int amberIndex){
        int[][] amber = new int[n-1][2];
        int k = amberIndex;
        int i = 0;
        while (k>0){
            amber[i][0] = k;
            amber[i++][1] = 0;
            k--;
        }
        int num = (n-1)-amberIndex;
        if (num>0){
            amber[i][0] = 0;
            amber[i++][1] = 1;
            num--;
        }
        while (num>0){
            amber[i][0] = ++amberIndex;
            amber[i++][1] = 1;
            num--;
        }

        return amber;
    }

}
