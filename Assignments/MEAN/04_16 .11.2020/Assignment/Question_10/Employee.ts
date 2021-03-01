export class Employee {
    name: string;
    id: number;
    address: string;
    phone: string;
    email: string;

    constructor(name: string, id: number, address: string, phone: string, email: string) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    display() {
        console.log("Name: " + this.name + "\nID: " + this.id + "\nAddress: " + this.address + "\nPhone: " + this.phone + "\nEmail: " + this.email);
    }
}