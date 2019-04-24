package com.adneom;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test Partitioner class.
 */
public class PartitionerTest {
	
	@Test
	public void throw_exception_when_list_is_null() {
	      Exception exception = assertThrows(IllegalArgumentException.class, () ->
			Partitioner.partition(null,1));
	      assertEquals(PartitionerResource.LIST_IS_NULL.name(), exception.getMessage());
		
	}
	
	@Test
	public void throw_exception_when_partition_size_is_less_than_one() {
	      Exception exception = assertThrows(IllegalArgumentException.class, () ->
			Partitioner.partition(Arrays.asList(1,2), 0));
	      assertEquals(PartitionerResource.PARTITION_SIZE_IS_LESS_THAN_ONE.name(), exception.getMessage());
		
	}
	@Test
	public void should_return_empty_list_when_list_is_empty() {
		 List<List<Integer>> emptyList = Partitioner.partition(new ArrayList<>(), 1);
		 assertTrue(emptyList.isEmpty());
		
	}
	@Test
	public void should_return_1_2_3_4_5_when_list_12345_and_partition_size_1() {
		 List<List<Integer>> list = Partitioner.partition(Arrays.asList(1,2,3,4,5), 1);
		 assertTrue(list.size()==5);
		 assertEquals(list.get(0), Arrays.asList(1));
		 assertEquals(list.get(1), Arrays.asList(2));
		 assertEquals(list.get(2), Arrays.asList(3));
		 assertEquals(list.get(3), Arrays.asList(4));
		 assertEquals(list.get(4), Arrays.asList(5));
		
	}
	@Test
	public void should_return_12_34_5_when_list_12345_and_partition_size_2() {
		 List<List<Integer>> list = Partitioner.partition(Arrays.asList(1,2,3,4,5), 2);
		 assertTrue(list.size()==3);
		 assertEquals(list.get(0), Arrays.asList(1,2));
		 assertEquals(list.get(1), Arrays.asList(3,4));
		 assertEquals(list.get(2), Arrays.asList(5));
		
	}
	@Test
	public void should_return_12345_when_list_12345_and_partition_size_6() {
		 List<List<Integer>> list = Partitioner.partition(Arrays.asList(1,2,3,4,5), 6);
		 assertTrue(list.size()==1);
		 assertEquals(list.get(0), Arrays.asList(1,2,3,4,5));

		
	}

}
