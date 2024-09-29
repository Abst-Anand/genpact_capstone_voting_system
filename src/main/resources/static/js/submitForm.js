import {validateForm} from "./validateForm.js";

export async function handleFormSubmission(event, api) {
    event.preventDefault(); // Prevent default form submission

    const button = event.target; // This should be the submit button
    const form = document.getElementById('voterForm');
    const formData = new FormData(form); // Create a FormData object


    console.log(formData)
    // Save original button text to restore later
    const originalText = button.innerHTML;

    // Add loading spinner
    button.innerHTML = 'Submitting... <div class="spinner"></div>';
    button.disabled = true;
    // await validateForm(formData);


}
