const API_URL = 'http://localhost:8080/contacts';
const http = new HTTP(API_URL);

http.fetchData().then((response) => {
    if(response.ok) {
        new Table(response.json());
    }
});