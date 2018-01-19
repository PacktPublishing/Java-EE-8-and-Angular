const url = '/resources/notifications';
class ApiClient {
    constructor() {
        this.init();
    }

    init() {
//        let data = {
//            name: 'test'
//        }
        let headers = new Headers({
            'Accept': 'application/json'
        });

        var request = new Request(url, {
            method: 'GET',
//            body: data,
            headers: headers
        });

        fetch(url, request)
                .then((resp) => {
                    console.log('status: ', resp.status);
                    return resp.json();
                }) // Transform the data into json
                .then(function (data) {
                    console.log('json: ',data);
                })
                .catch(function (error) {
                    console.log(error);
                });
    }
}

let client = new ApiClient();