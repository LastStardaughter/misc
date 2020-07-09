'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}
function getMaxLessThanK(n, k){
    if (k%2==1){return k-1} //If k is odd, we can & it with itself-1, resulting in k-1.
//Convert k-1 to binary, then stick a 1 in front of it -- this number & k-1 = k-1.
    const l=parseInt('1'.concat((k-1).toString(2)),2)
//If this number is <=n we can skip the brute force loop and return k-1.
    if (l>n){
        let max=0;
//If k is big enough that l > n, then the smallest possible answer is the biggest binary number <n that's all 1s, &'d with the second biggest binary number <n that's all 1s, which results in the latter. This is the binary number with the same number of digits as n, with the highest two digits set to 0 and the rest to 1.
//We convert n to binary, count the digits, take 1 less than 2^(numOfDigits-2)
//Starting from that number, we brute force the rest of the way.
        for (let i=2**(n.toString(2).length-2)-1; i<n;i++){
            for (let j=i+1; j<=n;j++){
                if ((i&j) < k && (i&j)>max){
                    //console.log("New max "+(i&j)+" found at "+i+"&"+j);
                    max = i&j;
                }
            }
        }
        return max;
    }
    return k-1;
}

function main() {
    const q = +(readLine());
    
    for (let i = 0; i < q; i++) {
        const [n, k] = readLine().split(' ').map(Number);
        
        console.log(getMaxLessThanK(n, k));
    }
}