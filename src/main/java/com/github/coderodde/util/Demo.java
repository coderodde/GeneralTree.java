package com.github.coderodde.util;

import java.util.Comparator;

class Demo {
    
    public static void main(String[] args) {
        
        Comparator<GeneralTreeNode<String>> cmp = new TreeComparator();
        
//        GeneralTreeNode<String> node1a  = new GeneralTreeNode<>("1", cmp);
//        GeneralTreeNode<String> node1b  = new GeneralTreeNode<>("2", cmp);
//        GeneralTreeNode<String> node1b1 = new GeneralTreeNode<>("a", cmp);
//        GeneralTreeNode<String> node1b2 = new GeneralTreeNode<>("b", cmp);
//        GeneralTreeNode<String> node1b3 = new GeneralTreeNode<>("c", cmp);
//        
//        node1b.addChild(node1b1);
//        node1b.addChild(node1b2);
//        node1b.addChild(node1b3);
//        
//        GeneralTree<String> tree = new GeneralTree<>(cmp);
//        
//        tree.addRoot(node1a);
//        tree.addRoot(node1b);
//        
//        String s = tree.toString();
//        System.out.println(s);

        GeneralTreeNode<String> n1 = new GeneralTreeNode<>("A", cmp);
        GeneralTreeNode<String> n2 = new GeneralTreeNode<>("B", cmp);
        GeneralTreeNode<String> n3 = new GeneralTreeNode<>("C", cmp);
        GeneralTreeNode<String> n31 = new GeneralTreeNode<>("1", cmp);
        GeneralTreeNode<String> n32 = new GeneralTreeNode<>("2", cmp);
        
        GeneralTree<String> tr = new GeneralTree<>(cmp);
        
        tr.addRoot(n1);
        tr.addRoot(n2);
        tr.addRoot(n3);
        
        n3.addChild(n31);
        n3.addChild(n32);
        
        String str = tr.toString();
        System.out.println(str);
    }
}

class TreeComparator implements Comparator<GeneralTreeNode<String>> {

    @Override
    public int compare(GeneralTreeNode<String> o1,
                       GeneralTreeNode<String> o2) {
        return o1.getData().compareTo(o2.getData());
    }
}
