package com.dt.scalaInAction.demo_037

/**
 * List的foldLeft、foldRight、sort操作代码实战
 */
object List_Fold_Sort {
    def main(args: Array[String]): Unit = {
      
        /**
         * 
         *    Source define
         *    
         *    def /:[B](z: B)(op: (B, A) => B): B = foldLeft(z)(op)

              def :\[B](z: B)(op: (A, B) => B): B = foldRight(z)(op)
            
              def foldLeft[B](z: B)(op: (B, A) => B): B = {
                var result = z
                this.seq foreach (x => result = op(result, x))
                result
              }
            
              def foldRight[B](z: B)(op: (A, B) => B): B =
                reversed.foldLeft(z)((x, y) => op(y, x))
                
         */
      
        println( (1 to 100).foldLeft(0)(_+_) )  //5050   0+1+2+3+4+...100
        println( (0/:(1 to 100))(_ + _) )  //5050
        
        println( (1 to 5).foldRight(100)(_-_) )  //-97   1-(2-(3-(4-(5-100))))
        println( ((1 to 5):\100)(_ - _) )  //-97
        
        
        //def sortWith(lt: (A, A) => Boolean): Repr = sorted(Ordering fromLessThan lt)
        //sortWith 这种方式的排序是线性的 效率客观
        println(List(1, -3, 4, 2, 6) sortWith (_ < _))  //List(-3, 1, 2, 4, 6)
        println(List(1, -3, 4, 2, 6) sortWith (_ > _))  //List(6, 4, 2, 1, -3)
        
    }
}