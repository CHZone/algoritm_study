package cai.algorithm.union_find;

import cai.algorithm.union_find.data_struct.UnionFindTestHelper;

public class Main {
    public static void main(String[] args){
        int n = 100000;
//        UnionFindTestHelper.testUF1(n);
        UnionFindTestHelper.TestUFParentTree(n);
        UnionFindTestHelper.TestUnionFindsize(n);
        UnionFindTestHelper.TestUnionFindRank(n);
        UnionFindTestHelper.TestUnionFindCompressRecursive(n);
    }
}
