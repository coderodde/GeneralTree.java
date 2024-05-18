package com.github.coderodde.util;

import java.util.Comparator;
import org.junit.Test;


public final class GeneralTreeStringBuilderTest {
    
    private final Comparator<GeneralTreeNode<String>> comparator = 
              new Comparator<>() {
                  
        @Override
        public int compare(final GeneralTreeNode<String> node1,
                           final GeneralTreeNode<String> node2) {
            return node1.getData().compareTo(node2.getData());
        }          
    };
    
    /*
    
    D+
    |a+
    | 1
    | 2
    E
    
    */
    @Test
    public void testToString() {
        final GeneralTreeNode<String> D = 
                new GeneralTreeNode<>("D", comparator);
        
        final GeneralTreeNode<String> a = 
                new GeneralTreeNode<>("a", comparator);
        
        final GeneralTreeNode<String> n1 = 
                new GeneralTreeNode<>("1", comparator);
        
        final GeneralTreeNode<String> n2 = 
                new GeneralTreeNode<>("2", comparator);
        
        final GeneralTreeNode<String> E = 
                new GeneralTreeNode<>("E", comparator);
        
        final GeneralTree<String> tree = new GeneralTree<>(comparator);
        
        D.addChild(a);
        a.addChild(n1);
        a.addChild(n2);
        
        tree.addRoot(D);
        tree.addRoot(E);
        
        final GeneralTreeStringBuilder builder =
                new GeneralTreeStringBuilder<>();
        
        final String string = builder.buildTreeString(tree);
        
        System.out.println(string);
    }
}
