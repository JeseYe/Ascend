
function guessNumber(){
	var result = 10;
	var str = document.getElementById("txtNumber").value;
	if(isNaN(str)){
		alert("请输入数值");
	}else{
		var data = parseFloat(str);
		var info = data > result ? "大了":"小了";
		info = data ==result ? "猜对了":info;
		alert(info);
	}
}

function getFac(){
	var result =1;
	for(var i=1;i<=10;i++){
		result *=i;
	}
	alert("10的阶乘为：" +result);
}

function searchStringAndReplace(){
	var str=document.getElementById("txtString").value;
	var index = str.indexOf("js", 0);
	while(index>-1){
		str =str.replace("js","*");
		index = str.indexOf("js", index+1);
	}
	document.getElementById("txtString").value = str;
}

function stringByRegex(){
	var str = document.getElementById("txtString").value;
	var result = str.match(/js/gi);
	
	document.getElementById("txtString").value = str.replace(/js/gi,"*");
	alert("共替换了"+result.length+"处");
	
}

function operateArray(t){
	//拆分为数组
	var array = document.getElementById("txtNumbers").value.split(",");
	//判断操作类型
	switch(t){
	case 1:
		array.reverse();
		break;
	case 2:
		array.sort();
		break;
	case 3:
		array.sort(sortFunc);
		break;
	}
	alert(array.toString());
}

function sortFunc(a, b){
	return a-b;
}

function getRandomNumber(){
	var min = parseInt(document.getElementById("txtMin").value);
	var max = parseInt(document.getElementById("txtMax").value);
	
	var ran = Math.random();
	var data = Math.floor(ran*(max-min))+min;
	alert(data);
}

function calculateDepreciation(){
	//得到录入的各项数值
	var money = parseFloat(document.getElementById("txtPrice").value);
	var rate = parseFloat(document.getElementById("txtRate").value);
	var year = parseFloat(document.getElementById("txtYear").value);
	
	//拼结果字符串
	var s ="年限 剩余价值\n";
	//循环计算每年的折旧
	for(var i = 1; i<=year;i++){
		var r = money*Math.pow((1-rate),i);
		//每年的结果显示为一行
		s += i+""+r+""+r.toFixed(2)+"\n";
	}
	document.getElementById("txtResult").innerHTML =s;
}























