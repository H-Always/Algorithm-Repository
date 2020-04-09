/**
 * @ClassName: LFUCacheTest
 * @Description: 算法测试
 * @Author: 余霜
 * @Date: 2020/04/05 20:12
 * @Version: V1.0
 **/
public class LFUCacheTest {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        //cache.put(3, 3);
        System.out.println(cache.get(2));   // 返回 1
        //cache.put(4, 3);    // 去除 key 2
        //System.out.println(cache.get(4));       // 返回 -1 (未找到key 2)
        //System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 3);    // 去除 key 1
        //System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(2));       // 返回 3
        System.out.println(cache.get(3));       // 返回 4
        System.out.println(cache.get(4));
    }
}
/*
System.out.println("查询"+key+"之前");
for (int l = 0; l < this.kv.length; l++) {
                        for (int k = 0; k < this.kv[0].length; k++) {
                            System.out.print(kv[l][k]+"\t");
                        }
                        System.out.println();
                    }
 */