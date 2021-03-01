/* 
Question : Write a typescript file that has a function strJoin(). 
    This function must take first argument as separator and any number of subsequent string arguments.
    The function must sort the input strings and then return a string that is a concatenated string, 
    with each input string separated by separator.
	eg : strJoin(“#”,”Soha”,”Shrilata”,” Sarita”) returns Sarita#Shrilata#Soha

*/

function strJoin(separator:string, ...strings:string[]){
    
    return strings.sort().join(separator);
}

console.log(strJoin("#","John","Bob","Ross","Ron","Grace","Julian"));