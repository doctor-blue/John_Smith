//Rest parameters
function sum(...args) {
  let sum = 0;
  args.forEach((item) => {
    sum += item;
  });
  return sum;
}
console.log(sum(1, 2));

console.log(sum(1, 2, 3, 4, 5));

// Spread operator

console.log('max= '+Math.max(1,2.5,3,25,4))
const arr=[8,7,5,28,9]
console.log('spread operator : max= '+Math.max(...arr)) // 8,7,5,28,9


