public class Radix{
  public static int nth(int n, int col)
  {
    return Math.abs(n / (int)Math.pow(10, col) % 10);
  }
  public static int length(int n)
  {
    return (int)Math.floor(Math.log(n));
  }
  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets)
  {
    for (int i =0 ; i < buckets.length; i ++ ) {
    original.extend(buckets[i]);
    }
  }
  public static void radixSort(SortableLinkedList data)
  {
    radixSortSimple(data);
    SortableLinkedList[] buckets = new SortableLinkedList[2];
    buckets[0] = new SortableLinkedList();
    buckets[1] = new SortableLinkedList();
    while (data.size() > 0){
      int digit = data.remove(0);
      if (digit > 0) {buckets[1].add(digit);} else {buckets[0].add(digit);}
    }
    merge(data, buckets);
  }
  public static void radixSortSimple(SortableLinkedList data)
  {
    int cycles = 0;
    for (int i = 0; i < data.size() ; i ++ )
    {
      cycles = Math.max(length(data.get(i)), cycles);
    }
    for (int i = 0; i < cycles; i ++ )
    {
      radixSortSimplest(data, i);
    }
  }
  public static void radixSortSimplest(SortableLinkedList data, int base)
  {
    SortableLinkedList[] buckets = new SortableLinkedList[11];
    for(int i = 0; i < 11; i ++) {buckets[i] = new SortableLinkedList();}
     while (data.size() > 0)
    {
      int digit = data.remove(0);
      if (length(digit) >= base) {buckets[nth(digit, base) + 1].add(digit);}
      else {buckets[0].add(digit);}
    }
    merge(data, buckets);
  }
}
