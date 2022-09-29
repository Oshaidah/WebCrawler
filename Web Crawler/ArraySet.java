import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T extends Comparable<T>> {
	
	ArrayList<T> ArraySet= new ArrayList<T>();
	
	public ArraySet()
	{
		 ArraySet= new ArrayList<T>();
	}

	public int size()
	{
		int size = ArraySet.size();
		return size;
		
		
	}
	
	public List<T> asList()
	{
		
		
		return this.ArraySet;
		
		
	}
	
	public boolean contains(T query)
	{
		
		for(T i: ArraySet)
		{
			if(i.equals(query))
			{
				return true;
			}
		}
		return false;
		
	}
	public boolean add(T item)
	{
		
		for(T i:ArraySet)
		{
			if(i.equals(item))
			{
				return false;
			}
		}
		if(item.equals(null))
		{
			throw new RuntimeException("ArraySet does not support null items");
		}
		else
		{
			int set=Collections.binarySearch(ArraySet, item);
			if(Collections.binarySearch(ArraySet, item)<0)
			{
				 set = -Collections.binarySearch(ArraySet, item)-1;
			}
			else
			{
				return false;
			}
			ArraySet.add(set,item);
			return true;
		}
	}
	public T get(T query)
	{
		for(int i =0;i<ArraySet.size();i++)
		{
			if(ArraySet.get(i).equals(query))
			{
				return ArraySet.get(i);
			}
		}
		return null;
		
		
	}
	public String toString()
	{
		return this.ArraySet.toString();
	}
	public Iterator<T> iterator()
	{
		return new I();
	
	
	}
	
	private class I implements Iterator<T>
	{
			
        
            private int i = 0;
            @Override
            public boolean hasNext() 
            {       
            	
            	List<T>l=ArraySet;
                return (i <ArraySet.size());
            }
            @Override
            public T next() 
            {             
                
                return ArraySet.get(i++);
            }
		
		
	}
	
	
}
