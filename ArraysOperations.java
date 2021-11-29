public class ArraysOperations
{
   public static void main(String[] args)
   {
      // a
      double[] x = {8, 4, 5, 21, 7, 9, 18, 2, 100};
      
      // b
      System.out.println("Length of x :  " + x.length);
      
      // c
      System.out.println("x[0] :  " + x[0]);
      
      // d
      System.out.println("x[8] :  " + x[8]);
      
      // e
      System.out.println("x[x.length - 1] :  " + x[x.length - 1]);
      
      // f
      for (int i = 0; i < x.length; i++)
      {
         System.out.println(x[i]);
      }   
      
      // g    
      for (int i = 0; i < x.length; i++)
      {
         System.out.println("x[" + i + "] :  " + x[i]);
      }
      
      // h
      for (int i = x.length - 1; i >= 0; i--)
      {
         System.out.println("x[" + i + "] :  " + x[i]);
      }  
      
      // i
      for (double value : x)
      {
         System.out.println(value);
      }
   }
}
