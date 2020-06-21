var myArr=["One",2,"Three",4,4.5,true]
console.log(myArr[2])

myArr[3]='Hello'

console.log('myArr[3]= '+myArr[3])

var myArr2=[2,[3,"Three"],[4,5]]

console.log('myArr2[1][0]= '+myArr2[1][0])

myArr.push("Zero")
console.log(myArr)
myArr.pop()
console.log(myArr)

myArr.unshift(24)
console.log('=================\n'+myArr)
myArr.shift()
console.log(myArr)