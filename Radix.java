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
    SortableLinkedList positives = new SortableLinkedList();
    SortableLinkedList negatives = new SortableLinkedList();
     while (data.size() > 0)
    {
      int element = data.get(0);
      if (element >= 0) {positives.add(element);}
      else {negatives.add(element);}
      data.remove(0);
    }
    radixSortSimple(negatives);
    radixSortSimple(positives);
    data.extend(negatives);
    data.extend(positives);
  }
  public static void radixSortSimple(SortableLinkedList data)
  {
    int basesize = 0;
    for (int i = 0; i < data.size() ; i ++ )
    {
      basesize = Math.max(data.get(i), basesize);
    }
    for (int i = 0; i < basesize ; i ++ )
    {
      radixSortSimplest(data, i);
    }
  }
  public static void radixSortSimplest(SortableLinkedList data, int base)
  {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i ++ ) { buckets[i] = new SortableLinkedList();}
    while (data.size() > 0)
    {
      int digit = nth(data.get(0), base);
      buckets[digit - 1].add(data.get(0));
      data.remove(0);
    }
    merge(data, buckets);
  }
}
