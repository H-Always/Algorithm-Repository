import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName: LFUCache
 * @Description: LFU缓存
 * @Author: 余霜
 * @Date: 2020/04/05 20:12
 * @Version: V1.4
 *
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。

 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *

 * 示例：
 *
 *cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // 返回 1
 *cache.put(3,3);    // 去除 key 2
 *cache.get(2);       // 返回 -1 (未找到key 2)
 *cache.get(3);       // 返回 3
 *cache.put(4,4);    // 去除 key 1
 *cache.get(1);       // 返回 -1 (未找到 key 1)
 *cache.get(3);       // 返回 3
 *cache.get(4);       // 返回 4
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/lfu-cache
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/

/*
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//求求leetcode找一个翻译吧，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键
//这啥意思？最近最少的键应该是最近一次执行过get或者更新的键吧，然而测试是找最久时间前使用的键
//我用的数组，基本数据结构。没有通过测试，小的测试通过了，暴力测试没通过，等我有机会找找bug
// 基本思路:先构造方法初始化一下给定大小数组，然后四个参数key-value-频率-年龄
// 执行的get的时候直接判断有没有就可以了，就就返回，同时频率+1，年龄变成当前最大，任何一次操作都要更新年龄！
// put的时候麻烦一点，我的思路是先判断存不存在传进来的键值，存在就更新fre+1,max(age),不存在就两种判断，数组满了或者没满
// 满了的话，就要替换，替换原则是执行频率最小的键值被替换，如果有相同的，则替换最古老的(年龄最小)键值，同时更新
// 如果数组没满，那么插入一条新数据就好了
public class LFUCache {

    int max;
    int i = 0;
    int[][] kv;

    public LFUCache(int capacity) {
        this.max = capacity;
        //初始化数组
        //四个参数分别是key，value，frequency，age
        kv = new int[this.max][4];
        for (int j = 0; j < this.kv.length; j++) {
            for (int k = 0; k < this.kv[0].length; k++) {
                kv[j][k] = -1;
            }
        }
    }

    //获得键所对应的值
    public int get(int key) {

        if (kv.length == 0)
            return-1;

        for (int i = 0; i < this.i; i++) {
            if (kv[i][0] == key) {
                kv[i][2]++;
                int maxVlaue = kv[0][3];
                for (int l = 1; l < this.i; l++)
                    maxVlaue = Math.max(kv[l][3], maxVlaue);

                this.kv[i][3] = maxVlaue + 1;

                return kv[i][1];
            }
        }


        return -1;
    }

    public void put(int key, int value) {
        //如果数组长度为0的话，就没有办法插入
        if (kv.length == 0)
            return;

        //先寻找是否已经存在了键值，如果存在，就更新，更新之后的频率+1，该元素年龄为设置为最大，证明是最近一次更新的
        for (int j = 0; j < this.i; j++) {

            if (this.kv[j][0] == key) {
                this.kv[j][1] = value;
                this.kv[j][2]++;

                int maxVlaue = kv[0][3];
                for (int l = 1; l < this.i; l++)
                    maxVlaue = Math.max(kv[l][3], maxVlaue);

                this.kv[j][3] = maxVlaue + 1;

                return;
            }
        }


        //如果不存在更新，就插入，判断一下数组书否满了，满了的话就替换
        if (this.i >= this.kv.length) {
            int min1 = this.kv[0][2];

            //找到频率最小的
            for (int j = 1; j < this.kv.length; j++) {
                min1 = Math.min(min1, kv[j][2]);

            }

            for (int j = 0; j < this.kv.length; j++) {
                //查看最小的值是否唯一，看一下list的长度
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < this.kv.length; k++) {
                    if (min1 == kv[k][2])
                        list.add(k);
                }
                if (list.size() == 1) {//如果唯一，替换频率最小的就好
                    if (this.kv[j][2] == min1) {
                        updata(j,key,value);

                        return;
                    }
                } else {//如果频率存在相等的，那么找到最久一次更新的，然后替换
                    min1 = kv[0][3];
                    for (int l = 1; l < list.size(); l++) {
                        min1 = Math.min(min1, kv[list.get(l)][3]);

                    }

                    for (Integer integer : list) {

                        if (this.kv[integer][3] == min1) {
                            updata(integer,key,value);
                            return;
                        }
                    }


                }
            }
        } else {//如果数组没满，证明可以直接插入。
            this.kv[i][0] = key;
            this.kv[i][1] = value;
            this.kv[i][2] = 0;

            int maxVlaue = kv[0][3];
            for (int l = 1; l < this.i; l++)
                maxVlaue = Math.max(kv[l][3], maxVlaue);

            this.kv[i][3] = maxVlaue + 1;
            this.i++;
        }
    }

    private  void updata(int i,int key,int value){
        this.kv[i][0] = key;
        this.kv[i][1] = value;
        this.kv[i][2] = 0;

        int maxVlaue = kv[0][3];
        for (int l = 1; l < this.kv.length; l++)
            maxVlaue = Math.max(kv[l][3], maxVlaue);

        this.kv[i][3] = maxVlaue + 1;
    }

}
