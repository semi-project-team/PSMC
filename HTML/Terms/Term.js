// agree 와 agreeAll 의 값이 유지 되지 않는 문제가 발생 

// const $check =document.getElementsByClassName('checkbutton');
// let agree =[false,false,false,false]
// for(let i =0; i<$check.length;i++){
//     $check[i].addEventListener('click',e=>{
//         if(!agree[i]){
//             e.currentTarget.firstElementChild.style.color='rgb(3, 61, 94)';
//             agree[i]=true;
//         }
//         else{
//             e.currentTarget.firstElementChild.style.color='lightgray'
//             agree[i]=false;
//             if(agreeAll){
//                 agreeAll=false;
//                 $checkAll.firstElementChild.style.color='lightgray'
//             }
//         }
//     })
// }
// let agreeAll=false;
// const $checkAll = document.getElementById('checkbuttonAll')
// $checkAll.addEventListener('click',e=>{
//     if(!agreeAll){
//         $checkAll.firstElementChild.style.color='rgb(3, 61, 94)'
    
//         for(let i = 0; i<$check.length;i++){
//             agree[i]=true
//             $check[i].firstElementChild.style.color='rgb(3, 61, 94)'
//         }
//         agreeAll=true;
//     }
//     else{
//         $checkAll.firstElementChild.style.color='lightgray'
    
//         for(let i = 0; i<$check.length;i++){
//             agree[i]=true;
//             $check[i].firstElementChild.style.color='lightgray'
//         }
//         agreeAll=false;
//     }

// })

// const $next = document.getElementById('nextPage')
// $next.addEventListener('click',e=>{
//     if(agree[0]&&agree[1]&&agree[2]&&agree[3]&&agreeAll){
//         console.log('왔니')
//         $next.disabled=false;
//     }
//     else{
//         $next.disabled=true;
//     }
// })

// 클로저를 사용하여 문제를 해결함

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

const $checkAll = document.getElementById('checkbuttonAll');
$checkAll.addEventListener('click', e => {
    if (!agreeAll) {
        $checkAll.firstElementChild.style.color = 'rgb(3, 61, 94)';

        for (let i = 0; i < $check.length; i++) {
            agree[i] = true;
            $check[i].firstElementChild.style.color = 'rgb(3, 61, 94)';
        }
        agreeAll = true;
    } else {
        $checkAll.firstElementChild.style.color = 'lightgray';

        for (let i = 0; i < $check.length; i++) {
            agree[i] = false;
            $check[i].firstElementChild.style.color = 'lightgray';
        }
        agreeAll = false;
    }
    checkNextButton();
});

function checkNextButton() {
    const $next = document.getElementById('nextPage');
    if (agree.every(agreed => agreed) && agreeAll) { // 모든 agree가 true이고 agreeAll도 true인 경우
        console.log('왔니');
        $next.style.pointerEvents='auto';
        $next.disabled = false;
        $next.style.opacity=1;
    } else {
        $next.style.opacity='55%'
        $next.style.pointerEvents='none';
        $next.disabled = true;
    }
}

