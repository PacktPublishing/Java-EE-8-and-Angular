//class
class Project {
    static numberOfTasks: number = 0;
    id: number;

    constructor(id: number) {
        this.id = id;
    }

    add(taskId: number) {
        Project.numberOfTasks++;
    }
}

class Person {
    private _name: string;

    get name() {
        return this._name;
    }
    set name(n: string) {
        this._name = n;
    }
}
let john = new Person();
john.name = 'John';
console.log(john.name);