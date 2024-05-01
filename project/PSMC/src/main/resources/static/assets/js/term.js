const $check = document.getElementsByClassName('checkbutton');
let agree = [false, false, false, false];
let agreeAll = false; // agreeAll을 외부로 빼서 클로저 활용

for (let i = 0; i < $check.length; i++) {
    $check[i].addEventListener('click', createClickHandler(i)); // 클로저를 사용하여 i값 저장
}

function createClickHandler(index) {
    return function (e) {
        if (!agree[index]) {
            e.currentTarget.firstElementChild.style.color = 'rgb(3, 61, 94)';
            agree[index] = true;
            if(agree.every(agreed=>agreed)){
                agreeAll = true;
                $checkAll.firstElementChild.style.color='rgb(3, 61, 94)';
            }
        } else {
            e.currentTarget.firstElementChild.style.color = 'lightgray';
            agree[index] = false;
            if (agreeAll) {
                agreeAll = false;
                $checkAll.firstElementChild.style.color = 'lightgray';
            }
        }
        checkNextButton();
    };
}