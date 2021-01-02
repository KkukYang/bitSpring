export default class {
    constructor(sang, dan) {
        this.sang = sang;
        this.dan = dan;
    }

    writeData() {
        console.log(this.sang, this.dan);
    }
}

export class Person {
    constructor(name, score) {
        this.name = name;
        this.score = score;
    }

    writePerson() {
        console.log(this.name, this.score);
    }
}