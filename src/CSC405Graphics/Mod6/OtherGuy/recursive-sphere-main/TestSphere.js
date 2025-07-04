
/* Initialize variables for number of times to subdivide the triangles,
current index, and array of vertex positions */
var numTimesToSubdivide = 3;
var index = 0;
var positions = [];

/* Initialize variables for near and far clipping planes, radius,
and angles for spherical coordinates */
var near = -10;
var far = 10;
var radius = 3.0;
var theta = 0.0;
var phi = 0.0;
var dr = 5.0 * Math.PI / 180.0; // dr is the change in theta per frame

// Initialize variables for left, right, top, and bottom boundaries of the view frustum
var left = -2.0;
var right = 2.0;
var ytop = 2.0;
var bottom = -2.0;

// Initialize the model view and projection matrices
var modelViewMatrix, projectionMatrix;
// Get the locations of the model view and projection matrix uniforms in the shaders
var modelViewMatrixLoc, projectionMatrixLoc;
// Declare and initialize values for the model view matrix
var eye;
const at = vec3(0.0, 0.0, 0.0);
const up = vec3(0.0, 1.0, 0.0);

// Generate the vertices of a sphere approximation by subdividing the triangles of the tetrahedron
function triangle(a, b, c) {
  positions.push(a);
  positions.push(b);
  positions.push(c);
  index += 3;
}

// Recursively divide a triangle into smaller triangles until the desired number of subdivisions is reached
function divideTriangle(a, b, c, count) {
  if (count > 0) {
    // Calculate the midpoints of the sides of the triangle
    var ab = normalize(mix(a, b, 0.5), true);
    var ac = normalize(mix(a, c, 0.5), true);
    var bc = normalize(mix(b, c, 0.5), true);

    // Recursively divide the four resulting triangles
    divideTriangle(a, ab, ac, count - 1);
    divideTriangle(ab, b, bc, count - 1);
    divideTriangle(bc, c, ac, count - 1);
    divideTriangle(ab, bc, ac, count - 1);
  }
  else { // draw tetrahedron at end of recursion
    triangle(a, b, c);
  }
}

// Initialize the vertices of the tetrahedron and divide its triangles the specified number of times
function tetrahedron(a, b, c, d, n) {
  divideTriangle(a, b, c, n);
  divideTriangle(d, c, b, n);
  divideTriangle(a, d, b, n);
  divideTriangle(a, c, d, n);
}

// Initialize WebGL context
const canvas = document.getElementById('canvas');
const gl = canvas.getContext('webgl');

// Set clear color and enable depth testing
gl.viewport(0, 0, canvas.width, canvas.height);
gl.clearColor(0.0, 0.0, 0.0, 1.0);
gl.enable(gl.DEPTH_TEST);
gl.depthFunc(gl.LESS);
gl.enable(gl.POLYGON_OFFSET_FILL);
gl.polygonOffset(1.0, 2.0);

// Set up the buttons for increasing/decreasing the number of times the triangles are subdivided
document.getElementById("increase-subdivision").addEventListener("click", function () {
  if (numTimesToSubdivide < 8) { // limit the maximum number of subdivisions
    numTimesToSubdivide++;
    index = 0; // reset index
    positions = []; // clear positions array
    tetrahedron(va, vb, vc, vd, numTimesToSubdivide); // create new sphere with updated number of subdivisions
    gl.bufferData(gl.ARRAY_BUFFER, flatten(positions), gl.STATIC_DRAW); // update the vertex buffer with new positions
  }
});
document.getElementById("decrease-subdivision").addEventListener("click", function () {
  if (numTimesToSubdivide > 0) { // limit the minimum number of subdivisions
    numTimesToSubdivide--;
    index = 0; // reset index
    positions = []; // clear positions array
    tetrahedron(va, vb, vc, vd, numTimesToSubdivide); // create new sphere with updated number of subdivisions
    gl.bufferData(gl.ARRAY_BUFFER, flatten(positions), gl.STATIC_DRAW); // update the vertex buffer with new positions
  }
});
document.getElementById("reset-button").addEventListener("click", function () {
  numTimesToSubdivide = 3; // reset number of subdivisions
  index = 0; // reset index
  positions = []; // clear positions array
  theta = 0.0;
  phi = 0.0;
  tetrahedron(va, vb, vc, vd, numTimesToSubdivide); // create new sphere with updated number of subdivisions
  gl.bufferData(gl.ARRAY_BUFFER, flatten(positions), gl.STATIC_DRAW); // update the vertex buffer with new positions
});

// Set up flag to track whether the button is being held
let isButtonHeld = false;

window.addEventListener('keydown', function (event) {
  switch (event.keyCode) {
    case 37: // left arrow key
      // Start the rotation if the button is not already being held
      if (!isButtonHeld) {
        isButtonHeld = true;
        // Start the timer to update theta
        let timer = setInterval(function () {
          theta += Math.PI / 90; // rotate the sphere to the left
        }, 1000 / 60); // update at 60 fps
        window.addEventListener('keyup', function stopRotation() {
          // Stop the rotation when the button is released
          isButtonHeld = false;
          clearInterval(timer);
          window.removeEventListener('keyup', stopRotation);
        });
      }
      break;
    case 38: // up arrow key
      // Start the rotation if the button is not already being held
      if (!isButtonHeld) {
        isButtonHeld = true;
        // Start the timer to update phi
        let timer = setInterval(function () {
          phi += Math.PI / 90; // rotate the sphere straight up
        }, 1000 / 60); // update at 60 fps
        window.addEventListener('keyup', function stopRotation() {
          // Stop the rotation when the button is released
          isButtonHeld = false;
          clearInterval(timer);
          window.removeEventListener('keyup', stopRotation);
        });
      }
      break;
    case 39: // right arrow key
      // Start the rotation if the button is not already being held
      if (!isButtonHeld) {
        isButtonHeld = true;
        // Start the timer to update theta
        let timer = setInterval(function () {
          theta -= Math.PI / 90; // rotate the sphere to the right
        }, 1000 / 60); // update at 60 fps
        window.addEventListener('keyup', function stopRotation() {
          // Stop the rotation when the button is released
          isButtonHeld = false;
          clearInterval(timer);
          window.removeEventListener('keyup', stopRotation);
        });
      }
      break;
    case 40: // down arrow key
      // Start the rotation if the button is not already being held
      if (!isButtonHeld) {
        isButtonHeld = true;
        // Start the timer to update phi
        let timer = setInterval(function () {
          phi -= Math.PI / 90; // rotate the sphere straight down
        }, 1000 / 60); // update
        window.addEventListener('keyup', function stopRotation() {
          // Stop the rotation when the button is released
          isButtonHeld = false;
          clearInterval(timer);
          window.removeEventListener('keyup', stopRotation);
        });
      }
      break;
  }
});
// Create the vertex shader
var vertexShader = gl.createShader(gl.VERTEX_SHADER);
var vertexShaderSource = `
            attribute vec4 aVertexPosition;
            uniform mat4 uModelViewMatrix;
            uniform mat4 uProjectionMatrix;
            void main() {
                gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition;
            }
        `;
gl.shaderSource(vertexShader, vertexShaderSource);
gl.compileShader(vertexShader);

// Create the fragment shader
var fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);
var fragmentShaderSource = `
            precision mediump float;
            void main() {
                gl_FragColor = vec4(0.0, 0.8, 0.0, 1.0);
            }
        `;
gl.shaderSource(fragmentShader, fragmentShaderSource);
gl.compileShader(fragmentShader);

// Create the program and link the shaders
var program = gl.createProgram();
gl.attachShader(program, vertexShader);
gl.attachShader(program, fragmentShader);
gl.linkProgram(program);
gl.useProgram(program);

var va = vec4(0.0, 0.0, -1.0, 1);
var vb = vec4(0.0, 0.942809, 0.333333, 1);
var vc = vec4(-0.816497, -0.471405, 0.333333, 1);
var vd = vec4(0.816497, -0.471405, 0.333333, 1);

tetrahedron(va, vb, vc, vd, numTimesToSubdivide);

// Create a vertex buffer object (VBO) and bind it to the WebGL context
var positionBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
gl.bufferData(gl.ARRAY_BUFFER, flatten(positions), gl.STATIC_DRAW);

var aVertexPosition = gl.getAttribLocation(program, 'aVertexPosition');
gl.vertexAttribPointer(aVertexPosition, 4, gl.FLOAT, false, 0, 0);
gl.enableVertexAttribArray(aVertexPosition);

// Set up the vertex shader to accept the VBO as an input and transform the vertices
uModelViewMatrix = gl.getUniformLocation(program, 'uModelViewMatrix');
uProjectionMatrix = gl.getUniformLocation(program, 'uProjectionMatrix');

// Render the sphere
function render() {
  gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

  // Calculate the model-view matrix
  eye = vec3(radius * Math.sin(theta) * Math.cos(phi),
    radius * Math.sin(theta) * Math.sin(phi), radius * Math.cos(theta));

  // Initialize the model view and projection matrices
  modelViewMatrix = lookAt(eye, at, up);
  projectionMatrix = ortho(left, right, bottom, ytop, near, far);

  // Set the model-view and projection matrices
  gl.uniformMatrix4fv(uModelViewMatrix, false, flatten(modelViewMatrix));
  gl.uniformMatrix4fv(uProjectionMatrix, false, flatten(projectionMatrix));

  // Draw the sphere
  for (var i = 0; i < index; i += 3) {
    gl.drawArrays(gl.LINE_LOOP, i, 3);
  }
  requestAnimationFrame(render);
}

// Start rendering the sphere
render();
