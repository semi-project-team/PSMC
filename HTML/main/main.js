// 서버에서 데이터 가져오기
fetch('/profile')
    .then(response => response.json())
    .then(data => {
        // 동적으로 데이터 표시하기
        document.getElementById('profileName').innerText = data.name;
        document.getElementById('profilePosition').innerText = data.position;
        // 필요한 다른 프로필 정보를 동적으로 표시할 수 있습니다
    })
    .catch(error => console.error('프로필 데이터를 가져오는 중 오류가 발생했습니다:', error));
