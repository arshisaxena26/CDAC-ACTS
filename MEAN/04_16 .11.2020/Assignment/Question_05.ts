/* 
Question : Write a typescript file that has a function that accepts a array of numbers.
           The function must loop through array, find square of each element and return the array with new elements.
	            var squareArray = arraySquare(original-array);

*/

function calcSquareArray (num:number[]) :number[]{

    for(let i:number = 0;i<num.length;i++)
        num[i] = num[i] * num[i];

    return num;
}

let numArray:number[] = [1,2,3,4,5,6];
console.log("Original Array : "+numArray);

let squareArray:number[] = calcSquareArray(numArray);
console.log("Squared Array : "+squareArray);


