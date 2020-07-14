function Cat(name){
    this.name=name;
}
const myCat=new Cat('Pink')

class Dog{
    constructor(name){
        this.name=name;
    }

    get dogName(){
        return this.name
    }
    set dogName(name){
        this.name=name
    }
}

const dog=new Dog('Fido')
console.log(dog.name)
dog.dogName='Black'
console.log(`My dog name is ${dog.dogName}`) // '' `` esc 

export default area = ()=>1+2