let priority: string = "high";
priority = "low";

/* Using enum */
enum Priority { High, Low};
let priorityEnum: Priority = Priority.High;
priorityEnum = Priority.Low;

function show(id: number, priority: Priority): void {     
    // ... 
}
show(1,Priority.Low);

/* Using const */
const flag: boolean = false;
// flag can't be reassigned another value
//flag = true;


//variable types
let isDone: boolean = true;
let author: string = "Prashant";
let age: number = 35;
let environments: string[] = ['dev', 'qa','prod'];
let something: any = "any value";
something = 99;

let random; //inferred as type any
let x: number;
let y: number = 2;
let z = 98 + y; //inferred as type number

var work = function() { return true; }
var isComplete = work();