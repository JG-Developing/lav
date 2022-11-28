/* Set the width of the sidebar to 250px (show it) */
function openNav() {
    document.getElementById("Resource-Panel").style.height = "200px";
    document.getElementById("Resource-Expand").style.display = "none";
    document.getElementById("Resource-Collapse").style.display = "block";
    document.getElementById("Resource-Info").style.height = "80%";
  }

  function openMenu() {
    document.getElementById("Side-Menu").style.width = "15vw";
    document.getElementById("Menu-Expand").style.display = "none";
    document.getElementById("Menu-Collapse").style.display = "block";
  }
  
  /* Set the width of the sidebar to 0 (hide it) */
  function closeNav() {
    document.getElementById("Resource-Panel").style.height = "40px";
    document.getElementById("Resource-Expand").style.display = "block";
    document.getElementById("Resource-Collapse").style.display = "none";
    document.getElementById("Resource-Info").style.height = "0%";
  }

  function closeMenu() {
    document.getElementById("Side-Menu").style.width = "40px";
    document.getElementById("Menu-Expand").style.display = "block";
    document.getElementById("Menu-Collapse").style.display = "none";
  }

  function openVuln(evt, vulnName) {
    // Declare all variables
    var i, vulnContent, vulnLinks;
  
    // Get all elements with class="vuln-content" and hide them
    vulnContent = document.getElementsByClassName("vulnContent");
    for (i = 0; i < vulnContent.length; i++) {
      vulnContent[i].style.display = "none";
    }
  
    // Get all elements with class="vulnLink" and remove the class "active"
    vulnLinks = document.getElementsByClassName("vulnLink");
    for (i = 0; i < vulnLinks.length; i++) {
      vulnLinks[i].className = vulnLinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(vulnName).style.display = "block";
    evt.currentTarget.className += " active";
  }