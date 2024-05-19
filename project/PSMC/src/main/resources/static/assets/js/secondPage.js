const checkDelete = document.querySelectorAll('[class^=delete-]');

console.table(checkDelete);

const deleteButton = document.getElementById('deleteButton');

deleteButton.addEventListener('click',e=>{
    const checkbox = [];
    checkDelete.forEach(d=>{
        if(d.checked){
            checkbox.push(d.className.split('-')[1]);
        }
    })


    console.log(checkbox);
})