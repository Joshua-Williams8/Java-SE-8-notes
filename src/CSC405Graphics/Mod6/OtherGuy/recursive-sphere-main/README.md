# Recursively Subdivided Sphere

<img src="https://user-images.githubusercontent.com/108101472/210532442-55d57c8e-ff3c-491e-b29d-ec1907389c54.jpg" width="400">

This program generates a 3D recursively subdivided sphere using WebGL and displays it on an HTML canvas element in the browser. The user can interact with the sphere by increasing or decreasing the number of times the triangles of the sphere are subdivided, as well as resetting the sphere to its original state. The sphere can also be rotated in 3D space using the arrow keys on the keyboard.

To run this program, open the recursive-sphere.html file in a web browser. The program should run automatically.

## Features

  * Generates a 3D recursively subdivided sphere using WebGL.
  * Displays the sphere on an HTML canvas element.
  * Allows the user to increase or decrease the number of times the triangles of the sphere are subdivided.
  * Provides a reset button to return the sphere to its original state.
  * Allows the user to rotate the sphere in 3D space using the arrow keys on the keyboard.

## Dependencies

This program has the following dependencies:

  * WebGL: A JavaScript API for rendering interactive 3D graphics in modern web browsers without the use of plug-ins.
  * helpers.js: A file of JavaScript functions for performing matrix and vector operations. It is included in the project directory.
    
## Customization

The following variables in the main.js file can be modified to customize the program:

  * numTimesToSubdivide: The initial number of times to subdivide the triangles of the sphere (default is 3). This controls the level of detail of the sphere.
  * radius: The radius of the sphere (default is 3.0).
  * dr: The change in theta (rotation around the y-axis) per frame (default is 5.0 degrees). This controls the speed of rotation when the user presses the arrow keys.
  * left, right, ytop, and bottom: The boundaries of the view frustum (default is -2.0, 2.0, 2.0, and -2.0, respectively). These values control the size and shape of the viewable area.

## Notes

  * The program uses a tetrahedron as a base for generating the sphere, and recursively divides its triangles to create a smoother approximation of a sphere. This is a common technique for creating spheres in computer graphics.
  * The program uses the normalize function to ensure that the vertices of the sphere are evenly distributed on the surface. This helps to avoid visual artifacts such as distortion or stretching.
