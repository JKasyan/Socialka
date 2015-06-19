/**
 * 
 */
function checkForm(){
	var email = document.getElementsByName("email");
	var password = document.getElementsByName("password");
	var repeatPassword = document.getElementById("password_repeat");
	var name = document.getElementsByName("name");
	var lastName = document.getElementsByName("lastName");
	
	var errorPassword = document.getElementsByName("errorPassword");
		if(password.valueOf() == repeatPassword.valueOf()){
			errorPassword.innerHTML("Passwords Do Not Match!");
		}else if(password.length<6){
			errorPassword.innerHTML("Passwords must be at least 6 characters!");
		}
}


function checkPassword(password){
	if(password.length){
		return false;
	}else{
		return true;
	}
}

