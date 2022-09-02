class Table {
    modal = new Modal();

    constructor(data = []) {
        this.store = data;
        this.tbody = document.querySelector('tbody');

        document.getElementById('add').addEventListener('click', () => this.add())

        this.updateTable();
    }

    add () {
        this.modal.setCallback((row) => {
            http.createData(row).then(() => {
                this.store.push(row);
                this.updateTable();
            });
        });

        this.modal.open();
    }

    delete (row) {
        http.deleteData(row).then(() => {
            this.store = this.store.filter(v => v.id !== row.id);
            this.updateTable();
        })
    }

    edit (row) {
        const currentId = this.store.findIndex(v => v.id === row.id);

        this.modal.setDialogData(row);
        this.modal.setCallback((editedRow) => {
            this.updateTable(editedRow).then(() => {
                this.store[currentId] = editedRow;
                this.updateTable();
            });
        });

        this.modal.open();
    };

    updateTable () {
        this.tbody.innerHTML = '';

        const rows = this.store.map(row => {
            return new TableRow(
                row,
                () => this.delete(row),
                () => this.edit(row)
            ).getHtmlElement()
        });

        this.tbody.append(...rows);
    }
}

class TableRow {
    rowElm = null;

    constructor(data = [], onDelete, onEdit) {
        this.data = data;
        this.onEdit = onEdit;
        this.onDelete = onDelete;

        this.init();
    }

    addIcons () {
        const iconCellElm = document.createElement('td');
        const editIcon = document.createElement('i');
        const deleteIcon = document.createElement('i');

        editIcon.setAttribute('class', 'fa-solid fa-pen-to-square');
        editIcon.addEventListener('click', () => this.onEdit(this.data));

        deleteIcon.setAttribute('class', 'fa-solid fa-trash');
        deleteIcon.addEventListener('click', () => this.onDelete(this.data));

        iconCellElm.append(editIcon);
        iconCellElm.append(deleteIcon);

        this.rowElm.append(iconCellElm);
    }

    init () {
        this.rowElm = document.createElement('tr');

        Object.entries(this.data).forEach(([key, value]) => {
            const cellElm = document.createElement('td');

            cellElm.append(key === 'date' ? value.toDateString() : value);
            this.rowElm.append(cellElm);
        });

        this.addIcons();
    }

    getHtmlElement = () => this.rowElm;
}
