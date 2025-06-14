//Canvas setup
let canvas = document.getElementById('CanvasCT5');
gl = canvas.getContext('experimental-webgl');

// Arrays
let vertices = [
  -1,-1,-1, 1,-1,-1, 1, 1,-1, -1, 1,-1,
  -1,-1, 1, 1,-1, 1, 1, 1, 1, -1, 1, 1,
  -1,-1,-1, -1, 1,-1, -1, 1, 1, -1,-1, 1,
  1,-1,-1, 1, 1,-1, 1, 1, 1, 1,-1, 1,
  -1,-1,-1, -1,-1, 1, 1,-1, 1, 1,-1,-1,
  -1, 1,-1, -1, 1, 1, 1, 1, 1, 1, 1,-1,
];
// 0,0,0, 0,0,0, 0,0,0, 0,0,0, black
// 2 3 6 are showing
//6 faces
let colors = [
  5,3,7, 5,3,7, 5,3,7, 5,3,7,
  0,0,0, 0,0,0, 0,0,0, 0,0,0,
  0,0,1, 0,0,1, 0,0,1, 0,0,1,
  1,0,0, 1,0,0, 1,0,0, 1,0,0,
  1,1,0, 1,1,0, 1,1,0, 1,1,0,
  0,1,0, 0,1,0, 0,1,0, 0,1,0
];

//Functions for buttons
function makeSideBlack() {
  colors.splice(12, 12, 0,0,0, 0,0,0, 0,0,0, 0,0,0);
  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);
}

function randomizeColorRight() {
  let c1 = Math.random() * 7;
  let c2 = Math.random() * 7;
  let c3 = Math.random() * 7;
  colors.splice(12, 12, c1,c2,c3, c1,c2,c3, c1,c2,c3, c1,c2,c3);
  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);
}


let indices = [
  0,1,2, 0,2,3, 4,5,6, 4,6,7,
  8,9,10, 8,10,11, 12,13,14, 12,14,15,
  16,17,18, 16,18,19, 20,21,22, 20,22,23
];

// Vertex buffer
let vertexBuffer = gl.createBuffer ();
gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertices), gl.STATIC_DRAW);

// Color buffer
let colorBuffer = gl.createBuffer ();
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);

// Index Buffer
let indexBuffer = gl.createBuffer ();
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
  'gl_Position = pMatrix*vMatrix*mMatrix*vec4(position, 1.0);'+
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
let squareShaderProgram = gl.createProgram();
gl.attachShader(squareShaderProgram, vertexShader);
gl.attachShader(squareShaderProgram, fragmentShader);
gl.linkProgram(squareShaderProgram);

//Location setup
let pMatrix = gl.getUniformLocation(squareShaderProgram, "pMatrix");
let vMatrix = gl.getUniformLocation(squareShaderProgram, "vMatrix");
let mMatrix = gl.getUniformLocation(squareShaderProgram, "mMatrix");

//binding buffers
//vertex
gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
let position = gl.getAttribLocation(squareShaderProgram, "position");
gl.vertexAttribPointer(position, 3, gl.FLOAT, false,0,0) ;
gl.enableVertexAttribArray(position);
//color
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
let color = gl.getAttribLocation(squareShaderProgram, "color");
gl.vertexAttribPointer(color, 3, gl.FLOAT, false,0,0) ;
gl.enableVertexAttribArray(color);
gl.useProgram(squareShaderProgram);

//View Array
function setUpProjection(angle, adjustment, min, max) {
  let newAngle = Math.tan((angle*.5)*Math.PI/180);
  return [
    0.5 / newAngle, 0 , 0, 0,
    0, 0.5 * adjustment / newAngle, 0, 0,
    0, 0, -(max + min)/(max - min), -1,
    0, 0, (-2*max * min)/(max - min), 0
  ];
}

let projectionArray = setUpProjection(40, canvas.width/canvas.height, 1, 100);

let locationArray = [1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1];
let viewArray = [1,1,0,0, 0,1,0,0, 1,0,1,0, 0,0,0,1];

// Zoom
viewArray[14] = viewArray[14]-7;

function changeZoom(zoom) {
  viewArray[14] = viewArray[14]+zoom;
}

function slideRight() {
  locationArray[14] = locationArray[14] + 1;
}
function slideLeft() {
  locationArray[14] = locationArray[14] - 1;
}

function slideUp() {
  locationArray[12] = locationArray[12] + 1;
}
function slideDown() {
  locationArray[12] = locationArray[12] - 1;
}
//NOTE: Below will happen each time the value on the slider is changed
zoom = document.getElementById("depthSlider").onchange = function() {

  far = event.target.value/2;
  // near = -event.target.value/2;
  // console.log(far);
  // console.log(near);
  //Call slightly changed zoom from earlier
  changeZoomSliderOnly(far);
};

function changeZoomSliderOnly(zoom) {
  //Need to reset the view, before changes to keep zoom consistent
  viewArray = [1,1,0,0, 0,1,0,0, 1,0,1,0, 0,0,0,1];
  viewArray[14] = viewArray[14] + (-7 + zoom);
}


//Final calls to draw
function drawCube() {

  gl.enable(gl.DEPTH_TEST);
  gl.depthFunc(gl.LEQUAL);
  gl.clearColor(0.5, 0.5, 0.5, 0.9);
  gl.clearDepth(1.0);

  gl.viewport(0.0, 0.0, canvas.width, canvas.height);
  gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
  gl.uniformMatrix4fv(pMatrix, false, projectionArray);
  gl.uniformMatrix4fv(vMatrix, false, viewArray);
  gl.uniformMatrix4fv(mMatrix, false, locationArray);
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, indexBuffer);
  gl.drawElements(gl.TRIANGLES, indices.length, gl.UNSIGNED_SHORT, 0);
  window.requestAnimationFrame(drawCube);
}
drawCube();

