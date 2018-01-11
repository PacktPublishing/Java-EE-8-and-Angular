/* Interface */
interface Author {
    name: string;
    age?: number;
}

function showInfo(author: Author): string {    
    console.log(author.age);
    if(author.age) {
        return 'Author ' + author.name + ' with age ' + author.age;        
    }
    return 'Author ' + author.name;
}

console.log(showInfo({name: 'bob',age: 35}));
console.log(showInfo({name: 'tom'}));

function addUp( addition: { x: number, y: number}) {
    return addition.x + addition.y;
}

var result: number = addUp( { x: 2, y: 5});
console.log('addUp returned ', result);