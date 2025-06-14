let canvas = document.getElementById("canvasCT6");
let gl = canvas.getContext("experimental-webgl");
gl.viewport(0, 0, canvas.width, canvas.height);
gl.clearColor(0.5, 0.5, 0.5, 1);
gl.clear(gl.COLOR_BUFFER_BIT);
// gl.enable(gl.DEPTH_TEST);

//GLSL Code
let vertexShaderGLSL =
  'attribute vec3 vertexPosition;' +
  'attribute vec3 vColor;' +
  'varying vec4 color;' +
  'void main() {' +
  'gl_Position = vec4(vertexPosition, 2.0);' +
  '    color = vec4(vColor,1.0);' +
  '}'

let fragmentShaderGLSL =
  'precision mediump float;' +
  'varying vec4 color;' +
  '' +
  'void main() {' +
  '   gl_FragColor = color;' +
  '}';

let vertexShader = gl.createShader(gl.VERTEX_SHADER);
gl.shaderSource(vertexShader, vertexShaderGLSL);
gl.compileShader(vertexShader);

let fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);
gl.shaderSource(fragmentShader, fragmentShaderGLSL);
gl.compileShader(fragmentShader);

let sphereProgram = gl.createProgram();
gl.attachShader(sphereProgram, vertexShader);
gl.attachShader(sphereProgram, fragmentShader);
gl.linkProgram(sphereProgram);

// var va = vec4(0.0, 0.0, -1.0, 1);
// var vb = vec4(0.0, 0.942809, 0.333333, 1);
// var vc = vec4(-0.816497, -0.471405, 0.333333, 1);
// var vd = vec4(0.816497, -0.471405, 0.333333, 1);


// tetrahedron(va, vb, vc, vd, numTimesToSubdivide);

let vertices = [
  //side A
  0.0, 0.0, -1.0,
  //side B
  0.0, 1.0, 0.5,
  //side C
  -1.0, -0.5, 0.5,
  //side D
  1.0, -0.5, 0.5
];

let indices = [
  //side A
  1, 2, 3,
  //side B
  2, 3, 0,
  //side C
  3, 0, 1,
  //side D
  0, 1, 2
];

let colors = [
  //side A
  1.0,  1.0,  1.0, // white
  //side B
  1.0,  0.0,  0.0, //  red
  //side C
  0.0,  1.0,  0.0, //  green
  //side D
  0.0,  0.0,  1.0  // blue
];

let itemDimension = 3;

//Color Buffer
let colorBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);
sphereProgram.vColor = gl.getAttribLocation(sphereProgram, "vColor");
gl.enableVertexAttribArray(sphereProgram.vColor);
gl.vertexAttribPointer(sphereProgram.vColor, 3, gl.FLOAT, false, 0, 0);


//Vertex Buffer
let vertexBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertices), gl.STATIC_DRAW);
sphereProgram.vertexPosition = gl.getAttribLocation(sphereProgram, "vertexPosition");
gl.enableVertexAttribArray(sphereProgram.vertexPosition);
gl.vertexAttribPointer(sphereProgram.vertexPosition, itemDimension, gl.FLOAT, false, 0, 0);

// Index Buffer
let indexBuffer = gl.createBuffer();
gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, indexBuffer);
gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(indices), gl.STATIC_DRAW);
gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, indexBuffer);

//
// let numItems = vertices.length / itemDimension;

gl.useProgram(sphereProgram);

gl.clear(gl.COLOR_BUFFER_BIT);
gl.clear(gl.DEPTH_BUFFER_BIT);
gl.viewport(0.0, 0.0, canvas.width, canvas.height);
gl.drawElements(gl.TRIANGLES, indices.length, gl.UNSIGNED_SHORT, 0 );
