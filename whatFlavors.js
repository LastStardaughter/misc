'use strict';

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

// Complete the whatFlavors function below.
function whatFlavors(cost, money) {
    //console.log(cost + ", " + money);
    let iceCreams=[]; // sparse cost-indexed array to hold flavor IDs
    cost.forEach((a, i)=>{
        if (iceCreams[a]){
            iceCreams[a].push(i+1);
        } else {iceCreams[a]=[i+1]}
    })
    //console.log(iceCreams);
    //console.log(costs);
    //costs.sort((a, b)=>a[1]-b[1]);
    //console.log(costs);
    for(let i=0;i<cost.length;i++){
        //console.log(iceCreams.hasOwnProperty(cost[i]));
        if (cost[i]==money/2){
            if(iceCreams[cost[i]][1]){
                console.log(i+1,iceCreams[money-cost[i]][1])
                return;
            }
            continue;
        }
        if (iceCreams.hasOwnProperty(money-cost[i])){
            console.log(i+1,iceCreams[money-cost[i]][0])
            return
        }
    }
    console.log("Ice cream not found");
    
    /*
    //iterate over cost array:
    //check if current element's cost < budget
    //if so search array for indexOf(budget-cost)
    //when you find an answer, break
    let a;
    let dup=[];
    //no forEach because we want break
    for (let i=0;i<cost.length;i++){
        if (cost[i]>money){continue}
        a=cost.indexOf(money-cost[i]);
        if (a==i){
            dup = [...cost];
            dup.splice(i,1)
            a=dup.indexOf(money-cost[i])+1;
            //console.log("Hello from element "+i+" comparing to element "+a);
            //console.log(cost);
            //console.log(dup)
        }
        //console.log(a);
        if (a>0){
            console.log(i+1,a+1)
            return;
        }
    }
    */


}

function main() {
    const t = parseInt(readLine(), 10);

    for (let tItr = 0; tItr < t; tItr++) {
        const money = parseInt(readLine(), 10);

        const n = parseInt(readLine(), 10);

        const cost = readLine().split(' ').map(costTemp => parseInt(costTemp, 10));

        whatFlavors(cost, money);
    }
}
