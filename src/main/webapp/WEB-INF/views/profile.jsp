<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css"> <!-- Link to external CSS file -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- FontAwesome for icons -->
</head>
<body>

<%
    String cloudinaryPrefix = "https://res.cloudinary.com/dl1hqxniz/image/upload/v1727458264/";
    Map<String,String> userDetails = (Map<String, String>) request.getAttribute("userDetails");
    System.out.println("Profile Map:" + userDetails.values());
    String imageLink = cloudinaryPrefix + userDetails.get("imagePublicId");
%>

<div class="profile-container">
    <!-- Left Section: Profile Picture -->
    <div class="left-section">
        <div class="profile-picture">
            <img src="<%= imageLink%>" alt="Profile Picture">
        </div>
        <div class="update-picture">
            <button class="btn" disabled>Update Picture</button>
        </div>
    </div>

    <!-- Right Section: Profile Details -->
    <div class="right-section">

        <div class="profile-details">
            <h2>Profile Details</h2>

            <!-- Logout Button -->
            <form action="/logout" method="post">
                <button type="submit" class="logout-button">Logout</button>
            </form>

            <div class="profile-info">
                <label for="profile_role">Role:</label>
                <p id="profile_role" style="color: red">[ <strong> <%=userDetails.get("role")%> </strong>]</p>
            </div>

            <div class="profile-info">
                <label for="profile-id">Id:</label>
                <p id="profile-id"> <%=userDetails.get("userId")%> </p>
            </div>

            <div class="profile-info">
                <label for="profile-name">Name:</label>
                <p id="profile-name"> <%=userDetails.get("name")%> </p>
            </div>

            <div class="profile-info">
                <label for="profile-email">Email:</label>
                <p id="profile-email"> <%=userDetails.get("email")%> </p>
            </div>

            <div class="profile-info password-field">
                <label for="profile-password">Password:</label>
                <p id="profile-password">********</p>
                <i class="fas fa-edit" id="edit-password" title="Change Password"></i>
            </div>

            <div class="alert-box success" id="successAlert">
                <button class="close-btn" onclick="closeAlert('successAlert')">&times;</button>
                <p><strong>Success!</strong> Your password was changed successfully.</p>
            </div>

            <div class="alert-box failed" id="failedAlert">
                <button class="close-btn" onclick="closeAlert('failedAlert')">&times;</button>
                <p><strong>Failed!</strong> There was an error changing your password.</p>
            </div>

        </div>
    </div>
</div>

<script>
    // Function to show the alert and auto-hide it after 3 seconds
    function showAlert(alertId) {
        const alertBox = document.getElementById(alertId);
        alertBox.style.display = 'flex'; // Show the alert box
        alertBox.style.opacity = '1'; // Start with full opacity


    }

    // Function to manually close the alert box
    function closeAlert(alertId) {
        const alertBox = document.getElementById(alertId);
        alertBox.style.opacity = '0'; // Fade out
        setTimeout(() => {
            alertBox.style.display = 'none'; // Hide after fade-out completes
        }, 500); // Wait for fade-out transition to complete
    }


    document.getElementById("edit-password").addEventListener("click", function() {
        const newPassword = prompt("Enter new password:");
        if (newPassword) {
            document.getElementById("profile-password").textContent = "*".repeat(newPassword.length);
            showAlert('successAlert');
        }else{
            showAlert('failedAlert')
        }
    });
</script>


</body>
</html>
