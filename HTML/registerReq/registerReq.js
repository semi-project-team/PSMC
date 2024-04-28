const $userId = document.getElementById('userId')
const $message = document.getElementById('message')
$userId.addEventListener('input',e=>{
    const value = $userId.value;
    const isValid =/^(?=.*\d)(?=.*[a-zA-Z]).{8,}$/.test(value);
    if(!isValid){
        $message.style.display='block'
    }
    else{
        $message.style.display='none'
    }
})

const $password = document.getElementById('password')
const $passMessage = document.getElementById('messagePass')

$password.addEventListener('input',e=>{
    const value = $password.value;
    const isValid = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+={}\[\]:;<>,.?\/\\]).{10,}$/.test(value)
    if(!isValid){
        $passMessage.style.display='block'
    }
    else{
        $passMessage.style.display='none'
    }
})


const $conPass = document.getElementById('conPass')
const $conMessage = document.getElementById('conMessage')

$conPass.addEventListener('input',e=>{
    const value = $conPass.value

    const isValid = ($password.value===value&&value!=='')
    if(!isValid){
        $conMessage.style.display='block'
    }
    else{
        $conMessage.style.display='none'
    }
})

const $phone = document.getElementById('phone')
const $phoneMessage = document.getElementById('phoneMessage')
$phone.addEventListener('input',e=>{
    const value = $phone.value;
    const isValid = /^\d{10,}$/.test(value)
    if(!isValid){
        $phoneMessage.style.display='block'
}

    else{
        $phoneMessage.style.display='none'
    }

})

const $email = document.getElementById('email')
const $emailMessage = document.getElementById('emailMessaage')
$email.addEventListener('input',e=>{
    const value = $email.value
    const isValid = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test($email)
    if(!isValid){
        $emailMessage.style.display='block'
    }else{
        $emailMessage.style.display='none'
    }

})

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