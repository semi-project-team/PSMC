function toggleGender(gender) {
    if (gender === 'male') {
        document.getElementById('maleBtn').classList.add('active');
        document.getElementById('femaleBtn').classList.remove('active');
    } else {
        document.getElementById('maleBtn').classList.remove('active');
        document.getElementById('femaleBtn').classList.add('active');
    }
}