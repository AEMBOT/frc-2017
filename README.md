# frc-2017
Liberty Robotics 2017 FRC code

# Liberty Robotics Code Guidelines (v2)
When writing any project code, please follow these guidelines to maintain consistency.
## Line Breaks, Whitespace
Use Egyptian Style Braces { }, where the opening brace is on the same line as the declaration:
```
void someMethod() {
  //code
}
```
Put spaces on either side of an operator, EXCEPT with unary operators:
```
int a = b + c;
boolean d = e || f && g;

//DO NOT use a space with unary operators
a++;
d = !e;

```
Blocks should be logically seperated with line breaks as appropiate:
```
determineDirection();
moveToPoint();

prepareForAction();
```
In languages where pointers are declared (not Java), the ```*``` should be associated with the type, not the field.
```
int* ptr; // conforms
// as opposed to
int *ptr; // does not conform
```
## Naming Conventions
Variables and methods should be typed in camelBack. Classes  should be typed in PascalCase.
```
SystemsManager sysManager = new SystemsManager();
```
Constants which are only used in the local scope may be in all capitals. However, constants which are accessible members must be in PascalCase.
```
public final int SystemIdentifier = 0;

...

final int SYSTEM_ID = SystemsManager.SystemIdentifier;
```
In a ```for``` loop, ```i``` should be the primary iterator, ```j``` the secondary iterator if necessary, ```k``` the third, and so on...
```
for (int i = 0; i < sizeX; i++) {
  for (int j = 0; j < sizeY; j++) {
    //code
  }
}
```
Side Note: As seen above, your braces should close on the same level of indentation as their opening statement.
## Organization
In python, all functions should be defined at the top of the file, BEFORE the main block.
```
def a():

def b():

a()
b()
```
In classes, accessors and mutators should be defined at the end of the class, getter then setter, in the order that the members are declared. 
```
public class Example {
  private int x;
  private double y, z;
  
  public Example() {}
  
  private doSomething() {}
  
  public int getX() {}
  
  public void setX(int x) {}
  
  public double getY() {}
  
  public void setY(double y) {}
  
  public double getZ() {}
  
  public void setZ (double z) {}
}
  ```
## Attribution
"Cite your sources!". No, really. FIRST allows (even encourages) sharing code. Make sure to respect the licenses of all public code, and it goes without saying that you should provide attribution to any adopted blocks. This can be as simple as commenting a URL with the source (Yes, cite StackOverflow if you steal a StackOverflow example, although that is less likely to come up in robotics). Changing the names of tokens (variables, method names, etc) does not magically make it your code!
