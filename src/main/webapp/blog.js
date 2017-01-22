$(document)
		.ready(
				function() {
					$('#registerbutton')
					.click(function() {
						$("#userDeatilsForm").show();
						$("#loginForm").hide();
					});
					$('#back')
					.click(function() {
						$("#userDeatilsForm").hide();
						$("#loginForm").show();
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
										$.ajax({
													url : 'http://localhost:8080/blog/user/account/adduser',
													type : 'post',
													contentType : 'application/json',
													success : function(response) {
														$("#openResults")
																.html(
																		"User added "
																				+ response);
														$("#userDeatilsForm").hide();
														$("#openResults")
																.show();
													},
													data : JSON.stringify(data)
												});
									});
					$('#loginUser')
					.click(
							function() {
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
												$("#openResults")
														.html(
																"Welcome To User Blog ");
												$("#loginForm").hide();
												$("#userDeatilsForm").hide();
												$("#openResults")
														.show();
											},
											failure : function(response) {
												$("#openResults")
														.html(
																"invalid login "
																		+ response);
												$("#userDeatilsForm").hide();
												$("#openResults")
														.show();
											},
											data : JSON.stringify(data)
										});
							});
				
				});