/* Using var */
for (var i = 0; i <= 9; i++) {
    console.log(i);
}
//var declaration leaks out the variable 'i', thus below prints 10
console.log(i);

/* Using let */
// Here let ensures x is accessible only within the for loop
for (let x = 0; x <= 9; x++) {
    console.log(x);
}
// Commented below else TSC will throw compiler error: Cannot find name 'x'.
// console.log(x);