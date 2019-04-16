function validation(){
		var email=document.getElementById("Em").value; 	
		var password=document.getElementById("Pa").value; 
		
		// if(!emailCheck(email)){
		// 	document.getElementById("email").setCustomValidity("You have entered an invalid email address. Please try again.");
		// }
		// else if(emailCheck(email)){
		// 	document.getElementById("email").setCustomValidity("");
		// }
		// if(!passwordCheck(password,password_cf)){
		// 	document.getElementById("password_cf").setCustomValidity("Password confirmation doesn't match Password");
		// }
		// else if(passwordCheck(password,password_cf)){
		// 	document.getElementById("password_cf").setCustomValidity("");
		// }
		// if(!phoneCheck(phone)){
		// 	document.getElementById("phone").setCustomValidity("You have entered an invalid phone number. Please try again.");
		// }
		// else if(phoneCheck(phone)){
		// 	document.getElementById("phone").setCustomValidity("");
		// }
		
		// if(emailCheck(email) && passwordCheck(password,password_cf) && phoneCheck(phone) && gender != null && age !=""){
		// 			alert("name: "+name+" password: "+password+" phone: "+phone+" gender: "+gender+" age: "+age);
		// 			senduserdata(name, email, password, phone, gender, age);
		// }

		if(email=="Cindy@gmail.com"&&password=="12345"){
			alert("Email: "+email+";;Password:"+password);
		}
		alert("Email: "+email+";;Password:"+password);

}
