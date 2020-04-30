function loaders_show(){
		document.getElementById('shadow').style.display='block';//先让遮罩层显示
		document.getElementById('loaders').style.display='block';//再让加载动画显示
	}
	function loaders_hide(){
		
		document.getElementById('loaders').style.display='none';//先让加载动画隐藏
		document.getElementById('shadow').style.display='none';//再让遮罩层隐藏
	}