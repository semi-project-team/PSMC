function toggleGender(gender) {
    if (gender === 'male') {
        document.getElementById('maleBtn').classList.add('active');
        document.getElementById('femaleBtn').classList.remove('active');
    } else {
        document.getElementById('maleBtn').classList.remove('active');
        document.getElementById('femaleBtn').classList.add('active');
    }
}

// Assume employee.gender is a global variable set somewhere in your code
// For demonstration, let's set it here:
const employee = {
    gender: "M" // This value should be dynamically set
};

// Function to initialize the button state based on employee.gender
function initializeGenderButtons() {
    const gender = employee.gender;
    const maleBtn = document.getElementById('maleBtn');
    const femaleBtn = document.getElementById('femaleBtn');

    if (gender === maleBtn.value) {
        maleBtn.classList.add('active');
        femaleBtn.classList.remove('active');
    } else if (gender === femaleBtn.value) {
        femaleBtn.classList.add('active');
        maleBtn.classList.remove('active');
    }
}

// Function to toggle the gender and update button states
function toggleGender(selectedGender) {
    const maleBtn = document.getElementById('maleBtn');
    const femaleBtn = document.getElementById('femaleBtn');

    if (selectedGender === 'M') {
        maleBtn.classList.add('active');
        femaleBtn.classList.remove('active');
    } else if (selectedGender === 'F') {
        femaleBtn.classList.add('active');
        maleBtn.classList.remove('active');
    }

    // Update the employee object or perform any other action as needed
    employee.gender = selectedGender;
}

// Initialize button states on page load
document.addEventListener('DOMContentLoaded', initializeGenderButtons);
