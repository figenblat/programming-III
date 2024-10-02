import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// --== CS400 File Header Information ==--
// Name: Noa Figenblat
// Email: figenblat@wisc.edu
// Team: CP
// TA: Evan Wireman
// Lecturer: Florian Heimerl
// Notes to Grader: 

public class TestRedBlackTree{
	@Test
	public static void test1() {
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		tree.insert(23);
		tree.insert(7);
		tree.insert(41);
		
		tree.insert(37);
		
		//assertEquals();
		
    	
    	
    		
    	
    		System.out.println("level order traversal: " + tree.root.toString());
    		//System.out.println(tree.forEach(nodeColor));
	}
	@Test
	public static void test2() {
		RedBlackTree<Integer> tree2 = new RedBlackTree<Integer>();
		tree2.insert(45);
		tree2.insert(26);
		tree2.insert(72);
		
		tree2.insert(18);
		
		assertEquals(tree2.root.toString(),"[45, 26, 72, 18]" );

		System.out.println("level order traversal: " + tree2.root.toString());
		
	}
	@Test
	public static void test3() {
		RedBlackTree<Integer> tree3 = new RedBlackTree<Integer>();
		tree3.insert(45);
		tree3.insert(26);
		tree3.insert(72);
		
		tree3.insert(18);
		
		
		
		//System.out.println("level order traversal: " + tree3.root.toString());

		
	}
	@Test 
	public static void test4() {
		RedBlackTree<Integer> tree4 = new RedBlackTree<Integer>();

		
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		
	}
}
