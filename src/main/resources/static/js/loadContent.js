// loadContent.js
function loadContent(url, containerId) {
    console.log(url + " Loader")
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            document.getElementById(containerId).innerHTML = data;
            // Optionally, set the font size after loading the content
            document.getElementById(containerId).style.fontSize = '20px';
        })
        .catch(error => console.error('Error loading content:', error));
}
