class Modal {
    dialogElm = document.getElementById('dialog');
    cancelButton = document.getElementById('cancel');
    nameInput = document.getElementById('name');
    phoneInput = document.getElementById('phone');
    dateInput = document.getElementById('date');

    callback = () => {};

    constructor () {
        this.cancelButton.addEventListener('click', () => {
            this.dialogElm.close();
        });

        this.dialogElm.addEventListener('submit', () => {
            const values = this.getDialogData();

            this.callback(values);
            this.resetDialogData();
        });

        this.resetDialogData();
    }

    getDialogData = () => {
        return {
            name: this.nameInput.value,
            phone: this.phoneInput.value
        }
    }

    open () {
        this.dialogElm.showModal();
    }

    resetDialogData = () => {
        this.nameInput.value = '';
        this.phoneInput.value = '';
    }

    setCallback (cb) {
        this.callback = cb;
    }

    setDialogData (row) {
        this.nameInput.value = row.name;
        this.phoneInput.value = row.phone;
    }
}
