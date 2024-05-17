document.getElementById("change-password-btn").addEventListener("click", function() {
    var newPassword = document.getElementById("new-password").value;
    var confirmPassword = document.getElementById("confirm-password").value;

    if (newPassword !== confirmPassword) {
        alert("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return;
    }

    // 비밀번호 변경 로직 추가
    // 예: 서버로 비밀번호 변경 요청을 보내거나, 클라이언트 측에서 비밀번호를 변경하는 등의 동작을 수행할 수 있습니다.
});

document.getElementById("cancel-btn").addEventListener("click", function() {
    // 취소 동작 추가
});