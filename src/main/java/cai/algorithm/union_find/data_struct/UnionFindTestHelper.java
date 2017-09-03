package cai.algorithm.union_find.data_struct;

public class UnionFindTestHelper {
    public static void testUF1(int n) {
        UnionFind1 uf1 = new UnionFind1(n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf1.unionElement(a, b);
        }
        long endTime = System.currentTimeMillis();

        System.out.println(
                UnionFind1.class.getSimpleName() + " 执行" + 2 * n + "次Union操作 耗时:" + (endTime - startTime) + "ms");

    }

    public static void TestUFParentTree(int n) {
        UnionFindParentTree ufpt = new UnionFindParentTree(n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            ufpt.union(a, b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(UnionFindParentTree.class.getSimpleName() + " 执行" + 2 * n + "次Union操作 耗时:"
                + (endTime - startTime) + "ms");
    }

    public static void TestUnionFindsize(int n) {
        UnionFindSize ufs = new UnionFindSize(n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            ufs.union(a, b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(
                UnionFindSize.class.getSimpleName() + " 执行" + 2 * n + "次Union操作 耗时:" + (endTime - startTime) + "ms");
    }

    public static void TestUnionFindRank(int n) {
        UnionFindRank ufr = new UnionFindRank(n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            ufr.union(a, b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(
                UnionFindRank.class.getSimpleName() + " 执行" + 2 * n + "次Union操作 耗时:" + (endTime - startTime) + "ms");

    }
    
    public static void TestUnionFindCompressRecursive(int n){
        UnionFindCompressRecursive ufcr = new UnionFindCompressRecursive(n);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            ufcr.union(a, b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(
                UnionFindCompressRecursive.class.getSimpleName() + " 执行" + 2 * n + "次Union操作 耗时:" + (endTime - startTime) + "ms");

    }
}
