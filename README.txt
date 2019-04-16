****Task 1*****
Fully implemented and every requirement met.
1)F to C class return just the json string, C to F returns nothing but the xml string with results and what was implemented
2)Precision parameter has been implemented and works with any digit of decimals you put in. NOTE: It will max the number of decimals depending on what you put in. (e.x if you set a decimal place of 20 and the response is only a float/double with a max of 3 decimal places it will stay at 3 decimal places since Zeros don't mean anything.
**How to run Requirement 2**
-The basic url is localhost:8080/path where path is either 'ctofservice' or 'ftocservice'. These will return the default values
-After this path you will add a '/' and then your number, this will return (depending on service xml or json) the result for your request.
-after an number has been entered but you want precision you have to add a parameter as such ?precision="digit" 
-Keep in mind that that goes after your number (e.g localhost:8080/ctofservice/35?precision=2)
NOTE: if you don't want any decimal places and you want a full number, have your precision value be "0"
3)Service deploys perfectly fine
**How to run requirement 3**
-You will need gradle installed in order to make this web app run.
-To be able to make the web app run you will have to be inside the Task 1 tree.
-Once inside the tree, run the command "gradle bootRun" and you should see the following (after the big SPRING thingy)

<=========----> 75% EXECUTING [1m 10s]
> :bootRun

-This means it is running even though it says 75%
-Go to your path of choice "localhost:8080/path" and start testing!
-to clean the build you will have to run "./gradlew clean" and that should get rid of everything.

*****Task 2*****