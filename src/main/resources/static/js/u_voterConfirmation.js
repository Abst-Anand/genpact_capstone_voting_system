document.addEventListener('DOMContentLoaded', function() {
	
	//This abovee line tells the browser to wait until the entire HTML page is loaded before running the code inside the function.
	//This is necessary because the script interacts with elements in the HTML (buttons and sections), and those elements need to exist on the page before the script can work.
	
    console.log("AdminDashboard js loaded")
	//This line prints the message "AdminDashboard js loaded" in the browser’s developer console. It’s just for debugging, so you can confirm that the JavaScript file was successfully loaded.
	
    const buttons = document.querySelectorAll('.tab-button');
	//	This line finds all the buttons on the page that have the class tab-button and stores them in the buttons variable.
	//buttons is a collection (list) of all tab buttons that users can click to switch between different sections.
	
    const sections = document.querySelectorAll('.table-section');
document.getElementById('yesButton').addEventListener('click', function() {
    // Add your logic for confirming the vote
    alert('Thank you for confirming your vote!');
    document.getElementById('confirmationDialog').style.display = 'none';
});

document.getElementById('noButton').addEventListener('click', function() {
    document.getElementById('confirmationDialog').style.display = 'none';
});
});
