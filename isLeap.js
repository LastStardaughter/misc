function isLeap(y){
	if (y%4!=0){
		return false;
	}
	else if (y%400==0){
		return true;
	}
  else if (y%100==0){
  	return false;
  }
  return true;
}

console.log(isLeap(2000));
console.log(isLeap(2004));
console.log(isLeap(1900));
console.log(isLeap(1600));