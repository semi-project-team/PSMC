let check = [false,false,false,false,false,false,false,false];

const $userId = document.getElementById('userId');
const $message = document.getElementById('message');
$userId.addEventListener('input',e=>{
    const value = $userId.value;
    const isValid =/^(?=.*\d)(?=.*[a-zA-Z]).{8,}$/.test(value);
    if(!isValid){
        $message.style.display='block';
        check[0]=false;
    }
    else{
        $message.style.display='none';
        check[0]=true;
    }
    checking();
});

const $password = document.getElementById('password');
const $passMessage = document.getElementById('messagePass');

$password.addEventListener('input',e=>{
    const value = $password.value;
    const isValid = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+={}\[\]:;<>,.?\/\\]).{10,}$/.test(value);
    if(!isValid){
        $passMessage.style.display='block';
        check[1]=false;
    }
    else{
        $passMessage.style.display='none';
        check[1]=true;
    }
    checking();
});



const $conPass = document.getElementById('conPass');
const $conMessage = document.getElementById('conMessage');

$conPass.addEventListener('input',e=>{
    const value = $conPass.value;

    const isValid = ($password.value===value&&value!=='');
    if(!isValid){
        $conMessage.style.display='block';
        check[2]=false;
    }
    else{
        $conMessage.style.display='none';
        check[2]=true;
    }
    checking();
});



const $phone = document.getElementById('phone');
const $phoneMessage = document.getElementById('phoneMessage');
$phone.addEventListener('input',e=>{
    const value = $phone.value;
    const isValid = /^\d{10,11}$/.test(value);
    if(!isValid){
        $phoneMessage.style.display='block';
        check[6]=false;
}

    else{
        $phoneMessage.style.display='none';
        check[6]=true;
    }
    checking();
});

const $email = document.getElementById('email');
const $emailMessage = document.getElementById('emailMessage');
$email.addEventListener('input',e=>{
    const value = $email.value;
    const isValid = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.(com|net)$/.test(value);
    if(!isValid){
        $emailMessage.style.display='block';
        check[7]=false;
    }
    else{
        $emailMessage.style.display='none';
        check[7]=true;
    }
    checking();
});



const $name = document.getElementById('name')
$name.addEventListener('input',e=>{
    
    if($name.value){
        check[3]=true;
    }
    else{
        check[3]=false;
    }
    checking();
});


const $birth= document.getElementById('birth');
document.addEventListener('click',e=>{
    const value = $birth.value;
    if(value){
        console.log(value);
        
        check[4]=true;
    }
    else{
        check[4]=false;
    }
    checking();
});

const maleRadio = document.getElementById("Male");
const femaleRadio = document.getElementById("Female");
const genderMessage = document.getElementById("genderMessage");

// // 라디오 버튼에 이벤트 리스너 추가
maleRadio.addEventListener("click", validateGender);
femaleRadio.addEventListener("click", validateGender);

// // 성별 유효성 검사 함수
function validateGender() {
    if (maleRadio.checked || femaleRadio.checked) {
        // 라디오 버튼이 선택되면 메시지 숨기기
        genderMessage.style.display = "none";
        check[5]=true;

        
    } else {
        // 라디오 버튼이 선택되지 않았을 때 메시지 보이기
        genderMessage.style.display = "block";
        check[5]=false;
    }
    checking();
};


// 버튼 활성화

function checking(){
    const $next = document.getElementById('nextPage');
    if(check.every(agree=>agree)){
        $next.style.pointerEvents='auto';
        $next.style.opacity=1;
    }
    else{
        $next.style.pointerEvents='none';
        $next.style.opacity=0.55;
    }
};

// 아이디 중복 확인

// const $idChecker = document.getElementById('idcheck');
// const $idCheckFail = document.getElementById('dupliFail');
// const $idCheckOk = document.getElementById('dupliOk');
// $idChecker.addEventListener('click',function(){
    
//     fetch("/")
//     .then(res=>res.json)
//     .then(data=>{
//         data.forEach(element => {
//             if(element===$userId){
//                 console.log('여긴')
//                 $idCheckFail.style.display='block'
//                 $idCheckOk.style.display='none'
//             }
//             else{
//                 $idCheckFail.style.display='none'
//                 $idCheckOk.style.display='block'
//             }
//         });
//     })
// })