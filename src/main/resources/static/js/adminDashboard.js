document.addEventListener('DOMContentLoaded', function() {
	
	//This abovee line tells the browser to wait until the entire HTML page is loaded before running the code inside the function.
	//This is necessary because the script interacts with elements in the HTML (buttons and sections), and those elements need to exist on the page before the script can work.
	
    console.log("AdminDashboard js loaded")
	//This line prints the message "AdminDashboard js loaded" in the browser’s developer console. It’s just for debugging, so you can confirm that the JavaScript file was successfully loaded.
	
    const buttons = document.querySelectorAll('.tab-button');
	//	This line finds all the buttons on the page that have the class tab-button and stores them in the buttons variable.
	//buttons is a collection (list) of all tab buttons that users can click to switch between different sections.
	
    const sections = document.querySelectorAll('.table-section');
	//	Similar to the previous line, this one finds all the sections (or parts of the page) that will be shown or hidden based on the selected tab. These sections are the containers with the class table-section.
	//The sections correspond to the content for each tab, like "Add Candidate", "Create Election", etc.

    buttons.forEach(button => {
		//This line loops over all the buttons. It tells the browser to take each button, one by one, and apply the same behavior when it’s clicked.
		//The behavior for each button is defined inside this loop.
        button.addEventListener('click', function() {
			
            // Remove active class from all buttons and sections
            buttons.forEach(btn => btn.classList.remove('active'));
			//This line removes the "active" class from all buttons. The active class is what makes a button appear selected or highlighted.
			//It's done so that only one button can be "active" at a time.
			
            sections.forEach(section => section.classList.remove('active'));
			//Similar to the previous line, this one removes the "active" class from all sections, which hides them. This ensures that only the section corresponding to the clicked button will be visible.
			
            // Add active class to the clicked button and the respective section
            button.classList.add('active');
			//After removing the "active" class from all buttons, this line adds the "active" class to the button that was clicked, highlighting it.
			
            const sectionToShow = document.getElementById(button.getAttribute('data-section'));
			//This line finds the section that corresponds to the clicked button.
			//The data-section attribute in the HTML tells the script which section to show when a particular button is clicked. For example, if the button has data-section="addTables", it will look for a section with the ID addTables.
			
            sectionToShow.classList.add('active');
			//This line makes the selected section visible by adding the "active" class to it, so it’s shown on the page.
        });
    });
});
