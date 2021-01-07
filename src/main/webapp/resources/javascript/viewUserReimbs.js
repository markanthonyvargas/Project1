
window.onload = function() {
	getAllUsers();
}

let myUserInformation ={};

function getAllUsers() {
	fetch(
			'http://localhost:9002/Project1/api/ajax/reimb')
			.then(function(daResponse) {
				const convertedResponse = daResponse.json();
				return convertedResponse;
			}).then(function(daSecondResponse) {
				console.log(daSecondResponse);
				myUserInformation=daSecondResponse;
				ourDOMManipulation(daSecondResponse);
			})

}

function ourDOMManipulation(ourJSON) {

	for (let i = 0; i < ourJSON.length; i++) {

		// ///////////CREATE ELEMENTS DYNAMICALLY//////////////
		// step1: creating our new element
		let newDiv = document.createElement("li");

		// step3: create a text node, then append to our new div element
		let divText = document.createTextNode("ReimbID: "+ourJSON[i].reimbID);
		newDiv.appendChild(divText);

		// step4: appending our new div element onto an existing element that is
		// currently being displayed
		let newSelection = document.querySelector("#myReimbList");
		newSelection.appendChild(newDiv);

		// console.log(newDiv);
		///////////////table time
	    
	 // ///////////CREATE ELEMENTS DYNAMICALLY//////////////
		// all creations
		let newTR = document.createElement("tr");
		let newTH = document.createElement("th");
		
		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
		let newTD6 = document.createElement("td");
		let newTD7 = document.createElement("td");
		let newTD8 = document.createElement("td");
		let newTD9 = document.createElement("td");
		
		// population creations
		newTH.setAttribute("scope", "row")
		let myText1 = document.createTextNode(ourJSON[i].reimbID);
		let myText2 = document.createTextNode("$" + ourJSON[i].amount);
		let myText3 = document.createTextNode(ourJSON[i].submitDate);
		let myText4 = document.createTextNode(ourJSON[i].resolveDate);
		let myText5 = document.createTextNode(ourJSON[i].description);
		let myText6 = document.createTextNode(ourJSON[i].author);
		let myText7 = document.createTextNode(ourJSON[i].resolver);
		let myText8;
		switch(ourJSON[i].statusID) {
			case 1:
				myText8 = document.createTextNode("Pending");
				break;
			case 2:
				myText8 = document.createTextNode("Approved");
				break;
			case 3:
			default:
				myText8 = document.createTextNode("Denied");
				break;
		}
		let myText9;
		switch(ourJSON[i].typeID) {
			case 1:
				myText9 = document.createTextNode("Lodging");
				break;
			case 2:
				myText9 = document.createTextNode("Travel");
				break;
			case 3:
				myText9 = document.createTextNode("Food");
				break;
			case 4:
			default:
				myText9 = document.createTextNode("Other");
				break;
		}
		//let myText9 = document.createTextNode(ourJSON[i].typeID);
		newDiv.appendChild(divText);
		
		///all appendings
		newTH.appendChild(myText1);
		newTD1.appendChild(myText2);
		newTD2.appendChild(myText3);
		newTD3.appendChild(myText4);
		newTD4.appendChild(myText5);
		newTD5.appendChild(myText6);
		newTD6.appendChild(myText7);
		newTD7.appendChild(myText8);
		newTD8.appendChild(myText9);
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		newTR.appendChild(newTD6);
		newTR.appendChild(newTD7);
		newTR.appendChild(newTD8);
		newTR.appendChild(newTD9);
		let newSelectionTwo = document.querySelector("#reimbTableBody");
		newSelectionTwo.appendChild(newTR);
	}
}