function formSubmit(){
	var span = $(".input").children("span");
	console.log(span);
	$.each(span,function(i){
		console.log($(span[i]).attr("class"));
	});
}