/* JavaScript would allow the 1st and 2nd invocations but TypeScript won't
unless the parameters are explicitly marked optional as shown here */
function dumb(a, b) {
    console.log('a ' + a + ',b ' + b);
}
dumb();
dumb(1);
dumb(1, 2);
dumb(1, null);
function squareIt(a) {
    return a * a;
}
//Arrow Function
var squareItFunc = function (a) { return a * a; };
console.log(squareIt(2));
console.log(squareItFunc(2));
