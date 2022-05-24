/**
 * 
 */

$(document).ready(function() {
	loadMenu();
	loadAccueil();
});

function loadMenu() {
	$("#Menu").load("menu.html", function() {
		$("#BTAccueil").click(function() {
			loadAccueil();
		});
		$("#BTEvenements").click(function() {
			loadEvenements();
		});
		$("#BTForum").click(function() {
			loadForum();
		});
		$("#BTReservation").click(function() {
			loadReservation();
		});
	});
}

function loadNavigation(HeadTitle) {
	$("#Navigation").load("navigation.html", function() {
		$("#HeadTitle").text(HeadTitle);
	});
}

function loadAccueil() {
	$("#Page").load("accueil.html", function() {
	});
	loadNavigation("Accueil");
}

function loadEvenements() {
	$("#Page").load("evenements.html", function() {
	});
	loadNavigation("Evenements");
}

function loadForum() {
	$("#Page").load("forum.html", function() {
	});
	loadNavigation("Forum");
}

function loadReservation() {
	$("#Page").load("reservation.html", function() {
	});
	loadNavigation("Réservation");
}

function loadMain() {
	$("#Main").load("Main.html", function() {
		$("#BTAddPerson").click(function() {
			loadAddPerson();
		});
		$("#BTAddAddress").click(function() {
			loadAddAddress();
		});
		$("#BTAssociate").click(function() {
			loadAssociate();
		});
		$("#BTList").click(function() {
			loadList();
		});
	});
}

function loadAddPerson() {
	$("#ShowMessage").empty();
	$("#Main").load("AddPerson.html", function() {
		$("#BTValAddPerson").click(function() {
			person = {};
			person.firstName=$("#FirstName").val();
			person.lastName=$("#LastName").val();		
			invokePost("rest/addperson", person, "person was added", "failed to add a person");
			loadMain();
		});
	});
}

function loadAddAddress() {
	$("#ShowMessage").empty();
	$("#Main").load("AddAddress.html", function() {
		$("#BTValAddAddress").click(function() {
			address = {};
			address.street=$("#Street").val();
			address.city=$("#City").val();		
			invokePost("rest/addaddress", address, "address was added", "failed to add an address");
			loadMain();
		});
	});
}

function loadAssociate() {
	$("#ShowMessage").empty();
	$("#Main").load("Associate.html", function() {
		var listPersons, listAddresses;
		invokeGet("rest/listpersons", "failed to list persons", function(response) {
			listPersons = response;
			if (listPersons == null) return;
			listAddresses = invokeGet("rest/listaddresses", "failed to list addresses", function(response) {
				listAddresses = response;
				if (listAddresses == null) return;	
				for (var i=0; i < listPersons.length; i++) {
					var person = listPersons[i];					
					$("#ListOfPersons").append("<input type='radio' name='PersonId' value='"+person.id+"'>"+person.firstName+" "+person.lastName+"<br>");
				}
				for (var j=0; j < listAddresses.length; j++) {
					var address = listAddresses[j];					
					$("#ListOfAddresses").append("<input type='radio' name='AddressId' value='"+address.id+"'>"+address.street+" "+address.city+"<br>");
				}
				$("#BTValAssociate").click(function() {
					ass = {};
					ass.personId=$("input[name='PersonId']:checked").val();
					ass.addressId=$("input[name='AddressId']:checked").val();
					invokePost("rest/associate", ass, "association was created", "failed to create association");
					loadMain();
				});
			});
		});
	});
}
	
function loadList() {
	$("#ShowMessage").empty();
	listPersons = invokeGet("rest/listpersons", "failed to list persons", function(response) {
		var list;
		listPersons = response;
		if (listPersons == null) return;
		list="<ul>";
		for (var i=0; i < listPersons.length; i++) {
			var person = listPersons[i];					
			list+="<li>"+person.firstName+" "+person.lastName+"</li>";
			list+="<ul>";
			for (var j=0; j < person.addresses.length; j++) {
				var address = person.addresses[j];
				list+="<li>"+address.street+" "+address.city+"</li>";
			}
			list+="</ul><br>";
		}
		list+="</ul><br>";
		$("#Main").empty();
		$("#Main").append(list);
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
	    	$("#ShowMessage").text(successMsg);
	    },
	    error: function (response) {
	    	$("#ShowMessage").text(failureMsg);
	    }
	});
}
function invokeGet(url, failureMsg, responseHandler) {
	jQuery.ajax({
	    url: url,
	    type: "GET",
	    success: responseHandler,
	    error: function (response) {
	    	$("#ShowMessage").text(failureMsg);
	    }
	});
}