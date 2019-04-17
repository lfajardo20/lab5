****Task 1*****

NOTE: To run this app and start testing you will need to start with requirement 3 then you can read instructions for the rest.

Fully implemented and every requirement met.
1)F to C class return just the json string, C to F returns nothing but the xml string with results and what was implemented

2)Precision parameter has been implemented and works with any digit of decimals you put in. NOTE: It will max the number of decimals depending on what you put in. (e.x if you set a decimal place of 20 and the response is only a float/double with a max of 3 decimal places it will stay at 3 decimal places since Zeros don't mean anything)

**How to run Requirement 2**
-The basic url is localhost:8080/path where path is either 'ctofservice' or 'ftocservice'. These will return the default values
-After this path you will add a '/' and then your number, this will return (depending on service xml or json) the result for your request.
-after an number has been entered and you want precision you have to add a parameter. Just like this: ?precision="digit" 
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

NOTE: If you want to run the java -jar command you WILL have to run the command "gradle bootJar" This will make sure to create the jar and place it under
the directory Task1/build/libs/.jar

*****Task 2*****

-Requirements for Task2 have been fully implemented and it is working.
-Dockerfile implemented that when running/creating docker build etc it will build an image and when you run "docker run etc" you will have an image in a container and run the paths just fine. (check for notes at the bottom)

1st NOTE: I am developing this in Docker Toolbox so things are different if you have the legit version of docker.

2nd NOTE: When I say CLI of choice, I mean if you can run docker on bash do that, but if you have docker toolbox, please navigate to the folder where the source of my code is at. Otherwise, you will not be able to run my dockerfile. Docker Toolbox by default has you on a seperate path so you will have to navigate wherever you have my source code in to run the instructions below.

3rd NOTE: if you are running Docker Toolbox, doing localhost:port WILL NOT WORK. you will have to run the command "docker-machine ip default" to obtain the ip you are using and exchange that ip address for localhost. E.x: http://192.168.99.100:8089/ctofservice

1) In the CLI of choice, go to the Task1 folder and run the command "gradle bootJar" Without this step, the image CANNOT be created
2) In the CLI of choice, go to the source tree of my project (where the dockerfile, the README, and .gradle folders are in) in other words "cd ../" from previous step
3) Run the docker build command to start an image. E.x: docker build -t lfajardo_task2 .   <-- period is included-->
4) You should see a message that says "Successfully built <id>"
5) Now run the command to have the image in a container and run it on port 8080 (or your port of choice just make sure it is clear a.k.a nothing is using that port) E.x: docker run -d -p 8089:8080 lfajardo_task2
6) You should see a long id printed. This means that your container is running and you can go to the path of the port specified.
7) All tests should be made just like you tested Task 1. All paths are the same. Precision is still implemented, C to F and F to C services are still implemented and everything is to work as usual.