document.addEventListener('DOMContentLoaded', function() {
    var buttons = document.querySelectorAll('.pack');
    var activePage = localStorage.getItem('activePage');

    if (activePage) {
        document.querySelector('.pack[data-page="' + activePage + '"]').classList.add('active');
    }

    buttons.forEach(function(button) {
        button.addEventListener('click', function() {
            buttons.forEach(function(btn) {
                btn.classList.remove('active');
            });
            button.classList.add('active');
            localStorage.setItem('activePage', button.dataset.page);
        });
    });
});
