function functionName() {
  console.log("this is a function");
}
functionName();
// Arrow functions

const arrowFunction = () => {
  console.log("this is an arrow function");
};
arrowFunction();

const printMyName = (name) => console.log("My name is: " + name);

printMyName("Nguyen Van Tan");

const sum = (a = 2, b = 3) => a + b;

console.log(sum(15, 7));
console.log(sum());
