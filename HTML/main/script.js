document.getElementById("menuButton").addEventListener("mouseover", function() {
    document.getElementById("dropdownContent").classList.toggle("show");
});

document.getElementById("menuButton").addEventListener("mouseout", function() {
    document.getElementById("dropdownContent").classList.remove("show");
});
