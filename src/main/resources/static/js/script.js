//function showNotification() {
 // alert("You have signed in for this Tour.");}
  
  function showNotification() {
  // Create a new notification element
  var notification = document.createElement("div");

  // Add the CSS class to the notification element
  notification.classList.add("notification");

  // Set the content of the notification
  notification.textContent = "You have signed up for this Tour!";

  // Append the notification element to the document body
  document.body.appendChild(notification);

  // Remove the notification after 3 seconds
  setTimeout(function() {
    document.body.removeChild(notification);
  }, 5000);
}
