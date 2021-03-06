# AccessorClassGeneration
**Category:** `pmd`<br/>
**Rule Key:** `pmd:AccessorClassGeneration`<br/>


-----

Instantiation by way of private constructors from outside of the constructor’s class often causes the generation of an accessor.
A factory method, or non-privatization of the constructor can eliminate this situation.
The generated class file is actually an interface. It gives the accessing class the ability to invoke a new hidden package scope constructor that takes the interface as a supplementary parameter.
This turns a private constructor effectively into one with package scope, and is challenging to discern.

<h2>Example:</h2>
<pre>
public class Outer {
  void method() {
    Inner ic = new Inner(); // Causes generation of accessor class
  }

  public class Inner {
    private Inner() {}
  }
}
</pre>
