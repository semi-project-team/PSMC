document.addEventListener("DOMContentLoaded", function() {
    // Header 아이콘 클릭 시 모든 버튼의 활성화 상태 제거
    document.querySelector("#headerIcon").addEventListener("click", function() {
        document.querySelectorAll(".pack").forEach(function(btn) {
            btn.classList.remove("active");
        });
    });
});
