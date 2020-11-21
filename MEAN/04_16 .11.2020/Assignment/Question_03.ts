/* 
Question : Write a function to find the sum of squares of even numbers upto N. 
           N is passed as argument to typescript function.
*/

function sumEvenSquares(num: number): number {

    let sum: number = 0;

    for (let i: number = 2; i <= num; i += 2) {
        sum += i * i;
    }

    return sum;
}

console.log("Sum : " + sumEvenSquares(10));


