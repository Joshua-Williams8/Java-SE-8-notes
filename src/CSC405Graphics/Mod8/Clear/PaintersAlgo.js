// function main() {
// Get A WebGL context
/** @type {HTMLCanvasElement} */
var canvas = document.querySelector("#canvas");
var gl = canvas.getContext("webgl");

function calculateDiagSize(a, b) {
  aSquared = a * a;
  bSquared = b * b;
  cSquared = aSquared + bSquared;
  c = Math.sqrt(cSquared);
}

//I want to hide an object if the object in front of it
// If 2d space is greater than the object in front
//a is the b and h, and z is the zoom.
function areaTaken(a, z) {
  return Math.abs((a * a) * z );
}

//z zoom
// first objects area taken
// second objects area taken
//third objects area taken
function hideShape(a, b ,c) {
  let output = [];
  //We want to see which shape is in front, and render that one no matter how small they are
  let sphereZoom = sphereTranslation[2];
  let cubeZoom = cubeTranslation[2];
  let coneZoom = coneTranslation[2];
  if (sphereZoom >= cubeZoom && sphereZoom >= coneZoom) {
    output.push("a")
  }
  if (cubeZoom >= sphereZoom && cubeZoom >= coneZoom) {
    output.push("b")
  }
  if (coneZoom >= sphereZoom && coneZoom >= cubeZoom) {
    output.push("c")
  }
  if (a >= b && a >= c) {
    //Display a for sure
    output.push("a");
    if (b > c) {
      output.push("b");
      //Display b but not c
    } else if (c > b) {
      output.push("c");
      //Display c
    } else {
      //Display all 3
      output.push("b");
      output.push("c");
    }
    return output;
  } else if ( b >= a && b >= c) {
    //Display b for sure
    output.push("b");
    if (a > c) {
      //Display a but not c
      output.push("a");
    } else if (c > a) {
      //Display c
      output.push("c");
    } else {
      //Display all 3
      output.push("a");
      output.push("c");
    }
    return output;
  } else if ( c >= a && c >= b) {
    //display c for sure
    output.push("c");
    if (a > b) {
      //Display a but not b
      output.push("a");
    } else if (b > a) {
      //Display b
      output.push("b");
    } else {
      //Display all 3
      output.push("a");
      output.push("b");
    }
    return output;
  }
  return output;
}

//If one object seems to be too small to be displayed then do not draw that object
//We will reset the objects to draw array, and only add the objects we decide are visible
//Using 2d math to see if the area of the object in front is too large for the object behind to be seen
function changeObjectsToDraw(letters) {
  objectsToDraw =  [];

  var addSphere =
    {
    programInfo: programInfo,
    bufferInfo: sphereBufferInfo,
    uniforms: sphereUniforms,
  };
  var addCube =
    {
      programInfo: programInfo,
      bufferInfo: cubeBufferInfo,
      uniforms: cubeUniforms,
    };
  var addCone =
    {
      programInfo: programInfo,
      bufferInfo: coneBufferInfo,
      uniforms: coneUniforms,
    };
  if (letters.includes("a")) {
    objectsToDraw.push(addSphere);
  }
  if (letters.includes("b")) {
    objectsToDraw.push(addCube);
  }
  if (letters.includes("c")) {
    objectsToDraw.push(addCone);
  }

}



// creates buffers with position, normal, texcoord, and vertex color
// data for primitives by calling gl.createBuffer, gl.bindBuffer,
// and gl.bufferData
const sphereBufferInfo = primitives.createSphereWithVertexColorsBufferInfo(gl, 10, 12, 6);
const cubeBufferInfo   = primitives.createCubeWithVertexColorsBufferInfo(gl, 20);
const coneBufferInfo   = primitives.createTruncatedConeWithVertexColorsBufferInfo(gl, 10, 0, 20, 12, 1, true, false);

// setup GLSL program
var programInfo = webglUtils.createProgramInfo(gl, ["vertex-shader-3d", "fragment-shader-3d"]);

function degToRad(d) {
  return d * Math.PI / 180;
}

var fieldOfViewRadians = degToRad(60);

// Uniforms for each object.
var sphereUniforms = {
  u_colorMult: [0.5, 1, 0.5, 1],
  u_matrix: m4.identity(),
};
var cubeUniforms = {
  u_colorMult: [1, 0.5, 0.5, 1],
  u_matrix: m4.identity(),
};
var coneUniforms = {
  u_colorMult: [0.5, 0.5, 1, 1],
  u_matrix: m4.identity(),
};

// W/E, N/S, I/O (West/East North/South, Zoom In/Out
//We want to change the bottom here.
var sphereTranslation = [  0, 0, 10];
var cubeTranslation   = [ 0, 0, 20];
var coneTranslation   = [ 0, 0, -20];

function MoveSphere(zoom) {
  sphereTranslation[2] = sphereTranslation[2] + zoom;
  drawScene();
}

function MoveCube(zoom) {
  cubeTranslation[2] = cubeTranslation[2] + zoom;
  drawScene();
}

function MoveCone(zoom) {
  coneTranslation[2] = coneTranslation[2] + zoom;
  drawScene();
}

var objectsToDraw = [
  {
    programInfo: programInfo,
    bufferInfo: sphereBufferInfo,
    uniforms: sphereUniforms,
  },
  {
    programInfo: programInfo,
    bufferInfo: cubeBufferInfo,
    uniforms: cubeUniforms,
  },
  {
    programInfo: programInfo,
    bufferInfo: coneBufferInfo,
    uniforms: coneUniforms,
  },
];



function computeMatrix(viewProjectionMatrix, translation, xRotation, yRotation) {
  var matrix = m4.translate(viewProjectionMatrix,
    translation[0],
    translation[1],
    translation[2]);
  matrix = m4.xRotate(matrix, xRotation);
  return m4.yRotate(matrix, yRotation);
}

requestAnimationFrame(drawScene);

function drawScene() {


  webglUtils.resizeCanvasToDisplaySize(gl.canvas);

  // Tell WebGL how to convert from clip space to pixels
  gl.viewport(0, 0, gl.canvas.width, gl.canvas.height);

  gl.enable(gl.CULL_FACE);
  gl.enable(gl.DEPTH_TEST);

  // Clear the canvas AND the depth buffer.
  gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

  // Compute the projection matrix
  var aspect = gl.canvas.clientWidth / gl.canvas.clientHeight;
  var projectionMatrix =
    m4.perspective(fieldOfViewRadians, aspect, 1, 2000);

  // Compute the camera's matrix using look at.
  var cameraPosition = [0, 0, 100];
  var target = [0, 0, 0];
  var up = [0, 1, 0];
  var cameraMatrix = m4.lookAt(cameraPosition, target, up);

  // Make a view matrix from the camera matrix.
  var viewMatrix = m4.inverse(cameraMatrix);

  var viewProjectionMatrix = m4.multiply(projectionMatrix, viewMatrix);

  //Removed the rotation by setting everything to 0.
  var sphereXRotation =  0;
  var sphereYRotation =  0;
  var cubeXRotation   = 0;
  var cubeYRotation   =  0;
  var coneXRotation   =  0;
  var coneYRotation   = 0;

  // Compute the matrices for each object.
  sphereUniforms.u_matrix = computeMatrix(
    viewProjectionMatrix,
    sphereTranslation,
    sphereXRotation,
    sphereYRotation);

  cubeUniforms.u_matrix = computeMatrix(
    viewProjectionMatrix,
    cubeTranslation,
    cubeXRotation,
    cubeYRotation);

  coneUniforms.u_matrix = computeMatrix(
    viewProjectionMatrix,
    coneTranslation,
    coneXRotation,
    coneYRotation);

  // ------ Draw the objects --------

  //Check the sizes of each object on screen.
  //If one object seems to be too small to be displayed then do not draw that object
  changeObjectsToDraw(hideShape(areaTaken(10, sphereTranslation[2]), areaTaken(10, cubeTranslation[2]), areaTaken(10, coneTranslation[2]) ));
  //Logs for checking my functions in action
  console.log(hideShape(areaTaken(10, sphereTranslation[2]), areaTaken(10, cubeTranslation[2]), areaTaken(10, coneTranslation[2]) ));
  console.log(areaTaken(10, sphereTranslation[2]));
  console.log(areaTaken(10, cubeTranslation[2]));
  console.log(areaTaken(10, coneTranslation[2]));

  objectsToDraw.forEach(function(object) {
    var programInfo = object.programInfo;
    var bufferInfo = object.bufferInfo;

    gl.useProgram(programInfo.program);

    // Setup all the needed attributes.
    webglUtils.setBuffersAndAttributes(gl, programInfo, bufferInfo);

    // Set the uniforms.
    webglUtils.setUniforms(programInfo, object.uniforms);

    // Draw
    gl.drawArrays(gl.TRIANGLES, 0, bufferInfo.numElements);
  });

  // requestAnimationFrame(drawScene);
}





