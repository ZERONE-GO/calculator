RPN Calculator: A command-line RPN calculator

Exact the zip file, and then use *mvn install eclipse:eclipse* to import the project into eclipse. 

### `mvn test` 
run the test cases.

### `mvn clean package`
package and install the execution jar file. 
The jar file was package base on spring boot. 

Use *java -jar calculator-1.0.0* can start and running the projects. 

### Undefined Operator Behavior 

#### `clear`
The clear operator will clear number stack and operator history, and then start a new calculation. 

#### `divide zero`
Will return infinite. 

1.0 0 /
Infinity

#### `sqrt negative number`
Will return NaN

-1.0 sqrt
NaN

### `Factorial`
When number is negative or not integer, will return NaN, when out of the double, it will return Infinite.

-1 !
NaN

10.2 !
NaN

1000 !
Infinity



