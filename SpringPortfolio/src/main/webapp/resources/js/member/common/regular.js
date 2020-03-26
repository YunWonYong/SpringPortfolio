function regular(key,value){
	var msg = null;
	switch (key) {
	case "name":
		msg = !((value.length >= 2) && (value.length <= 5)) ? "2이상 5글자 이하 입니다."
				: (/.*\s.*/.test(value)) ? "공백을 포함할수 없습니다."
						: (/.*[ㄱ-ㅎ|ㅏ-ㅣ].*/.test(value)) ? "자음 또는 모음은 사용할수 없습니다."
								: !(/.*[가-힣].*/.test(value)) ? "한글만 입력가능합니다."
										: null;	
		break;
	case "nickname":
		msg = (/.*\s.*/.test(value))?"빈문자를 포함할수 없습니다."
				:(/^[a-zA-Z0-9]*$/.test(value))?(!(value.length>=4 && value.length<=15)?"최소 4글자 최대 15 글자 입니다.":null)
						:(/^[가-힣0-9]*$/.test(value))?!(value.length>=2 && value.length<=5)?"최소 2글자 최대 5글자 입니다.":null
								:!(/^[a-zA-Z0-9가-힣]*$/.test(value))?"특수문자나 자음,모음을 포함할수 없습니다.":null;
		break;
	case "id":
		msg = !(value.length >= 5 && value.length <= 12) ? "최소 5글자 최대 12글자 입니다."
				: (/[.*\s.*]/.test(value)) ? "공백을 포함할수 없습니다."
						: (/^[0-9]/.test(value)) ? "숫자로 시작하실수 없습니다."
								: (/[ㄱ-ㅎ|가-힣|ㅏ-ㅣ|ㄱ-ㅎ가-힣ㅏ-ㅣ]/.test(value)) ? "한글은 사용하실수 없습니다."
										: !(/^[a-zA-Z0-9]*$/.test(value)) ? "특수문자를 포함할수 없습니다."
												: null;
		break;
	case "password": 
		 msg = !((value.length >= 8) && (value.length <= 15)) ? "최소 8글자 최대 15글자"
					: !(/^[a-zA-Z]+/.test(value)) ? "영문 대소문자로 시작해야 합니다."
							: !(/.*[!|@|#|$|%|&|*|^|~]+/
									.test(value)) ? "특수문자 한개 이상 포함해야 합니다.(~,!,@,#,$,%,&,^,*)"
									: null;
		 break;
	case "name":  
		msg = !((value.length >= 2) && (value.length <= 5)) ? "2이상 5글자 이하 입니다."
				: (/.*\s.*/.test(value)) ? "공백을 포함할수 없습니다."
						: (/^[ㄱ-ㅎ|ㅏ-ㅣ]$/.test(value)) ? "자음 또는 모음은 사용할수 없습니다." 
								: !(/^[가-힣]$/.test(value)) ? "한글만 입력가능합니다."
										: null;
		break;
	case "phone":
		msg = !(/^[010]{3}.-?[0-9]{3,4}.-?[0-9]{4}/.test(value)) ?
				"010-2222-2222 형식으로 입력해 주세요."
						: null;
		break;
	case "email":
		msg =(/^[0-9]/.test(value))?"숫자로 시작하실수 없습니다."
				:(/.*\s.*/.test(value))?"공백은 포함하실수 없습니다."
						:!(/^[a-zA-Z0-9|@|.]*$/.test(value))?"특수문자 또는 한글을 포함할수 없습니다."
								:!(/^[a-zA-Z0-9]{4,12}/.test(value))?"이메일 아이디는 최소 4 최대 12 입력해주세요,"
										:!((/^[a-zA-Z0-9]{4,12}.@?[a-zA-Z]{4,10}..?[a-z]{2,3}$/i).test(value))?"이메일 형식에 맞지 않습니다."
												:null;
		break;
	}
	return msg;
}