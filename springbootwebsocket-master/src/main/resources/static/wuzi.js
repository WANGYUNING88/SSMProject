

/*状态事件*/

function choose(chessmen) {
	$.ajax({
		method : 'get',
		url : '/choose',
		data : {

			chessmen : chessmen,
			against : window.localStorage.getItem('against')

		},
		success : function(result) {
			console.log("选择棋子:  "+result);
			$("#myqizi").attr("src", chessmen + ".png");
			var againstqizi = "black";
			if(chessmen=="black"){
				againstqizi = "white";
			}
			$("#againstqizi").attr("src",againstqizi  + ".png");
			color = chessmen;
			$("#s1").attr("disabled", true);
			$("#s2").attr("disabled", true); 
		}
	})
}

function status1() {
	chessmen = "black";
	choose(chessmen);
}
function status2(n) {
	chessmen = "white";
	choose(chessmen);
}

/* 控件事件 */
function closeFunction() {
	if (confirm("是否退出游戏？")) {
		window.close();
	} else {
		history.back();
	}
}




var tds = document.getElementsByTagName('td');




// 负责下棋，即改变单元格的背景
var xia = function() {
	if (color == "") {
		if (main == 0) {
			alert('你是先手，请确定棋子');
		} else if (main == 1) {
			alert("你是后手，等待对手确定棋子");
		} else {
			alert("初始化错误");
		}
		return;
	}

	// 判断是否已分出胜负

	if (iswin) {
		alert('游戏结束!');
		return;
	}
	if (this.style.background.indexOf('.png') >= 0) {
		//('不能重复放置棋子！');
		return;
	}
	if(status==0){
		var t = false;
		var qizi = [this.parentElement.rowIndex,this.cellIndex];
		console.log(qizi[0]+ " "+qizi[1]);
		$.ajax({
			method : 'get',
			url : '/xiaziqi',
			data : {
				against:window.localStorage.getItem('against'),
				x:qizi[0],
				y:qizi[1],
				color:color

			},
			success : function(result) {
				console.log("result:"+result);
				console.log("坐标：" + qizi[0] + " " + qizi[1]);
				status++;
				var s = isWin(result);
				var table = document.getElementById("tbl");// 获取第一个表格
				var child = table.getElementsByTagName("tr")[qizi[0]];// 获取行的第一个单元格
				var td = child.children[qizi[1]];
				td.style.background = 'url(' + color + '.png)';				
				if(s!=""){
					alert(s);
				}
			}
		});
		
		
	}else{
		alert("未到你的回合");
	}
}


function reset(){
	$("#reset").attr("disabled", true);
	$.ajax({
		method : 'get',
		url : '/reset',
		data : {
			username:my,
			against:against
		},
		success : function(result) {
			console.log("result:"+result);
			if(result>=3){
				main = result -3;
				window.localStorage.setItem('main',result.main);
				
			}else{
				window.location.href=window.location;
			}
		}
	});
}


