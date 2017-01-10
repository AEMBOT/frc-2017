# frc-2017
Liberty Robotics 2017 FRC code

# Liberty Robotics Code Guidelines (v2)
When writing any project code, please follow these guidelines to maintain consistency.
## Line Breaks, Whitespace
Use Egyption Style Braces { }, where the opening brace is on the same line as the declaration:
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
