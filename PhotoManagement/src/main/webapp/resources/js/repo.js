$(document).ready(function(){
	$("#allCheck").on("click", function(){
		var checkText = $("#allCheck").text();
		
		if(checkText == "전체선택"){
			$("#allCheck").text("선택해제");
		}else if(checkText == "선택해제"){
			$("#allCheck").text("전체선택");
		}
	})
});

function allCheckHideAndShow(){
	$("#allCheck").show();
}
