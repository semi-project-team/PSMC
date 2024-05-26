const profileImage = document.getElementById('profileImage');
const inputImage = document.getElementById('inputImages');
profileImage.addEventListener('click',e=>{
    inputImage.click();
})

inputImage.addEventListener('change',e=>{
    const file = e.target.files[0];
    if(file){
        const reader = new FileReader();
        reader.onload = function(e){
            const imagePreview = document.getElementById('imagePreview');
            if(imagePreview){
                imagePreview.innerHTML = `<img src=${e.target.result} alt="/common/img/employeeProfile.png" class="circle-image">`
            }
        };
        reader.readAsDataURL(file);

        const formData = new FormData();
        formData.append('file',file);
        fetch('/uploadProfileImage',{
            method: 'POST',

            body: formData
        }).then(res=>res.json())
            .then(data=>{
                console.table(data);
            })
    }
})