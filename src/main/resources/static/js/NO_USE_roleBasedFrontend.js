async function getRoleId() {
    try {
        const response = await fetch('/loggedIn/getRoleId');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        return data.roleId; // Assuming API returns { roleId: 1 }
    } catch (error) {
        console.error('Error fetching roleId:', error);
        return null;
    }
}

function enableButton(buttonId) {
    const button = document.getElementById(buttonId);
    button.classList.add('enabled');
    button.disabled = false;
}

async function configureButtons() {

    const createElection = document.getElementById('createElection')
    createElection.style.display = 'none'
    // const roleId = await getRoleId();
    const roleId = 1;

    if (roleId === 1) { // Admin
        createElection.style.display = 'block'
        enableButton('func1');
        enableButton('func2');
        enableButton('func3');
        enableButton('func4');
    } else if (roleId === 2) { // Sub-Admin
        enableButton('func3');
        enableButton('func4');
    }
    // Add more role checks as needed
}

// Run when the page loads
document.addEventListener('DOMContentLoaded', configureButtons);