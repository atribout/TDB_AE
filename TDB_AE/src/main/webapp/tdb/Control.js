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
		$("#BTLogOut").click(function() {
			loadLogOut();
		});
	});
}

function loadNavigation(HeadTitle) {
	$("#Navigation").load("navigation.html", function() {
		$("#HeadTitle").text(HeadTitle);
		$("#user_session").text(Cookies.get('sessionMembre'));
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

function loadLogOut() {
	Cookies.remove('sessionMembre',{ path: '/' });
	location.replace("/TDB_AE_V2/");
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