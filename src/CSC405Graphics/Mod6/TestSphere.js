//Canvas setup
let canvas = document.getElementById('CanvasCT6');
let gl = canvas.getContext('experimental-webgl');

// Define tetrahedron vertices - using your original coordinates
let vertices = [
  //side A
  0.0, 0.0, -1.0,
  //side B
  0.0, 0.942809, 0.333333,
  //side C
  -0.816497, -0.471405, 0.333333,
  //side D
  0.816497, -0.471405, 0.333333
];
// variables from book below:
let index = 0;
let va = vec4(0.0, 0.0, -1.0, 1);
let vb = vec4(0.0, 0.942809, 0.333333, 1);
let vc = vec4(-0.816497, -0.471405, 0.333333, 1);
let vd = vec4(0.816497, -0.471405, 0.333333, 1);

// Colors for each vertex
let colors = [
  //side A
  1.0, 1.0, 1.0, // white
  //side B
  1.0, 0.0, 0.0, // red
  //side C
  0.0, 1.0, 0.0, // green
  //side D
  0.0, 0.0, 1.0  // blue
];

// Indices defining the 4 triangular faces of tetrahedron
let indices = [
  //side A
  1, 2, 3,
  //side B
  0, 1, 3,
  //side C
  0, 3, 2,
  //side D
  0, 2, 1
];
//Adding in for sphere below
let divideCount = 0;

//Caused an error when it would run forever.
function triangleTest(a, b, c) {
  a.forEach(function(vert) {
    vertices.push(vert);
  });
  b.forEach(function(vert) {
    vertices.push(vert);
  });
  c.forEach(function(vert) {
    vertices.push(vert);
  });
  index += 3;
}

function triangle(a, b, c) {
  vertices.push(a);
  vertices.push(b);
  vertices.push(c);
  index += 3;
}

//Should take triangle and divide them in half (from book)
function divideTriangle(a, b, c, count) {
  if (count > 0) {
    var ab = normalize(mix(a, b, 0.5), true);
    var ac = normalize(mix(a, c, 0.5), true);
    var bc = normalize(mix(b, c, 0.5), true);

    divideTriangle( a, ab, ac, count - 1);
    divideTriangle(ab,   b, bc, count - 1);
    divideTriangle(bc,   c, ac, count - 1);
    divideTriangle(ab, bc, ac, count - 1);
  }
  else {
    triangle(a, b, c);
  }
}
//Creates the tetrahedron (from book)
function tetrahedron(a, b, c, d, n) {
  divideTriangle(a, b, c, n);
  divideTriangle(d, c, b, n);
  divideTriangle(a, d, b, n);
  divideTriangle(a, c, d, n);
}

//Below is called on our button.
function increaseDetail() {
  //Limit the amount of times
  if (divideCount < 9) {
    vertices = [];
    index = 0;
    divideCount = divideCount + 1;
    tetrahedron(va, vb, vc, vd, divideCount);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW); // update the vertex buffer with new positions
  }
}

function decreaseDetail() {
  //Limit the amount of times
  if (divideCount > 0) {
    vertices = [];
    index = 0;
    divideCount = divideCount - 1;
    tetrahedron(va, vb, vc, vd, divideCount);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW); // update the vertex buffer with new positions

  }
}


//Functions for buttons
function makeSideBlack() {
  colors.splice(0, 12, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
  gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);
}

function randomizeColors() {
  colors = [
    Math.random(), Math.random(), Math.random(), // Vertex 1 color
    Math.random(), Math.random(), Math.random(), // Vertex 2 color
    Math.random(), Math.random(), Math.random(), // Vertex 3 color
    Math.random(), Math.random(), Math.random()  // Vertex 4 color
  ];
  gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);
}

// Vertex buffer
let vertexBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertices), gl.STATIC_DRAW);

// Color buffer
let colorBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);

// Index Buffer
let indexBuffer = gl.createBuffer();
gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, indexBuffer);
gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(indices), gl.STATIC_DRAW);

//GLSL Code
let vertexShaderGLSL = 'attribute vec3 position;'+
  'uniform mat4 pMatrix;'+
  'uniform mat4 vMatrix;'+
  'uniform mat4 mMatrix;'+
  'attribute vec3 color;'+
  'varying vec3 vColor;'+

  'void main(void) { '+
  'gl_Position = pMatrix*vMatrix*mMatrix*vec4(position, 1.);'+
  'vColor = color;'+
  '}';

let fragmentShaderGLSL = 'precision mediump float;'+
  'varying vec3 vColor;'+
  'void main(void) {'+
  'gl_FragColor = vec4(vColor, 1.0);'+
  '}';

//Shader setup
let vertexShader = gl.createShader(gl.VERTEX_SHADER);
gl.shaderSource(vertexShader, vertexShaderGLSL);
gl.compileShader(vertexShader);

let fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);
gl.shaderSource(fragmentShader, fragmentShaderGLSL);
gl.compileShader(fragmentShader);

//Program setup
let sphereShaderProgram = gl.createProgram();
gl.attachShader(sphereShaderProgram, vertexShader);
gl.attachShader(sphereShaderProgram, fragmentShader);
gl.linkProgram(sphereShaderProgram);

let pMatrix = gl.getUniformLocation(sphereShaderProgram, "pMatrix");
let vMatrix = gl.getUniformLocation(sphereShaderProgram, "vMatrix");
let mMatrix = gl.getUniformLocation(sphereShaderProgram, "mMatrix");

//binding buffers
//vertex
gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
let position = gl.getAttribLocation(sphereShaderProgram, "position");
gl.vertexAttribPointer(position, 3, gl.FLOAT, false, 0, 0);
gl.enableVertexAttribArray(position);
//color
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
let color = gl.getAttribLocation(sphereShaderProgram, "color");
gl.vertexAttribPointer(color, 3, gl.FLOAT, false, 0, 0);
gl.enableVertexAttribArray(color);
gl.useProgram(sphereShaderProgram);

//View Array
function setUpProjection(angle, adjustment, min, max) {
  let newAngle = Math.tan((angle * 0.5) * Math.PI / 180);
  return [
    0.5 / newAngle, 0, 0, 0,
    0, 0.5 * adjustment / newAngle, 0, 0,
    0, 0, -(max + min) / (max - min), -1,
    0, 0, (-2 * max * min) / (max - min), 0
  ];
}

let projectionArray = setUpProjection(30, canvas.width / canvas.height, 1, 100);

// Initial transformation matrices
let locationArray = [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1];
let viewArray = [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, -7, 1]; // Initial view distance

// Functions for camera control
function changeZoom(zoom) {
  viewArray[14] = viewArray[14] + zoom;
}

function slideRight() {
  locationArray[12] = locationArray[12] + 0.5;
}

function slideLeft() {
  locationArray[12] = locationArray[12] - 0.5;
}

function slideUp() {
  locationArray[13] = locationArray[13] + 0.5;
}

function slideDown() {
  locationArray[13] = locationArray[13] - 0.5;
}

// Function for slider
function changeZoomSliderOnly(zoom) {
  // Reset the view, before changes to keep zoom consistent
  viewArray = [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1];
  viewArray[14] = -7 + zoom;
}

// Listen for slider changes
if (document.getElementById("depthSlider")) {
  document.getElementById("depthSlider").onchange = function(event) {
    let far = event.target.value / 2;
    changeZoomSliderOnly(far);
  };
}

rotate = document.getElementById("rotateSlider").onchange = function() {
  far = event.target.value/2;
  // console.log(far);
  //Same deal here need to reset the location array so slider changes don't save over original forever
  locationArray = [1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1];
  rotateFunction(locationArray, far);
};

function rotateFunction(locArray, value) {
  //Need the original array values for last part
  let originalLocationArray = [1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1];
  let cos = Math.cos(value);
  let sin = Math.sin(value);

  locArray[0] = cos * locArray[0] + sin * locArray[2];
  locArray[4] = cos * locArray[4] + sin * locArray[6];
  locArray[8] = cos * locArray[8] + sin * locArray[10];

  locArray[2] = cos * locArray[2] - sin * originalLocationArray[0];
  locArray[6] = cos * locArray[6] - sin * originalLocationArray[4];
  locArray[10] = cos * locArray[10] - sin * originalLocationArray[8];
}

//Final rendering function
function draw() {
  gl.enable(gl.DEPTH_TEST);
  gl.depthFunc(gl.LEQUAL);
  gl.clearColor(0.5, 0.5, 0.5, 0.9);
  gl.clearDepth(1.0);

  gl.viewport(0.0, 0.0, canvas.width, canvas.height);
  gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
  gl.uniformMatrix4fv(pMatrix, false, new Float32Array(projectionArray));
  gl.uniformMatrix4fv(vMatrix, false, new Float32Array(viewArray));
  gl.uniformMatrix4fv(mMatrix, false, new Float32Array(locationArray));
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, indexBuffer);
  gl.drawElements(gl.TRIANGLES, indices.length, gl.UNSIGNED_SHORT, 0);


  window.requestAnimationFrame(draw);


}

draw();
