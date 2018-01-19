var priority = "high";
priority = "low";
/* Using enum */
var Priority;
(function (Priority) {
    Priority[Priority["High"] = 0] = "High";
    Priority[Priority["Low"] = 1] = "Low";
})(Priority || (Priority = {}));
;
var priorityEnum = Priority.High;
priorityEnum = Priority.Low;
function show(id, priority) {
    // ... 
}
show(1, Priority.Low);
/* Using const */
var flag = false;
// flag can't be reassigned another value
//flag = true;
//variable types
var isDone = true;
var author = "Prashant";
var age = 35;
var environments = ['dev', 'qa', 'prod'];
var something = "any value";
something = 99;
var random; //inferred as type any
var x;
var y = 2;
var z = 98 + y; //inferred as type number
var work = function () { return true; };
var isComplete = work();
