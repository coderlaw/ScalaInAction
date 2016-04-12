Scala中实现case class最为重要的两个方法apply和unapply，这两个方法是在case class类的伴生对象定义的。
apply用于对象的生成，所以在使用时并没有new出case class是调用了伴生对象中的apply方法减少了new关键字而unapply用于进行模式匹配 。
unapply用于在模式匹配时将该对象中的成员"析构"(结构)出来

