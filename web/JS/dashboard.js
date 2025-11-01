function toggleSubMenu(event) {
  event.preventDefault();
  var submenu = this.parentElement.querySelector(".sub-content");
  if (submenu) {
    submenu.parentElement.classList.toggle("open");
  }
}

document.addEventListener("click", function() {
  var submenuLinks = document.querySelectorAll(".submenu .parent");
  
  submenuLinks.forEach(function(link) {
    link.onclick = toggleSubMenu;
  });
});