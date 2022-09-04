const API_URL = 'http://localhost:8080/contacts';
const http = new HTTP(API_URL);

http.fetchData().then(async (response) => {
    if(response.ok) {
        const data = await response.json();
        new Table(data);
    }
});