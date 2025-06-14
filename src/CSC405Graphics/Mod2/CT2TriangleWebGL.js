//For displaying any errors that come up
function displayError(text) {
  let errorDiv = document.getElementById('error-text');
  let errorOutputText = document.createElement('p');
  errorOutputText.innerText = text;
  errorDiv.append(errorOutputText);
  //Log it in case the page doesn't display.
  // console.log(text);
}

function webGlCT() {

  let gl = document.querySelector('#CanvasCT2').getContext('webgl');

  gl.clearColor(0, 0.5, 0, 1);
  gl.clear(gl.COLOR_BUFFER_BIT);
  gl.clear(gl.DEPTH_BUFFER_BIT);

// Vertex shader part needs to be compiled in a language called GLSL
//GLSL takes inputs in attributes
  let vertexShaderGLSL = `
  attribute vec2 vertexPosition;

  void main() {
    gl_Position = vec4(vertexPosition, 0, 1);
  }
`;


  let vertexShader = gl.createShader(gl.VERTEX_SHADER);
  gl.shaderSource(vertexShader, vertexShaderGLSL);
  gl.compileShader(vertexShader);
  //If this returns false that means there was an error
  if (!gl.getShaderParameter(vertexShader, gl.COMPILE_STATUS)) {
    let error = gl.getShaderInfoLog(vertexShader);
    displayError("vertex shader: " + error);
    return;
  }

  let fragmentShaderGLSL = `
  precision mediump float;

  void main() {
    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);
  }
`;

  let fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);
  gl.shaderSource(fragmentShader, fragmentShaderGLSL);
  gl.compileShader(fragmentShader);
  //If this returns false that means there was an error
  if (!gl.getShaderParameter(fragmentShader, gl.COMPILE_STATUS)) {
    let error = gl.getShaderInfoLog(fragmentShader);
    displayError("fragment shader: " + error);
    return;
  }

  //You can not actually use either shader on their own, they need to be used together
  //To create what is called a webGL program object
  //Use the same error checking as before except we use program instead of shader
  let triangleShaderProgram = gl.createProgram();
  gl.attachShader(triangleShaderProgram, vertexShader);
  gl.attachShader(triangleShaderProgram, fragmentShader);
  gl.linkProgram(triangleShaderProgram);
  if (!gl.getProgramParameter(triangleShaderProgram, gl.LINK_STATUS)) {
    let error = gl.getProgramInfoLog(triangleShaderProgram);
    displayError("link status: " + error);
    return;
  }

  //This might be where we add the triangles
  //This variable initially should be 0?
  // will be -1 if the call fails
  let positionAttributeLocation = gl.getAttribLocation(triangleShaderProgram, 'vertexPosition');
  if (positionAttributeLocation < 0 ) {
    displayError("Issue with positionAttributeLocation");
    return;
  }
  //Set GPU program
  gl.useProgram(triangleShaderProgram);

  let positionBuffer = gl.createBuffer();
  //input assembler
  gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);

  gl.enableVertexAttribArray(positionAttributeLocation);
  //Needs the vertex points, size, type the buffer is using itself, stride, offset
  gl.vertexAttribPointer(positionAttributeLocation, 2, gl.FLOAT, false,
    0, 0);


//NOTE: Stuff for Fractal Sierpinski Gasket below
  let vertexArray = [];

  let minMaxVerts = [
    [-1, -1],
    [1, -1],
    [0, 1] ];

  //Call this to cut values in half for verts
  function halfVertVals(pointA, pointB) {
    return [
      pointA[0] * 0.5 + pointB[0] * 0.5,
      pointA[1] * 0.5 + pointB[1] * 0.5 ]
  }

  function createTriangles(edgePoints, triangleDepth) {
    // console.log(triangleDepth)
    if(triangleDepth === 0) {

      vertexArray = vertexArray.concat(edgePoints[0]);
      vertexArray = vertexArray.concat(edgePoints[1]);
      vertexArray = vertexArray.concat(edgePoints[2]);
      return vertexArray
    }
    let middlevertexArray = [
      halfVertVals(edgePoints[0], edgePoints[1]),
      halfVertVals(edgePoints[0], edgePoints[2]),
      halfVertVals(edgePoints[1], edgePoints[2]) ];
    // console.log(middlevertexArray[0]);
    // console.log(middlevertexArray[1]);
    // console.log(middlevertexArray[2]);
    console.log(edgePoints[0] + " edgepoints1 " + edgePoints[1]);
    console.log(edgePoints[0] + " edgepoints2 " + edgePoints[2]);
    console.log(edgePoints[1] + " edgepoints3 " + edgePoints[2]);
    //As we create triangles count downwards.
    triangleDepth = triangleDepth - 1;
    createTriangles([edgePoints[0], middlevertexArray[0], middlevertexArray[1]], triangleDepth);
    createTriangles([edgePoints[1], middlevertexArray[0], middlevertexArray[2]], triangleDepth);
    createTriangles([edgePoints[2], middlevertexArray[1], middlevertexArray[2]], triangleDepth);
  }

  createTriangles(minMaxVerts, 3);

  //Javascript by default gives these values 64 bits each, but our GPU wants them to be 32
  //We need to place them into a 32 float array instead
  let triangleVertexFloats = new Float32Array(vertexArray);
  //We have to tell the buffer:
  // what kind of data we are giving it
  // the data it self
  // what it will used for?
  //We are asking for a chunk of memory for this triangle
  gl.bufferData(gl.ARRAY_BUFFER, triangleVertexFloats, gl.STATIC_DRAW);
  gl.drawArrays(gl.TRIANGLE_FAN, 0, vertexArray.length / 2);
  console.log(vertexArray);

}
try {
  webGlCT();
} catch (e) {
  displayError(e);
}
