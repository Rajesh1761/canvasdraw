"# canvasdraw" 
Project Title:
------------------------------------------------
A simple console version of a drawing program.

Prerequisites:
------------------------------------------------
Java 1.8

Future implementation:
------------------------------------------------
1) All messages will be put in property files, so whenever we want change any thing in messages we do not require any deployment.
2) More exception can be handled.


How to run the program:
------------------------------------------------
1) un-zip the drawingcanvas file.
2) Go to target folder on extracted location.
3) Now open command prompt at same location and enter below command.
4) java -jar canvasdrawing.jar
5) Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q

