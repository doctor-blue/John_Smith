var dog={
    'name':'Sam',
    12:'abc',
    numLegs:4,
    sayHello:function(){
        console.log('Hello, I am '+this.name)
    }
}

function Bird(name,numLegs){
    this.name=name;
    this.numLegs=numLegs;
}

console.log(dog.name)
console.log(dog[12])
var num='numLegs';
console.log(dog[num])

var myBird=new Bird('No name',2)
console.log(myBird.name)
console.log(myBird['numLegs'])
var myBird2=new Bird('three',2)

dog.name='Double'
console.log('Update Dog name to ' +dog.name)
dog[12]='Hello'
console.log(dog[12])

myBird.sayHi=function(){
    console.log(' bird hello')
}

myBird.sayHi()

myBird.color='White'
console.log(myBird.color)

//delete property

delete dog[12]
console.log(dog[12])

console.log(dog.hasOwnProperty('name'))
console.log(dog.hasOwnProperty(12))

console.log('==========================')

var myPets={
    cat:{
        type:'cat',
        names:[
            'apple',
            'orange',
            'susan'
        ]
    },
    dog:{
        type:'dog',
        name:[
            'black',
            'white',
            'Sam'
        ]
    }

}
//Nessted Object
// console.log(myPets['cat']['names'])
// console.log(myPets['cat']['names'])

//Nessted Array

var myPlant=[
    {
        type:'flowers',
        colors:[
            'blue',
            'white',
            'black'
        ]
    },
    {
        type:'trees',
        list:[
            'fir',
            'pine'
        ]
    }
]

//console.log(myPlant[1].list[0])









