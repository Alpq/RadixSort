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
      if (digit > 0) {buckets[1].add(digit);}
      else {buckets[0].add(0, digit);}
    }
    merge(data, buckets);
  }
  public static void radixSortSimple(SortableLinkedList data)
  {
    int goal = data.size();
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    SortableLinkedList sorted = new SortableLinkedList();
    for(int i = 0; i < 10; i ++) {buckets[i] = new SortableLinkedList();}
    int cycle = 0;
    int beeg = 0;
    while (data.size() > 0)
    {
       while (data.size() > 0)
      {
        int digit = data.remove(0);
        if (length(digit) < cycle) {sorted.add(digit);}
        else {buckets[nth(digit, cycle)].add(digit);}
      }
      merge(data, buckets);
      cycle ++;
    }
    data.extend(sorted);
  }
}
