import { FormControl, AbstractControl } from "@angular/forms/src/model";

export class Email {

    static unique(control: AbstractControl) {
        const USERS = ['abc@coolcomp.com'];

        return new Promise(resolve => {
            if (USERS.indexOf(control.value) !== -1) {
                console.log('err', control.value);
                resolve({ unique: 'false' });
            }
            resolve(null);
        });
    }
}
