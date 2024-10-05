<%@ page import="java.util.List" %>
<%@ page import="com.votingSystem.entity.Candidate" %>
<%@ page import="com.votingSystem.entity.User" %>
<%@ page import="com.votingSystem.entity.Election" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tables.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/confirmation.css">

</head>
<body>

<%    
   List<User> allVoters = (List<User>) request.getAttribute("allVoters");
%>



<h2 style="color: black">All Pending Voters Information</h2>


<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Aadhar Number</th>        
        <th>Disapprove Voter</th>
        <th>Approve Voter</th>
        
    </tr>
    </thead>
    <tbody>
    <%
     
        if (!allVoters.isEmpty()){
            for(User user : allVoters){

    %>
    <tr>
    
        <td> <%=user.getUserId() %> </td>
        <td> <%=user.getName() %> </td>
        <td> <%=user.getEmail() %> </td>
        <td> <%=user.getAadharNumber() %> </td>

      
         
        <td class="action-icons">
            <button class="icon-button icon-revoke" title="Move to Rejection list" onclick="confirmAction('/subAdmin/manageVoters?subAdminId=45&voterId=<%=user.getUserId() %>')">
                <i class="fas fa-times-circle"></i>
            </button>
        </td>
        
      
          
        <td class="action-icons">

            <button class="icon-button icon-authorize" title="Approve Now" onclick="confirmAction('/subAdmin/manageVoters?subAdminId=18&voterId=<%=user.getUserId() %>')">
                <i class="fas fa-check-circle"></i>
            </button>
        </td>
       

    </tr>

    
    
    <%
        }
        }
    %>


    </tbody>
</table>

<!-- Confirmation Modal -->
<div id="confirmationModal" class="modal" style="display: none">
    <div class="modal-content">
        <h3>Are you sure you want to proceed?</h3>
        <div class="button-container">
            <button class="btn-warning" id="cancelButton">Cancel</button>
            <button class="btn-cancel" id="confirmButton">Confirm</button>
        </div>
    </div>
</div>

<script>
    function confirmAction(actionUrl) {
        const modal = document.getElementById('confirmationModal');
        modal.style.display = 'block';

        document.getElementById('confirmButton').onclick = function () {
            // If confirmed, execute the action and refresh the main page
            window.top.location.href = actionUrl;
        };

        document.getElementById('cancelButton').onclick = function () {
            // If canceled, close the modal and do nothing
            modal.style.display = 'none';
        };
    }
</script>

</body>
</html>