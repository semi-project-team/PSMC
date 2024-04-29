let check = [false,false,false,false,false,false,false,false]

const $userId = document.getElementById('userId')
const $message = document.getElementById('message')
$userId.addEventListener('input',e=>{
    const value = $userId.value;
    const isValid =/^(?=.*\d)(?=.*[a-zA-Z]).{8,}$/.test(value);
    if(!isValid){
        $message.style.display='block'
        check[0]=false
    }
    else{
        $message.style.display='none'
        check[0]=true;
    }
})

const $password = document.getElementById('password')
const $passMessage = document.getElementById('messagePass')

$password.addEventListener('input',e=>{
    const value = $password.value;
    const isValid = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+={}\[\]:;<>,.?\/\\]).{10,}$/.test(value)
    if(!isValid){
        $passMessage.style.display='block'
        check[1]=false
    }
    else{
        $passMessage.style.display='none'
        check[1]=true
    }
})


const $conPass = document.getElementById('conPass')
const $conMessage = document.getElementById('conMessage')

$conPass.addEventListener('input',e=>{
    const value = $conPass.value

    const isValid = ($password.value===value&&value!=='')
    if(!isValid){
        $conMessage.style.display='block'
        check[2]=false
    }
    else{
        $conMessage.style.display='none'
        check[2]=true
    }
})



const $phone = document.getElementById('phone')
const $phoneMessage = document.getElementById('phoneMessage')
$phone.addEventListener('input',e=>{
    const value = $phone.value;
    const isValid = /^\d{10,11}$/.test(value)
    if(!isValid){
        $phoneMessage.style.display='block'
        check[6]=false
}

    else{
        $phoneMessage.style.display='none'
        check[6]=true
    }

})

const $email = document.getElementById('email')
const $emailMessage = document.getElementById('emailMessage')
$email.addEventListener('input',e=>{
    // const value = $email.value
    // const isValid = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test($email)
    // if(!isValid){
    //     $emailMessage.style.display='block'
    //     check[7]=false
    // }else{
    //     $emailMessage.style.display='none'
    //     check[7]=true
    
    // check[7]=true;
    }

)

// function textCheck(exp,ele){
//     const value = this.value;
//     const isValid = exp.test(value);
//     if(!isValid){
//         console.log('왔는가')
//         ele.style.display='block'
//     }
//     else{
//         ele.style.display='none'
//     }
// }

const $name = document.getElementById('name')
$name.addEventListener('input',e=>{
    if($name.value){
        check[3]=true
    }
    else{
        check[3]=false
    }
})

const $birth = document.getElementById('birth')
$birth.addEventListener('input',e=>{
    if($birth.value){
        check[4]=true
    }
    else{
        check[4]=false
    }
})

// const maleRadio = document.getElementById("Male");
// const femaleRadio = document.getElementById("Female");
// const genderMessage = document.getElementById("genderMessage");

// // 라디오 버튼에 이벤트 리스너 추가
// maleRadio.addEventListener("change", validateGender);
// femaleRadio.addEventListener("change", validateGender);

// // 성별 유효성 검사 함수
// function validateGender() {
//     if (maleRadio.checked || femaleRadio.checked) {
//         // 라디오 버튼이 선택되면 메시지 숨기기
//         genderMessage.style.display = "none";
//         check[5]=true
//     } else {
//         // 라디오 버튼이 선택되지 않았을 때 메시지 보이기
//         genderMessage.style.display = "block";
//         check[5]=false
//     }
// }
// const maleRadio = document.getElementById("Male");
// const femaleRadio = document.getElementById("Female");
// const genderMessage = document.getElementById("genderMessage");
// // 라디오 버튼에 이벤트 리스너 추가
// maleRadio.addEventListener("change", hideGenderMessage);
// femaleRadio.addEventListener("change", hideGenderMessage);

// // 성별 메시지 숨기는 함수
// function hideGenderMessage() {
//     console.log('선택됨')
//     genderMessage.style.display = "none";
// }


// 버튼 활성화



