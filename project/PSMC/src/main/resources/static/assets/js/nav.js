document.querySelectorAll('.pack').forEach(item => {
    item.addEventListener('mouseenter', event => {
        // 아이콘과 텍스트 색상 변경
        event.currentTarget.querySelector('i').style.color = 'lightblue'; // 아이콘 색상 변경
        event.currentTarget.querySelector('span').style.color = 'lightblue'; // 텍스트 색상 변경
    });

    item.addEventListener('mouseleave', event => {
        // 아이콘과 텍스트 색상 초기화
        event.currentTarget.querySelector('i').style.color = ''; // 아이콘 기본 색상으로 변경
        event.currentTarget.querySelector('span').style.color = ''; // 텍스트 기본 색상으로 변경
    });
});