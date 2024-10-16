<%@ page import="com.votingSystem.entity.Candidate" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="${pageContext.request.contextPath}images/favicon.png" type="image/x-icon">
    <title>ECI | Election Commissioner</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- FontAwesome for icons -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/u_voterConfirmation.css">

</head>

<%
    Candidate candidate = (Candidate) request.getAttribute("candidate");

%>

<body>

<jsp:include page="../header.jsp" />

<div class="profile-container">
    <!-- Left Section: Profile Picture -->
    <div class="left-section">
        <div class="profile-picture">
            <img src="images/partylogo.jpg" alt="Party Logo">
            <label for="party-name" style="margin-top: 45%">Party Name:</label>
            <p id="party-name"> <%=candidate.getPartyName()%> </p>
        </div>
    </div>

    <!-- Right Section: Profile Details and Confirmation -->
    <div class="right-section">
        <div class="container">
            <!-- Candidate Details and Image -->
            <div class="profile-details">
                <h2>Candidate Details</h2>

                <!-- Flex container to align details and image -->
                <div class="profile-info-wrapper">
                    <!-- Candidate Info -->
                    <div class="profile-info">
                        <label for="election-name">Election Name:</label>
                        <p id="election-name">Lok Sabha</p>
                        <br/><br/><br/>

                        <label for="profile-name">Candidate Name:</label>
                        <p id="profile-name"> <%=candidate.getCandidateName()%> </p>
                        <br/><br/><br/>

                        <label for="about-candidate">About:</label>
                        <p id="about-candidate"> <%=candidate.getCandidateDescription()%> </p>
                    </div>

                    <!-- Image on the right side -->
                    <div class="profile-picture-right">
                        <img src="images/partylogo.jpg" alt="Party Logo">
                    </div>
                </div>

                <!-- Buttons -->
                <div class="confirmation-buttons">
                    <button id="noButton" class="btn" onclick="goBack()">Go Back</button>
                    <button id="yesButton" class="btn">Vote</button>
                </div>


            </div>
        </div>
    </div>
</div>



</body>

<script>
    const submitButton = document.getElementById('yesButton')
    submitButton.addEventListener('click', ()=>{

        // Add spinning animation on the button
        submitButton.innerHTML = 'Voting... <div class="spinner"></div>';

        // Also make it disabled
        submitButton.disabled = true;
    })

    function goBack(){
        window.history.back()
    }
</script>

</html>
