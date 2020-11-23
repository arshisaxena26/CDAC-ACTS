export class People {
    name: string;
    age: number;
    gender: string;

    constructor(name: string, age: number, gender: string) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

export class Module {
    people: People[];

    constructor() {
        this.people = [
            new People("Ria", 23, "Female"),
            new People("Dia", 27, "Female"),
            new People("Anish", 20, "Male")
        ];
    }
}