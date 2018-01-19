class Event {
    constructor() {
        console.log('event constructor called');
        this.events = new EventSource('http://localhost:8080/ims-micro-tasks/resources/updates');
        this.events.onopen = (e) => console.log(e);
        this.events.onmessage = (e) => {
            console.log(e);
            let stats = e.data;
            document.querySelector('#updates').innerHTML = 'Last update: ' + stats;
        }
    }
}

let event = new Event();