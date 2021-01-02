//export 는 여러번 쓰는게 가능.
//export default 는 딱 한번 가능.
// ->클래스 이름 지정을 안해도 되고 import할때 이름지정하면 됨.

export default {
    age: 23, msg: "happy"
}

let week = () => {
    console.log("asdfasdfasdf");
    console.log("qwerqwerqwer");
}

export {week}