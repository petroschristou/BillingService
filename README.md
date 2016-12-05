## Overview

This project was build in Maven, to build/compile the project, just run the following command from the parent directory:

mvn clean install

This will also run the automated tests. 

### Execution

To execute the jar file:

C:\BillingService\target>java -jar billing-service-1.0-SNAPSHOT.jar


When prompted, you enter your menu selection separated by a space.

```
Welcome to Cafe X Menu

1 : Cola

2 : Coffee

3 : Cheese Sandwich

4 : Steak Sandwich

Please select which item number you wish to purchase from the menu separated by a space:
```
1 3 4

So selection here was items 1, 3 and 4.

Note, given the time limits on the project, the data specified is not imported from a data file or database but included statically.

