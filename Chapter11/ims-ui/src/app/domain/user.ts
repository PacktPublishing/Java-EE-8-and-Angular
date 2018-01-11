import { Credential } from "./credential";

export class User {
    id: number;
    name: string;
    email?: string;
    credential?: Credential;
}
