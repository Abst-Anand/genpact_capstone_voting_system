export async function handleFormSubmission(event) {
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

    try {
        // Send POST request to the server
        const response = await fetch('/api/submitForm', { // Ensure this path matches your backend
            method: 'POST',
            body: formData
        });

        // Check if the response is successful
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        // Handle successful response
        const result = await response.text(); // or response.json() if your backend returns JSON
        button.innerHTML = originalText;
        button.disabled = false;
        alert(result); // Show server response
    } catch (error) {
        // Handle error
        button.innerHTML = originalText;
        button.disabled = false;
        alert('An error occurred: ' + error.message);
    }
}
