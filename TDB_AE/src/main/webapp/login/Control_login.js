/**
 * 
 */
 
$(document).ready(function() {
	
	var loginUsername;
	var loginPassword;
	var loginUsernameAdmin = "admin";
	var loginPasswordAdmin = "admin";
	
	var account = [loginUsername, loginPassword];
  
	$('#BTConnexionUtilisateur').on('click', function() {
		var loginUsernameEntry = $("#login-username").val();
		var loginPasswordEntry = $("#login-password").val();
		if (loginUsernameEntry == account[0] && loginPasswordEntry == account[1]) {
			console.log("Current Username " + account[0]);
			console.log("Current Password " + account[1]);
			console.log("Logged In");
		} else if (loginUsernameEntry == loginUsernameAdmin && loginPasswordEntry == loginPasswordAdmin) {
			
		} else {
			console.log("Attempted Username " + loginUsernameEntry);
			console.log("Attempted Password " + loginPasswordEntry);
			console.log("Login Falied");
		};
	});
  
	$('#BTRegisterUtilisateur').on('click', function() {
		var createUsernameEntry = $("#create-username").val();
		var createPasswordEntry = $("#create-password").val();
		var createEmailEntry = $("#create-email").val();
    var createUsernameValid = false;
    var createPasswordValid = false;
    var createEmailValid = false;
    var createUsernameObject = $("#create-username");
    var createPasswordObject = $("#create-password");
    var createEmailObject = $("#create-email");
    var validate = /^\s*[a-zA-Z0-9,\s]+\s*$/;
    var validateEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
   
    if(!validate.test(createUsernameEntry) || (createUsernameEntry).length == 0) {
      $(createUsernameObject).addClass("error")
      $(createUsernameObject).val("No special characters or spaces.")
    } else {
      createUsernameValid = true;
      var createUsername = $(createUsernameObject).val();
    }
    
    if(!validate.test(createPasswordEntry) || (createPasswordEntry).length == 0) {
      $(createPasswordObject).addClass("error");
      $(createPasswordObject).val("No special characters or spaces.");
    } else {
      createPasswordValid = true;
      var createPassword = $(createPasswordObject).val();
    }
    
    if(!validateEmail.test(createEmailEntry)) {
      $(createEmailObject).addClass("error");
      $(createEmailObject).val("Enter a valid email");
    } else {
      createEmailValid = true;
      console.log("Account Email " + createEmailObject.val())
    }
      
    $(createUsernameObject).on('click', function () {
      $(this).val("");  
      $(this).removeClass("error");
    });
    
    $(createPasswordObject).on('click', function () {
      $(this).val("");  
      $(this).removeClass("error");
    });
    
    $(createEmailObject).on('click', function () {
      $(this).val("");
      $(this).removeClass("error");
    });
    
		account = [createUsername, createPassword];
		
		
		
		console.log("Account Username " + account[0]);
		console.log("Account Password " + account[1]);
    
		if(createUsernameValid == true && createPasswordValid == true && createEmailValid == true) {
		
		utilisateur = {};
		utilisateur.username = account[0];
		utilisateur.password = account[1];
		
      $('form').animate({
			height: "toggle",
			opacity: "toggle"
		}, "fast");

		invokePost("rest/addutilisateur", utilisateur, "L'utilisateur a été ajouté'", "Erreur Ajout utilisateur");
    }
	});
	
	$('.message a').on('click', function() {
		$('form').animate({
			height: "toggle",
			opacity: "toggle"
		}, "fast");
	});
});

function loadRegister() {
	$("#pageBox").load("login/loginRegister.html", function() {
		$("#BTRetour").click(function() {
			loadLoginBtn();
		});
		$("#BTRegisterUtilisateur").click(function() {
			utilisateur = {};
			utilisateur.prenom=$("#FirstName").val();
			utilisateur.nom=$("#LastName").val();
			if ($("#Mdp") != $("#MdpConfirm")) {
				$("#RegisterErrorMsg").text("Les mots de passes ne correspondent pas !");
			} else {
				utilisateur.setMdp("#Mdp");
			}
			invokePost("rest/addutilisateur", utilisateur, "L'utilisateur a été ajouté'", "Erreur Ajout utilisateur");
		});
	});
}

function invokePost(url, data, successMsg, failureMsg) {
	jQuery.ajax({
	    url: url,
	    type: "POST",
	    data: JSON.stringify(data),
	    dataType: "json",
	    contentType: "application/json; charset=utf-8",
	    success: function (response) {
	    	$("#RegisterErrorMsg").text(successMsg);
	    },
	    error: function (response) {
	    	$("#RegisterErrorMsg").text(failureMsg);
	    }
	});
}



