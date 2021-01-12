public class Radix{
  public static int nth(int n, int col)
  {
    return n % Math.pow(10, 1 + col);
  }
  public static int length(int n)
  {
    return Math.floor(Math.log(n));
  }
  public static void merge(MyLinkedList original,MyLinkedList[]buckets)
  {
    for (int i =0 ; i < buckets.length ; i ++ ) {
      buckets[i].extend(buckets[i + 1])
    }
  }
}
