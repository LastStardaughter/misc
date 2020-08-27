// Complete the isValid function below.
function isValid(s) {
    //sparse array to hold character frequencies
    let frequencies=new Array(36).fill(0);
    
    //iterate over characters in string, add up frequencies
    for (let i=0;i<s.length;i++){
        frequencies[parseInt(s[i],36)]++;
    }
    console.log(frequencies);
    //placeholder variable: Expected letter frequency
    let freq;
    //off-by-one flag: Indicates whether we've used our single one-higher frequency
    let extra=false;
    //number of frequencies seen so far, for special case
    let num=0;
    //iterate over array until first nonzero frequency
    for (let i=10;i<36;i++){
        if (frequencies[i]==0){continue}
        num++;
        //set placeholder variable to first nonzero frequency
        if (freq == undefined){
            freq = frequencies[i];
            continue;
        }
        //if placeholder matches current letter's frequency, continue
        if (freq == frequencies[i]){continue}
        //if frequency is one above placeholder, continue (allowed ONCE)
        if ((frequencies[i]-freq==1) && extra==false){
            extra = true;
            continue;
        }
        //if second nonzero frequency is one below first nonzero frequency, continue and set extra flag
        if ((freq-frequencies[i]==1) && num==2){
            freq--;
            extra = true;
            continue;
        }
        //if current frequency is 1 and doesn't match placeholder, continue ONCE.
        if (extra==false && frequencies[i]==1 && freq >1){
            extra = true;
            continue;
        }
        return "NO";
    }
    if(freq==undefined){return "NO"}
    return "YES";
}