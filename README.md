## Game description:
Our project idea is to create a simulation of a two dimensional solar system with orbiting planets. These orbiting planets will be clickable and when one of these planets is clicked, the player will be transported to that planet. On the planet the user can walk around in a Super Mario style 2D world. The end-goal of the program is for the player to reach the end of that planet, by traversing the terrain and interacting with the environment.

## Libraries, framewerks and methods:

### Libraries:
- swing:
  - use JFrame to construct a display and buttons It is a good library for creating a GUI.
- awt:
  - Basic toolkit for user interfacing and creating images and graphics.
- Graphics:
  - Additional graphics library.
-  ActionListener, KeyListener:
  - Tracks the user's buttonpresses and keyboard inputs to interpret the information
  
### Methods:
- Creating the canvas
- Update canvas
- Create circle
- Move circle in orbit around sun (circular)
- Gravitational function (advanced move function)
- Click planet
- Move character (left, right and jump)
- Interaction method

## Installation and usage:
The method of installation for this program will be downloadable with a jar-file and the following java-files. The jar-file will be accompanied by a Manifest file in the top folder, while the java files are placed in the repos's src folder. It is insider the src folder where the program shall be run. As soon as you clone the repo or whatever form of download is utilized, the user must type into src folder's command line/terminal:
```
java -jar ../NoMansBudget.jar
```
Doing so will run the program as expected.

The usage of the program will be to start in a simulation of a solar system. Inside here, the user can travel to one planet by either pressing the 'M' or the 'Enter' button. Doing so will transport the user to the 2D-world where the goal is to reach the end of the map by traversing the terrrain and interacting with the environment. 

The user can move around, either by using the general WASD-keys and optionally, the 'spacebar' for jumping as a substitution for 'W'. There are blocks with skulls on them and a green one with a face. 

These are breakable, and will give the player an item as a means to progress further along the path (speed, jumpboost). The user can destroy these by either clicking or holding down the left or right arrow keys.

If the user is to fall down to the lake, the user will die and start over from the beginning of the location.
