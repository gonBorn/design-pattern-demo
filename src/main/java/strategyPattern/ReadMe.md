# Definition
The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
Strategy lets the algorithm vary independently from clients that use it.

策略模式定义了算法族，分别封装起来，让他们之间可以互相替换
此模式让算法独立于使用算法的客户

# Design Principle

1. Identify the aspects of your application that vary 
and separate them from what stays the same.

Separating what changes from what stays the same

2. Program to a supertype, not an implementation.
The supertype can be java interface or abstract class.

We’ll use an interface to represent each behavior
Subclasses of Duck won't need to know any of implementation details of fly behaviors.

3. Favor composition over inheritance.
Instead of inheriting their behavior, the ducks get their behavior by being composed with the right behavior object.
Has-a can be better than is-a
As you can see, using composition gives you a lot more flexibility.