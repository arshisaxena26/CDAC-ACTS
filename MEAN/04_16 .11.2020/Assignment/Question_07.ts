/* 
Question : Write a typescript function that takes variable array of strings. The array holds many web site names. 
    Eg, www.google.com, www.msn.com, www.amazon.co.in, in.answers.yahoo.com, en.m.wikipedia.com, codehs.gitbooks.io, www.coderanch.com 	  etc. 
    Search for all sites that begin with “www” and display the total number of such sites. Eg for above eg, total is 4.

*/

function searchPattern(...sites: string[]): number {
    let match: number = 0;
    let pattern = /^www/;

    for (let i: number = 0; i < sites.length; i++) {
        if (sites[i].search(pattern) != -1)
            match++;
    }
    return match;
}

console.log("Matches : " + searchPattern("www.google.com", "www.msn.com", "www.amazon.co.in", "in.answers.yahoo.com", "en.m.wikipedia.com", "codehs.gitbooks.io", "www.coderanch.com"));