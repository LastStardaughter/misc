'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the makeAnagram function below.
function makeAnagram(a, b) {
    let lettersa=[];
    let lettersb=[];
    let delchars=0;
    for(let i=10;i<36;i++){
        lettersa[i]=lettersb[i]=0;
    }

    a.split("").forEach(char=>{
        lettersa[parseInt(char,36)]++;
    });
    b.split("").forEach(char=>{
        lettersb[parseInt(char,36)]++;
    });

    for(let i=10;i<36;i++){
        delchars+=Math.abs(lettersa[i]-lettersb[i]);
    }
    return delchars;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const a = readLine();

    const b = readLine();

    const res = makeAnagram(a, b);

    ws.write(res + '\n');

    ws.end();
}
