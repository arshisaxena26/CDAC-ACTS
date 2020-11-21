/* 
Question : Write a typescript file that has a function that accepts an array of numbers.
            The function must loop through array, find the min and max element in the array.
            It must also find the average of all elements in the array. 
            Display all values in function only.

*/

function arrayOps (arr:number[]) {
    let sum:number = 0;
    let avg:number = 0;
    let min:number = arr[0];
    let max:number = arr[0];

    for(let i:number = 1; i<arr.length; i++){

        sum += arr[i];

        if(min > arr[i])
            min = arr[i];
        
        if(max < arr[i])
            max = arr[i];    
    }

    avg = sum / Number.length;

    console.log("Min : "+min);
    console.log("Max : "+max);
    console.log("Average : "+avg);
}

arrayOps([9,2,5,1,7,4,10]);

