/* 
Question : Write a function pow(x,y) that calculates x^y. Do not use the Math predefined object.
*/

function pow(x: number, y: number): number {
    let result: number = 1;

    for (let i: number = 0; i < y; i++)
        result *= x;

    return result;
}

console.log("Result : " + pow(2, 8));

