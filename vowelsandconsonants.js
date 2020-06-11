/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
function vowelsAndConsonants(s) {
    let v="";
    let c="";

    for(let i=0;i<s.length;i++){
        if (s.charAt(i).match('[aeiou]')){
            v+=s.charAt(i);
        } else {
            c+=s.charAt(i);
        }
    }
//console.log(v);
//console.log(c);

    for (let i=0;i<v.length;i++){
        console.log(v.charAt(i))
    }
    for (let i=0;i<c.length;i++){
        console.log(c.charAt(i))
    }
}

