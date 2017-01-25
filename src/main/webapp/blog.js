$(document)
		.ready(
				function() {
					$('#registerbutton')
					.click(function() {
						$("#userDetailsDiv").show();
						$("#loginDiv").hide();
						$("#userBlogEntryDiv").hide();
						document.signinForm.Name.focus();
					});
					$('#back')
					.click(function() {
						$("#userDetailsDiv").hide();
						$("#loginDiv").show();
						$("#userBlogEntryDiv").hide();
						document.signinForm.uname.focus();
					});
					$('#backToUpdateUser')
					.click(function() {
						$("#userBlogEntryDiv").hide();
						$("#loginDiv").hide();
						$("#userDetailsDiv").show();
						document.signinForm.Name.focus();
					});
					$('#addUser')
							.click(
									function() {
										var name = $("#name").val();
										var phoneNumber = $("#phoneNumber").val();
										var emailId = $("#emailId").val();
										var password = $("#password").val();
										var dob = $("#dob").val();
										var interest = $("#interest").val();
										var data = {
											email : emailId,
											password:password,
											personalInfo:{name : name,
											phoneNum : phoneNumber,
											dob : dob},
											topic : {name:interest}
										};
										  console.log ( '#name: '+name+',phoneNumber: '+phoneNumber+',emailId: '+emailId+',dob: '+dob+',interest: '+interest );
						if(formValidation()){
										$.ajax({
													url : 'http://localhost:8080/blog/user/account/adduser',
													type : 'post',
													contentType : 'application/json',
													success : function(response) {
														console.log("Success response: "+response);
														$("#openResults")
																.html(
																		"User added "
																				+ response);
														$("#userDetailsDiv").hide();
//														$("#openResults").show();
														$("#userBlogEntryDiv").show();
													},
													data : JSON.stringify(data)
												});
						}
									});
					$('#loginUser')
					.click(
							function() {
								console.log("loginUser");
								var name = "UserName";
								var phoneNumber ="phoneNumber";
								var emailId = $("#uname").val();
								var password = $("#psw").val();
								var dob = "dob";
								var interest = "interest";
								var data = {
									email : emailId,
									password:password,
									personalInfo:{name : name,
									phoneNum : phoneNumber,
									dob : dob},
									topic : {name:interest}
								};
								  console.log ( '#name: '+name+',phoneNumber: '+phoneNumber+',emailId: '+emailId+',password: '+password+',interest: '+interest );
								$.ajax({
											url : 'http://localhost:8080/blog/user/account/authenticateuser',
											type : 'post',
											contentType : 'application/json',
											success : function(response) {
												console.log("success response: "+ response);
//												$("#openResults").html("Welcome To User Blog ");
//												$("#openResults").show();
//												$("#loginDiv").hide();
//												$("#userDetailsDiv").hide();
												$("#userBlogEntryDiv").show();
											},
											/*failure : function(response) {
												$("#openResults")
														.html(
																"invalid login "
																		+ response);
												$("#userDetailsDiv").hide();
												$("#openResults").show();
											},*/
											data : JSON.stringify(data)
										});
							});
				
				});

function formValidation()  {
	var uname = document.signinForm.Name;  
	var uphonenumber = document.signinForm.PhoneNo;  
	var uemail = document.signinForm.Email;  
	var passid = document.signinForm.Pwd;  
	var dob = document.signinForm.Dob;  
	if(validateName(uname)) {  
		if(validateContactNumber(uphonenumber,10,6)){
			if(validateEmail(uemail)) {  
				if(passid_validation(passid,7,12))  
				{  
					if(validatedate(dob)){
						return true;
					}
				}
			}

		}
	}
}
function validateName(uname)  
{   
	var letters = /^[A-Za-z]+$/;  
	if(uname.value.match(letters))  
	{  
		return true;  
	}else if(uname.value==""){
		alert("Name field is blank!"); 
		uname.focus(); 
//		document.getElementById('emailId').style.borderColor = "red";
		return false;  
	} else  
	{  
		alert('Username must have alphabet characters only');  
		uname.focus();  
		return false;  
	}  
}

function validateContactNumber(phonenumber,mx,min)  
{   
	var numbers = /^[0-9]+$/;
	var phonenumber_len = phonenumber.value.length;  
	/*if(phonenumber_len==0){
		alert('Phone Number field is Empty!');  
		phonenumber.focus();  
		return false;  
	}else if(!phonenumber.value.match(numbers))  
	{  
		alert('Phone Number must have numeric characters only!');  
		phonenumber.focus();  
		return false;  

	}
	else if ((phonenumber_len >= min && phonenumber_len < mx) || phonenumber_len > mx)  
	{ 
		alert('Entered Phone Number is not proper!');  
		phonenumber.focus();  
		return false;  
	}else {  
		return true;  
	}  */
	if(phonenumber_len!=0){
		if(phonenumber.value.match(numbers))  
		{
			if (phonenumber_len >= min && phonenumber_len <= mx )  
			{ 
				return true;
			}else{
				alert('Entered Phone Number is not proper!');  
				phonenumber.focus();  
				return false; 
			} 


		}else{
			alert('Phone Number must have numeric characters only!');  
			phonenumber.focus();  
			return false;
		}

	}else {
		alert('Phone Number field is Empty!');  
		phonenumber.focus();  
		return false; 
	}  
}  
/*function validateEmail(uemail)  
{  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(uemail.value.match(mailformat))  
	{  
		return true;
	}  
	else if(uemail.value==""){
		alert("Email field is blank!"); 
		uemail.focus(); 
//		document.getElementById('emailId').style.borderColor = "red";
		return false;  
	}else{  
		alert("You have entered an invalid email address!");  
		uemail.focus();  
		return false;  
	}  
} */

/*function validateEmail(mail)   
{  
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.emailAddr.value))  
  {  
    return (true)  
  }  
    alert("You have entered an invalid email address!")  
    return (false)  
}  */
function validateEmail(inputText)  
{  
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(inputText.value.match(mailformat))  
{  
document.signinForm.Email.focus();  
return true;  
}  
else  
{  
alert("You have entered an invalid email address!");  
document.signinForm.Email.focus();  
return false;  
}  
}
function passid_validation(passid,mx,my)  
{  
	var passid_len = passid.value.length;  
	if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
	{  
		alert("Password should not be empty / length be between "+mx+" to "+my);  
		passid.focus();  
		return false;  
	}  
	return true;  
}

function validatedate(inputText)  
{  
	var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;  
//	Match the date format through regular expression  
	if(inputText.value.match(dateformat))  
	{  
		inputText.focus();  
//		Test which seperator is used '/' or '-'  
		var opera1 = inputText.value.split('/');  
		var opera2 = inputText.value.split('-');  
		lopera1 = opera1.length;  
		lopera2 = opera2.length;  
//		Extract the string into month, date and year  
		if (lopera1>1)  
		{  
			var pdate = inputText.value.split('/');  
		}  
		else if (lopera2>1)  
		{  
			var pdate = inputText.value.split('-');  
		}  
		var dd = parseInt(pdate[0]);  
		var mm  = parseInt(pdate[1]);  
		var yy = parseInt(pdate[2]);  
//		Create list of days of a month [assume there is no leap year by default]  
		var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];  
		if (mm==1 || mm>2)  
		{  
			if (dd>ListofDays[mm-1])  
			{  
				alert('Invalid date format!');  
				return false;  
			}  else{
				return true;
			}
		}  
		if (mm==2)  
		{  
			var lyear = false;  
			if ( (!(yy % 4) && yy % 100) || !(yy % 400))   
			{  
				lyear = true;  
				return true;
			}  
			if ((lyear==false) && (dd>=29))  
			{  
				alert('Invalid date format!');  
				return false;  
			}  
			if ((lyear==true) && (dd>29))  
			{  
				alert('Invalid date format!');  
				return false;  
			}  
		}  
	}  
	else  
	{  
		alert("Invalid date format!");  
		document.form1.Dob.focus();  
		return false;  
	}  
}  
