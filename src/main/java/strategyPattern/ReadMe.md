# Design Principle

Identify the aspects of your application that vary 
and separate them from what stays the same.

Program to a supertype, not an implementation.
The supertype can be java interface or abstract class.

一个类的行为或其算法可以在运行时更改

https://www.runoob.com/design-pattern/strategy-pattern.html


### Has-a can be better than is-a
Favor composition over inheritance.
When we put two classes together like this we're using composition.
Instead of inheriting their behavior, 
the ducks get their behavior by being composed with the right behavior object.

As you can see, using composition gives you a lot more flexibility.

策略模式定义了算法族，分别封装起来，让他们之间可以互相替换
此模式让算法独立于使用算法的客户