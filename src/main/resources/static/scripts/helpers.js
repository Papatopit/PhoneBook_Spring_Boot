class HTTP {
    // ! expected date format {
    //     id: 0,
    //     name: 'Jhonny',
    //     phone: '424-24-42',
    //     date: new Date()
    // }

    constructor (url) {
        this.API = url;
    }

    request (method, body) {
        return fetch(this.API, { method, body });
    }

    createData (body) {
        return this.request('POST', body);
    }

    deleteData (body) {
        return this.request('DELETE', body);
    }

    fetchData = () => fetch(this.API);

    updateData = (body) => {
        return this.request('PATCH', body);
    }
}

class Utils {
    static padTo2Digits (num) {
        return num.toString().padStart(2, '0');
    }

    static formatDate (date) {
        return [
            date.getFullYear(),
            this.padTo2Digits(date.getMonth() + 1),
            this.padTo2Digits(date.getDate()),
        ].join('-');
    }
}
