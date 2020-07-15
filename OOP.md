Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation

Encapsulation is a 2-fold concept.  The first idea is to bundle data (properties) and actions (methods)
that operate together.  This is represented by the classes (which contain the properties, as well as the
methods that manipulate or reference those properties).  The second idea is to hide the inner workings of
the program from the outside.  Only the properties and methods ABSOLUTELY necessary should be accessible
to components outside the class.  This is accomplished via access modifiers and using getters and setters
when accessing or manipulating data stored within classes.


********************
2. Inheritance

Inheritance is represented by an "IS-A" relationship.  It is the idea of basing one class (the subclass) on
another (the parent).  The subclass can INHERIT certain methods from the parent class.  These methods, if
not overridden by the subclass, will be implemented as written in the parent.  The child class can, 
however, override these methods to implement it's own as long as the method signature remains the same.
This is represented in my code with the parent Piece class being extended by each of it's subclasses.  The 
subclasses INHERIT the getter methods defined within the parent, as well as overriding the abstract 
legalMoves() method of the parent.


********************
1. Abstraction

Abstraction is hiding unnecessary detail and only exposing the relavent information.  It is similar to
encapsulation in that respect.  Abstraction, however, is more concerned with the external results of the 
entity, while encapsulation is more concerned with hiding the internal details.  Abstraction is more reusable because it is only concerned with the input and output of the method or class and leaves the inner working completely out of the equation, while encapsulation is ONLY concerned with the inner workings and hiding these internal workings from the outside.  Abstraction is implemented using the Interface type and the "abstract" keyword.



********************
1. Polymorphism

Polymorphism is the idea that one object can take on multiple forms.  In my code, for example, a Bishop and a Rook are completely different pieces and each follows their own movement rules, but each are of just different versions of the Piece parent class; each are different FORMS of a single type.  They each have legal moves (represented by their legalMoves() method), but even though the method name is the same for both of them, the result of the method is distinct to each of them individually.  Even within a single class, though, polymorphism can still exist.  For example, the sum of two numbers is calculated when they are "added" together, but if you have a string and want to append more information to that string, you can also "add" information to that string as well.  While this could be done with a numberAdd() method and a stringAdd() method, it isn't necessary to create seperate method names to seperate the ideas.  Polymorphism allows us to create two separate add() methods with different signatures (one which takes two numbers and produces a number, and another that takes two strings and produces a string) and the program will know which method to run based on parameters passed to it.






Please write a 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



