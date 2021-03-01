//Question : Write a typescript program to find sum of digits of given five-digit number.

function sumOfDigits(num: number): number {
    let sum: number = 0;
    let rem: number = 0;

    while (num != 0) {
        rem = num % 10;
        sum += rem;
        num = Math.floor(num / 10);
    }

    return sum;
}

console.log("Sum : " + sumOfDigits(17829));
