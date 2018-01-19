import { FormControl, AbstractControl } from "@angular/forms/src/model";

export class Phonenumber {

    static indiaPhone(control: AbstractControl) {
        const phone = control.value as number;
        if (phone === null || !phone.toString().startsWith("91")) {
            return { india: false };
        }

        return null;
    }
    
}
