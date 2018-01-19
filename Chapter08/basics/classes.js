//class
var Project = /** @class */ (function () {
    function Project(id) {
        this.id = id;
    }
    Project.prototype.add = function (taskId) {
        Project.numberOfTasks++;
    };
    Project.numberOfTasks = 0;
    return Project;
}());
var Person = /** @class */ (function () {
    function Person() {
    }
    Object.defineProperty(Person.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (n) {
            this._name = n;
        },
        enumerable: true,
        configurable: true
    });
    return Person;
}());
var john = new Person();
john.name = 'John';
console.log(john.name);
