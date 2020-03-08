function dateSplit(yearData, get) {
	var dateArr = yearData.split(" ");
	var year = dateArr[0];
	var time = dateArr[1];
	var replaceFunction = function() {
		var oldChar = null;
		var newChar = null;
		var target = null;
		switch (get) {
		case "time":
			oldChar = [ ":", ":" ];
			newChar = [ "시", "분" ];
			target = time + "초";
			break;
		case "year":
			oldChar = [ "-", "-" ];
			newChar = [ "년", "월" ];
			target = year + "일";
			break;
		case "all":
			oldChar = [ "-", "-", ":", ":" ];
			newChar = [ "년", "월", "시", "분" ];
			target = year + "일" + time + "초";
			break;
		}
		var resultFunction = function() {
			var result = target;
			for (var i = 0; i < oldChar.length; i++) {
				result = result.replace(oldChar[i], newChar[i]);
			}
			return result;
		};
		return resultFunction();
	}
	return replaceFunction();
}
