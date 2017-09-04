package cai.algorithm.graph.datastruct;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

import cai.algorithm.io.Resource;
import cai.algorithm.io.ResourceLoader;

public class ReadGraph {
    public static Scanner scanner;

    public static void read(Graph graph, String fileName) {
        readFile(fileName);
        int v = scanner.nextInt();
        if(v < 0){
            throw new IllegalArgumentException("节点数不能小于0");
        }
        int e = scanner.nextInt();
        if(e < 0){
            throw new IllegalArgumentException("边数不能小于0");
        }
        
        for(int i = 0; i < e; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.addEdge(a, b);
        }
    }

    public static void readFile(String fileName) {
        ResourceLoader rl = new ResourceLoader();
        Resource urlr = rl.getResource(fileName);
        try {
            InputStream is = urlr.getInputStream();
            scanner = new Scanner(new BufferedInputStream(is),"UTF-8");
            scanner.useLocale(Locale.ENGLISH);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
