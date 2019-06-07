package linked;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTester {
	@Test
	public void test_default_ctor(){
		LinkedList<String> names = new LinkedList<>();

		assertEquals(names.get_head(), null);
		assertEquals(names.get_tail(), null);
	}

	@Test
	public void test_first_insertion() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");

		assertEquals(names.get_size(), 1);

		System.out.println("Linda must be at the head and at the tail");
		names.print();
	}

	@Test
	public void test_insert_before() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");

		assertEquals(names.get_size(), 2);

		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();	
	}

	@Test
	public void test_insert_after() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");
		names.insert_after("Dory", "Felicia");

		assertEquals(names.get_size(), 3);
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();	
	}

	@Test
	public void test_invalid_insertion() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");
		names.insert_after("Dory", "Felicia");

		names.insert_after("Timothy", "Samantha");
		names.insert_before("Samantha", "Timothy");

		assertEquals(names.get_size(), 3);
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();	
	}

	@Test
	public void test_vanilla_deletion() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");
		names.insert_after("Dory", "Felicia");
		
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();
		
		names.delete("Felicia");
		
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();
		
		assertEquals(names.get_size(), 2);	
	}
	
	@Test
	public void test_deletion_at_head() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");
		names.insert_after("Dory", "Felicia");
		
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();
		
		names.delete("Dory");
		
		System.out.println("Felicia must be at the head and Linda must be at the tail");
		names.print();
		
		assertEquals(names.get_size(), 2);	
	}
	
	@Test
	public void test_deletion_in_size1_list() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		assertEquals(names.get_size(), 1);

		System.out.println("Linda must be at the head and at the tail");
		names.print();
		
		names.delete("Linda");
		assertEquals(names.get_size(), 0);
		
		System.out.println("Head and tail must be null");
		names.print();
	}
	
	@Test
	public void test_deletion_at_tail() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");
		names.insert_after("Dory", "Felicia");
		
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();
		
		names.delete("Linda");
		
		System.out.println("Dory must be at the head and Felicia must be at the tail");
		names.print();
		
		assertEquals(names.get_size(), 2);	
	}
	
	@Test
	public void test_multiple_appends() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.append("Dory");
		names.append("Felicia");
		
		assertEquals(names.get_size(), 3);
		
		System.out.println("Linda must be at the head and Felicia must be at the tail");
		names.print();
	}
	
	@Test
	public void test_insert_before_head() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");
		names.insert_after("Dory", "Felicia");
		
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();
		
		names.insert_before("Dory", "Cathy");
		
		System.out.println("Cathy must be at the head and Linda must be at the tail");
		names.print();
		
		assertEquals(names.get_size(), 4);
	}
	
	@Test
	public void test_insert_after_tail() {
		LinkedList<String> names = new LinkedList<>();
		names.append("Linda");
		names.insert_before("Linda", "Dory");
		names.insert_after("Dory", "Felicia");
		
		System.out.println(">>>>>>>>>>>>>>>>>");
		System.out.println("Dory must be at the head and Linda must be at the tail");
		names.print();
		
		names.insert_after("Linda", "Katherine");
		System.out.println("Dory must be at the head and Katherine must be at the tail");
		names.print();
		
		assertEquals(names.get_size(), 4);
	}
}
