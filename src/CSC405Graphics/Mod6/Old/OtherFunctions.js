/*

function mix() {

}

function normalize() {

}

function triangle(a, b, c){
  positiions.push(a);
  positiions.push(a);
  positiions.push(a);
  index += 3;
}

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


function tetrahedron(a, b, c, d, n)
{
  divideTriangle(a, b, c, n);
  divideTriangle(d, c, b, n);
  divideTriangle(a, d, b, n);
  divideTriangle(a, c, d, n);
}
*/

