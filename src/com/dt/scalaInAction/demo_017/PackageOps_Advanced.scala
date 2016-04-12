package com.dt.scalaInAction.demo_017

/**
 * Scala中包、类、对象、成员、伴生类、伴生对象访问权限
 */

package spark {
    package navigation {
        private[spark] class Navigator{ //class前的private 用于限定该类的可见度  表示Navigator的可见度可以扩展到spark包下
            protected[navigation] def useStarChart(){}
            class LegOfJourney {
                private[Navigator] val distance = 100
            }
            private[this] var speed = 200
        }    
    }
    
    package launch{
        import navigation._
        object Vehice {
            private[launch] val guide = new Navigator
        }
    }
}

class PackageOps_Advanced{
    import PackageOps_Advanced.power
    private def canMakeItTrue = power > 10001
}

object PackageOps_Advanced {
    private def power  = 10000
    def makeItTrue(p: PackageOps_Advanced): Boolean = {
        val result = p.canMakeItTrue
        result
    }
}