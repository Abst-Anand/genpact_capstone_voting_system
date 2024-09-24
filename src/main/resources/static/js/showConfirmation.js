export function showConfirmation(button) {

    console.log("showConfirmation called")
    // Get the parent <a> tag's href attribute
    const url = button.parentElement.getAttribute('href');

    // Now create and display the confirmation modal
    const confirmationFrame = document.createElement('iframe');
    confirmationFrame.src = `confirmation.html?url=${encodeURIComponent(url)}`;
    confirmationFrame.style.width = '100%';
    confirmationFrame.style.height = '100%';
    confirmationFrame.style.border = 'none';
    console.log(confirmationFrame.src)

    document.body.appendChild(confirmationFrame);



    // Prevent the default behavior of the <a> tag
    return false;
}
