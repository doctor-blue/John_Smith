//Random from 0 to 1
var num = Math.random()
console.log(num)
console.log(Math.floor(Math.random()*20))

function randomRange(min,max){
    return Math.floor(Math.random()*(max-min+1))+min
}

// 50 - 20 =30 +1=31 range from 0 to 31 = > num +20 => range 20 -> 50
console.log(randomRange(20,50))