public class Radix{
  public static int nth(int n, int col)
  {
    return Math.abs(n / (int)Math.pow(10, col) % 10);
  }
  public static int length(int n)
  {
    return (int)Math.floor(Math.log(Math.abs(n)));
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
      if (digit > 0) {buckets[1].add(digit);} else {buckets[0].add(0, digit);}
    }
    merge(data, buckets);
  }
  public static void radixSortSimple(SortableLinkedList data)
  {
    boolean done = false;
    int cycle = 0;
    while (!done)
    {
      done = radixSortSimplest(data, cycle);
      cycle ++;
    }
  }
  public static boolean radixSortSimplest(SortableLinkedList data, int base)
  {
    SortableLinkedList[] buckets = new SortableLinkedList[11];
    for(int i = 0; i < 11; i ++) {buckets[i] = new SortableLinkedList();}
    int sorted = 0;
     while (data.size() > 0)
    {
      int digit = data.remove(0);
      if (length(digit) >= base) {buckets[nth(digit, base) + 1].add(digit);}
      else {buckets[0].add(digit); sorted ++;}
    }
    merge(data, buckets);
    return sorted == data.size() ? true : false;
  }
}
