
// Function to load header.html into the specified element
import {COLORS} from "../colors/data.js";

function loadHeader() {
    console.log("Head Loader")

    fetch('header.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('header').innerHTML = data;
            updateDefaultStyles();
            attachHeaderEvents();
        })
        .catch(error => console.error('Error loading Header:', error.message))
}

function updateDefaultStyles() {
    // Apply header background color
    const header = document.querySelector('header');
    if (header) {
        header.style.backgroundColor = COLORS['header-bg-color'];
    }

    // Apply body background color
    document.body.style.backgroundColor = COLORS['body-bg-light'];

    // Apply font color
    document.body.style.color = COLORS['font-color'];
}

// Function to attach event listeners to header buttons
function attachHeaderEvents() {
    const increaseFontSizeButton = document.getElementById('increaseFontSize');
    const decreaseFontSizeButton = document.getElementById('decreaseFontSize');
    const resetFontSizeButton = document.getElementById('resetFontSize')
    const toggleModeButton = document.getElementById('toggleMode');


    let currentFontSize = 16;
    let isDarkMode = false;

    increaseFontSizeButton.addEventListener('click', () => {
        if (currentFontSize <= 34) {
            currentFontSize += 2;
            // console.log(currentFontSize)

            document.body.style.fontSize = `${currentFontSize}px`;
        } else {
            currentFontSize -= 2;
        }

    });

    resetFontSizeButton.addEventListener('click', () => {
        document.body.style.fontSize = '16px';

    })

    decreaseFontSizeButton.addEventListener('click', () => {
        if (currentFontSize > 10) {
            currentFontSize -= 2;
            document.body.style.fontSize = `${currentFontSize}px`;
        }
    });

    toggleModeButton.addEventListener('click', () => {
        isDarkMode = !isDarkMode;
        if (isDarkMode) {
            document.body.style.backgroundColor = COLORS['body-bg-dark'];
            toggleModeButton.classList.toggle('rotate-180-plus');
        } else {
            document.body.style.backgroundColor = COLORS['body-bg-light'];
            toggleModeButton.classList.toggle('rotate-180-minus');
        }
    });
}



// Load the header when the page loads
document.addEventListener('DOMContentLoaded', loadHeader);
