document.querySelectorAll('.vote-button').forEach(button => {
    button.addEventListener('click', function() {
        const candidateName = this.getAttribute('data-candidate');
        document.getElementById('candidateName').innerText = candidateName;
        document.getElementById('confirmationPopup').classList.remove('hidden');
    });
});

document.getElementById('confirmVote').addEventListener('click', function() {
    // Handle vote submission logic here
    alert('Vote confirmed!');
    document.getElementById('confirmationPopup').classList.add('hidden');
});

document.getElementById('cancelVote').addEventListener('click', function() {
    document.getElementById('confirmationPopup').classList.add('hidden');
});
