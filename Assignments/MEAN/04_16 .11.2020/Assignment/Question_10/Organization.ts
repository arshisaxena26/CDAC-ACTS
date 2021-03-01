export class Organization{
    name:string;
    registrationId:number;
    address:string;

    constructor(name:string,registrationId:number,address:string){
        this.name=name;
        this.registrationId=registrationId;
        this.address=address;
    }

    display(){
        console.log("Name : "+this.name+"\nRegistration ID : "+this.registrationId+"\nAddress: "+this.address);
    }
}