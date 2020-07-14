let dog={
    name:"pink",
    age:12,
    numLegs:4
}
// let dogName=dog.name
// let dogAge=dog.age

//let {name, numLegs,age}=dog

//letconsole.log(name,age,numLegs)

let {name:dogName,age:dogAge}=dog
console.log(dogName,dogAge)

/* function getDogInformations(dog){
    return "Name: "+dog.name+" Age: "+dog.age+" numLegs: "+dog.numLegs
}
 */
const getDogInformations=({name,age,numLegs})=> "Name: "+name+" Age: "+age+" numLegs: "+numLegs
console.log(getDogInformations(dog))

let myArr=[1,8,9,6,7,5]

//let a=myArr[2]
/* let [a,b,,,c]=myArr
console.log(a,b,c) */

let [a,b,...arr] =myArr
console.log(a,b,arr)


//import Object from './ES6_Objects.js'
const ABC=require('./ES6_Objects.js')

console.log(ABC.area())




