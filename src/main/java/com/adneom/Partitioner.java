package com.adneom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *  Partitioner class
 *
 */
public class Partitioner 
{

	public static <T> List<List<T>> partition(List<T> list , int partitionSize) {
		checkArguments(list,partitionSize);
		final AtomicInteger counter = new AtomicInteger();
		final Collection<List<T>> result = list.stream()
			    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / partitionSize))
			    .values();
		return   new ArrayList<>(result);
	}
	
	public static <T> void checkArguments(List<T> list , int partitionSize) {
		if(list == null)
			throw new IllegalArgumentException(PartitionerResource.LIST_IS_NULL.name());
		if(partitionSize <= 0)
			throw new IllegalArgumentException(PartitionerResource.PARTITION_SIZE_IS_LESS_THAN_ONE.name());
	}

}
