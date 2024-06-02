const inputs = document.querySelectorAll(".input");


function addcl(){
    let parent = this.parentNode.parentNode;
    parent.classList.add("focus");
}

function remcl(){
    let parent = this.parentNode.parentNode;
    if(this.value == ""){
        parent.classList.remove("focus");
    }
}


inputs.forEach(input => {
    input.addEventListener("focus", addcl);
    input.addEventListener("blur", remcl);
});

const findIdButton = document.getElementById('findIdModal');

findIdButton.addEventListener('click',e=>{
    e.preventDefault();



    const name = document.getElementById('name').value;
    const pmCode = document.getElementById('pmCode').value;
    const empNo = document.getElementById('empNo').value;


    document.getElementById('name').value = '';
    document.getElementById('pmCode').value = '';
    document.getElementById('empNo').value = '';
    document.getElementById('userId').value = '';

    const userId = document.getElementById('userId');

    fetch("/finddingId",{
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: name,
            pmCode: pmCode,
            empNo: empNo
        })
    }).then(res=>res.json())
        .then(data=>{

            userId.value = data.userId;
        })



})


// $('#findId').on('hidden.bs.modal', function (e) {
//
// });

$('#findId').on('hidden.bs.modal', function (e) {
    document.getElementById('name').value = '';
    document.getElementById('pmCode').value = '';
    document.getElementById('empNo').value = '';
    document.getElementById('userId').value = '';
});

$('#findPassword').on('hidden.bs.modal', function (e) {
    document.getElementById('pmCode1').value = '';
    document.getElementById('empNo1').value = '';
    document.getElementById('userId1').value = '';
    document.getElementById('email').value = '';
});

