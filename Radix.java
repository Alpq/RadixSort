public class Radix{
  public static int nth(int n, int col)
  {
    return n % (int)Math.pow(10, 1 + col);
  }
  public static int length(int n)
  {
    return (int)Math.floor(Math.log(n));
  }
  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets)
  {
    for (int i =0 ; i < buckets.length ; i ++ ) {
      original.extend(buckets[i]);
    }
  }
  public static void radixSort(SortableLinkedList data)
  {
  }
  public static void radixSortSimple(SortableLinkedList data)
  {
    int basesize = 0;
    for (int i = 0; i < data.size() ; i ++ ) {
      basesize = Math.max(data.get(i), basesize);
    }
    for (int i = 0; i < basesize ; i ++ ) {
      SortableLinkedList[] bucket = new SortableLinkedList[10];
      for (int j = 0; j < data.size(); j += 0)
      {
        int digit = nth(data.get(0), i);
        bucket[digit].add(data.get(0));
        data.remove(0);
      }
      merge(data, bucket);
    }
  }

}
