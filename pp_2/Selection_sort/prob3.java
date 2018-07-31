class ArrayBub
{
	private long[] a;
	private int nElems;
	public ArrayBub(int max)
	{
		a = new long[max];
		nElems = 0;
	}
	public void insert(long value)
	{
		a[nElems] = value;	
		nElems++;
	}
	public void display()
	{
		for(int j=0; j<nElems; j++)
		System.out.print(a[j] + " ");
		System.out.println("");
	}
	public void selectionsort()
	{
		int out, in, min;
		for(out=0; out<nElems-1; out++)
		{
			min = out;
			for(in=out+1; in<nElems; in++)
			{
				if(a[in] < a[min] )
					min = in;
					swap(out, min);
			}	
		}

	}		
	private void swap(int one, int two)
	{
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
} 
public class prob3
{
	public static void main(String[] args)
	{
		int maxSize = 100;
		ArrayBub arr;
		
		System.out.println("");
		System.out.println("*_______USING SELECTION SORT_______*");
		System.out.println("");
		arr = new ArrayBub(maxSize);
		arr.insert(9);
		arr.insert(39);
		arr.insert(19);
		arr.insert(49);
		arr.insert(89);
		arr.insert(79);
		arr.insert(29);
		arr.insert(99);
		arr.insert(59);
		arr.insert(69);
		arr.display();
		arr.selectionsort();
		arr.display();
	}
}
